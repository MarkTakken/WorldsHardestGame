import java.awt.Color;
import java.awt.Graphics;
public class Circle extends GameObject
{
    private final int radius;
    public Circle(int x, int y, int c, Color d)
    {
        super(x,y,d);
        radius = c;
    }
    public boolean shouldInteract(int x, int y,int size)
    {
        int dx = getClosest(x,y,size)[0]-this.getX();
        int dy = getClosest(x,y,size)[1]-this.getY();
        return Math.sqrt(dx*dx + dy*dy) <= radius;
    }
    public void draw(Graphics g)
    {
        g.setColor(this.getColor());
        g.fillOval(this.getX()-radius,this.getY()-radius, radius*2, radius*2);
    }
    public int getRadius()
    {
        return radius;
    }
}
