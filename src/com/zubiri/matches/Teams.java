package com.zubiri.matches;
import java.util.ArrayList;

public class Teams {
	private ArrayList<Team> teams = new ArrayList<Team>();

	public ArrayList<Team> getTeams() {
		return teams;
	}

	public void setTeams(ArrayList<Team> teams) {
		this.teams = teams;
	}
	
	public Team getTeam(int index) {
		return teams.get(index);
	}

	public int findTeam(String nameOfTeam) {
		for(int i = 0; i<teams.size(); i++) {
			if(nameOfTeam.toLowerCase().equals(teams.get(i).getName().toLowerCase()))
				return i;
		}
		return -1;
	}
	
	public void addTeam(Team team) {
		teams.add(team);
	}

	public void add(FootballTeam team1) {
		teams.add(team1);		
	}

}
