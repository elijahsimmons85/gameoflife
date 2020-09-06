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
    public double threshold = 0.4;
    private int dimensionx;
    private int dimensiony;
    public boolean grid = true;
    public int theme = 1;
	public boolean[][] world;
	public long generation;
	gameOfLife(int dimensionx, int dimensiony){//CONSTRUCTER/MAKE INITAL WORLD
		this.dimensionx = dimensionx;
		this.dimensiony = dimensiony;
		createNewWorld();
		this.generation = 0;
	}

	//START OF GET METHODS
	public int getGen(){
		return (int) generation;
	}
	public void setCell(int row, int col, boolean value){
		if(world[row][col] == true){//SET SPECIFIC CELL TO TRUE OR FALSE
			world[row][col] = false;
		}else{
			world[row][col] = true;
		}
		
		//System.out.println("bing");
	}
	public void setTheme(int t){
    	theme = t;
    }
    public void setThresh(double t){
    	System.out.println(t);
    	threshold = t;
    }
    public void setGrid(boolean b){
    	grid = b;
    }
    
    //END OF GET METHODS
	public void createNewWorld(){//CREATE RANDOM CELLS BASED ON THE THRESHOLD
		
		boolean[][] newWorld = new boolean[dimensionx][dimensiony];
		for(int row = 0; row < newWorld.length; row++ ){
			for(int col = 0; col < newWorld[row].length; col++ ){
				newWorld[row][col] = (Math.random() < threshold);
			}
		}
		world = newWorld;
	}
	public void drawWorldLite(Graphics g){
		
    	
		for(int row = 0; row < world.length; row++ ){
			for(int col = 0; col < world[row].length; col++ ){
				if(world[row][col] == true){
					switch(theme){//chose color based on theme
					
						case 1 :
							Expo.setColor(g, Expo.black);
							break;
						case 2 :
							Expo.setColor(g, Expo.white);
							break;
						case 3 :
							Expo.setRandomColor(g);
							break;
						case 4 :
							double ranch = Math.random();
							if(ranch > 0.5)
								Expo.setColor(g, Expo.lightGreen);
							else
								Expo.setColor(g, Expo.white);

							break;
						case 5 :
							Expo.setColor(g, 194, 127, 49);
							break;
						case 6 :
							double america = Math.random();
							if(america > 0.5)
								Expo.setColor(g, Expo.red);
							else
								Expo.setColor(g, Expo.blue);

							break;
						case 7 :
							Expo.setColor(g, Expo.yellow);
							break;
						case 8 :
							Expo.setColor(g, Expo.white);
							break;
						case 9 :
							Expo.setColor(g, 252,149,255);
							break;
						case 10 :
							Expo.setColor(g, 131,209,118);
							break;
						case 11 :
							Expo.setColor(g, Expo.lightBlue);
							break;
						case 12 :
							double spice = Math.random();
							if(spice > 0.5)
								Expo.setColor(g, Expo.red);
							else
								Expo.setColor(g, Expo.orange);

							break;
						case 13 :
							Expo.setColor(g, Expo.black);
							break;
						case 14 :
							Expo.setColor(g, Expo.gold);
							break;
					}
					if(grid){ //Draw with spaces
						Expo.fillRectangle(g, row * 10 - 4, col * 10 - 4, row * 10 + 4, col * 10 + 4);
					}else{//Draw without spaces
					
					Expo.fillRectangle(g, row * 10 - 5, col * 10 - 5, row * 10 + 5, col * 10 + 5);
					}
				}else{
					switch(theme){//chose color based on theme
					
						case 1 :
							Expo.setColor(g, Expo.white);
							break;
						case 2 :
							Expo.setColor(g, 52, 52, 103);
							break;
						case 3 :
							Expo.setColor(g, Expo.black);
							break;
						case 4 :
							Expo.setColor(g, Expo.black);
							break;
						case 5 :
							Expo.setColor(g, 89, 54, 49);
							break;
						case 6 :
							Expo.setColor(g, Expo.white);
							break;
						case 7 :
							Expo.setColor(g, Expo.red);
							break;
						case 8 :
							Expo.setColor(g, Expo.white);
							break;
						case 9 :
							Expo.setColor(g, Expo.lightBlue);
							break;
						case 10 :
							Expo.setColor(g, 252, 206, 113);
							break;
						case 11 :
							Expo.setColor(g, Expo.white);
							break;
						case 12 :
							Expo.setColor(g, Expo.yellow);
							break;
						case 13 :
							double gray = Math.random();
							if(gray > 0.6)
								Expo.setColor(g, Expo.white);
							else if(gray < 0.6 && gray > 0.3)
								Expo.setColor(g, Expo.gray);
							else
								Expo.setColor(g, Expo.darkGray);
							break;
						case 14 :
							Expo.setColor(g, Expo.white);
							break;
					}
					
					
					if(grid){
						Expo.fillRectangle(g, row * 10 - 4, col * 10 - 4, row * 10 + 4, col * 10 + 4);//draw cell
					}else{
					
					Expo.fillRectangle(g, row * 10 - 5, col * 10 - 5, row * 10 + 5, col * 10 + 5);
					}
				}
				
					
				 
			}
			
		}
		
	}
	/*~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~OLD DRAW METHOD
	public void drawWorld(Graphics g){
		
    	
		for(int row = 0; row < world.length; row++ ){
			for(int col = 0; col < world[row].length; col++ ){
				if(isAlive(row, col) == true){
					switch(theme){
					
						case 1 :
							Expo.setColor(g, Expo.black);
							break;
						case 2 :
							Expo.setColor(g, Expo.white);
							break;
						case 3 :
							Expo.setRandomColor(g);
							break;
						case 4 :
							double ranch = Math.random();
							if(ranch > 0.5)
								Expo.setColor(g, Expo.lightGreen);
							else
								Expo.setColor(g, Expo.white);

							break;
						case 5 :
							Expo.setColor(g, 194, 127, 49);
							break;
						case 6 :
							double america = Math.random();
							if(america > 0.5)
								Expo.setColor(g, Expo.red);
							else
								Expo.setColor(g, Expo.blue);

							break;
						case 7 :
							Expo.setColor(g, Expo.yellow);
							break;
						case 8 :
							Expo.setColor(g, Expo.white);
							break;
					}
					if(grid){
						Expo.fillRectangle(g, row * 5 - 2, col * 5 - 2, row * 5 + 2, col * 5 + 2);
					}else{
					
					Expo.fillRectangle(g, row * 5 - 2, col * 5 - 2, row * 5 + 2, col * 5 + 2);
					}
				}else{
					switch(theme){
					
						case 1 :
							Expo.setColor(g, Expo.white);
							break;
						case 2 :
							Expo.setColor(g, 52, 52, 103);
							break;
						case 3 :
							Expo.setColor(g, Expo.black);
							break;
						case 4 :
							Expo.setColor(g, Expo.black);
							break;
						case 5 :
							Expo.setColor(g, 89, 54, 49);
							break;
						case 6 :
							Expo.setColor(g, Expo.white);
							break;
						case 7 :
							Expo.setColor(g, Expo.red);
							break;
						case 8 :
							Expo.setColor(g, Expo.white);
							break;
					}
					
					
					if(grid){
						Expo.fillRectangle(g, row * 5 - 2, col * 5 - 2, row * 5 + 2, col * 5 + 2);
					}else{
					
					Expo.fillRectangle(g, row * 5 - 2, col * 5 - 2, row * 5 + 2, col * 5 + 2);
					}
				}
				
					
				 
			}
			
		}
		
	}*/
	public void Preset1(){//Clear the world then set specific cells to be alive
		for(int row = 0; row < world.length; row++ ){
			for(int col = 0; col < world[row].length; col++ ){
				world[row][col] = false;
			}
		}
		world[70 - 15][90 - 50] = true;
		world[71- 15][90 - 50] = true;
		world[70- 15][91- 50] = true;
		world[71- 15][91- 50] = true;
		
		world[80- 15][90- 50] = true;
		world[80- 15][91- 50] = true;
		world[80- 15][92- 50] = true;
		world[81- 15][93- 50] = true;
		world[81- 15][89- 50] = true;
		world[82- 15][88- 50] = true;
		world[83- 15][88- 50] = true;
		world[82- 15][94- 50] = true;
		world[83- 15][94- 50] = true;
		world[84- 15][91- 50] = true;
		
		world[86- 15][91- 50] = true;
		world[87- 15][91- 50] = true;
		world[86- 15][90- 50] = true;
		world[86- 15][92- 50] = true;
		world[85- 15][89- 50] = true;
		world[85- 15][93- 50] = true;
		
		world[90- 15][90- 50] = true;
		world[90- 15][89- 50] = true;
		world[90- 15][88- 50] = true;
		world[91- 15][90- 50] = true;
		world[91- 15][89- 50] = true;
		world[91- 15][88- 50] = true;
		
		world[92- 15][87- 50] = true;
		world[92- 15][91- 50] = true;
		
		world[94- 15][87- 50] = true;
		world[94- 15][86- 50] = true;
		world[94- 15][91- 50] = true;
		world[94- 15][92- 50] = true;
		
		world[104- 15][88- 50] = true;
		world[104- 15][89- 50] = true;
		world[105- 15][88- 50] = true;
		world[105- 15][89- 50] = true;
		
	}
	public void Preset2(){//Clear the world then set specific cells to be alive
		for(int row = 0; row < world.length; row++ ){
			for(int col = 0; col < world[row].length; col++ ){
				world[row][col] = false;
			}
		}
		world[80][40] = true;
		world[80][41] = true;
		world[80][42] = true;
		world[81][42] = true;
		world[82][41] = true;
		
		
	}
	public void Preset3(){//Clear the world then set specific cells to be alive
		for(int row = 0; row < world.length; row++ ){
			for(int col = 0; col < world[row].length; col++ ){
				world[row][col] = false;
			}
		}
		world[80 - 30][60- 25] = true;
		world[81- 30][60- 25] = true;
		world[81- 30][58- 25] = true;
		world[83- 30][59- 25] = true;
		world[84- 30][60- 25] = true;
		world[85- 30][60- 25] = true;
		world[86- 30][60- 25] = true;
		
		
		
	}
	public void Preset4(){//Clear the world then set specific cells to be alive
		for(int row = 0; row < world.length; row++ ){
			for(int col = 0; col < world[row].length; col++ ){
				world[row][col] = false;
			}
		}
		world[100 - 50][60 - 20] = true;
		world[99- 50][60- 20] = true;
		world[101- 50][60- 20] = true;
		
		world[100- 50][58- 20] = true;
		world[100- 50][57- 20] = true;
		world[100- 50][56- 20] = true;
		
		
		
		
	}
	// do one step
	public void nextGeneration(){//Find if every cell should live or die then set current world to that
		boolean[][] newWorld = new boolean[dimensionx][dimensiony];
		for(int row = 0; row < newWorld.length; row++ ){
			for(int col = 0; col < newWorld[row].length; col++ ){
				newWorld[row][col] = isAlive(row, col);
			}
		}
		world = newWorld;
		generation++;
	}
	

	
	private boolean isAlive(int row, int col){//Find the border cells and do rules
		int liveCount = 0;
		boolean cellCurrentlyAlive = world[row][col];

		for(int r = -1; r <= 1; r++){//Check neighbors horizontal
			int currentRow = row + r;
			currentRow = (currentRow < 0)? dimensionx - 1: currentRow;
			currentRow = (currentRow >= dimensionx)? 0 : currentRow;
			for(int c = -1; c <= 1; c++){//Check neighbors vertical
				int currentCol = col + c;
				currentCol = (currentCol < 0)? dimensiony - 1: currentCol;
				currentCol = (currentCol >= dimensiony)? 0 : currentCol;
				if(world[currentRow][currentCol]){
					liveCount++;
				}
			}
		}
		if(cellCurrentlyAlive){
			liveCount--;
		}

		if(liveCount == 2 && cellCurrentlyAlive){//Basic rules
			return true;
		} else if(liveCount == 3){
			return true;
		} else {
			return false;
		}
	}
	}
    
    
