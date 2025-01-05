package main;

import java.awt.Color;
import java.awt.Font;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.*;

public class JavaTicTacToe implements ActionListener {
	
	JFrame frame; // Jframe
	
	JPanel startPanel; // first screen - start game
	JPanel gamePanel; // second screen - the game
	JPanel buttonPanel; // panel with grid
	
	JLabel title; // title label
	JLabel imgCover; // holds the cover image
	JLabel playerInfo; // label that shows info game
	
	JButton startButton;
	
	// Font Settings (font, type, size)
	Font fontTitle = new Font("Candara",Font.BOLD,42);
	Font fontMax = new Font("Candara",Font.BOLD,120);
	Font fontMid = new Font("Candara",Font.BOLD,24);
	
	JButton [] buttons = new JButton[9]; // array of numbers
	JButton restartButton; // restartButton
	
	int buttonsPressed = 0;
	
	boolean xTurn = true; // boolean to flag if its X or O turn

	// constructor
	public JavaTicTacToe() {
		
		frame = new JFrame("Java Tic Tac Toe"); // creates JFrame
		frame.setSize(700, 700); // sets size
		frame.setLocationRelativeTo(null); // centralizes frame
		
		startScreen(); // calls startScreen
		frame.setVisible(true); // set frame visible after all elements
	}
	
	// sets start screen
	public void startScreen() {
		
		startPanel = new JPanel(); // creates JPanel
		startPanel.setSize(700, 700); // sets size
		startPanel.setBackground(Color.black); // sets color background
		startPanel.setLayout(null); // sets layout to null
		frame.add(startPanel); // adds Jpanel to JFrame
	
		title = new JLabel("Java Tic Tac Toe"); // creates JLabel for title
		title.setBounds(200, 20, 300, 50); // sets coordinates
		title.setFont(fontTitle); // sets font
		title.setForeground(Color.red); // sets font color
		//title.setBorder(redBorder2); // set border
		startPanel.add(title); // add title to panel
		
		imgCover = new JLabel(); // creates label to hold image
		imgCover.setBounds(120, 90, 450, 450); // set coordinates
		startPanel.add(imgCover); // add label to panel
		
		ImageIcon img = new ImageIcon(getClass().getResource("/img/cover450.jpg")); // gets cover image and sets it to ImageIcon
		imgCover.setIcon(img); // sets ImageIcon to label
		
		startButton = new JButton("START!"); // creates button and sets text
		startButton.setBounds(260, 570, 150, 45); // sets coordinates
		startButton.setBackground(Color.orange); // sets background color
		startButton.setForeground(Color.black); // sets font color
		startButton.setFont(fontMid); // sets font
		startButton.addActionListener(this); // adds actionListener to capture events
		startPanel.add(startButton); // adds button to panel
		
		
		startPanel.setVisible(true); // sets panel visible after all elements
	}
	
	// sets gamePlay
	public void setGamePlay() {
		
		startPanel.setVisible(false); // turns off startPanel
		
		gamePanel = new JPanel(); // create gamePanel
		gamePanel.setLayout(null); // no layout
		gamePanel.setSize(700, 700); // sets size
		frame.add(gamePanel); // add panel to frame
		
		buttonPanel = new JPanel(); // create buttonPanel
		buttonPanel.setLayout(new GridLayout (3,3)); // grid layout 3 x 3
		buttonPanel.setBounds(0, 0, 700, 600); // sets coordinates
		gamePanel.add(buttonPanel); // adds button to panel
		
		playerInfo = new JLabel("Player x turn!"); // creates JLabel for title
		playerInfo.setBounds(120,613, 300, 35); // sets coordinates
		playerInfo.setFont(fontMid); // sets font
		playerInfo.setForeground(Color.black); // sets font color
		gamePanel.add(playerInfo); // add title to panel
		
		restartButton = new JButton("Restart"); // creates button and sets text
		restartButton.setBounds(390, 610, 130, 35); // sets coordinates
		restartButton.setFont(fontMid); // set font
		restartButton.setBackground(Color.orange); // sets background color
		restartButton.setForeground(Color.black); // sets font color
		restartButton.addActionListener(this); // adds actionListener
		gamePanel.add(restartButton); // add button to panel

		
		// for loop for buttons settings
		for (int i = 0; i < 9 ; i++) {
			buttons[i] = new JButton(); // creates buttons
			buttonPanel.add(buttons[i]); // adds buttons to panel
			buttons[i].setFont(fontMax); // sets fonts
			buttons[i].setFocusable(false); // disables focusable
			buttons[i].addActionListener(this); // adds actionlistener
			buttons[i].setBackground(Color.black); // sets buttons color

		}
		
		// turn visible after all the elements
		gamePanel.setVisible(true);
		
	}
	
