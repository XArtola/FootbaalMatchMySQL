package com.zubiri.matches;
/**
 * 
 */

/**
 * @author ik013043z1
 *
 */
public class Player {

	private String name;
	private String team;
	private int age;
	private int height;
	private String sport ="";
	
	
	public String getName() {
		
		return name;
	
        }

	public void setName(String name) {
		
		this.name=name;
		
	}

	public String getTeam() {
		
		return team;
	}

	public void setTeam(String team) {
		
		this.team = team;
		
	}

	public int getAge() {
		
		return age;
		
	}

	public void setAge(int age) {
		
		this.age= age;
		
	}

	public int getHeight() {
		
		return height;
		
	}

	public void setHeight(int height) {
		
		this.height=height;
		
	}

	public String getSport() {
		return sport;
	}

	public void setSport(String sport) {
		this.sport = sport;
	}
}