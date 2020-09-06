/**
 * @(#)startGameofLife.java
 *
 *
 * @author 
 * @version 1.00 2018/5/11
 */

import java.awt.*;

public class startGameofLife extends java.applet.Applet {
    
    /** Initialization method that will be called after the applet is loaded
     *  into the browser.
     */
    public void init() {
        // TODO start asynchronous download of heavy resources
    }

    public void paint(Graphics g) {
        
		gameOfLife world = new gameOfLife(150);
		world.drawWorld(g);
		while(true){
			//Expo.delay(50);
			world.nextGeneration();
			world.drawWorld(g);
		}
		
    }
}