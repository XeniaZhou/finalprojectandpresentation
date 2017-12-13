

import java.awt.Graphics2D;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.util.Scanner;
import javax.swing.JPanel;
/**
	 * this class used to catch the mouse clicks, 
	 * draw the chess and indicate which player is the winner.
	 */
public class MouseClick extends JPanel implements MouseListener{
	static Scanner myScan = new Scanner(System.in);
	
	private static final long serialVersionUID = 1L;
	
	private int num = 0;
	
	private boolean canMove = true;
	
	private Panel panel;
	
	private int trueX;	
	private int trueY;
	
	private Player player1, player2;
	
	private Graphics2D g;
	
	public MouseClick(Panel p, Player a, Player b) {
		this.panel = p;
		this.player1 = a;
		this.player2 = b;
		g = (Graphics2D)this.panel.getGraphics();
	}
	
	@Override
	public void mouseClicked(MouseEvent arg0) {
		if(canMove) {
			int x = arg0.getX() - 15;
			int y = arg0.getY();
			trueX = (x - panel.getX() + panel.getSizex() / 2) / panel.getSizex();  
			trueY = (y - panel.getX() + panel.getSizex() / 2) / panel.getSizex();  
			if (trueX < 15 && trueY < 15 && trueX >= 0 && trueY >= 0) {
					if (panel.getArray()[trueX][trueY] == 0) {
							if (num % 2 == 0) {
								panel.setArray(trueX, trueY, player1.getColor());
								g.setColor(player1.getColor());

								g.fillOval((trueX) * panel.getSizex() + 30, (trueY) * panel.getSizex(), panel.getSizex(), panel.getSizex());
								this.judge();
								num++;
							} else {
								panel.setArray(trueX, trueY, player2.getColor());
								g.setColor(player2.getColor());

								g.fillOval((trueX) * panel.getSizex() + 30, (trueY) * panel.getSizex(), panel.getSizex(), panel.getSizex());
								this.judge();
								num++;
							}
					} else {
							System.out.println("invalid input");
					}
			}
        } else {
        	System.out.println("This turn has been finished!");
        }		
	}
	
	@Override
	public void mouseEntered(MouseEvent arg0) {
		// TODO Auto-generated method stub
		
	}
	@Override
	public void mouseExited(MouseEvent arg0) {
		// TODO Auto-generated method stub
		
	}
	@Override
	public void mousePressed(MouseEvent arg0) {

		
	}
	@Override
	public void mouseReleased(MouseEvent arg0) {
		// TODO Auto-generated method stub
		
	}
	
	public int getTrueX() {
		return trueX;
	}
	public int getTrueY() {
		return trueY;
	}
	
	private int count;

