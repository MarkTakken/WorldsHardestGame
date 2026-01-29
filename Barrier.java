import java.awt.Color;

class Barrier extends Rectangle
{
    String sideLastTouched = "none";
    
    Barrier(int x, int y, int xRad, int yRad)
    {
        super(x,y,xRad,yRad,Color.BLACK);
    }
    
    String sideTouched(int x, int y, int r, int s)
    {
        if (xPos-xRadius()-r < x
            && x < xPos + xRadius() + r
            && y < yPos - yRadius() - r + s
            && y >= yPos - yRadius() - r)
        {
            return "down";
        }
        else if (xPos-xRadius()-r < x
            && x < xPos + xRadius() + r
            && y > yPos + yRadius() + r - s
            && y <= yPos + yRadius() + r)
        {
            return "up";
        }
        else if (yPos - yRadius() - r < y
            && y < yPos + yRadius() + r
            && x < xPos - xRadius() - r + s
            && x >= xPos - xRadius() - r)
        {
            return "right";
        }
        else if (yPos - yRadius() - r < y
            && y < yPos + yRadius() + r
            && x > xPos + xRadius() + r - s
            && x <= xPos + xRadius() + r)
        {
            return "left";
        }
        return null;
    }
}
