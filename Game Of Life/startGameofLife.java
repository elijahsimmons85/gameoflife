/**
 * @(#)startGameofLife.java
 *
 *
 * @author 
 * @version 1.00 2018/5/11
 */

import java.awt.*;
import java.awt.event.*;
import java.io.IOException;

public class startGameofLife extends java.applet.Applet implements KeyListener, MouseListener {
    
    /** Initialization method that will be called after the applet is loaded
     *  into the browser.
     */
     int x, y;
     public boolean optionsMenu;
     public boolean grid = false;
     public double thresh = 0.4;
     boolean temp = false;
     public int theme = 1;
     public int fps = 60;//static num
     gameOfLife world;
	 GUI userInterface;
	 boolean pause;
	 boolean splash = true;
	 boolean rUI = false;
	 public String worldName;
	 boolean background = true;
    public void init() {
    	worldName = "default";
    	
    	pause = true;
        addKeyListener(this);
        addMouseListener( this );
        setFocusable(true);
        world = new gameOfLife(100, 72);//INITIALIZE THE GRID
		userInterface = new GUI(pause, world.getGen(), worldName);//INITIALIZE THE GUI
    }

    public int getTheme(){
    	return theme;
    }
	public void splashScreen(Graphics g, int x){//DRAW SPLASH SCREEN
		Expo.setBackground(g, Expo.black);
		g.setFont(new Font("Arial", Font.PLAIN, 30));
		
		
		Expo.setColor(g, x, x ,x);
		g.drawString("Conway's Game of Life", 500, 135);
		
		g.setFont(new Font("Arial", Font.PLAIN, 20));
		
		g.drawString("Programed by Elijah Simmons", 500, 700);
		
		Expo.fillRectangle(g, 550 + 20, 150 + 20, 600 + 20, 200+ 20);
		//Expo.fillRectangle(g, 550 + 80, 150+ 20, 600+ 80, 200+ 20);
		//Expo.fillRectangle(g, 550 + 140, 150+ 20, 600+ 140, 200+ 20);
		
		
		Expo.fillRectangle(g, 550 + 20, 150 + 80, 600 + 20, 200+ 80);
		//Expo.fillRectangle(g, 550 + 80, 150+ 80, 600+ 80, 200+ 80);
		
		Expo.fillRectangle(g, 550 + 140, 150+ 80, 600+ 140, 200+ 80);
		
		
		Expo.fillRectangle(g, 550 + 20, 150+ 140, 600 + 20, 200+ 140);
		
		Expo.fillRectangle(g, 550 + 80, 150+ 140, 600+ 80, 200+ 140);
		//Expo.fillRectangle(g, 550 + 140, 150+ 140, 600+ 140, 200+ 140);
		
	}
	public void paint(Graphics g) {
		if(splash){
			splashScreen(g, 255);//DRAW THE SPASH SCREEN AND GET DARKER
			Expo.delay(2000);
			for(int b = 255; b > 0; b -= 5){
					
				splashScreen(g, b);
				//Expo.delay(20); //Time between ticks
			}
			splash = false;
			
		}
			
		if(background = true){
		Expo.setBackground(g, Expo.black);
		background = false;	
		}
		
		if(temp = true){
			userInterface.setThresh(Math.round(thresh*100.0)/100.0);// DO ONE STEP
			world.setThresh(Math.round(thresh*100.0)/100.0);
			
			
			userInterface.setTheme(theme);
			userInterface.setPaused(pause);
			userInterface.setGen(world.getGen());
			userInterface.drawGUI(g);
			world.drawWorldLite(g);
			if(userInterface.optionsMenuActive && pause){
    		userInterface.drawOptionsMenu(g);
    		}
			
			
			
			Expo.delay(100);
			temp = false;
		}
    		
			
			
		
		while(!pause){//DO GENERATION AND DRAW
			
    		//Expo.delay(50);
			world.nextGeneration();
			
			world.drawWorldLite(g);
			userInterface.setGen(world.getGen());
			userInterface.drawGUI(g);
			
			
			
    	}
		
    }
    
    public void mouseEntered( MouseEvent e ) { }
   	public void mouseExited( MouseEvent e ) { }
   	
