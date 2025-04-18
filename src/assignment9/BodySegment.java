package assignment9;

import java.awt.Color;

import edu.princeton.cs.introcs.StdDraw;

public class BodySegment {

	private int x, y;
	private double size;
	private Color color = Color.GREEN;
	
	public BodySegment(int x, int y, double size) {
		this.x = x;
		this.y = y;
		this.size = size;
	}
	
	public int getX() {
		return x;
	}
	
	public int getY() {
		return y;
	}
	
	public BodySegment move(int deltaX, int deltaY) {
		x = x + deltaX;
		y = y + deltaY;
		return this;
	}
	
	/**
	 * Draws the segment
	 */
	public void draw() {
		StdDraw.setPenColor(color);
		StdDraw.filledSquare(x * size - size * 0.5, y * size - size * 0.5, size * 0.5);
	}
	
}