	public void judge()  
    {  
        count = 1;  
        //column  
        for (int i = trueX + 1; i < panel.getColumn(); i++)  
        {  
            if (panel.getArray()[i][trueY] != 0 && 
            		(panel.getArray()[trueX][trueY] % 2) == (panel.getArray()[i][trueY] % 2))  
            {  
                count++;
            } else {
            	break;
            }
        }  
        for (int i = trueX - 1; i >= 0; i--)  
        {  
            if (panel.getArray()[i][trueY] != 0 && 
            		(panel.getArray()[trueX][trueY] % 2) == (panel.getArray()[i][trueY] % 2)) { 
            	count++; 
            } else {
            	break;  
            }
        }  
        if (count >= 5)  
        {  
            if (panel.getArray()[trueX][trueY] % 2 != 0)  
            {  
            	player1.addScore();
            	System.out.println(player1.getID() + " Win!");
            	System.out.println("Total Score: " + player1.getScore());
            	canMove = false;
            	System.out.println("Do you want to try again?(Y)");
            	String temp = myScan.next();
            	if (temp.toUpperCase().equals("Y")) {
            		panel.reSetArray();
            		panel.repaint();
            		canMove = true;
            	}
            } else {  
            	player2.addScore();
            	System.out.println(player2.getID() + " Win!");
            	System.out.println("Total Score: " + player2.getScore());
            	canMove = false;
            	System.out.println("Do you want to try again?(Y)");
            	String temp = myScan.next();
            	if (temp.toUpperCase().equals("Y")) {
            		panel.reSetArray();
            		panel.repaint();
            		canMove = true;
            	}
            }  
            return;  
        }  
        count = 1;  
        //row  
        for (int i = trueY + 1; i < panel.getRow(); i++)  
        {  
            if (panel.getArray()[trueX][i] != 0
            		&&
            		(panel.getArray()[trueX][trueY] % 2) == (panel.getArray()[trueX][i] % 2))  
            {  
                    count++;  
            } else {
            	break;             
            }
        }  
        for (int i = trueY - 1; i >= 0; i--)  
        {  
            if (panel.getArray()[trueX][i] != 0
            		&&
            		(panel.getArray()[trueX][trueY] % 2) == (panel.getArray()[trueX][i] % 2))  
            {   
                    count++;  
            } else {
            	break;  
            }
        }  
        if (count >= 5)  
        {  
            if (panel.getArray()[trueX][trueY]%2 != 0)  
            {  
                player1.addScore();
            	System.out.println(player1.getID() + " Win!");
            	System.out.println("Total Score: " + player1.getScore());
            	canMove = false;
            	System.out.println("Do you want to try again?(Y)");
            	String temp = myScan.next();
            	if (temp.toUpperCase().equals("Y")) {
            		panel.reSetArray();
            		panel.repaint();
            		canMove = true;
            	}
            } else {  
            	player2.addScore();
            	System.out.println(player2.getID() + " Win!");
            	System.out.println("Total Score: " + player2.getScore());
            	canMove = false;
            	System.out.println("Do you want to try again?(Y)");
            	String temp = myScan.next();
            	if (temp.toUpperCase().equals("Y")) {
            		panel.reSetArray();
            		panel.repaint();
            		canMove = true;
            	}
            }  
            return;  
        }   
        count = 1;  
        //left top to right bottom  
        for (int i = trueX - 1, j = trueY - 1; i >= 0 && j >= 0; i--, j--)  
        {  
            if (panel.getArray()[i][j] != 0 &&
            		(panel.getArray()[trueX][trueY] % 2) == (panel.getArray()[i][j] % 2))  
            { 
                    count++;  

            } else {
            	break;  
            }
        }  
        for (int i = trueX + 1, j = trueY + 1; i < panel.getColumn() && j < panel.getRow(); i++, j++)  
        {  
            if (panel.getArray()[i][j] != 0 &&
            		(panel.getArray()[trueX][trueY] % 2) == (panel.getArray()[i][j] % 2))  
            {
                    count++;  

            }else {
            	break;  
            }
        }  
        if (count >= 5)  
        {  
            if (panel.getArray()[trueX][trueY] % 2 != 0)  
            {  
            	player1.addScore();
            	System.out.println(player1.getID() + " Win!");
            	System.out.println("Total Score: " + player1.getScore());
            	canMove = false;
            	System.out.println("Do you want to try again?(Y)");
            	String temp = myScan.next();
            	if (temp.toUpperCase().equals("Y")) {
            		panel.reSetArray();
            		panel.repaint();
            		canMove = true;
            	}
            } else {  
            	player2.addScore();
            	System.out.println(player2.getID() + " Win!");
            	System.out.println("Total Score: " + player2.getScore());
            	canMove = false;
            	System.out.println("Do you want to try again?(Y)");
            	String temp = myScan.next();
            	if (temp.toUpperCase().equals("Y")) {
            		panel.reSetArray();
            		panel.repaint();
            		canMove = true;
            	}
            }  
            return;  
        }  
        count = 1;  
        //left bottom to right top  
        for (int i = trueX - 1,j = trueY + 1;i >= 0 && j < panel.getRow(); i--,j++)  
        {  
            if (panel.getArray()[i][j] != 0 &&
            		(panel.getArray()[trueX][trueY] % 2) == (panel.getArray()[i][j] % 2))  
            {  
               
                    count++;  
 
            } else {
            	break;  
            }
        }  
        for (int i = trueX + 1, j = trueY - 1; i< panel.getColumn() && j >= 0; i++, j--)  
        {  
            if (panel.getArray()[i][j] != 0 &&
            		(panel.getArray()[trueX][trueY] % 2) == (panel.getArray()[i][j] % 2))  
            {                
                    count++;    
            } else {
            	break;  
            }
        }  
        if (count >= 5)  
        {  
            if (panel.getArray()[trueX][trueY] % 2 != 0)  
            {  
            	player1.addScore();
            	System.out.println(player1.getID() + " Win!");
            	System.out.println("Total Score: " + player1.getScore());
            	canMove = false;
            	System.out.println("Do you want to try again?(Y)");
            	String temp = myScan.next();
            	if (temp.toUpperCase().equals("Y")) {
            		panel.reSetArray();
            		panel.repaint();
            		canMove = true;
            	}
            } else {  
            	player2.addScore();
            	System.out.println(player2.getID() + " Win!");
            	System.out.println("Total Score: " + player2.getScore());
            	canMove = false;
            	System.out.println("Do you want to try again?(Y)");
            	String temp = myScan.next();
            	if (temp.toUpperCase().equals("Y")) {
            		panel.reSetArray();
            		panel.repaint();
            		canMove = true;
            	}
            }  
            return;  
        }  
    } 

}
