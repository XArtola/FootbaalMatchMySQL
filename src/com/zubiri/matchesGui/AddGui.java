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
import java.util.Scanner;

import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JMenu;
import javax.swing.JMenuBar;
import javax.swing.JMenuItem;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JTextPane;
import javax.swing.SwingConstants;

import com.zubiri.matches.FootballTeam;
import com.zubiri.matches.Teams;

public class AddGui {

	private JFrame frame;
	private JTextPane textPaneName;
	private JLabel lblName;
	private JPanel panel;
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
	private JLabel lblLocalTeam;
	private JTextPane textPaneLocalTeam;
	private JLabel lblVisitorTeam;
	private JTextPane textPaneVisitorTeam;
	private JLabel lblLocalGoals;
	private JTextPane textPaneLocalGoals;
	private JLabel lblVisitorGoals;
	private JTextPane textPaneVisitorGoals;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					AddGui window = new AddGui();
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
	public AddGui() {
		initialize();
	}

	public JFrame getFrame() {
		return this.frame;
	}

	private void fillMatchPanel() {
		lblLocalTeam = new JLabel("Local Team's name");
		lblLocalTeam.setFont(new Font("Verdana", Font.PLAIN, 14));
		lblLocalTeam.setBounds(10, 11, 181, 35);
		panel.add(lblLocalTeam);

		frame.repaint();

		textPaneLocalTeam = new JTextPane();
		textPaneLocalTeam.setBackground(Color.LIGHT_GRAY);
		textPaneLocalTeam.setBounds(163, 11, 122, 35);
		panel.add(textPaneLocalTeam);

		lblLocalGoals = new JLabel("Local team's goals");
		lblLocalGoals.setFont(new Font("Verdana", Font.PLAIN, 14));
		lblLocalGoals.setBackground(Color.LIGHT_GRAY);
		lblLocalGoals.setBounds(10, 57, 181, 35);

		panel.add(lblLocalGoals);

		textPaneLocalGoals = new JTextPane();
		textPaneLocalGoals.setBounds(163, 57, 122, 35);
		textPaneLocalGoals.setBackground(Color.LIGHT_GRAY);
		panel.add(textPaneLocalGoals);

		lblVisitorTeam = new JLabel("Visitor Team's name");
		lblVisitorTeam.setFont(new Font("Verdana", Font.PLAIN, 14));
		lblVisitorTeam.setBounds(10, 103, 181, 35);
		panel.add(lblVisitorTeam);

		textPaneVisitorTeam = new JTextPane();

		textPaneVisitorTeam.setEditable(false);
		textPaneVisitorTeam.setBackground(Color.LIGHT_GRAY);
		textPaneVisitorTeam.setBounds(163, 103, 122, 35);
		textPaneVisitorTeam.setEditable(true);
		panel.add(textPaneVisitorTeam);

		lblVisitorGoals = new JLabel("Visitor team's goals");
		lblVisitorGoals.setFont(new Font("Verdana", Font.PLAIN, 14));
		lblVisitorGoals.setBounds(10, 150, 181, 35);
		panel.add(lblVisitorGoals);

		textPaneVisitorGoals = new JTextPane();
		textPaneVisitorGoals.setBackground(Color.LIGHT_GRAY);
		textPaneVisitorGoals.setBounds(163, 150, 122, 35);
		panel.add(textPaneVisitorGoals);
	}

