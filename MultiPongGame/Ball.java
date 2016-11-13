import java.awt.Color;
import java.awt.Graphics;
import java.awt.Rectangle;
import java.util.Random;

public class Ball implements Runnable{
    
    int x, y, xDirection, yDirection;
    Rectangle ball;
    int p1Score, p2Score;
    
    Paddle p1 = new Paddle(15, MultiPongGame.GHEIGHT/2, 1);
    Paddle p2 = new Paddle(MultiPongGame.GWIDTH - 30, MultiPongGame.GHEIGHT/2, 2);
    
    public Ball(int x, int y){
        p1Score = p2Score = 0;
        this.x = x;
        this.y = y;
        
        //moving ball randomly
        Random r = new Random();
        int rDir = r.nextInt(2);
        if(rDir==0)
            rDir--;
        setXDirection(rDir);
        int yrDir = r.nextInt(2);
        if(yrDir==0)
            yrDir--;
        setYDirection(yrDir);
        
        ball = new Rectangle(this.x, this.y, 15, 15);
        
    }
    public void setXDirection(int xd){
        xDirection = xd;
    }
    public void setYDirection(int yd){
        yDirection = yd;
    }
    
    public void draw(Graphics g){
        g.setColor(Color.WHITE);
        g.fillRect(ball.x, ball.y, ball.width, ball.height);
    }
    
    public void move(){
        ball.x += xDirection;
        ball.y += yDirection;
        
        //Bounce the ball when edge is detected
        if(ball.x <= 0){
            setXDirection(1);
            p2Score++;
        }
        if(ball.x >= 385){
            setXDirection(-1);
            p1Score++;
        }
        if(ball.y <= 26){
            setYDirection(1);
        }
        if(ball.y >= 285){
            setYDirection(-1);
        }
    }



    @Override
    public void run(){
        try{
            while(true){
                move();
                Thread.sleep(5);
            }
        }catch(Exception e){System.err.println(e.getMessage());}
    }
}
