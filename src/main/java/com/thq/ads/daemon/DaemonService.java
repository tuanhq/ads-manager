package com.thq.ads.daemon;

import java.security.SecureRandom;
import java.util.Random;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

import com.thq.ads.dto.Ads;
import com.thq.ads.dto.User;
import com.thq.ads.repositores.AdsRepository;
import com.thq.ads.repositores.UserRepository;
import com.thq.ads.services.AdsServices;

@Component
public class DaemonService implements CommandLineRunner {

	@Autowired
	private AdsRepository adsRepository;

	@Autowired
	private UserRepository userRepository;
	
	@Autowired
	private AdsServices adsService;
	
	private SecureRandom random = new SecureRandom();
	private String[] TYPE_ADS = { "video", "app", "banner", "image", "gif" };
	private int[] duration_ads = { 10, 20, 40, 24, 60 };

	private String[] targetCountry = { "us", "vi", "en", "fr", "ru" };
	private String[] targetAge = { ">10", ">16", ">18", "<60", "" };
	private String[] targetSex = { "male", "female", "all" };
	private String[] frequency_type = { "1h", "3h", "6h", "12h", "24h" };
	private long[] limitDisplayPerday = { 1000L, 2000L, 3000L, 100000L, 100000L };
	private String[] prices = { "1000usd", "3000usd", "6usd", "12usd", "24usd" };
	private String[] platforms = { "fb", "you", "tik", "x", "tele" };
	private int[] alows = { 1, 2, 3 };
	private static final String CHARACTERS = "ABCDEFGHIJKLMNOPQRSTUVWXYZ" + "abcdefghijklmnopqrstuvwxyz" + "0123456789";
	
	public void setupData() throws Exception{
		// TODO Auto-generated method stub
				for(int i =0;i <10000;i++) {
					Ads ads = new Ads();
					ads.setTitle(generateRandomString(10));
					ads.setDescription(generateRandomString(10));
					ads.setType(TYPE_ADS[random.nextInt(5)]);
					ads.setType("https://" + generateRandomString(10) + ".com");
					ads.setDurationTime(duration_ads[random.nextInt(5)]);
					ads.setTargetCountry(targetCountry[random.nextInt(5)]);
					ads.setTargetAge(targetAge[random.nextInt(5)]);
					ads.setTargetSex(targetSex[random.nextInt(3)]);
					ads.setFrequencyType(frequency_type[random.nextInt(5)]);
					ads.setLimitDisplayPerday(limitDisplayPerday[random.nextInt(5)]);
					ads.setPrice(prices[random.nextInt(5)]);
					ads.setPlatformDisplay(platforms[random.nextInt(5)]);
					ads.setOtherType(alows[random.nextInt(3)]);
					ads.setTotalViewDay(0);
					adsRepository.save(ads);
					
				}
				for(int i=0;i<10;i++) {
					User user = new User();
					user.setAge(15);
					user.setCountry("us");
					user.setEmail(generateRandomString(10)+"@gmail.com");
					user.setName(generateRandomString(10));
					user.setSex(targetSex[random.nextInt(3)]);
					
					userRepository.save(user);
				}
	}
	@Override
	public void run(String... args) throws Exception {
		//setupData();
		
		adsService.getAdsRandom(1);
		

	}

	

	private static String generateRandomString(int length) {
		Random random = new Random();
		StringBuilder stringBuilder = new StringBuilder();

		for (int i = 0; i < length; i++) {
			int index = random.nextInt(CHARACTERS.length());
			char randomChar = CHARACTERS.charAt(index);
			stringBuilder.append(randomChar);
		}

		return stringBuilder.toString();
	}

}
