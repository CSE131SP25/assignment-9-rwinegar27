package assignment9;

import java.awt.Color;
import java.util.Random;

import edu.princeton.cs.introcs.StdDraw;

public class Food {

	public static final double FOOD_SIZE = 0.02;
	private double x, y;
	
	/**
	 * Creates a new Food at a random location
	 */
	public Food() {
		Random rand = new Random();
		int randX = 2 * rand.nextInt(49) + 2;
		x = randX / 100.0;
		
		int randY = 2 * rand.nextInt(49) + 2;
		y = randY / 100.0;
	}
	
	/**
	 * Draws the Food
	 */
	public void draw() {
		StdDraw.setPenColor(200, 100, 200);
		StdDraw.filledSquare(x, y, FOOD_SIZE);
	}
	
	public double getX() {
		return x;
	}
	
	public double getY() {
		return y;
	}
}
