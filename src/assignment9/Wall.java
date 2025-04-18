package assignment9;

import java.awt.Color;

import edu.princeton.cs.introcs.StdDraw;

public class Wall {

	public static final double WALL_SIZE = 0.05;
	private int x, y;
	private Color color = Color.BLACK;
	
	/**
	 * Creates a new Wall at a random location
	 */
	public Wall() {
		this.x = ((int) (Math.random() / WALL_SIZE)) + 1;
		this.y = ((int) (Math.random() / WALL_SIZE)) + 1;
	}
	
	public int getX() {
		return x;
	}
	
	public int getY() {
		return y;
	}
	
	/**
	 * Draws the Food
	 */
	public void draw() {
		StdDraw.setPenColor(color);
		StdDraw.filledSquare(x * WALL_SIZE - WALL_SIZE * 0.5, y * WALL_SIZE - WALL_SIZE * 0.5, WALL_SIZE * 0.5);
	}
	
}
