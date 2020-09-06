/**
 * @(#)gameOfLife.java
 *
 *
 * @author 
 * @version 1.00 2018/4/30
 */

import java.awt.*;
import java.util.Random;

public class gameOfLife{
    
    private int dimension;
	private boolean[][] world;
	private long generation;
	gameOfLife(int dimension){
		this.dimension = dimension;
		createNewWorld();
		this.generation = 0;
	}

	// Inits random cells

	private void createNewWorld(){
		boolean[][] newWorld = new boolean[dimension][dimension];
		for(int row = 0; row < newWorld.length; row++ ){
			for(int col = 0; col < newWorld[row].length; col++ ){
				newWorld[row][col] = (Math.random() < 0.3);
			}
		}
		world = newWorld;
	}

	// Draws the world 
	public void drawWorld(Graphics g){
		
    	int red   = Expo.random(0,255);
	    int green = Expo.random(0,255);
	    int blue  = Expo.random(0,255); 
	    Color c = new Color(red, green, blue);
		for(int row = 0; row < world.length; row++ ){
			for(int col = 0; col < world[row].length; col++ ){
				if(isAlive(row, col) == true){
					Expo.setColor(g, c);
					Expo.fillRectangle(g, row * 5 - 3, col * 5 - 3, row * 5 + 3, col * 5 + 3);
				}else{
					//Expo.setRandomColor(g);
					Expo.setColor(g, Expo.black);
					Expo.fillRectangle(g, row * 5 - 3, col * 5 - 3, row * 5 + 3, col * 5 + 3);
				}
				
					
				 
			}
			
		}
		
	}

	// do one step
	public void nextGeneration(){
		boolean[][] newWorld = new boolean[dimension][dimension];
		for(int row = 0; row < newWorld.length; row++ ){
			for(int col = 0; col < newWorld[row].length; col++ ){
				newWorld[row][col] = isAlive(row, col);
			}
		}
		world = newWorld;
		generation++;
	}

	
	private boolean isAlive(int row, int col){
		int liveCount = 0;
		boolean cellCurrentlyAlive = world[row][col];

		for(int r = -1; r <= 1; r++){
			int currentRow = row + r;
			currentRow = (currentRow < 0)? dimension - 1: currentRow;
			currentRow = (currentRow >= dimension)? 0 : currentRow;
			for(int c = -1; c <= 1; c++){
				int currentCol = col + c;
				currentCol = (currentCol < 0)? dimension - 1: currentCol;
				currentCol = (currentCol >= dimension)? 0 : currentCol;
				if(world[currentRow][currentCol]){
					liveCount++;
				}
			}
		}
		if(cellCurrentlyAlive){
			liveCount--;
		}

		if(liveCount == 2 && cellCurrentlyAlive){
			return true;
		} else if(liveCount == 3){
			return true;
		} else {
			return false;
		}
	}
	}
    
    
