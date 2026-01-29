import java.awt.Color;

public class GameObject {
    int xPos;
    int yPos;
    private final Color color;
    
     /**<h1>GameObjects Constructor</h1>
      * Initializes the basic fields of the GameObject that
      * will be shared between the Key and Enemy objects
      * @param S is the total width and length of the shape
      *        since the shapes are either circles or squares,
      *        they will have the same length and width
      * @param xCo is the top left X coordinate of the object
      * @param yCo is the top left Y coordinate of the object
      * @param c Color of the Object
      */
    public GameObject(int xCo, int yCo, Color c)
    {
        xPos = xCo;
        yPos = yCo;
        color = c;
        
    }
    /**
     * <h1>Point Accesseor Method</h1>
     * returns the Point variable which represents the top left pixel
     * @return  coord Top left pixel/Point
     */
    public int getX()
    {
        return xPos;
    }
    public int getY()
    {
        return yPos;
    }
    public Color getColor()
    {
        return color;
    }
    int[] getClosest(int x, int y, int r)
    {
        int dx = x - this.xPos;
        int dy = y - this.yPos;
        int rSq = r;
        int[] closest = new int[2];
        
        if (dx >= rSq && dy >= rSq)
        {
            closest[0] = x - rSq;
            closest[1] = y - rSq;
        }
        else if (dx >= rSq && -rSq < dy && dy < rSq)
        {
            closest[0] = x - rSq;
            closest[1] = this.yPos;
        }
        else if (dx >= rSq && dy <= -rSq)
        {
            closest[0] = x - rSq;
            closest[1] = y + rSq;
        }
        else if (-rSq < dx && dx < rSq && dy <= -rSq)
        {
            closest[0] = this.xPos;
            closest[1] = y + rSq;
        }
        else if (dx <= -rSq && dy <= -rSq)
        {
            closest[0] = x + rSq;
            closest[1] = y + rSq;
        }
        else if (dx <= -rSq && -rSq < dy && dy < rSq)
        {
            closest[0] = x + rSq;
            closest[1] = this.yPos;
        }
        else if (dx <= -rSq && dy >= rSq)
        {
            closest[0] = x + rSq;
            closest[1] = y - rSq;
        }
        else if (-rSq < dx && dx < rSq && dy >= rSq)
        {
            closest[0] = this.xPos;
            closest[1] = y - rSq;
        }
        else
        {
            closest[0] = this.xPos;
            closest[1] = this.yPos;
        }
        return closest;
    }
}
