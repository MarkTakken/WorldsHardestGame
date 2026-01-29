public class Targeter extends Enemy
{   
    private int initX, initY;
    public Targeter(int a, int b, double s, int freq)
    {
        super(a, b, s,freq);
        initX = a;
        initY = b;
    }
    public void setInitPos(int x, int y)
    {
        initX = x;
        initY = y;
    }
    public void reset()
    {
        xPos = initX;
        yPos = initY;
    }
    public void target(int x, int y)
    {
        if (freqCounter < getMoveFreq())
        {
            freqCounter ++;
            return;
        }
        freqCounter = 1;
        int deltaX = x - xPos;
        int deltaY = y - yPos;
        double slope = (double) deltaY / deltaX;
        int sign;
        if (deltaX == 0) sign = 1;
        else sign = deltaX / Math.abs(deltaX);
        double rawXIncrement = sign * Math.sqrt(getSpeed() * getSpeed() / (slope * slope + 1));
        double rawYIncrement = rawXIncrement * slope;
        int xIncrement = (int) Math.round(rawXIncrement);
        int yIncrement = (int) Math.round(rawYIncrement);
        xPos += xIncrement;
        yPos += yIncrement;
    }
}
