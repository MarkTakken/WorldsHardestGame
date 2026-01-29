import java.awt.Color;
import java.awt.Graphics;

public class Player{
    private int xPos, yPos, initX,initY;
    public boolean upPossible = true, downPossible = true, leftPossible = true, rightPossible = true;
    private static final Color color=Color.RED;
    private final int radius;
    private int speed=4;
    /*Constructor for player*/
    public Player(int x, int y, int r)
    {
        yPos=y;
        xPos=x;
        initX = x;
        initY = y;
        radius=r;
    }
    public Player(int x, int y, int r, int s)
    {
        this(x,y,r);
        speed = s;
    }
    /*Returns xPos value*/
    public int getX()
    {
        return xPos;
    }
    /*Returns yPos value*/
    public int getY()
    {
        return yPos;
    }
    /*Increments xPos and yPos by x and y */
    public void move(int x, int y)
    {
        xPos+=x;
        yPos+=y;
    }
    /*Sets initX and initY to x and y*/
    public void setInitPos(int x, int y)
    {
        initX=x;
        initY=y;
    }
    /*Accessor method for int radius*/
    public int getRadius()
    {
        return radius;
    }
    /*GUI for Player; draws a red 30x30 square*/
    public void draw(Graphics g)
    {
        g.setColor(color);
        g.fillRect(xPos-radius, yPos-radius, 2*radius, 2*radius);
    }
    /*Accessor method for int speed*/
    public int getSpeed()
    {
        return speed;
    }
    /*Sets player position, xPos and yPos, to initial position, intitX and initY*/
    public void reset()
    {
        xPos=initX;
        yPos=initY;
    }
}
