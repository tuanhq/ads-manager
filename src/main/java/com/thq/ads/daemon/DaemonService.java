package com.thq.ads.daemon;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

import com.thq.ads.repositores.AdsRepository;
import com.thq.ads.repositores.UserRepository;

@Component
public class DaemonService implements CommandLineRunner{
	
	@Autowired
	private AdsRepository adsRepository;
	
	@Autowired
	private UserRepository userRepository;

	@Override
	public void run(String... args) throws Exception {
		// TODO Auto-generated method stub
		
	}
	
}
