/**
 * 
 */
package com.seamoon.demo.test;

import jxl.write.Label;

/**
 * @author Administrator
 * @Date   2013-5-3下午05:21:42
 * @File   Person.java
 */
public class Person {
	
	private String name;
	/**
	 * 
	 */
	
	private String nickname;

	private String power;
	private String wit;
	private String polity;
	private String charm;
	private String story;

	/**
	 * @param name
	 * @param nickname
	 * @param power
	 * @param wit
	 * @param polity
	 * @param charm
	 * @param story
	 */
	public Person(String name, String nickname, String power, String wit,
			String polity, String charm, String story) {
		super();
		this.name = name;
		this.nickname = nickname;
		this.power = power;
		this.wit = wit;
		this.polity = polity;
		this.charm = charm;
		this.story = story;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getNickname() {
		return nickname;
	}
	public void setNickname(String nickname) {
		this.nickname = nickname;
	}
	public String getPower() {
		return power;
	}
	public void setPower(String power) {
		this.power = power;
	}
	public String getWit() {
		return wit;
	}
	public void setWit(String wit) {
		this.wit = wit;
	}
	public String getPolity() {
		return polity;
	}
	public void setPolity(String polity) {
		this.polity = polity;
	}
	public String getCharm() {
		return charm;
	}
	public void setCharm(String charm) {
		this.charm = charm;
	}
	public String getStory() {
		return story;
	}
	public void setStory(String story) {
		this.story = story;
	}
	

}
