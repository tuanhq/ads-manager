package com.thq.ads.filters;

import java.util.List;
import java.util.stream.Collectors;

import com.thq.ads.dto.Ads;
import com.thq.ads.dto.User;
import com.thq.ads.services.RedisCached;

public class LimitFrequencyDisplayAds implements AdsFilter {
	
	private RedisCached redisCached;
	
	public LimitFrequencyDisplayAds(RedisCached redisCached) {
		this.redisCached = redisCached;
	}
	
	
	@Override
	public List<Ads> doFilter(User user, List<Ads> listAds) {
		// TODO Auto-generated method stub
		return listAds.stream().filter(
				ads ->{
					
					if (redisCached.get("ADS_USER_VIEW"+user.getId()+ads.getId()) != null){
						return true;
					}else {
						long userViewAdsStartTime = (long)redisCached.get("ADS_USER_VIEW"+user.getId()+ads.getId());
						long currentTime = System.currentTimeMillis()/1000;
						switch (ads.getFrequencyType()) {
						case "4h":
							if (currentTime - userViewAdsStartTime > 4*3600) {
								return true;
							}
							break;
						case "8h":
							if (currentTime - userViewAdsStartTime > 8*3600) {
								return true;
							}
							break;
						case "12h":
							if (currentTime - userViewAdsStartTime > 12*3600) {
								return true;
							}
							break;
						case "24h":	
							if (currentTime - userViewAdsStartTime > 24*3600) {
								return true;
							}
							break;
						default:
								return false;
						}

				}
					return false;
				}
				
				).collect(Collectors.toList());
				
	}

}
