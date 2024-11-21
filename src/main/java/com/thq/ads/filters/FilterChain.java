package com.thq.ads.filters;

import java.util.ArrayList;
import java.util.List;

import com.thq.ads.dto.Ads;
import com.thq.ads.dto.User;

public class FilterChain {
    private final List<AdsFilter> filters = new ArrayList<>();

    public void addFilter(AdsFilter filter) {
        filters.add(filter);
    }

    public List<Ads> doFilters(User user, List<Ads> listAds) {
        List<Ads> filteredAds = listAds;
        for (AdsFilter filter : filters) {
            filteredAds = filter.doFilter(user,filteredAds);
        }
        return filteredAds;
    }
}