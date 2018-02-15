package edu.jsu.mcis;

import java.awt.*;
import java.awt.event.*;
import javax.swing.*;

public class TicTacToeView extends JPanel implements ActionListener {
	
	public TicTacToeModel model;
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
		
		for (int i = 0; i < model.getWidth(); i++) {
			for (int j = 0; j < model.getWidth(); j++) {
				
				squares[i][j] = new JButton("");
				squares[i][j].setName("Square" + Integer.toString(i) + Integer.toString(j));
				squares[i][j].addActionListener(this);
				squares[i][j].setPreferredSize(new Dimension(64, 64));
				add(squares[i][j]);
				
			}
		}
		
		add(squaresPanel);
		add(resultLabel);
		resultLabel.setName("ResultLabel");
		resultLabel.setText("Welcome to Tic-Tac-Toe");
        
    }
	
		@Override
		
		public void actionPerformed(ActionEvent event) {
			for(int i = 0; i < model.getWidth(); i++){
				for (int j = 0; j < model.getWidth(); j++){
					
					if(event.getSource() == squares[i][j]){
						if(!model.makeMark(i,j)){
							showInputError();
						}
						else {
							squares[i][j].setText(model.getMark(i,j).toString());
							resultLabel.setText("");
						}
						if(model.getResult() == TicTacToeModel.Result.NONE){
							if(model.isXTurn()){
								resultLabel.setText("X Turn");
							}
							else{
								resultLabel.setText("O Turn");
							}
						}
						else{
							resultLabel.setText(model.getResult().toString().toUpperCase());
						}
					}
				}
			}
			if(model.getResult() != TicTacToeModel.Result.NONE){
				for(int i = 0; i < model.getWidth(); i++) {
					for(int j = 0; j < model.getWidth(); j++){
						squares[i][j].setEnabled(false);
					}
				}
			}
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