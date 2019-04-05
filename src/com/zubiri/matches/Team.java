package com.zubiri.matches;
import java.util.ArrayList;

/**
 * 
 */

/**
 * @author ik013043z1
 *
 */
public abstract class Team {

	private String name;
	private String stadium;
	private int wonLeagues;
	private String shirtColor;

	protected ArrayList<Player> players = new ArrayList<Player> ();
	
	public String getName() {
		
		return name;
	
        }

	public void setName(String name) {
		
		this.name=name;
		
	}

	public String getStadium() {
		
		return stadium;
	}

	public void setStadium(String stadium) {
		
		this.stadium = stadium;
		
	}

	public int getWonLeagues() {
		
		return wonLeagues;
		
	}

	public void setWonLeagues(int wonLeagues) {
		
		this.wonLeagues= wonLeagues;
		
	}

	public String getShirtColor() {
		
		return shirtColor;
		
	}

	public void setShirtColor(String shirtColor) {
		
		this.shirtColor=shirtColor;
		
	}
	
	public ArrayList<Player> getPlayers() {

		return players;

	}

	public void addPlayer(Player player) throws Exception {

		if(checkPlayer(player)) 
			players.add(player);

	}
	
	public abstract boolean checkPlayer(Player player) throws Exception ;
	
	
}