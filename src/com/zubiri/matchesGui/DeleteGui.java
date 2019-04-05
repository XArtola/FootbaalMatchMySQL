package com.zubiri.matchesGui;

import java.awt.Color;
import java.awt.EventQueue;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileWriter;
import java.io.IOException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.Scanner;

import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JMenu;
import javax.swing.JMenuBar;
import javax.swing.JMenuItem;
import javax.swing.JOptionPane;
import javax.swing.JTextField;
import javax.swing.JTextPane;
import javax.swing.SwingConstants;

import com.zubiri.matches.FootballMatch;
import com.zubiri.matches.FootballTeam;
import com.zubiri.matches.Player;
import com.zubiri.matches.Players;
import com.zubiri.matches.Teams;

public class DeleteGui{

	private JFrame frame;
	private JTextPane textPaneName;
	private JLabel lblName;
	private JTextPane textPaneStadium;
	private JLabel lblStadium;
	private JTextPane textPaneWonLeagues;
	private JLabel lblWonLeagues;
	private JTextPane textPaneShirtColor;
	private JLabel lblShirtColor;
	private JLabel label;
	private JTextPane textPanePlayerName;
	private JTextPane textPanePlayerTeam;
	private JLabel lblTeam;
	private JTextPane textPanePlayerAge;
	private JLabel lblAge;
	private JTextPane textPanePlayerHeight;
	private JMenuBar menuBar;
	private JMenu menu;
	private JMenuItem menuItem;
	private JMenuItem menuItem_1;
	private JMenuItem menuItem_2;
	private JMenu menu_1;
	private JMenuItem menuItem_3;
	private JTextField textField;
	private JButton button;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					DeleteGui window = new DeleteGui();
					window.frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the application.
	 */
	public DeleteGui() {
		initialize();
	}
	
	public JFrame getFrame() {
		return this.frame;
	}
	
	
	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		frame = new JFrame();
		frame.setBounds(100, 100, 317, 444);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.getContentPane().setLayout(null);
		
		JComboBox comboBox = new JComboBox();
		comboBox.setBounds(159, 68, 113, 37);
		comboBox.addItem("Team");
		comboBox.addItem("Player");
		frame.getContentPane().add(comboBox);
		
		textField = new JTextField();
		textField.setToolTipText("");
		textField.setColumns(10);
		textField.setBounds(10, 177, 170, 35);
		frame.getContentPane().add(textField);
		
		// read teams information and add it to Teams class
		File toReadTeam = new File("src/TeamInfo.txt");
		Teams teams = new Teams();
		File toReadPlayers = new File("src/Players.txt");
		Players players = new Players();
		File toReadMatches = new File("src/MatchInfo.txt");
		ArrayList<FootballMatch> matches = new ArrayList<FootballMatch>();
		try {
			Scanner sc = new Scanner(toReadTeam);
			while (sc.hasNextLine()) {
				FootballTeam team1 = new FootballTeam();
				String lineValues[] = sc.nextLine().split("::");
				team1.setName(lineValues[0]);
				team1.setStadium(lineValues[1]);
				team1.setWonLeagues(Integer.parseInt(lineValues[2]));
				team1.setShirtColor(lineValues[3]);
				teams.add(team1);
			}
			sc = new Scanner(toReadPlayers);
			while (sc.hasNextLine()) {
				Player player1 = new Player();
				String lineValues[] = sc.nextLine().split("::");
				player1.setName(lineValues[0]);
				player1.setTeam(lineValues[1]);
				player1.setAge(Integer.parseInt(lineValues[2]));
				player1.setHeight(Integer.parseInt(lineValues[3]));
				player1.setSport("football");
				players.add(player1);
			}
			/*
			sc = new Scanner(toReadMatches);
			while (sc.hasNextLine()) {
				FootballMatch match = new FootballMatch();
				String lineValues[] = sc.nextLine().split("::");
				match.setLocalTeam(teams.getTeam(teams.findTeam(lineValues[0])));
				match.setVisitorTeam(teams.getTeam(teams.findTeam(lineValues[1])));
				match.setGoalsLocal(Integer.parseInt(lineValues[2]));
				match.setGoalsVisitor(Integer.parseInt(lineValues[3]));
				matches.add(match);
			}*/
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		} catch (Exception e) {
			e.printStackTrace();
		}
		
