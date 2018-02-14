package edu.jsu.mcis;

import java.awt.*;
import java.awt.event.*;
import javax.swing.*;

public class TicTacToeView extends Jpanel implements ActionListener {
	
	public TicTacToe model;
	private JButton[][] squares;
	private JPanel squaresPanel;
	private JLabel resultLabel;
	

    /* CONSTRUCTOR */
	
    public TicTacToeView(TicTacToeModel model) {
        
        this.model = model;
		int width = model.getWidth();
		
		setLayout(new GridLayout(model.getWidth() + 1, model.getWidth() + 1));
		squares = new JButton[width][width];
		squaresPanel = new JPanel(new GridLayout(width,width));
		resultLabel = new JLabel();
		resultLabel.setName("ResultLabel");
		
		for (int row = 0; row < model.getWidth(); row++) {
			for (int col = 0; col < model.getWidth(); col++) {
				
				squares[row][col] = new JButton("");
				squares[row][col].setName("Square" + Integer.toString(row) + Integer.toString(col));
				squares[row][col].addActionListener(this);
				squares[row][col].setPreferredSize(new Dimension(64, 64));
				add(square[row][col]);
				
			}
		}
		
		add(squarePanel);
		add(resultLabel);
		resultLabel.setName("ResultLabel");
		resultLabel.setText(Welcome to Tic-Tac-Toe");
        
    }
	


    public void showInputError() {

        /* Display an error if input is invalid (see examples) */

        System.out.println("Invalid Input!");

    }

    public void showResult(String r) {

        /* Display final winner */

        System.out.println(r + "!");

    }
	
}