import java.awt.Color;
import java.awt.Container;
import java.awt.GridLayout;

import javax.swing.*;

	
public class MineSweeper extends JPanel {
	
	public static void main(String[] args) {
		JFrame frame = new JFrame("Drawing by Koushik");
	    frame.setSize(600,600);
	    frame.setLocationRelativeTo(null);
	    frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    
        Container pane = frame.getContentPane();
        pane.setLayout(new GridLayout(9,9));
	    pane.setBackground(Color.CYAN);
	    
        //add all grids
	    Mine mine[][] = new Mine[9][9];
        for(int i=0;i<9;i++) {
        	for(int j=0; j<9; j++) {
            	mine[i][j] = new Mine();
            	pane.add(mine[i][j]);
            	
        	}
        }
        //Implant the bombs
	    for(int i=0; i <10; i++) {
		    int temp = (int)(Math.random()*81);
		    //System.out.println(temp%9+", "+temp/9);
		    mine[temp%9][temp/9].bomb = 1;
	    }
	    
	    //Calculate grid numbers
        for(int i=0;i<9;i++) {
        	for(int j=0; j<9; j++) {
        		if (mine[i][j].bomb == 1) mine[i][j].num = 99;
        		else {
	        		for(int k=-1;k<2;k++) {
	        			for(int m=-1;m<2;m++) {
	        				if( -1==i+k || i+k>8 || -1==j+m || j+m>8) continue;
	        				mine[i][j].num += mine[i+k][j+m].bomb;
	        			}
	        		}
        		}
          	}
        }
        frame.setVisible(true);
        
        
    }
	
}
