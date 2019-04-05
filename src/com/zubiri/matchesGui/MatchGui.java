package com.zubiri.matchesGui;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JLabel;
import java.awt.BorderLayout;
import javax.swing.JList;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.KeyListener;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.awt.event.MouseMotionListener;
import java.io.File;
import java.io.FileNotFoundException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.Scanner;
import java.awt.event.ActionEvent;
import java.awt.Font;
import java.awt.TextArea;
import java.awt.Color;
import java.awt.Component;

import javax.swing.JFormattedTextField;
import javax.swing.JToggleButton;
import javax.swing.JMenuBar;
import javax.swing.JTextField;
import javax.swing.JComboBox;
import javax.swing.AbstractAction;
import javax.swing.Action;
import com.zubiri.matches.*;
import javax.swing.JPanel;
import javax.swing.JTextPane;
import java.awt.CardLayout;
import javax.swing.JMenu;
import javax.swing.JMenuItem;
import javax.swing.JOptionPane;
import javax.swing.JScrollBar;
import javax.swing.JTextArea;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;

public class MatchGui {

	private JFrame frame;
	private JTextField txtFindForA;
	private final Action action = new SwingAction();
	private JComboBox comboBox;
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

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					MatchGui window = new MatchGui();
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
	public MatchGui() {
		initialize();
	}

	public JFrame getFrame() {
		return this.frame;
	}

