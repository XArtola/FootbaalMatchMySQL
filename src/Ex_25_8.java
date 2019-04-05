/**
 * 
 */

/**
 * @author ik013043z1
 *
 */
import java.util.ArrayList;
import java.util.Scanner;

import com.zubiri.matches.*;

import java.io.*;

public class Ex_25_8 {

	/**
	 * @param args
	 */
	public static void main(String[] args) {

		if (args.length == 3) {

			File toRead = new File(args[0]);

			ArrayList<Player> players = new ArrayList<Player>();

			try {
				Scanner sc = new Scanner(toRead);

				while (sc.hasNextLine()) {

					Player player1 = new Player();

					String lineValues[] = sc.nextLine().split("::");
					player1.setName(lineValues[0]);

					player1.setTeam(lineValues[1]);

					player1.setAge(Integer.parseInt(lineValues[2]));

					player1.setHeight(Integer.parseInt(lineValues[3]));
					
					player1.setSport(lineValues[4]);

					players.add(player1);

				}

			} catch (FileNotFoundException e) {
				e.printStackTrace();
			} catch (ArrayIndexOutOfBoundsException e) {
				System.out.println("There's information missing in the player's file");
				e.printStackTrace();
			}

			// Take teams info
			File toRead2 = new File(args[1]);

			Teams teams = new Teams();

			try {
				Scanner sc = new Scanner(toRead2);

				while (sc.hasNextLine()) {

					FootballTeam team1 = new FootballTeam();

					String lineValues[] = sc.nextLine().split("::");
					team1.setName(lineValues[0]);

					team1.setStadium(lineValues[1]);

					team1.setWonLeagues(Integer.parseInt(lineValues[2]));

					team1.setShirtColor(lineValues[3]);

					for (int b = 0; b < players.size(); b++) {

						if (team1.getName().matches(players.get(b).getTeam())) {

							team1.addPlayer(players.get(b));

							players.remove(b);

						}

					}

					teams.add(team1);

				}

			} catch (FileNotFoundException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			} catch (Exception e) {
				// TODO Auto-generated catch block
				System.out.println("Unable to check the sport");
			}

			File toRead3 = new File(args[2]);

			ArrayList<FootballMatch> matches = new ArrayList<FootballMatch>();

			try {
				Scanner sc = new Scanner(toRead3);

				while (sc.hasNextLine()) {

					FootballMatch match = new FootballMatch();

					String lineValues[] = sc.nextLine().split("::");

					for (int a = 0; a < teams.getTeams().size(); a++) {

						if (lineValues[0].matches(teams.getTeam(a).getName())) {

							match.setLocalTeam(teams.getTeam(a));

						}

						else if (lineValues[1].matches(teams.getTeam(a).getName())) {

							match.setVisitorTeam(teams.getTeam(a));

						}

					}

					match.setGoalsLocal(Integer.parseInt(lineValues[2]));

					match.setGoalsVisitor(Integer.parseInt(lineValues[3]));

					matches.add(match);

				}

			} catch (FileNotFoundException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}

			System.out.println("There are " + matches.size() + " matches\n" + "They are: \n");

			for (int a = 0; a <= matches.size() - 1; a++) {

				System.out.println(matches.get(a).getLocalTeam().getName() + " " + matches.get(a).getGoalsLocal()
						+ " - " + matches.get(a).getGoalsVisitor() + " " + matches.get(a).getVisitorTeam().getName());

				System.out.println("\n\tThe info of the team " + matches.get(a).getLocalTeam().getName() + " is:\n\n"
						+ "\t\tName: " + matches.get(a).getLocalTeam().getName() + "\n\t\tStadium: "
						+ matches.get(a).getLocalTeam().getStadium() + "\n\t\tWon Leagues: "
						+ matches.get(a).getLocalTeam().getWonLeagues() + "\n\t\tShirt color: "
						+ matches.get(a).getLocalTeam().getShirtColor() + "\n");

				if (matches.get(a).getLocalTeam().getPlayers().isEmpty()) {

					System.out.println("There is no player info for this team\n");

				}

				else {
					
					
					System.out.println("\t\t\tThis are players of team " + matches.get(a).getLocalTeam().getName()
							+ " and their information\n");

					for (int c = 0; c < matches.get(a).getLocalTeam().getPlayers().size(); c++) {

						

						System.out.println("\t\t\t\tName: "
								+ matches.get(a).getLocalTeam().getPlayers().get(c).getName() + "\n" + "\t\t\t\tAge: "
								+ matches.get(a).getLocalTeam().getPlayers().get(c).getHeight() + "\n"
								+ "\t\t\t\tHeight: " + matches.get(a).getLocalTeam().getPlayers().get(c).getHeight()
								+ "\n");

					}

				}

				System.out.println("\n\tThe info of the team " + matches.get(a).getVisitorTeam().getName() + " is:\n\n"
						+ "\t\tName: " + matches.get(a).getVisitorTeam().getName() + "\n\t\tStadium: "
						+ matches.get(a).getVisitorTeam().getStadium() + "\n\t\tWon Leagues: "
						+ matches.get(a).getVisitorTeam().getWonLeagues() + "\n\t\tShirt color: "
						+ matches.get(a).getVisitorTeam().getShirtColor() + "\n");

				if (matches.get(a).getLocalTeam().getPlayers().isEmpty()) {

					System.out.println("There is no player info for this team\n");

				}

				else {
					
					System.out.println("\t\t\tThis are players of team " + matches.get(a).getLocalTeam().getName()
							+ " and their information\n");

					for (int c = 0; c < matches.get(a).getVisitorTeam().getPlayers().size(); c++) {

	
						System.out.println("\t\t\t\tName: "
								+ matches.get(a).getLocalTeam().getPlayers().get(c).getName() + "\n" + "\t\t\t\tAge: "
								+ matches.get(a).getLocalTeam().getPlayers().get(c).getHeight() + "\n"
								+ "\t\t\t\tHeight: " + matches.get(a).getLocalTeam().getPlayers().get(c).getHeight()
								+ "\n");

					}

				}

			}

		}

		else if (args.length < 2) {

			System.out.println(
					"Not enough information. Please run again the program and enter the file with the matches info and the file with the team info.");

		}

		else {

			System.out.println(
					"So many information. Please run again the program and enter the file with the matches info and the file with the team info");

		}

	}

}
