import java.awt.Color;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.util.Scanner;

import javax.swing.JPanel;
/**
 * 
 * @author 11429
 * this class is used to paint the whole chess board, which is in the dimension of 15 * 15.
 */
public class Panel extends JPanel{
	/**
	 * default.
	 */
	private static final long serialVersionUID = 1L;
	
	static Scanner myScan = new Scanner(System.in);
	
	private final int row = 15;
	private final int column = 15;
	private final int x = 25;
	private final int size = 40;
	
	private int[][] array = new int[row][column];
	
	public void paint(Graphics gg) {
        //paint the grid 
		super.paint(gg);
		Graphics2D g = (Graphics2D) gg;
		g.setColor(Color.black);
		 for(int i = 0; i < row; i++)//ÐÐ  
	        {  
	            g.drawLine(x, x + i * size, x + size * (column - 1), x + i * size);  
	        }  
	        for(int i = 0; i < column; i++)//ÁÐ  
	        {  
	            g.drawLine(x + i * size, x, x + i * size, x + size * (row - 1));  
	        }  
	}
	
	public void reSetArray() {
		for (int i = 0; i < column; i++) {
			for (int j = 0; j < row; j++) {
				array[i][j] = 0;
			}
		}
	}
	
	public int getRow() {
		return row;
	}
	public int getColumn() {
		return column;
	}
	public int[][] getArray() {
		return array;
	}
	public int getX() {
		return x;
	}
	public int getSizex() {
		return size;
	}
	
	public void setArray(int trueX, int trueY, Color c) {
		if (c.equals(Color.black)) {
		array[trueX][trueY] = 1;
		} else {
			array[trueX][trueY] = 2;
		}
	}
	
}