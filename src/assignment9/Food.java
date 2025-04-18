package assignment9;

import java.awt.Color;

import edu.princeton.cs.introcs.StdDraw;

public class Food {

	public static final double FOOD_SIZE = 0.05;
	private int x, y;
	private Color color = Color.RED;
	
	/**
	 * Creates a new Food at a random location
	 */
	public Food() {
		this.x = ((int) (Math.random() / FOOD_SIZE)) + 1;
		this.y = ((int) (Math.random() / FOOD_SIZE)) + 1;
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
		StdDraw.filledCircle(x * FOOD_SIZE - FOOD_SIZE * 0.5, y * FOOD_SIZE - FOOD_SIZE * 0.5, FOOD_SIZE * 0.5);
	}
	
}