	private void fillTeamPanel() {
		lblName = new JLabel("Name");
		lblName.setFont(new Font("Verdana", Font.PLAIN, 14));
		lblName.setBounds(10, 11, 81, 35);
		panel.add(lblName);

		frame.repaint();

		textPaneName = new JTextPane();
		textPaneName.setBackground(Color.LIGHT_GRAY);
		textPaneName.setBounds(163, 11, 122, 35);
		panel.add(textPaneName);

		lblStadium = new JLabel("Stadium");
		lblStadium.setFont(new Font("Verdana", Font.PLAIN, 14));
		lblStadium.setBounds(10, 57, 81, 35);
		panel.add(lblStadium);

		textPaneStadium = new JTextPane();

		textPaneStadium.setBackground(Color.LIGHT_GRAY);
		textPaneStadium.setBounds(163, 57, 122, 35);
		panel.add(textPaneStadium);

		lblWonLeagues = new JLabel("Won leagues");
		lblWonLeagues.setText("Won leages");
		lblWonLeagues.setFont(new Font("Verdana", Font.PLAIN, 14));
		lblWonLeagues.setBackground(Color.LIGHT_GRAY);
		lblWonLeagues.setBounds(10, 103, 122, 35);

		panel.add(lblWonLeagues);

		textPaneWonLeagues = new JTextPane();
		textPaneWonLeagues.setBounds(163, 103, 122, 35);
		textPaneWonLeagues.setBackground(Color.LIGHT_GRAY);
		panel.add(textPaneWonLeagues);

		lblShirtColor = new JLabel("Shirt color");
		lblShirtColor.setFont(new Font("Verdana", Font.PLAIN, 14));
		lblShirtColor.setBounds(10, 150, 81, 35);
		panel.add(lblShirtColor);

		textPaneShirtColor = new JTextPane();
		textPaneShirtColor.setBackground(Color.LIGHT_GRAY);
		textPaneShirtColor.setBounds(163, 150, 122, 35);
		panel.add(textPaneShirtColor);
	}