		button = new JButton("Delete");
		button.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				switch (comboBox.getSelectedItem().toString().toLowerCase()) {
				case "team":
					
					try {
					Class.forName("com.mysql.cj.jdbc.Driver");
					Connection con = DriverManager.getConnection(
							"jdbc:mysql://localhost/footballMatches?useUnicode=true&useJDBCCompliantTimezoneShift=true&useLegacyDatetimeCode=false&serverTimezone=UTC",
							"root", "root");
					Statement stmt = con.createStatement();
					String query = " delete from teams where name = ? ";
							
					// create the mysql insert prepared statement
					PreparedStatement preparedStmt = con.prepareStatement(query);
					preparedStmt.setString(1, textField.getText());
					preparedStmt.execute();
					con.close();
				} catch (SQLException | ClassNotFoundException e) {
					// TODO Auto-generated catch block
					System.err.println("Got an exception! ");
					System.err.println(e.getMessage());
				}

					break;
				case "player":
					
					try {
						Class.forName("com.mysql.cj.jdbc.Driver");
						// jdbc:mysql://localhost/db?useUnicode=true&useJDBCCompliantTimezoneShift=true&useLegacyDatetimeCode=false&serverTimezone=UTC
						Connection con = DriverManager.getConnection(
								"jdbc:mysql://localhost/footballMatches?useUnicode=true&useJDBCCompliantTimezoneShift=true&useLegacyDatetimeCode=false&serverTimezone=UTC",
								"root", "root");
						Statement stmt = con.createStatement();

						String query = " delete from players where name = ? ";
								

						// create the mysql insert prepared statement
						PreparedStatement preparedStmt = con.prepareStatement(query);
						preparedStmt.setString(1, textField.getText());
						preparedStmt.execute();
						con.close();
					} catch (SQLException | ClassNotFoundException e) {
						// TODO Auto-generated catch block
						System.err.println("Got an exception! ");
						System.err.println(e.getMessage());
					}
					break;
				}
			}
		});
		button.setBackground(Color.WHITE);
		button.setBounds(190, 177, 101, 35);
		frame.getContentPane().add(button);
		
		menuBar = new JMenuBar();
		menuBar.setBounds(0, 0, 303, 42);
		frame.getContentPane().add(menuBar);

		menu = new JMenu("Consult");
		menuBar.add(menu);

		menuItem = new JMenuItem("Team");
		menuItem.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				MatchGui matchGui = new MatchGui();
				matchGui.getFrame().setVisible(true);
				matchGui.getCombobox().setSelectedItem("Team");
				frame.dispose();
			}
		});
		menu.add(menuItem);

		menuItem_1 = new JMenuItem("Player");
		menuItem_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				MatchGui matchGui = new MatchGui();
				matchGui.getFrame().setVisible(true);
				matchGui.getCombobox().setSelectedItem("Player");
				frame.dispose();
			}
		});
		menu.add(menuItem_1);

		menuItem_2 = new JMenuItem("Match");
		menuItem_2.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				MatchGui matchGui = new MatchGui();
				matchGui.getFrame().setVisible(true);
				matchGui.getCombobox().setSelectedItem("Match");
				frame.dispose();
			}
		});
		menu.add(menuItem_2);

		menu_1 = new JMenu("Manage");
		menuBar.add(menu_1);

		menuItem_3 = new JMenuItem("Add");
		menuItem_3.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				AddGui addGui = new AddGui();
				addGui.getFrame().setVisible(true);
				frame.dispose();
			}
		});
		menu_1.add(menuItem_3);
		
		JLabel lblModify = new JLabel("Delete");
		lblModify.setHorizontalAlignment(SwingConstants.RIGHT);
		lblModify.setFont(new Font("Verdana", Font.PLAIN, 31));
		lblModify.setBounds(0, 68, 149, 37);
		frame.getContentPane().add(lblModify);
		
		
		
	}
}