	public JComboBox getCombobox() {
		return this.comboBox;
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

		textPaneStadium.setEditable(false);
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
		textPaneWonLeagues.setBackground(new Color(204, 204, 204));
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
		frame.getContentPane().setBackground(Color.WHITE);
		frame.setBounds(100, 100, 311, 455);
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

		menuItem_3 = new JMenuItem("Add");
		menuItem_3.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				AddGui addGui = new AddGui();
				addGui.getFrame().setVisible(true);

				frame.dispose();
			}
		});
		menu_1.add(menuItem_3);

		JMenuItem mntmDelete = new JMenuItem("Delete");
		mntmDelete.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				DeleteGui deleteGui = new DeleteGui();
				deleteGui.getFrame().setVisible(true);

				frame.dispose();
			}
		});
		menu_1.add(mntmDelete);

		panel = new JPanel();
		panel.setBounds(0, 159, 295, 257);
		panel.setBackground(Color.WHITE);
		frame.getContentPane().add(panel);
		panel.setLayout(null);

		txtFindForA = new JTextField();
		txtFindForA.setBounds(102, 61, 183, 35);
		txtFindForA.setToolTipText("");
		frame.getContentPane().add(txtFindForA);
		txtFindForA.setColumns(10);

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
			sc = new Scanner(toReadMatches);
			while (sc.hasNextLine()) {
				boolean foundLocal = true;
				boolean foundVisitor = true;
				FootballMatch match = new FootballMatch();
				String lineValues[] = sc.nextLine().split("::");
				if (teams.findTeam(lineValues[0]) < 0) {
					FootballTeam a = new FootballTeam();
					a.setName(lineValues[0]);
					a.setStadium("No info");
					a.setWonLeagues(-1);
					a.setShirtColor("No info");
					match.setLocalTeam(a);
					foundLocal = false;

				}
				if (teams.findTeam(lineValues[1]) < 0) {
					FootballTeam a = new FootballTeam();
					a.setName(lineValues[1]);
					a.setStadium("No info");
					a.setWonLeagues(-1);
					a.setShirtColor("No info");
					match.setVisitorTeam(a);
					foundVisitor = false;
				}
				if (foundLocal)
					match.setLocalTeam(teams.getTeam(teams.findTeam(lineValues[0])));
				if (foundVisitor)
					match.setVisitorTeam(teams.getTeam(teams.findTeam(lineValues[1])));

				match.setGoalsLocal(Integer.parseInt(lineValues[2]));
				match.setGoalsVisitor(Integer.parseInt(lineValues[3]));
				matches.add(match);
			}
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		} catch (Exception e) {
			System.out.println("Unable to check the sport");
		}

		JButton btnNewButton = new JButton("Find");
		txtFindForA.addKeyListener(new KeyAdapter() {
			@Override
			public void keyPressed(KeyEvent e) {
				if (e.getKeyCode() == KeyEvent.VK_ENTER) {

					switch (comboBox.getSelectedItem().toString().toLowerCase()) {
					case "team":
						panel.removeAll();
						panel.setVisible(true);

						fillTeamPanel();
						lblName.setEnabled(true);
						textPaneName.setEditable(false);

						// Take information from server

						try {
							Class.forName("com.mysql.cj.jdbc.Driver");
							// jdbc:mysql://localhost/db?useUnicode=true&useJDBCCompliantTimezoneShift=true&useLegacyDatetimeCode=false&serverTimezone=UTC
							Connection con = DriverManager.getConnection(
									"jdbc:mysql://localhost/footballMatches?useUnicode=true&useJDBCCompliantTimezoneShift=true&useLegacyDatetimeCode=false&serverTimezone=UTC",
									"root", "root");
							Statement stmt = con.createStatement();

							String query = "select * from teams where name = '" + txtFindForA.getText() + "'";

							ResultSet result = stmt.executeQuery(query);
							// create the mysql insert prepared statement
							result.first();
							textPaneName.setText(result.getString(1));
							textPaneStadium.setEditable(false);
							textPaneStadium.setText(result.getString(2));
							textPaneWonLeagues.setEditable(false);
							textPaneWonLeagues.setText(Integer.toString(result.getInt(3)));
							textPaneShirtColor.setEditable(false);
							textPaneShirtColor.setText(result.getString(4));
							con.close();
						} catch (SQLException | ClassNotFoundException e1) {
							// TODO Auto-generated catch block
							System.err.println("Got an exception! ");
							System.err.println(e1.getMessage());
						}
						break;
					case "player":
						panel.removeAll();
						panel.setVisible(true);
						fillPlayerPanel();

						try {
							Class.forName("com.mysql.cj.jdbc.Driver");
							// jdbc:mysql://localhost/db?useUnicode=true&useJDBCCompliantTimezoneShift=true&useLegacyDatetimeCode=false&serverTimezone=UTC
							Connection con = DriverManager.getConnection(
									"jdbc:mysql://localhost/footballMatches?useUnicode=true&useJDBCCompliantTimezoneShift=true&useLegacyDatetimeCode=false&serverTimezone=UTC",
									"root", "root");
							Statement stmt = con.createStatement();

							String query = "select * from players where name = '" + txtFindForA.getText() + "'";

							ResultSet result = stmt.executeQuery(query);
							// create the mysql insert prepared statement
							result.first();
							textPanePlayerName.setEditable(false);
							textPanePlayerName.setText(result.getString(1));
							textPanePlayerAge.setEditable(false);
							textPanePlayerAge.setText(Integer.toString(result.getInt(3)));
							textPanePlayerHeight.setEditable(false);
							textPanePlayerHeight.setText(Integer.toString(result.getInt(4)));
							textPanePlayerTeam.setEditable(false);
							textPanePlayerTeam.setText(result.getString(2));
							con.close();
						} catch (SQLException | ClassNotFoundException e1) {
							// TODO Auto-generated catch block
							System.err.println("Got an exception! ");
							System.err.println(e1.getMessage());
						}

						break;
					case "match":
						panel.removeAll();
						panel.setVisible(true);
						JTextArea textArea = new JTextArea();
						textArea.setBounds(34, 0, 232, 257);
						textArea.setFont(new Font("Verdana", Font.PLAIN, 13));
						textArea.setEditable(false);
						textArea.setAutoscrolls(true);
						panel.add(textArea);

						try {
							Class.forName("com.mysql.cj.jdbc.Driver");
							// jdbc:mysql://localhost/db?useUnicode=true&useJDBCCompliantTimezoneShift=true&useLegacyDatetimeCode=false&serverTimezone=UTC
							Connection con = DriverManager.getConnection(
									"jdbc:mysql://localhost/footballMatches?useUnicode=true&useJDBCCompliantTimezoneShift=true&useLegacyDatetimeCode=false&serverTimezone=UTC",
									"root", "root");
							Statement stmt = con.createStatement();

							String query = "select * from matches where localTeam = '" + txtFindForA.getText()
									+ "'|| visitorTeam = '" + txtFindForA.getText() + "'";

							ResultSet result = stmt.executeQuery(query);
							// create the mysql insert prepared statement
							//result.first();
							while (result.next()) {
							
								textArea.append(result.getString("localTeam") + "  " + result.getInt("goalsLocal") + " - "
										+ result.getInt("goalsVisitor") + "  " +  result.getString("visitorTeam") + "\n");
							}
							con.close();
						} catch (SQLException | ClassNotFoundException e1) {
							// TODO Auto-generated catch block
							System.err.println("Got an exception! ");
							System.err.println(e1.getMessage());
						}

						break;
					}
				}
			}
		});

		btnNewButton.addMouseListener(new MouseListener() {

			@Override
			public void mouseReleased(MouseEvent e) {
				// TODO Auto-generated method stub

			}

			@Override
			public void mousePressed(MouseEvent e) {
				// TODO Auto-generated method stub

			}

			@Override
			public void mouseExited(MouseEvent e) {
				// TODO Auto-generated method stub
				btnNewButton.setBackground(Color.white);
				btnNewButton.setFont(new Font("Dialog", Font.PLAIN, 14));
			}

			@Override
			public void mouseEntered(MouseEvent e) {
				btnNewButton.setBackground(Color.gray);
				btnNewButton.setForeground(Color.black);
				btnNewButton.setFont(new Font("Verdana", Font.PLAIN, 20));

				// TODO Auto-generated method stub

			}

			@Override
			public void mouseClicked(MouseEvent e) {
				// TODO Auto-generated method stub

			}
		});

		btnNewButton.setBounds(10, 107, 275, 41);
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				switch (comboBox.getSelectedItem().toString().toLowerCase()) {
				case "team":
					panel.removeAll();
					panel.setVisible(true);

					int position = teams.findTeam(txtFindForA.getText().toLowerCase());
					if (position >= 0) {
						fillTeamPanel();
						lblName.setEnabled(true);
						textPaneName.setEditable(false);
						textPaneName.setText(teams.getTeam(position).getName());
						textPaneStadium.setEditable(false);
						textPaneStadium.setText(teams.getTeam(position).getStadium());
						textPaneWonLeagues.setEditable(false);
						textPaneWonLeagues.setText(Integer.toString(teams.getTeam(position).getWonLeagues()));
						textPaneShirtColor.setEditable(false);
						textPaneShirtColor.setText(teams.getTeam(position).getShirtColor());
					} else
						JOptionPane.showMessageDialog(frame, "Not found");
					break;
				case "player":
					panel.removeAll();
					panel.setVisible(true);

					position = players.findPlayer(txtFindForA.getText().toLowerCase());
					if (position >= 0) {
						fillPlayerPanel();
						textPanePlayerName.setEditable(false);
						textPanePlayerAge.setEditable(false);
						textPanePlayerHeight.setEditable(false);
						textPanePlayerTeam.setEditable(false);

						textPanePlayerName.setText(players.getPlayer(position).getName());
						textPanePlayerTeam.setText(players.getPlayer(position).getTeam());
						textPanePlayerAge.setText(Integer.toString(players.getPlayer(position).getAge()));
						textPanePlayerHeight.setText(Integer.toString(players.getPlayer(position).getHeight()));
					} else
						JOptionPane.showMessageDialog(frame, "Not found");

					break;
				case "match":
					panel.removeAll();
					panel.setVisible(true);
					JTextArea textArea = new JTextArea();
					textArea.setBounds(34, 0, 232, 257);
					textArea.setFont(new Font("Verdana", Font.PLAIN, 13));
					textArea.setEditable(false);
					textArea.setAutoscrolls(true);
					panel.add(textArea);
					boolean found = false;
					for (int i = 0; i < matches.size(); i++) {
						if (matches.get(i).getLocalTeam().getName().toLowerCase()
								.equals(txtFindForA.getText().toLowerCase())
								|| matches.get(i).getVisitorTeam().getName().toLowerCase()
										.equals(txtFindForA.getText().toLowerCase())) {
							textArea.append(matches.get(i).getLocalTeam().getName() + "  "
									+ matches.get(i).getGoalsLocal() + " - " + +matches.get(i).getGoalsVisitor() + "  "
									+ matches.get(i).getVisitorTeam().getName() + "\n");
							found = true;

						}
					}
					if (!found)
						JOptionPane.showMessageDialog(frame, "Not found");
					frame.repaint();

					break;
				}
			}
		});

		btnNewButton.setAction(action);
		btnNewButton.setBackground(Color.WHITE);
		frame.getContentPane().add(btnNewButton);

		comboBox = new JComboBox();
		comboBox.setBounds(10, 61, 82, 35);
		comboBox.setForeground(Color.DARK_GRAY);
		comboBox.setBackground(Color.WHITE);
		frame.getContentPane().add(comboBox);
		comboBox.addItem("Team");
		comboBox.addItem("Player");
		comboBox.addItem("Match");
	}

	private class SwingAction extends AbstractAction {
		public SwingAction() {
			putValue(NAME, "Find");
			putValue(SHORT_DESCRIPTION, "find information about the selected category");
		}

		public void actionPerformed(ActionEvent e) {
		}
	}
}
