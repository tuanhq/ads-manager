package com.thq.ads.filters;

import java.util.List;
import java.util.stream.Collectors;

import org.apache.commons.lang3.StringUtils;


import com.thq.ads.dto.Ads;
import com.thq.ads.dto.User;



public class GenderFilter implements AdsFilter{

	@Override
	public List<Ads> doFilter(User user, List<Ads> listAds) {
		// TODO Auto-generated method stub
		   return listAds.stream()
                .filter(ads ->  StringUtils.isBlank(ads.getTargetSex()) || ads.getTargetSex().toLowerCase().contains(user.getSex().toLowerCase()))
                .collect(Collectors.toList());
                
	}

}
