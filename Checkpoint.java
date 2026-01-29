import java.awt.Color;
public class Checkpoint extends Rectangle{
    
    public Checkpoint(int x, int y, int xRad, int yRad)
    {
        super(x,y,xRad,yRad,Color.GREEN);
    }

    public boolean shouldInteract(int x, int y, int r)
    {
        return (x-r) >= (getX() - xRadius()) 
            && (y-r) >= (getY() - yRadius())
            && (x+r) <= (getX() + xRadius())
            && (y+r) <= (getY() + yRadius());
    }
}
