import java.awt.BorderLayout;
import java.awt.Color;

import java.util.Scanner;

import javax.swing.JFrame;
import javax.swing.JPanel;

/**
 * 
 * @author 11429
 * this is the class to run the whole gobang game.
 */
public class Game extends JFrame{
	/**
	 * default.
	 */
	private static final long serialVersionUID = 1L;
static Scanner myScan = new Scanner(System.in);
	public static void main(String[] args) {

		 JFrame frame = new JFrame();
		 frame.setSize(700, 700);
		 Panel panel = new Panel();
		
		 System.out.println("Name Yourself, Player 1!");
		 Player player1 = new Player();
		 player1.setID(myScan.next());
		 player1.setColor(Color.black);
		 System.out.println(player1.getID() + ", you will go as black chess!");
		 System.out.println("Name Yourself, Player 2!");
		 Player player2 = new Player();
		 player2.setID(myScan.next());
		 player2.setColor(Color.white);
		 System.out.println(player2.getID() + ", you will go as white chess!");

		 frame.add(panel);
		 frame.setLayout(new BorderLayout());           
	     frame.add(panel,BorderLayout.CENTER);  
		 frame.setVisible(true);	

		 JPanel pa = new JPanel();
		 MouseClick click = new MouseClick(panel, player1, player2);
		 pa.addMouseListener(click);
		 frame.add(pa);
		 frame.setVisible(true);	        	 
	}
} 

