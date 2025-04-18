package assignment9;

import java.awt.event.KeyEvent;

import java.util.LinkedList;

import edu.princeton.cs.introcs.StdDraw;

public class Game {
	
	Snake snake;
	Food food;
	private LinkedList<Wall> walls = new LinkedList<>();
	
	public Game() {
		StdDraw.enableDoubleBuffering();
		this.snake = new Snake();
		this.food = new Food();
	}
	
	public void play() {
		while (snake.isInbounds() && checkWalls()) {
			int dir = getKeypress();
			/*
			 * 1. Pass direction to your snake
			 * 2. Tell the snake to move
			 * 3. If the food has been eaten, make a new one
			 * 4. Update the drawing
			 */
			snake.changeDirection(dir);
			snake.move();
			if (snake.eatFood(food)) {
				walls.add(new Wall());
				food = new Food();
			}
			updateDrawing();
		}
	}

	private int getKeypress() {
		if(StdDraw.isKeyPressed(KeyEvent.VK_W)) {
			return 1;
		} else if (StdDraw.isKeyPressed(KeyEvent.VK_S)) {
			return 2;
		} else if (StdDraw.isKeyPressed(KeyEvent.VK_A)) {
			return 3;
		} else if (StdDraw.isKeyPressed(KeyEvent.VK_D)) {
			return 4;
		} else {
			return -1;
		}
	}
	
	private boolean checkWalls() {
		for (Wall item : walls) {
			if ((food.getX() == item.getX()) && (food.getY() == item.getY())) {
				food = new Food();
			}
		}
		for (Wall item : walls) {
			if ((snake.getHead().getX() == item.getX()) && (snake.getHead().getY() == item.getY())) {
				return false;
			}
		}
		return true;
	}
	
	/**
	 * Clears the screen, draws the snake and food, pauses, and shows the content
	 */
	private void updateDrawing() {
		/*
		 * 1. Clear screen
		 * 2. Draw snake and food
		 * 3. Pause (50 ms is good)
		 * 4. Show
		 */
		StdDraw.clear();
		this.snake.draw();
		for (Wall item : walls) {
			item.draw();
		}
		this.food.draw();
		StdDraw.pause(100);
		StdDraw.show();
	}
	
	public static void main(String[] args) {
		Game g = new Game();
		g.play();
	}
}