	private void fillPlayerPanel() {
		label = new JLabel("Name");
		label.setFont(new Font("Verdana", Font.PLAIN, 14));
		label.setBounds(10, 11, 81, 35);
		label.setBackground(new Color(1, 25, 44));
		label.setEnabled(true);

		panel.add(label);

		frame.repaint();

		textPanePlayerName = new JTextPane();
		textPanePlayerName.setBackground(Color.LIGHT_GRAY);
		textPanePlayerName.setBounds(163, 11, 122, 35);

		panel.add(textPanePlayerName);

		lblAge = new JLabel("Age");
		lblAge.setFont(new Font("Verdana", Font.PLAIN, 14));
		lblAge.setBounds(10, 57, 81, 35);
		panel.add(lblAge);

		textPanePlayerAge = new JTextPane();
		textPanePlayerAge.setBackground(Color.LIGHT_GRAY);
		textPanePlayerAge.setBounds(163, 57, 122, 35);
		panel.add(textPanePlayerAge);

		JLabel lblHeight = new JLabel("Height");
		lblHeight.setFont(new Font("Verdana", Font.PLAIN, 14));
		lblHeight.setBounds(10, 103, 122, 35);
		lblHeight.setBackground(new Color(204, 204, 204));
		panel.add(lblHeight);

		textPanePlayerHeight = new JTextPane();
		textPanePlayerHeight.setBackground(Color.LIGHT_GRAY);
		textPanePlayerHeight.setBounds(163, 103, 122, 35);
		panel.add(textPanePlayerHeight);

		lblTeam = new JLabel("Team");
		lblTeam.setFont(new Font("Verdana", Font.PLAIN, 14));
		lblTeam.setBounds(10, 149, 122, 35);
		panel.add(lblTeam);

		textPanePlayerTeam = new JTextPane();
		textPanePlayerTeam.setBackground(Color.LIGHT_GRAY);
		textPanePlayerTeam.setBounds(163, 149, 122, 35);

		panel.add(textPanePlayerTeam);
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		frame = new JFrame();
		frame.setBounds(100, 100, 317, 444);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.getContentPane().setLayout(null);

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

		menuItem_3 = new JMenuItem("Delete");
		menuItem_3.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				DeleteGui deleteGui = new DeleteGui();
				deleteGui.getFrame().setVisible(true);
				frame.dispose();
			}
		});
		menu_1.add(menuItem_3);

		JLabel lblModify = new JLabel("Add");
		lblModify.setHorizontalAlignment(SwingConstants.RIGHT);
		lblModify.setFont(new Font("Verdana", Font.PLAIN, 31));
		lblModify.setBounds(10, 68, 139, 37);
		frame.getContentPane().add(lblModify);
		panel = new JPanel();
		panel.setBounds(0, 109, 301, 257);
		panel.setBackground(Color.WHITE);
		frame.getContentPane().add(panel);
		panel.setLayout(null);
		frame.getContentPane().add(panel);
		JComboBox comboBox = new JComboBox();
		comboBox.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				switch (comboBox.getSelectedItem().toString()) {
				case "Team":
					panel.removeAll();
					panel.setVisible(true);
					fillTeamPanel();
					break;
				case "Player":
					panel.removeAll();
					panel.setVisible(true);
					fillPlayerPanel();
					break;
				case "Match":
					panel.removeAll();
					panel.setVisible(true);
					fillMatchPanel();
					break;
				}
			}
		});
		comboBox.setBounds(159, 68, 113, 37);
		comboBox.addItem("Team");
		comboBox.addItem("Player");
		comboBox.addItem("Match");
		frame.getContentPane().add(comboBox);

		JButton btnAdd = new JButton("Confirm");
		btnAdd.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				switch (comboBox.getSelectedItem().toString()) {
				case "Team":
					if (textPaneName.getText().isEmpty() || textPaneStadium.getText().isEmpty()
							|| textPaneWonLeagues.getText().isEmpty() || textPaneShirtColor.getText().isEmpty()) {
						JOptionPane.showMessageDialog(frame, "Please, fill all the gaps");
					} else {
						
						// Connection with mysql to enter a new team

						try {
							Class.forName("com.mysql.cj.jdbc.Driver");
							// jdbc:mysql://localhost/db?useUnicode=true&useJDBCCompliantTimezoneShift=true&useLegacyDatetimeCode=false&serverTimezone=UTC
							Connection con = DriverManager.getConnection(
									"jdbc:mysql://localhost/footballMatches?useUnicode=true&useJDBCCompliantTimezoneShift=true&useLegacyDatetimeCode=false&serverTimezone=UTC",
									"root", "root");
							Statement stmt = con.createStatement();

							String query = " insert into teams (name, stadium, wonLeagues, shirtColor)"
									+ " values (?, ?, ?, ?)";

							// create the mysql insert preparedstatement
							PreparedStatement preparedStmt = con.prepareStatement(query);
							preparedStmt.setString(1, textPaneName.getText());
							preparedStmt.setString(2, textPaneStadium.getText());
							preparedStmt.setInt(3, Integer.parseInt(textPaneWonLeagues.getText()));
							preparedStmt.setString(4, textPaneShirtColor.getText());

							preparedStmt.execute();
							con.close();
						} catch (SQLException | ClassNotFoundException e) {
							// TODO Auto-generated catch block
							System.err.println("Got an exception! ");
							System.err.println(e.getMessage());
						}
							
						File teamFile = new File("src/TeamInfo.txt");
						try {
							BufferedWriter writer = new BufferedWriter(new FileWriter(teamFile, true));
							writer.write(textPaneName.getText() + "::" + textPaneStadium.getText() + "::"
									+ textPaneWonLeagues.getText() + "::" + textPaneShirtColor.getText() + "\n");
							writer.close();
							JOptionPane.showMessageDialog(frame, "Information added correctly");
							textPaneName.setText("");
							textPaneStadium.setText("");
							textPaneWonLeagues.setText("");
							textPaneShirtColor.setText("");
						} catch (IOException e) {
							e.printStackTrace();
						}

					}
					break;
				case "Player":
					if (textPanePlayerName.getText().isEmpty() || textPanePlayerTeam.getText().isEmpty()
							|| textPanePlayerAge.getText().isEmpty() || textPanePlayerHeight.getText().isEmpty()) {
						JOptionPane.showMessageDialog(frame, "Please, fill all the gaps");
					} else {
						
						// Connection with mysql to enter a new team

						try {
							Class.forName("com.mysql.cj.jdbc.Driver");
							// jdbc:mysql://localhost/db?useUnicode=true&useJDBCCompliantTimezoneShift=true&useLegacyDatetimeCode=false&serverTimezone=UTC
							Connection con = DriverManager.getConnection(
									"jdbc:mysql://localhost/footballMatches?useUnicode=true&useJDBCCompliantTimezoneShift=true&useLegacyDatetimeCode=false&serverTimezone=UTC",
									"root", "root");
							Statement stmt = con.createStatement();

							String query = " insert into players (name, team, age, height)"
									+ " values (?, ?, ?, ?)";

							// create the mysql insert preparedstatement
							PreparedStatement preparedStmt = con.prepareStatement(query);
							preparedStmt.setString(1, textPanePlayerName.getText());
							preparedStmt.setString(2, textPanePlayerTeam.getText());
							preparedStmt.setInt(3, Integer.parseInt(textPanePlayerAge.getText()));
							preparedStmt.setInt(4, Integer.parseInt(textPanePlayerAge.getText()));

							preparedStmt.execute();
							con.close();
						} catch (SQLException | ClassNotFoundException e) {
							// TODO Auto-generated catch block
							System.err.println("Got an exception! ");
							System.err.println(e.getMessage());
						}
						
						File playerFile = new File("src/Players.txt");
						try {
							BufferedWriter writer = new BufferedWriter(new FileWriter(playerFile, true));
							writer.write(textPanePlayerName.getText() + "::" + textPanePlayerTeam.getText() + "::"
									+ textPanePlayerAge.getText() + "::" + textPanePlayerHeight.getText()
									+ "::football\n");
							writer.close();
							JOptionPane.showMessageDialog(frame, "Information added correctly");
							textPanePlayerName.setText("");
							textPanePlayerTeam.setText("");
							textPanePlayerAge.setText("");
							textPanePlayerHeight.setText("");
						} catch (IOException e) {
							e.printStackTrace();
						}
					}
					break;
				case "Match":
					// read the teams file and save it in an arraylist to check if the team entered
					// exists
					File toReadTeam = new File("src/TeamInfo.txt");
					Teams teams = new Teams();
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
					} catch (FileNotFoundException e) {
						e.printStackTrace();
					} catch (Exception e) {
						System.out.println("Unable to check the sport");
					}
					if (textPaneLocalTeam.getText().isEmpty() || textPaneVisitorTeam.getText().isEmpty()
							|| textPaneLocalGoals.getText().isEmpty() || textPaneVisitorGoals.getText().isEmpty()) {
						JOptionPane.showMessageDialog(frame, "Please, fill all the gaps");
					} else if (teams.findTeam(textPaneLocalTeam.getText()) < 0
							|| teams.findTeam(textPaneVisitorTeam.getText()) < 0) {
						JOptionPane.showMessageDialog(frame, "Enter an existing team or create it before");
					} else {
						
						// Connection with mysql to enter a new team

						try {
							Class.forName("com.mysql.cj.jdbc.Driver");
							// jdbc:mysql://localhost/db?useUnicode=true&useJDBCCompliantTimezoneShift=true&useLegacyDatetimeCode=false&serverTimezone=UTC
							Connection con = DriverManager.getConnection(
									"jdbc:mysql://localhost/footballMatches?useUnicode=true&useJDBCCompliantTimezoneShift=true&useLegacyDatetimeCode=false&serverTimezone=UTC",
									"root", "root");
							Statement stmt = con.createStatement();

							String query = " insert into matches (localTeam, visitorTeam, golasVisitor, golaslocal)"
									+ " values (?, ?, ?, ?)";

							// create the mysql insert preparedstatement
							PreparedStatement preparedStmt = con.prepareStatement(query);
							preparedStmt.setString(1, textPaneLocalTeam.getText());
							preparedStmt.setString(2, textPaneVisitorTeam.getText());
							preparedStmt.setInt(3, Integer.parseInt(textPaneLocalGoals.getText()));
							preparedStmt.setInt(4, Integer.parseInt(textPaneVisitorGoals.getText()));
							preparedStmt.execute();
							con.close();
						} catch (SQLException | ClassNotFoundException e) {
							// TODO Auto-generated catch block
							System.err.println("Got an exception! ");
							System.err.println(e.getMessage());
						}
						
						File playerFile = new File("src/MatchInfo.txt");
						try {
							BufferedWriter writer = new BufferedWriter(new FileWriter(playerFile, true));
							writer.write(textPaneLocalTeam.getText() + "::" + textPaneVisitorTeam.getText() + "::"
									+ textPaneLocalGoals.getText() + "::" + textPaneVisitorGoals.getText() + "\n");
							writer.close();
							JOptionPane.showMessageDialog(frame, "Information added correctly");
							textPaneLocalTeam.setText("");
							textPaneVisitorTeam.setText("");
							textPaneLocalGoals.setText("");
							textPaneVisitorGoals.setText("");
						} catch (IOException e) {
							e.printStackTrace();
						}
					}
					break;
				}

			}
		});
		btnAdd.setBounds(0, 368, 301, 37);
		frame.getContentPane().add(btnAdd);

	}
}
