package assignment9;

import java.util.LinkedList;

public class Snake {

	private static final double SEGMENT_SIZE = 0.05;
	private static final int MOVEMENT_SIZE = 1;
	private LinkedList<BodySegment> segments = new LinkedList<>();
	private int deltaX;
	private int deltaY;
	
	public Snake() {
		deltaX = MOVEMENT_SIZE;
		deltaY = 0;
		for (int i = 0; i < 5; i++) {
			segments.add(new BodySegment(6 - i, 2, SEGMENT_SIZE));
		}
	}
	
	public void changeDirection(int direction) {
		if(direction == 1) { //up
			deltaY = MOVEMENT_SIZE;
			deltaX = 0;
		} else if (direction == 2) { //down
			deltaY = -MOVEMENT_SIZE;
			deltaX = 0;
		} else if (direction == 3) { //left
			deltaY = 0;
			deltaX = -MOVEMENT_SIZE;
		} else if (direction == 4) { //right
			deltaY = 0;
			deltaX = MOVEMENT_SIZE;
		}
	}
	
	/**
	 * Moves the snake by updating the position of each of the segments
	 * based on the current direction of travel
	 */
	public void move() {
		for (int i = segments.size() - 1; i > 0; i--) {
			segments.set(i, new BodySegment(segments.get(i - 1).getX(), segments.get(i - 1).getY(), SEGMENT_SIZE));
		}
		segments.set(0, segments.get(0).move(deltaX, deltaY));
	}
	
	/**
	 * Draws the snake by drawing each segment
	 */
	public void draw() {
		for (int i = 0; i < segments.size(); i++) {
			segments.get(i).draw();
		}
	}
	
	/**
	 * The snake attempts to eat the given food, growing if it does so successfully
	 * @param f the food to be eaten
	 * @return true if the snake successfully ate the food
	 */
	public boolean eatFood(Food f) {
		if ((segments.get(0).getX() == f.getX()) && (segments.get(0).getY() == f.getY())) {
			segments.add(new BodySegment(segments.getLast().getX(), segments.getLast().getY(), SEGMENT_SIZE));
			return true;
		} else {
			return false;
		}
	}
	
	/**
	 * Returns true if the head of the snake is in bounds
	 * @return whether or not the head is in the bounds of the window
	 */
	public boolean isInbounds() {
		if ((segments.get(0).getX() > 0) && (segments.get(0).getX() < 21) && (segments.get(0).getY() > 0) && (segments.get(0).getY() < 21)) {
			return true;
		} else {
			return false;
		}
	}
}
