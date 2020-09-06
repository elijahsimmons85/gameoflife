/**
 * @(#)LifeStarts.java
 *
 *
 * @author 
 * @version 1.00 2018/5/10
 */

public class LifeStarts {
        
    public static void main(String[] args)
	 throws java.lang.InterruptedException{
		gameOfLife world = new gameOfLife(55);
		world.drawWorld();
		while(true){
			Thread.sleep(1000);
			world.nextGeneration();
			world.drawWorld();
		}
	}
}
