import java.awt.event.KeyListener;
import java.awt.event.KeyEvent;

class KeyInput implements KeyListener
{
    private boolean upPressed, downPressed, leftPressed, rightPressed;
    
    boolean upPressed() {return upPressed;}
    boolean downPressed() {return downPressed;}
    boolean leftPressed() {return leftPressed;}
    boolean rightPressed() {return rightPressed;}
    
    public void keyPressed(KeyEvent e)
    {
        switch(e.getKeyCode())
        {
            case KeyEvent.VK_UP: case KeyEvent.VK_W:
                upPressed = true;
                downPressed = false;
                break;
            case KeyEvent.VK_DOWN: case KeyEvent.VK_S:
                downPressed = true;
                upPressed = false;
                break;
            case KeyEvent.VK_LEFT: case KeyEvent.VK_A:
                leftPressed = true;
                rightPressed = false;
                break;
            case KeyEvent.VK_RIGHT: case KeyEvent.VK_D:
                rightPressed = true;
                leftPressed = false;
                break;
        }
    }
    
    public void keyReleased(KeyEvent e)
    {
        switch(e.getKeyCode())
        {
            case KeyEvent.VK_UP: case KeyEvent.VK_W:
                upPressed = false;
                break;
            case KeyEvent.VK_DOWN: case KeyEvent.VK_S:
                downPressed = false;
                break;
            case KeyEvent.VK_LEFT: case KeyEvent.VK_A:
                leftPressed = false;
                break;
            case KeyEvent.VK_RIGHT: case KeyEvent.VK_D:
                rightPressed = false;
                break;
        }
    }
    
    public void keyTyped(KeyEvent e){}
}
