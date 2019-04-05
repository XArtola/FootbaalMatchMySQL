package com.zubiri.matches;

public class FootballTeam extends Team{
	
	public boolean checkPlayer(Player player) throws Exception{
		if(player.getSport().equals("football")) {
			return true;
		}
		return false;
	}
}
