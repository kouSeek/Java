package fireworks;

import java.awt.Color;
import java.util.Random;

public class Cracker {
	
	Random rand = new Random();
	
	int radius, x, y;
	double yVel, xVel;
	static int GRAVITY = 2;
	boolean atTop;
	Color color;
	float fadeRate;
	
	Cracker(){
		x = rand.nextInt(FireWork.WIDTH - 160) + 80;
		y = FireWork.HEIGHT;
		xVel = rand.nextInt(20) - 10;
		yVel = 40 + rand.nextInt(15) ;
		atTop = false;
		color = Color.getHSBColor((float)Math.random(), 1f, 1f);
		radius = 15;
	}
	
	Cracker(int xp, int yp, double xV){
		x = xp;
		y = yp;
		xVel = rand.nextInt(20) - 10;
		yVel = rand.nextInt( (int) Math.sqrt(101 - xVel*xVel) );
		yVel *= (Math.signum((float)Math.random()-0.5));
		xVel = xVel + xV;
		
		atTop = false;
		color = Color.getHSBColor((float)Math.random(), 1f, 1f);
		radius = 5;
	}
	

	void fly() {
		y -= yVel;
		x += xVel;
		yVel -= GRAVITY;
	}
	
	void fly(boolean subCracker) {
		y -= yVel*Math.random()*.8;
		x += xVel*Math.random()*.7;
		//xVel -= 0.94;
		yVel -= 0.4;
		fadeRate = 0.975f;
		color = new Color((int) (color.getRed()*fadeRate), (int) (color.getGreen()*fadeRate), (int) (color.getBlue()*fadeRate));
	}

	
	void topCheck() {
		if (Math.abs(yVel) <= 4) {
			atTop = true;
		}
	}
	
	
}
package fireworks;

import java.awt.Color;
import java.util.Random;

public class Cracker {
	
	Random rand = new Random();
	
	int radius, x, y;
	double yVel, xVel;
	static int GRAVITY = 2;
	boolean atTop;
	Color color;
	float fadeRate;
	
	Cracker(){
		x = rand.nextInt(FireWork.WIDTH - 160) + 80;
		y = FireWork.HEIGHT;
		xVel = rand.nextInt(20) - 10;
		yVel = 40 + rand.nextInt(15) ;
		atTop = false;
		color = Color.getHSBColor((float)Math.random(), 1f, 1f);
		radius = 15;
	}
	
	Cracker(int xp, int yp, double xV){
		x = xp;
		y = yp;
		xVel = rand.nextInt(20) - 10;
		yVel = rand.nextInt( (int) Math.sqrt(101 - xVel*xVel) );
		yVel *= (Math.signum((float)Math.random()-0.5));
		xVel = xVel + xV;
		
		atTop = false;
		color = Color.getHSBColor((float)Math.random(), 1f, 1f);
		radius = 5;
	}
	

	void fly() {
		y -= yVel;
		x += xVel;
		yVel -= GRAVITY;
	}
	
	void fly(boolean subCracker) {
		y -= yVel*Math.random()*.8;
		x += xVel*Math.random()*.7;
		//xVel -= 0.94;
		yVel -= 0.4;
		fadeRate = 0.975f;
		color = new Color((int) (color.getRed()*fadeRate), (int) (color.getGreen()*fadeRate), (int) (color.getBlue()*fadeRate));
	}

	
	void topCheck() {
		if (Math.abs(yVel) <= 4) {
			atTop = true;
		}
	}
	
	
}