	// check if its a draw
	public void checkDraw() {
		// if all the buttons have been pressed
		if (buttonsPressed == 9) {
			playerInfo.setBounds(100,613, 300, 35); // centralize text
			playerInfo.setText("Draw! Restart the game"); // shows draw text
			
			// disables buttons
			for (int i = 0; i < 9; i ++) {
				buttons[i].setEnabled(false);
			}
		} // end if
	} // end checkDraw

	// check for wins
	public void checkVictory() {
		
		// check in every turn, if there is a draw
		checkDraw();
		
		// combinations who giver Player X the victory
		if (
				buttons[0].getText().equals("X") &&
				buttons[1].getText().equals("X") && 
				buttons[2].getText().equals("X")) {
					setVictory(0, 1, 2, "X");
		}
		
		if (
				buttons[3].getText().equals("X") &&
				buttons[4].getText().equals("X") && 
				buttons[5].getText().equals("X")) {
					setVictory(3, 4, 5, "X");
		}
		
		if (
				buttons[6].getText().equals("X") &&
				buttons[7].getText().equals("X") && 
				buttons[8].getText().equals("X")) {
					setVictory(6, 7, 8, "X");
		}
		
		if (
				buttons[0].getText().equals("X") &&
				buttons[3].getText().equals("X") && 
				buttons[6].getText().equals("X")) {
					setVictory(0, 3, 6, "X");
		}
		
		if (
				buttons[1].getText().equals("X") &&
				buttons[4].getText().equals("X") && 
				buttons[7].getText().equals("X")) {
					setVictory(1, 4, 7, "X");
		}
		
		if (
				buttons[2].getText().equals("X") &&
				buttons[5].getText().equals("X") && 
				buttons[8].getText().equals("X")) {
					setVictory(2, 5, 8, "X");
		}
		
		if (
				buttons[0].getText().equals("X") &&
				buttons[4].getText().equals("X") && 
				buttons[8].getText().equals("X")) {
					setVictory(0, 4, 8, "X");
		}
		
		if (
				buttons[2].getText().equals("X") &&
				buttons[4].getText().equals("X") && 
				buttons[6].getText().equals("X")) {
					setVictory(2, 4, 6, "X");
		}
		
		// combinations who giver Player O the victory
		
		if (
				buttons[0].getText().equals("O") &&
				buttons[1].getText().equals("O") && 
				buttons[2].getText().equals("O")) {
					setVictory(0, 1, 2, "O");
		}
		
		if (
				buttons[3].getText().equals("O") &&
				buttons[4].getText().equals("O") && 
				buttons[5].getText().equals("O")) {
					setVictory(3, 4, 5, "O");
		}
		
		if (
				buttons[6].getText().equals("O") &&
				buttons[7].getText().equals("O") && 
				buttons[8].getText().equals("O")) {
					setVictory(6, 7, 8, "O");
		}
		
		if (
				buttons[0].getText().equals("O") &&
				buttons[3].getText().equals("O") && 
				buttons[6].getText().equals("O")) {
					setVictory(0, 3, 6, "O");
		}
		
		if (
				buttons[1].getText().equals("O") &&
				buttons[4].getText().equals("O") && 
				buttons[7].getText().equals("O")) {
					setVictory(1, 4, 7, "O");
		}
		
		if (
				buttons[2].getText().equals("O") &&
				buttons[5].getText().equals("O") && 
				buttons[8].getText().equals("O")) {
					setVictory(2, 5, 8, "O");
		}
		
		if (
				buttons[0].getText().equals("O") &&
				buttons[4].getText().equals("O") && 
				buttons[8].getText().equals("O")) {
					setVictory(0, 4, 8, "O");
		}
		
		if (
				buttons[2].getText().equals("O") &&
				buttons[4].getText().equals("O") && 
				buttons[6].getText().equals("O")) {
					setVictory(2, 4, 6, "O");
		}
		
		
	}
	
