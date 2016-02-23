import java.awt.BorderLayout;
import java.awt.Container;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;

import javax.imageio.ImageIO;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTextArea;


public class ChipsGameWindow {
	
	private ChipsGame game;
	private int buttonSelection;
	private JFrame frame;
	private JTextArea textArea;
	 
			
	
	public ChipsGameWindow() {
		
		game = new ChipsGame();
		
		frame = new JFrame();
		frame.setVisible(true);
		frame.setLayout(new BorderLayout());
		frame.setSize(600, 600);
		frame.setMaximumSize(new Dimension(600, 600));
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		
		
		textArea = new JTextArea();
		textArea.setEditable(false);
		textArea.setLineWrap(true);
		textArea.setWrapStyleWord(true);
		textArea.setColumns(20);
		textArea.setRows(15);
		textArea.setFont(new Font("Serif", Font.PLAIN, 30));
		
		displayMessage(game.getInstructions());
		
		JScrollPane textPane = new JScrollPane(textArea, JScrollPane.VERTICAL_SCROLLBAR_AS_NEEDED, 
				JScrollPane.HORIZONTAL_SCROLLBAR_NEVER);
		
		JButton button1 = new JButton("ONE");
		JButton button2 = new JButton("TWO");
		JButton button3 = new JButton("THREE");
		
		button1.addActionListener(new ActionListener() {
			
			public void actionPerformed(ActionEvent e) {
				executeTurn(1);
			}
			
		});
		
		button2.addActionListener(new ActionListener() {
			
			public void actionPerformed(ActionEvent e) {
				executeTurn(2);
			}
			
		});
		
		button3.addActionListener(new ActionListener() {
			
			public void actionPerformed(ActionEvent e) {
				executeTurn(3);
			}
			
		});
		
		
		button1.setPreferredSize(new Dimension(200, 100));
		
		JPanel buttonPanel = new JPanel();
		buttonPanel.setLayout(new GridLayout(1, 3));
		buttonPanel.add(button1);
		buttonPanel.add(button2);
		buttonPanel.add(button3);
		
		try {
		BufferedImage myPicture = ImageIO.read(new File("mandela.jpg"));
		JLabel picLabel = new JLabel(new ImageIcon(myPicture));
		
		
		Container c = frame.getContentPane();
		c.add(textPane, BorderLayout.CENTER);
		c.add(buttonPanel, BorderLayout.SOUTH);
		c.add(picLabel, BorderLayout.EAST);
		}
		catch(IOException e) {
			System.out.println("Can't find image");
		}
		
		frame.pack();
		
	}
	
	public int getButtonSelection() {
		return buttonSelection;
	}
	public void displayMessage(String message) {
		textArea.append(message+"\n\n");
	}
	
	public void executeTurn(int n) {
		game.setChoice(n);
		game.playerOneTurn();
		game.updateIsFinished();
		displayMessage(game.getMessage());
		if (game.getIsFinished()) {
			game = new ChipsGame();
			displayMessage(game.getRepeatMessage());
		}
		else {
			game.playerTwoTurn();
			game.updateIsFinished();
			displayMessage(game.getMessage());
			if (game.getIsFinished()) {
				game = new ChipsGame();
				displayMessage(game.getRepeatMessage());
			}
		}
	}
	
	public ChipsGame getChipsGame() {
		return game;
	}
	
	public void setChipsGame(ChipsGame anotherGame) {
		game = anotherGame;
	}
	
	public static void main (String[] args) {
		
		ChipsGameWindow theGameWindow = new ChipsGameWindow();
		
	
		
	}

}
