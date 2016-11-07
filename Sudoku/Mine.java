import java.awt.*;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import javax.swing.JComponent;
import javax.swing.JOptionPane;


public class Mine extends JComponent {
	
	public int num;
	boolean flag;
	boolean show;
	int bomb;
	
	public Mine() {
		num = 0;
		addMouseListener(new event());
		show = false;
		flag = false;
		bomb = 0;
    }
    
	public void paint(Graphics g) {
		Font font = new Font("Verdana", Font.PLAIN, 25);
		int w = this.getWidth();
		int h = this.getHeight();
		int[] x = {0,w,w,0};
		int[] y = {0,0,h,h};
		g.drawPolygon(x, y, 4);
		g.setFont(font);
		if (show) {
			if (num != 99) g.drawString(Integer.toString(num), w/2 - 10, h/2 + 8);
			else g.drawString("X", w/2 - 10, h/2);
		}
		if (flag) {
			g.drawString("FF", w/2 - 10, h/2);
		}
	}

    public class event extends MouseAdapter {
    	@Override
        public void mouseClicked(MouseEvent e) {
    		if (e.getModifiers() != MouseEvent.BUTTON3_MASK) {
	        	show = true;
	        	if (bomb==1) {
	        		System.out.println("Game Over");
	        		JOptionPane.showMessageDialog(null,"Game OVER!!","Suck",JOptionPane.WARNING_MESSAGE);
	        	}
	            repaint();
    		}
    		else {
    	        flag = true;
    	        repaint();
    		}
        }
    	
    }
	
}
