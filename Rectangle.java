import java.awt.Color;
import java.awt.Graphics;

public class Rectangle extends GameObject {
    private int xRadius, yRadius;
    
    public Rectangle(int x, int y, int xRad, int yRad, Color c) {
        super(x, y, c);
        xRadius = xRad;
        yRadius = yRad;
    }
    
    int xRadius() {return xRadius;}
    int yRadius() {return yRadius;}
    
    public void draw(Graphics g) {
        g.setColor(getColor());
        int topLeftX = getX() - xRadius;
        int topLeftY = getY() - yRadius;
        int width = 2 * xRadius;
        int height = 2 * yRadius;
        g.fillRect(topLeftX, topLeftY, width, height);
    }
}
