package com.thq.ads.filters;

import java.util.List;
import java.util.stream.Collectors;

import org.apache.commons.lang3.StringUtils;

import com.thq.ads.dto.Ads;
import com.thq.ads.dto.User;

public class CountryFilter implements AdsFilter{

	@Override
	public List<Ads> doFilter(User user, List<Ads> listAds) {
		// TODO Auto-generated method stub
		   return listAds.stream()
                .filter(ads -> StringUtils.isBlank(ads.getTargetCountry()) || ads.getTargetCountry().toLowerCase().contains(user.getCountry().toLowerCase()))
                .collect(Collectors.toList());
                
	}

}
