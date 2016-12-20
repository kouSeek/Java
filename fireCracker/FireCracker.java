package fireworks;

import java.awt.Color;
import java.awt.Graphics;
import java.awt.Image;
import java.util.ArrayList;
import java.util.Random;

import javax.swing.JFrame;


public class FireWork extends JFrame implements Runnable{
	
	public static int WIDTH = 1300, HEIGHT = 900;
	
	Graphics gfx;
	Image img;
	Random rand = new Random();
	
	ArrayList<Cracker> crackers = new ArrayList<Cracker>();
	ArrayList<Cracker> subCrackers = new ArrayList<Cracker>();
	
	public FireWork(){
		this.setSize(WIDTH, HEIGHT);
		this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		this.setResizable(true);	
		
		crackers.add(new Cracker());
		Thread thread = new Thread(this);
		thread.start();
	
		this.setVisible(true);
	}
	
	
	public void paint(Graphics g){
		img = createImage(this.getWidth(), this.getHeight());
		gfx = img.getGraphics();
		
		// Draw Black Sky
		gfx.setColor(Color.BLACK);	
		gfx.fillRect(0, 0, this.getWidth(), this.getHeight());
		// Draw Crackers
		for (int i=0; i <crackers.size(); i++){
			gfx.setColor(crackers.get(i).color);
			gfx.fillOval(crackers.get(i).x, crackers.get(i).y, crackers.get(i).radius, crackers.get(i).radius);
			
		}
		// Draw subCrackers
		for (int i=0; i <subCrackers.size(); i++){
			gfx.setColor(subCrackers.get(i).color);
			gfx.fillOval(subCrackers.get(i).x, subCrackers.get(i).y, subCrackers.get(i).radius, subCrackers.get(i).radius);
		}
		
		g.drawImage(img, 0, 0, this);
	}

	
	
	@Override
	public void run() {
		while(true){
			try {
				// Fly crackers and explode when at Top and create new subCrackers
				for (int i=0; i <crackers.size(); i++){
					crackers.get(i).fly();
					crackers.get(i).topCheck();
					
					if (crackers.get(i).atTop) {
						for(int j=0; j<200; j++)
							subCrackers.add(new Cracker(crackers.get(i).x, crackers.get(i).y, crackers.get(i).xVel));
						crackers.remove(i);
					}
					
				}
				
				// Each moment 8% Chance for a new Cracker to show up
				if(Math.random() < 0.08){
					crackers.add(new Cracker());
				}
				
				// Fly subCrackers
				for (int i=0; i <subCrackers.size(); i++){
					subCrackers.get(i).fly(true);
				}

				// Pop subCrackers for Garbage Collection
				for(int i=0; i<subCrackers.size(); i++){
					if(subCrackers.get(i).y > HEIGHT){
						subCrackers.remove(i);
					}
				}
				Thread.sleep(50);
				repaint();
			} 
			catch (InterruptedException e) {
				e.printStackTrace();
			}
		}
	}
	

	
	public static void main(String[] args){
		new FireWork();
	}
}