   	public void mouseReleased( MouseEvent e ) { }
   	public void mouseClicked( MouseEvent e ) { }
   	private int findRow(int pixelY) {
		return (int)(((double)pixelY)/720*72);//Find grid row based on pixel coords
	}
	

	
	private int findColumn(int pixelX) {
		return (int)(((double)pixelX)/1000*100);//Find grid col based on pixel coords
	}
	

	
	public void mousePressed(MouseEvent evt) {
		int row, col; // the row and column in the grid of squares where the user clicked.
		row = findRow( evt.getY() );
		col = findColumn( evt.getX() );
		world.setCell(col, row, true);//Toggle the cell that was clicked
		System.out.println(col + ", " + row);
		repaint();
      
   }
    public void keyPressed(KeyEvent e)   //TODO : Use switch case instead of else if
    {
    	if (e.getKeyCode() == KeyEvent.VK_LEFT) {//CHANGE THEME
    		
			theme--;
			temp = true;
			if(theme < 1){theme = 1;}
			if(theme > 14){theme = 14;}
			world.setTheme(theme);
			repaint();
    	}else if (e.getKeyCode() == KeyEvent.VK_RIGHT) { //CHANGE THEME
			theme++;
			temp = true;
			if(theme < 1){theme = 1;}
			if(theme > 14){theme = 14;}
			world.setTheme(theme);
			repaint();
    	}else if (e.getKeyCode() == KeyEvent.VK_SPACE) {//UNPAUSE SIMLULATION
			pause = !pause;
			repaint();
    	}
    	else if (e.getKeyCode() == KeyEvent.VK_R) {//REGENERATE THE GRID
			world.createNewWorld();
			
			repaint();
    	}else if (e.getKeyCode() == KeyEvent.VK_UP) {//MORE CELLS
    		
			thresh += 0.05;
			temp = true;
			if(thresh > 1){thresh = 1;}
			if(thresh <= 0.0d){thresh = 0.0d;}
			userInterface.setThresh(Math.round(thresh*100.0)/100.0);
			world.setThresh(Math.round(thresh*100.0)/100.0);
			world.createNewWorld();
			repaint();
    	}
    	else if (e.getKeyCode() == KeyEvent.VK_DOWN) {//LESS CELLS
    		
			thresh -= 0.05;
			temp = true;
			if(thresh > 1){thresh = 1;}
			if(thresh <= 0){thresh = 0.00;}
			userInterface.setThresh(Math.round(thresh*100.0)/100.0);
			world.setThresh(Math.round(thresh*100.0)/100.0);
			world.createNewWorld();
			repaint();
    	}else if (e.getKeyCode() == KeyEvent.VK_M) {//OPEN AND CLOSE MENU
			if(optionsMenu){
				optionsMenu = false;
			}else if(!optionsMenu){
				optionsMenu = true;
			}
			userInterface.setOptions(optionsMenu);
			temp = true;
			repaint();
    	}else if (e.getKeyCode() == KeyEvent.VK_G && pause && optionsMenu) {//TOGGLE THE GRID
			if(grid){
				grid = false;
			}else if(!grid){
				grid = true;
			}
			userInterface.setGrid(grid);
			world.setGrid(grid);
			temp = true;
			repaint();
    	}else if (e.getKeyCode() == KeyEvent.VK_H && pause && optionsMenu) {//TOGGLE THE RAINBOW GUI
			if(rUI){
				rUI = false;
			}else if(!rUI){
				rUI = true;
			}
			userInterface.setRainbow(rUI);
			
			temp = true;
			repaint();
    	}else if (e.getKeyCode() == KeyEvent.VK_1) {//PRESET 1
			
			world.Preset1();
			temp = true;
			repaint();
    	}else if (e.getKeyCode() == KeyEvent.VK_2) {//PRESET 2
			
			world.Preset2();
			temp = true;
			repaint();
    	}else if (e.getKeyCode() == KeyEvent.VK_3) {//PRESET 3
			
			world.Preset3();
			temp = true;
			repaint();
    	}
    	else if (e.getKeyCode() == KeyEvent.VK_4) {//PRESET 4
			
			world.Preset4();
			temp = true;
			repaint();
    	}
    }
  	public void keyReleased(KeyEvent e)  {   }
  	public void keyTyped(KeyEvent e)  
  	{   
    	
  	}    
  	
}