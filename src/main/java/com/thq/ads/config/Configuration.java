package com.thq.ads.config;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.stereotype.Component;

import com.thq.ads.filters.CountryFilter;
import com.thq.ads.filters.FilterChain;
import com.thq.ads.filters.GenderFilter;
import com.thq.ads.filters.LimitFrequencyDisplayAds;
import com.thq.ads.filters.TotalViewPerDayFilter;
import com.thq.ads.services.RedisCached;

@Component
public class Configuration {
	
	@Value(value = "${spring.redis.host}")
	private String redisHost;

	@Value(value = "${spring.redis.port}")
	private int redisPort;

	@Value(value = "${spring.redis.prefix}")
	private String prefixCache;

	@Bean
	public RedisCached redis() {
		return new RedisCached(redisHost, redisPort, prefixCache);
	}
	
	
	
	@Bean	
	public FilterChain filterChain() {		
		
		FilterChain filterChain = new FilterChain();
		//add country filter
//		CountryFilter countryFilter = new CountryFilter();
//		filterChain.addFilter(countryFilter);
//		//add gender filter
//		
//		GenderFilter genderFilter = new GenderFilter();
//		filterChain.addFilter(genderFilter);
//		
//		// Limit Frequency 		
//		LimitFrequencyDisplayAds limitFrequencyFilter = new LimitFrequencyDisplayAds(redis());		
//		filterChain.addFilter(limitFrequencyFilter);
//		
//		//total view limit		
//		TotalViewPerDayFilter totalViewPerDayFilter = new TotalViewPerDayFilter(redis());
//		filterChain.addFilter(totalViewPerDayFilter);
		
		return filterChain;
	}
		
}
