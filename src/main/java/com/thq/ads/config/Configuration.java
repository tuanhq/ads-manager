package com.thq.ads.config;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.stereotype.Component;

import com.thq.ads.filters.FilterChain;
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
		return filterChain;
	}
		
}
