import java.awt.*;
public class Key extends Circle {
    public static final Color KEY_COLOR = Color.ORANGE;
    public static final int RADIUS = 10;
    public boolean collected = false;
    /**
     * <h1>Construction for Keys</h1>
     * Calls the GameObject constructor and initializes
     *  the center of the key, as well as the size.
     *  the Radius is a default size of 10
     * @param xCo X Center Point of the key
     * @param yCo Y Center Point of the key
     */
    public Key(int xCo, int yCo)
    {
        super(xCo,yCo,RADIUS,KEY_COLOR);
    }
}
