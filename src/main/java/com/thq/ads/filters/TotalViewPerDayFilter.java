package com.thq.ads.filters;

import java.util.List;
import java.util.stream.Collectors;

import com.thq.ads.dto.Ads;
import com.thq.ads.dto.User;
import com.thq.ads.services.RedisCached;

public class TotalViewPerDayFilter implements AdsFilter {

	private RedisCached redisCached;

	public TotalViewPerDayFilter(RedisCached redisCached) {
		this.redisCached = redisCached;
	}

	@Override
	public List<Ads> doFilter(User user, List<Ads> listAds) {
		// TODO Auto-generated method stub
		return listAds.stream()
				.filter(ads -> redisCached.get("ADS_VIEW" + ads.getId()) != null
						&& (long) (redisCached.get("ADS_VIEW" + ads.getId())) >= ads.getTotalViewDay())
				.collect(Collectors.toList());
	}

}
