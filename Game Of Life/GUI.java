/**
 * @(#)GUI.java
 *
 *
 * @author 
 * @version 1.00 2018/5/12
 *~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~Honestly there isn't much to comment, it's just a bunch of draw methods
 */
import java.awt.*;

public class GUI {
	public boolean optionsMenuActive = false;
	public boolean grid = false;
	public double threshold;
	private boolean paused;
	private boolean rainbow;
	private int gen;
	public int theme;
	public String[] themeNames = {"Oreos", "Slate", "Rough Night", "Suddenly Ranch", "Chicken", "America", "Comrade", "France", "Sherbert", "Cactus", "Frozone", "Spicy", "50 Shades", "Trump"};
	private String worldName;
    public GUI(boolean p, int g, String w) {
    	paused = p;
    	gen = g;
    	worldName = w;
    }
    public void setGen(int g){
    	gen = g;
    }
    public void setTheme(int t){
    	theme = t;
    }
    public void setPaused(boolean  p){
    	paused = p;
    }
    public void setThresh(double  t){
    	threshold = t;
    }
    public void setOptions(boolean b){
    	optionsMenuActive = b;
    }
    public void setGrid(boolean b){
    	grid = b;
    }
    public void setRainbow(boolean b){
    	rainbow = b;
    }
    public void drawOutline(Graphics g, String text, Color c, int x, int y){
    	g.setColor(c);
		g.drawString(text, ShiftWest(x, 1), ShiftNorth(y, 1));
		g.drawString(text, ShiftWest(x, 1), ShiftSouth(y, 1));
		g.drawString(text, ShiftEast(x, 1), ShiftNorth(y, 1));
		g.drawString(text, ShiftEast(x, 1), ShiftSouth(y, 1));
		g.drawString(text, ShiftWest(x, 2), ShiftNorth(y, 2));
		g.drawString(text, ShiftWest(x, 2), ShiftSouth(y, 2));
		g.drawString(text, ShiftEast(x, 2), ShiftNorth(y, 2));
		g.drawString(text, ShiftEast(x, 2), ShiftSouth(y, 2));
		
    }
    public void drawCheckbox(Graphics g,boolean b, int x, int y){
    	Expo.setColor(g, Expo.white);
    	Expo.fillRectangle(g, x-8, y-8, x+8, y+8);
    	if(b){
    		Expo.setColor(g, Expo.black);
    		Expo.fillRectangle(g, x-6, y-6, x+6, y+6);
    	}
    }
    public void drawOptionsMenu(Graphics g){
    	
    	Expo.setColor(g, Expo.black);
		Expo.fillRectangle(g, 98-50, 98-50, 502-50, 302-50);
    	Expo.setColor(g, 133, 133, 133);
		Expo.fillRectangle(g, 100-50, 100-50, 500-50, 300-50);
		
		g.setFont(new Font("Arial", Font.PLAIN, 20));
    	drawOutline(g, "Additional Options", Color.black, 110-50, 120-50);
		g.setColor(Color.white);
		g.drawString("Additional Options", 110-50, 120-50);
		
		g.setFont(new Font("Arial", Font.PLAIN, 14));
		drawCheckbox(g, grid, 80, 100);
		drawOutline(g, "Press G to toggle grid", Color.black, 105, 105);
		g.setColor(Color.white);
		g.drawString("Press G to toggle grid", 105, 105);
		
		g.setFont(new Font("Arial", Font.PLAIN, 14));
		drawCheckbox(g, rainbow, 80, 130);
		drawOutline(g, "Press H to toggle rainbow UI", Color.black, 105, 135);
		g.setColor(Color.white);
		g.drawString("Press H to toggle rainbow UI", 105, 135);
    }
    public void drawGUI(Graphics g){
    	if(rainbow){
    		Expo.setRandomColor(g);
    	}else{
    		Expo.setColor(g, 133, 133, 133);
    	}
    	
		Expo.fillRectangle(g, 1000, 0, 1280, 720);
    	g.setFont(new Font("Arial", Font.PLAIN, 20));
    	drawOutline(g, "Conway's Game of Life", Color.black, 1030, 30);
		g.setColor(Color.white);
		g.drawString("Conway's Game of Life", 1030, 30);
		
		drawOutline(g, "Fps : 60", Color.black, 1030, 60);
		g.setColor(Color.white);
		g.drawString("Fps : 60", 1030, 60);
		
		drawOutline(g, "Generation : " + gen, Color.black, 1030, 90);
		g.setColor(Color.white);
		g.drawString("Generation : " + gen, 1030, 90);
		
		drawOutline(g, "Theme : " + themeNames[theme - 1], Color.black, 1030, 120);
		g.setColor(Color.white);
		g.drawString("Theme : " + themeNames[theme - 1], 1030, 120);
		
		drawOutline(g, "Use [<~] & [~>]", Color.black, 1030, 180);
		g.setColor(Color.white);
		g.drawString("Use [<~] & [~>]", 1030, 180);
		
		drawOutline(g, "to change themes.", Color.black, 1030, 200);
		g.setColor(Color.white);
		g.drawString("to change themes.", 1030, 200);
		
		drawOutline(g, "Press space to start", Color.black, 1030, 250);
		g.setColor(Color.white);
		g.drawString("Press space to start", 1030, 250);
		
		drawOutline(g, "Press R to regenerate", Color.black, 1030, 300);
		g.setColor(Color.white);
		g.drawString("Press R to regenerate", 1030, 300);
		
		drawOutline(g, "Generation Threshold", Color.black, 1060, 380);
		g.setColor(Color.white);
		g.drawString("Generation Threshold", 1060, 380);
		
		drawOutline(g, "(" + threshold + ")", Color.black, 1060, 400);
		g.setColor(Color.white);
		g.drawString("(" + threshold + ")", 1060, 400);
		
		g.setColor(Color.black);
		Expo.fillRectangle(g, 1030, 330, 1050, 430);
		g.setColor(Color.white);
		int thing = (int) (100 * threshold);
		
		drawOutline(g, "Press M to toggle", Color.black, 1030, 460);
		g.setColor(Color.white);
		g.drawString("Press M to toggle", 1030, 460);
		drawOutline(g, "Additional Options Menu", Color.black, 1030, 480);
		g.setColor(Color.white);
		g.drawString("Additional Options Menu", 1030, 480);
		
		g.setFont(new Font("Arial", Font.PLAIN, 30));
			drawOutline(g, "Presets :", Color.black, 1030, 600);
			g.setColor(Color.green);
			g.drawString("Presets :", 1030, 600);
		g.setFont(new Font("Arial", Font.PLAIN, 15));
		drawOutline(g, "[1] - Glider gun", Color.black, 1030, 630);
		g.setColor(Color.white);
		g.drawString("[1] - Glider gun", 1030, 630);
		
		drawOutline(g, "[2] - Single glider", Color.black, 1030, 650);
		g.setColor(Color.white);
		g.drawString("[2] - Single glider", 1030, 650);
		
		drawOutline(g, "[3] - Acorn", Color.black, 1030, 670);
		g.setColor(Color.white);
		g.drawString("[3] - Acorn", 1030, 670);
		
		drawOutline(g, "[4] - Thunderbird", Color.black, 1030, 690);
		g.setColor(Color.white);
		g.drawString("[4] - Thunderbird", 1030, 690);
		
		Expo.fillRectangle(g, 1030, 430 - thing, 1050, 430);
		//g.setColor(Color.white);
		//int thing = (int) (100 * threshold);
		//g.fillRect(1020, 450, 1021, 430);
		if(paused){
			
			g.setFont(new Font("Arial", Font.PLAIN, 40));
			drawOutline(g, "PAUSED", Color.black, 1030, 540);
			g.setColor(Color.red);
			g.drawString("PAUSED", 1030, 540);
		}
    }
    static int ShiftNorth(int p, int distance) {
		return (p - distance);
	}
 
	static int ShiftSouth(int p, int distance) {
		return (p + distance);
	}
 
	static int ShiftEast(int p, int distance) {
		return (p + distance);
	}
 
	static int ShiftWest(int p, int distance) {
		return (p - distance);
	}
    
}