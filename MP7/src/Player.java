import java.awt.Color;

import javax.swing.JPanel;

public class Player{
	private String id;
	private Color color;
	private int score = 0;
	public Color getColor() {
		// TODO Auto-generated method stub
		return color;
	}

	public String getID() {
		// TODO Auto-generated method stub
		return id;
	}
	public int getScore() {
		return score;
	}
	public void addScore() {
		score++;
	}
	public void setID(String a) {
		id = a;
	}
	public void setColor(Color c) {
		color = c;
	}
	
}
