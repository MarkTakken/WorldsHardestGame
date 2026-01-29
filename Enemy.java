import java.awt.Color;

class Enemy extends Circle
{
    private double speed;
    private double counter;
    private static final Color enemyColor = Color.BLUE;
    private static final int enemyRadius = 10;
    private int moveFreq;
    int freqCounter;
    
    Enemy(int x, int y, double s, int freq)
    {
        super(x,y,enemyRadius,enemyColor);
        speed = s;
        moveFreq = freq;
    }
    
    //Separate constructor if you want to initialize counter to
    //something other than zero
    Enemy(int x, int y, double s,int freq, double c)
    {
        this(x,y,s,freq);
        counter = c;
    }
    
    int getMoveFreq() {return moveFreq;}
    
    double getSpeed(){return speed;}
    
    //If the enemy is not necessarily moving in a straight line(which is
    //the case), then it makes sense to have speed as a double.  This returns
    //the speed rounded as an int.
    private int roundedSpeed()
    {
        return (int) Math.round(speed);
    }
    
    void move(int x, int y)
    {
        xPos += x;
        yPos += y;
    }
    
    //Moves the enemy some on the horizontal line of a certain length that it
    //is located on
    //Assumes that the starting position is the left end.  If this is not
    //the starting position you want, then use the second constructor to
    //initialize the counter properly.
    void moveInHLine(int xLen)
    {
        if (freqCounter < moveFreq)
        {
            freqCounter ++;
            return;
        }
        freqCounter = 1;
        int deltaTime = (int) Math.round(xLen/speed);
        if (0 <= counter && counter < deltaTime) move(roundedSpeed(),0);
        else move(-roundedSpeed(),0);
        counter ++;
        counter %= (2 * deltaTime);
    }
    
    //Same as previous method, just for a vertical line
    void moveInVLine(int yLen)
    {
        if (freqCounter < moveFreq)
        {
            freqCounter ++;
            return;
        }
        freqCounter = 1;
        int deltaTime = (int) Math.round(yLen/speed);
        if (0 <= counter && counter < deltaTime) move(0,roundedSpeed());
        else move(0,-roundedSpeed());
        counter ++;
        counter %= (2 * deltaTime);
    }
    /*
    //Direction is either "ccw" (for counterclockwise) or "cw" (for clockwise)
    //r is radius of circle
    //Assumes the starting position is the rightmost end
    void moveInCircle(int r, String direction)
    {
        if (freqCounter < moveFreq)
        {
            freqCounter ++;
            return;
        }
        freqCounter = 1;
        double theta; //angle that the enemy has moved
        if (direction.equals("ccw"))
            theta = (counter * speed) / r;
        else
            theta = -(counter * speed) / r;
        int sign;
        if (counter < Math.PI * r/speed)
            sign = -1;
        else
            sign = 1;
        double x = r*Math.cos(theta);
        double y = r*Math.sin(theta);
        double slope = -x/y; //slope of the circle at the given point
        double rawXIncr = sign * Math.sqrt(speed * speed / (1 + slope * slope));
        double rawYIncr = -slope * rawXIncr;
        int xIncr = (int) Math.round(rawXIncr);
        int yIncr = (int) Math.round(rawYIncr);
        move(xIncr,yIncr);
        counter ++;
        counter %= (2*Math.PI*r/speed);
    }
    */
   
    void moveInCircle(int xCen, int yCen, int radius, String direction)
    {
        if (freqCounter < moveFreq)
        {
            freqCounter++;
            return;
        }
        freqCounter = 1;
        counter %= 2*Math.PI;
        if (direction.equals("ccw")) 
            counter += speed/radius;
        else
            counter -= speed/radius;
        xPos = xCen + (int) Math.round(radius*Math.cos(counter));
        yPos = yCen - (int) Math.round(radius*Math.sin(counter));
    }
    
    //Number of timer firings that it takes the enemy to move along the
    //x side of a rectangle; see moveRectCW and moveRect CWW
    private int xTime(int xRad, int yRad)
    {
        return (int)Math.round(xRad/speed);
    }
    
    //Same as previous, just for ySide
    private int yTime(int xRad, int yRad)
    {
        return (int)Math.round(yRad/speed);
    }
    
    private void moveInRectCW(int xRad, int yRad)
    {
        freqCounter = 0;
        int xTime = xTime(xRad,yRad);
        int yTime = yTime(xRad,yRad);
        //four phases:
        if (0 <= counter && counter < xTime)
            move(roundedSpeed(),0);
        else if (xTime <= counter && counter < xTime + yTime)
            move(0,roundedSpeed());
        else if (xTime + yTime <= counter && counter < 2*xTime + yTime)
            move(-roundedSpeed(),0);
        else
            move(0,-roundedSpeed());
        counter ++;
        counter %= 2*(xTime + yTime);
    }
    
    private void moveInRectCCW(int xRad, int yRad)
    {
        int xTime = xTime(xRad,yRad);
        int yTime = yTime(xRad,yRad);
        //four phases:
        if (0 <= counter && counter < yTime)
            move(0,roundedSpeed());
        else if (yTime <= counter && counter < xTime + yTime)
            move(roundedSpeed(),0);
        else if (xTime + yTime <= counter && counter < xTime + 2*yTime)
            move(0,-roundedSpeed());
        else
            move(-roundedSpeed(),0);
        counter ++;
        counter %= 2*(xTime + yTime);
    }
    
    void moveInRect(int xRad, int yRad, String direction)
    {
        if (freqCounter < moveFreq)
        {
            freqCounter ++;
            return;
        }
        freqCounter = 1;
        if (direction.equals("ccw"))
            moveInRectCCW(xRad,yRad);
        else
            moveInRectCW(xRad,yRad);
    }
}
