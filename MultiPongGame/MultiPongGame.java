import java.awt.*;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;
import javax.swing.*;

public class MultiPongGame extends JFrame{
    
    //Double Buffering
    Image dbImage;
    Graphics dbg;
    
    //Ball object
    static Ball b = new Ball(200, 150);
    
    //variable for Screen Size
    public static int
    GWIDTH = 400,
    GHEIGHT = 300;
    Dimension ScreenSize = new Dimension(GWIDTH, GHEIGHT);
    
    //Constructor
    public MultiPongGame(){
        this.setTitle("Ping Pong Fight");
        this.setSize(ScreenSize);
        this.setResizable(false);
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        this.setVisible(true);
        this.setBackground(Color.DARK_GRAY);
        this.addKeyListener(new AL());
    }
    
    @Override
    public void paint(Graphics g){
        dbImage = createImage(getWidth(),getHeight());
        dbg = dbImage.getGraphics();
        draw(dbg);
        g.drawImage(dbImage, 0, 0, this);
    }
    
    public void draw(Graphics g){
        b.draw(g);
        b.p1.draw(g);
        b.p2.draw(g);
        
        repaint();
    }
    
    public class AL extends KeyAdapter{
        @Override
        public void keyPressed(KeyEvent e){
            b.p1.keyPressed(e);
            b.p2.keyPressed(e);
        }
        public void KeyReleased(KeyEvent e){
            b.p1.keyReleased(e);
            b.p2.keyReleased(e);
        }
    }

    public static void main(String[] args){
        new MultiPongGame();
        Thread ball = new Thread(b);
        Thread p1 = new Thread(b.p1);
        Thread p2 = new Thread(b.p2);
        ball.start();
        p1.start();
        p2.start();
    }
    
}
