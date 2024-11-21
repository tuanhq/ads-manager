package com.thq.ads.filters;

import java.util.List;

import com.thq.ads.dto.Ads;
import com.thq.ads.dto.User;

public interface AdsFilter {
	public List<Ads> doFilter(User user, List<Ads>listAds);

}
