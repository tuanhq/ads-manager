package com.thq.ads.repositores;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import com.thq.ads.dto.Ads;

@Repository
public interface AdsRepository extends JpaRepository<Ads, Long> {
	public Ads findByName(String name);
	@Query(value = "SELECT * FROM ads LIMIT :limit OFFSET :offset", nativeQuery = true)
	public List<Ads> findAdsWithOffset(@Param("limit") int limit, @Param("offset") int offset);
	
	@Query("SELECT COUNT(a) FROM Ads a")
	public int getTotalAds();
	
}
