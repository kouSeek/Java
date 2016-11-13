import java.awt.Color;
import java.awt.Graphics;
import java.awt.Rectangle;
import java.awt.event.KeyEvent;

public class Paddle implements Runnable{
    int x, y, yDirection, id;
    Rectangle paddle;
    
    
    public Paddle(int x, int y, int id){
        this.x = x;
        this.y = y;
        this.id = id;
        paddle = new Rectangle(x, y, 10, 50);
    }
    
    public void keyPressed(KeyEvent e){
        switch(id){
            default:
                System.out.println("Enter a valid paddle id");
                break;
            case 1:
                if(e.getKeyCode() == e.VK_UP){
                    setYDirection(1);
                }
                if(e.getKeyCode() == e.VK_DOWN){
                    setYDirection(-1);
                }
                break;
            case 2:
                if(e.getKeyCode() == e.VK_W){
                    setYDirection(1);
                }
                if(e.getKeyCode() == e.VK_S){
                    setYDirection(-1);
                }
                break;
        }
    }
    public void keyReleased(KeyEvent e) {
        switch(id){
            default:
                System.out.println("Enter a valid paddle id");
                break;
            case 1:
                if(e.getKeyCode() == e.VK_UP){
                    setYDirection(0);
                }
                if(e.getKeyCode() == e.VK_DOWN){
                    setYDirection(0);
                }
                break;
            case 2:
                if(e.getKeyCode() == e.VK_W){
                    setYDirection(0);
                }
                if(e.getKeyCode() == e.VK_S){
                    setYDirection(0);
                }
                break;
        }    
    }
        
    public void setYDirection(int yd){
        yDirection = yd;
    }
    
    public void move(){
        paddle.y -= yDirection;
        if(paddle.y <= 26) paddle.y = 26;
        if(paddle.y >= MultiPongGame.GHEIGHT - 50) paddle.y = MultiPongGame.GHEIGHT - 50;
        
        }


    public void draw(Graphics g){
        switch(id){
            default:
                System.out.println("Enter a valid paddle id");
                break;
            case 1:
                g.setColor(Color.CYAN);
                g.fillRect(paddle.x, paddle.y, paddle.width, paddle.height);
                break;
            case 2:
                g.setColor(Color.PINK);
                g.fillRect(paddle.x, paddle.y, paddle.width, paddle.height);
                break;                   
                
        }
    }

    @Override
    public void run(){
        try{
            while(true){
                move();
                Thread.sleep(8);
            }
        }catch(Exception e){System.err.println(e.getMessage());}
    }    


}
