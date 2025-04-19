package assignment9;

import java.awt.Color;
import java.awt.Font;
import java.awt.event.KeyEvent;

import edu.princeton.cs.introcs.StdDraw;

public class Game {
	
	private Snake snake;
	private Food food;
	private int foodEaten;
	
	public Game() {
		StdDraw.enableDoubleBuffering();
		this.snake = new Snake();
		this.food = new Food();
	}
	
	public void play() {
		while (snake.isInbounds()) {
			int dir = getKeypress();
			if (dir != -1) {
				snake.changeDirection(dir);
			}
			
			snake.move();
			
			if(snake.eatFood(food)) {
				food = new Food();
				foodEaten++;
			}
			
			updateDrawing();
			
			if (!snake.isInbounds()) {
				StdDraw.clear(StdDraw.DARK_GRAY);
				StdDraw.setPenColor(StdDraw.RED); //game over message window
				StdDraw.filledRectangle(0.5, 0.5, 0.4, 0.2); //game over window
				
				StdDraw.setPenColor(StdDraw.BLACK); //border color
				StdDraw.setPenRadius(0.005); //border thickness
				StdDraw.rectangle(0.5, 0.5, 0.4, 0.2);
				
				Font font = new Font("Times New Roman", Font.BOLD, 50);
				StdDraw.setFont(font);
				StdDraw.setPenColor(Color.BLACK);
				StdDraw.text(0.5, 0.6, "GAME OVER!");
				
				StdDraw.setPenColor(Color.BLACK);
				StdDraw.text(0.5, 0.4, "SCORE: " + foodEaten);
				
				StdDraw.show();				
			}
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
	
	/**
	 * Clears the screen, draws the snake and food, pauses, and shows the content
	 */
	private void updateDrawing() {
		
		//display game window
		StdDraw.clear(StdDraw.LIGHT_GRAY);
		snake.draw();
		food.draw();
		
		StdDraw.setPenColor(Color.BLACK);
		StdDraw.text(0.5, 0.96, "Score: " + foodEaten);
		
		StdDraw.pause(50);
		
		StdDraw.show();
	}
	
	public static void main(String[] args) {
		Game g = new Game();
		g.play();
	}
}
