package com.zubiri.matches;
import java.util.ArrayList;

public class Players {
	private ArrayList<Player> players = new ArrayList<Player>();

	public ArrayList<Player> getPlayers() {
		return players;
	}

	public void setPlayers(ArrayList<Player> players) {
		this.players = players;
	}
	
	public Player getPlayer(int index) {
		return players.get(index);
	}

	public int findPlayer(String nameOfPlayer) {
		for(int i = 0; i<players.size(); i++) {
			if(nameOfPlayer.toLowerCase().equals(players.get(i).getName().toLowerCase()))
				return i;
		}
		return -1;
	}
	
	public void addPlayer(Player player) {
		players.add(player);
	}

	public void add(Player player1) {
		players.add(player1);		
	}

}
