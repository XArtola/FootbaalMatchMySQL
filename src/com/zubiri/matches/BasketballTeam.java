package com.zubiri.matches;

public class BasketballTeam extends Team{
	public boolean checkPlayer(Player player) {
		if(player.getSport().equals("basketball")) {
			return true;
		}
		return false;
	}
}