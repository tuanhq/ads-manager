package com.thq.ads.dto;

import java.io.Serializable;

import javax.persistence.*;

@Entity
@Table(name = "ads")
public class Ads implements Serializable {

	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;

	
	private String title;
	
	private String description;

	private String type;

	@Column(name = "target_link")
	private String targetLink;

	@Column(name = "duration_time")
	private int durationTime;
	
	@Column(name = "target_country")
	private String targetCountry;

	@Column(name = "target_age")
	private String targetAge;

	@Column(name = "target_sex")
	private String targetSex;

	@Column(name = "frequency_type")
	private String frequencyType;

	@Column(name = "limit_display_per_day")
	private long limitDisplayPerday;
	
	private String price;

	@Column(name = "quest_authen")
	private String questAuthen;
	
	@Column(name = "total_view_day")
	private Integer totalViewDay;

	@Column(name = "platform_display")
	private String platformDisplay;

	@Column(name = "other_type")
	private int otherType;

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getTitle() {
		return title;
	}

	public void setTitle(String title) {
		this.title = title;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public String getType() {
		return type;
	}

	public void setType(String type) {
		this.type = type;
	}

	public String getTargetLink() {
		return targetLink;
	}

	public void setTargetLink(String targetLink) {
		this.targetLink = targetLink;
	}

	public int getDurationTime() {
		return durationTime;
	}

	public void setDurationTime(int durationTime) {
		this.durationTime = durationTime;
	}

	public String getTargetCountry() {
		return targetCountry;
	}

	public void setTargetCountry(String targetCountry) {
		this.targetCountry = targetCountry;
	}

	public String getTargetAge() {
		return targetAge;
	}

	public void setTargetAge(String targetAge) {
		this.targetAge = targetAge;
	}

	public String getTargetSex() {
		return targetSex;
	}

	public void setTargetSex(String targetSex) {
		this.targetSex = targetSex;
	}

	public String getFrequencyType() {
		return frequencyType;
	}

	public void setFrequencyType(String frequencyType) {
		this.frequencyType = frequencyType;
	}

	public long getLimitDisplayPerday() {
		return limitDisplayPerday;
	}

	public void setLimitDisplayPerday(long limitDisplayPerday) {
		this.limitDisplayPerday = limitDisplayPerday;
	}

	public String getPrice() {
		return price;
	}

	public void setPrice(String price) {
		this.price = price;
	}

	public String getQuestAuthen() {
		return questAuthen;
	}

	public void setQuestAuthen(String questAuthen) {
		this.questAuthen = questAuthen;
	}

	public Integer getTotalViewDay() {
		return totalViewDay;
	}

	public void setTotalViewDay(Integer totalViewDay) {
		this.totalViewDay = totalViewDay;
	}

	public String getPlatformDisplay() {
		return platformDisplay;
	}

	public void setPlatformDisplay(String platformDisplay) {
		this.platformDisplay = platformDisplay;
	}

	public int getOtherType() {
		return otherType;
	}

	public void setOtherType(int otherType) {
		this.otherType = otherType;
	}

}
