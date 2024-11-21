package com.thq.ads.services;

import java.security.SecureRandom;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;

import com.thq.ads.dto.Ads;
import com.thq.ads.dto.User;
import com.thq.ads.filters.FilterChain;
import com.thq.ads.repositores.AdsRepository;
import com.thq.ads.repositores.UserRepository;

@Service
public class AdsServices {
	
	@Autowired
	private AdsRepository adsRepository;
	
	@Autowired
	private UserRepository userRepository;
	
	@Autowired
	private FilterChain filterChain;
	
	private SecureRandom random = new SecureRandom();
	
	@Value("${app.limit_record:100}")
	private int limit;
	
	public Ads getAdsRandom(long id)throws Exception{
		User user = userRepository.getReferenceById(id);
		int totalRecord = adsRepository.getTotalAds();		
	    int offset = random.nextInt(totalRecord - limit);
	    
	    List<Ads> listAds = adsRepository.findAdsWithOffset(limit,offset);
		List<Ads> listAdsFitered = filterChain.doFilters(user, listAds);
		
		int index = random.nextInt(listAdsFitered.size()-1);
		return listAdsFitered.get(index);
	}

}
