import java.awt.Color;

/**
 * 
 * @author 11429
 * this class used to store the information of players.
 */
public class Player{
	private String id;
	private Color color;
	private int score = 0;
	
	public Color getColor() {
		return color;
	}

	public String getID() {
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