	// sets the game victory - arguments are the numbers of the buttons and X or O
	public void setVictory(int a, int b, int c, String p) {
		
		// if the winner is X, sets colors
		if (p.equals("X")) {
			buttons[a].setBackground(Color.red);
			buttons[a].setForeground(Color.black);
			
			buttons[b].setBackground(Color.red);
			buttons[b].setForeground(Color.black);
			
			buttons[c].setBackground(Color.red);
			buttons[c].setForeground(Color.black);
			
			// disable all buttons
			for (int i =0; i < 9; i++) {
				buttons[i].setEnabled(false);
			}
			
			// show message
			playerInfo.setText("Player X is the winner!");
		}
		
		// if the winner is O, sets colors
		if (p.equals("O")) {
			
			buttons[a].setBackground(Color.blue);
			buttons[a].setForeground(Color.white);
			
			buttons[b].setBackground(Color.blue);
			buttons[b].setForeground(Color.white);
			
			buttons[c].setBackground(Color.blue);
			buttons[c].setForeground(Color.white);
			
			// disable all buttons
			for (int i =0; i < 9; i++) {
				buttons[i].setEnabled(false);
			}
			
			
			// show message
			playerInfo.setText("Player O is the winner!");
		} // end if
	} // end setVictory
	
	// set X and O turn
	public void setTurn() {
		if (xTurn) {
			playerInfo.setText("Player X turn");
		}
		
		else {
			playerInfo.setText("Player O turn");
		}
	}
	
	// main method to run the program
	public static void main(String[] args) {
		JavaTicTacToe game = new JavaTicTacToe();
	}

	// actionPerformed for the events
	public void actionPerformed(ActionEvent e) {
		
		// startButton events
		if (e.getSource() == startButton) {
			
			startPanel.setVisible(false); // turn off startPanel
			setGamePlay(); // calls setGamePlay to set the game
		}
		
		// catches the buttons played and check for wins
		for(int i = 0; i < 9; i ++) {
			if(e.getSource() == buttons[i]) { // if a button is press
				buttonsPressed += 1; // increase to buttonsPressed
				
				// if is xTurn
				if (xTurn) {
	
					// is the button is empty, sets it to X
					if (buttons[i].getText().equals("")) { 
						buttons[i].setText("X"); 
						buttons[i].setForeground(Color.red);
						
						checkVictory(); // checks for victory
						xTurn = false; // ends xTurn
						setTurn(); // changes to O turn
					}
				}
				
				// if is OTurn
				else {
					
					// is the button is empty, sets it to O
					if (buttons[i].getText().equals(""))
						buttons[i].setText("O"); 
						buttons[i].setForeground(Color.blue);
						checkVictory(); // checks for victory
						xTurn = true; // ends O turn
						setTurn(); // changes to X turn

				} // end else
				
			} // end if
	
		} // end for
		
			// restartButton settings
			if (e.getSource() == restartButton) {
				xTurn = true; // sets to xTurn
				buttonsPressed = 0;
				// for loop to reset settings in all the buttons
				for (int i = 0; i < 9; i++) {
					buttons[i].setText("");
					buttons[i].setBackground(Color.black);
					buttons[i].setEnabled(true);
					playerInfo.setText("Player X turn");
					
				} // end for
			} // end restartButton
		
	} // end actionPerformed
		
	

}
