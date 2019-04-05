package com.zubiri.matches;
/**
 * 
 */

/**
 * @author ik013043z1
 *
 */
public class FootballMatch{

	private Team localTeam;
	private Team visitorTeam;
	private int goalsLocal;
	private int goalsVisitor;

	public Team getLocalTeam() {
		
		return localTeam;
	
        }

	public void setLocalTeam(Team LocalTeam) {
		
		this.localTeam=LocalTeam;
		
	}

	public Team getVisitorTeam() {
		
		return visitorTeam;
	}
	

	public void setVisitorTeam(Team visitorTeam) {
		
		this.visitorTeam = visitorTeam;
		
	}

	public int getGoalsLocal() {
		
		return goalsLocal;
		
	}

	public void setGoalsLocal(int goalsLocal) {
		
		this.goalsLocal= goalsLocal;
		
	}

	public int getGoalsVisitor() {
		
		return goalsVisitor;
		
	}

	public void setGoalsVisitor(int goalsVisitor) {
		
		this.goalsVisitor=goalsVisitor;
		
	}
}