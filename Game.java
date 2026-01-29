import java.awt.Graphics;
import java.util.ArrayList;

public abstract class Game {
    KeyInput keys = new KeyInput();
    Player player;
    ArrayList<Enemy> ignoringEnemies = new ArrayList<Enemy>();
    ArrayList<Targeter> targeters = new ArrayList<Targeter>();
    ArrayList<Key> keysLeft = new ArrayList<Key>();
    ArrayList<Barrier> barriers = new ArrayList<Barrier>();
    ArrayList<Checkpoint> checkpoints = new ArrayList<Checkpoint>();
    private boolean shouldReset = false;
    private static final int boardLength = 850, boardWidth = 650;
    private static final int lastLevel = 5;

    public boolean shouldReset() {
        return shouldReset;
    }

    public boolean gameWon() {
        return keysLeft.size() == 0;
    }

    public static int boardLength() {
        return boardLength;
    }

    public static int boardWidth() {
        return boardWidth;
    }

    public static int lastLevel() {
        return lastLevel;
    }

    public void reset() {
        player.reset();
        for (Targeter targeter : targeters)
            targeter.reset();
        for (Key key : keysLeft)
            key.collected = false;
        shouldReset = false;
    }

    public void enemyInteract(Enemy enemy) {
        shouldReset = true;
    }

    public void keyInteract(Key key) {
        key.collected = true;
    }

    public void barrierInteract(Barrier barrier) {
        String side = barrier.sideTouched(player.getX(),player.getY(),player.getRadius(),player.getSpeed());
        if (side == null)
        {
            switch(barrier.sideLastTouched)
            {
                case "left":
                    player.leftPossible = true;
                    barrier.sideLastTouched = "none"; //So that leftPossible will not be continuously
                                                       //being set to true
                    break;
                case "right":
                    player.rightPossible = true;
                    barrier.sideLastTouched = "none";
                    break;
                case "up":
                    player.upPossible = true;
                    barrier.sideLastTouched = "none";
                    break;
                case "down":
                    player.downPossible = true;
                    barrier.sideLastTouched = "none";
                    break;
            }
        }
        else
        {
            switch (side)
            {
                case "left":
                    //This is in case side simply goes from one direction to the other without
                    //ever being null.  Then the direction previously touched needs to be set to true.  
               //Again, this smells bad, but I couldn’t think of a better way.
                    if (barrier.sideLastTouched.equals("right"))
                        player.rightPossible = true;
                    else if (barrier.sideLastTouched.equals("up"))
                        player.upPossible = true;
                    else if (barrier.sideLastTouched.equals("down"))
                        player.downPossible = true;
                    barrier.sideLastTouched = "left";
                    player.leftPossible = false;
                    break;
                case "right":
                    if (barrier.sideLastTouched.equals("left"))
                        player.leftPossible = true;
                    else if (barrier.sideLastTouched.equals("up"))
                        player.upPossible = true;
                    else if (barrier.sideLastTouched.equals("down"))
                        player.downPossible = true;
                    barrier.sideLastTouched = "right";
                    player.rightPossible = false;
                    break;
                case "up":
                    if (barrier.sideLastTouched.equals("right"))
                        player.rightPossible = true;
                    else if (barrier.sideLastTouched.equals("left"))
                        player.leftPossible = true;
                    else if (barrier.sideLastTouched.equals("down"))
                        player.downPossible = true;
                    barrier.sideLastTouched = "up";
                    player.upPossible = false;
                    break;
                case "down":
                    if (barrier.sideLastTouched.equals("right"))
                        player.rightPossible = true;
                    else if (barrier.sideLastTouched.equals("up"))
                        player.upPossible = true;
                    else if (barrier.sideLastTouched.equals("left"))
                        player.leftPossible = true;
                    barrier.sideLastTouched = "down";
                    player.downPossible = false;
                    break;
            }
        }
    }

    public void checkpointInteract(Checkpoint checkpoint) {
        for (int i = 0; i < keysLeft.size(); i++) {
            if (keysLeft.get(i).collected) {
                keysLeft.remove(i);
                i--;
            }
        }
        player.setInitPos(checkpoint.xPos, checkpoint.yPos);
    }

    public void interactAll() {
        for (Enemy enemy : ignoringEnemies)
            if (enemy.shouldInteract(player.getX(), player.getY(), player.getRadius()))
                enemyInteract(enemy);
        for (Enemy enemy : targeters)
            if (enemy.shouldInteract(player.getX(), player.getY(), player.getRadius()))
                enemyInteract(enemy);
        for (Key key : keysLeft)
            if (key.shouldInteract(player.getX(), player.getY(), player.getRadius()))
                keyInteract(key);
        for (Barrier barrier : barriers) {
            barrierInteract(barrier);
        }
        for (Checkpoint checkpoint : checkpoints)
            if (checkpoint.shouldInteract(player.getX(), player.getY(), player.getRadius()))
                checkpointInteract(checkpoint);
    }

    public void drawAll(Graphics g) {
        for (int i = 0; i < checkpoints.size(); i++) {
            checkpoints.get(i).draw(g);
        }
        for (int i = 0; i < keysLeft.size(); i++) {
            if (!keysLeft.get(i).collected)
                keysLeft.get(i).draw(g);
        }
        player.draw(g);
        for (int i = 0; i < barriers.size(); i++) {
            barriers.get(i).draw(g);
        }
        for (int i = 0; i < ignoringEnemies.size(); i++) {
            ignoringEnemies.get(i).draw(g);
        }
        for (int i = 0; i < targeters.size(); i++) {
            targeters.get(i).draw(g);
        }
    }

    public void updatePlayer() {
        if (keys.leftPressed() && player.leftPossible)
            player.move(-player.getSpeed(), 0);
        if (keys.rightPressed() && player.rightPossible)
            player.move(player.getSpeed(), 0);
        if (keys.upPressed() && player.upPossible)
            player.move(0, -player.getSpeed());
        if (keys.downPressed() && player.downPossible)
            player.move(0, player.getSpeed());
    }

    public void updateTargeters() {
        for (Targeter targeter : targeters)
            targeter.target(player.getX(), player.getY());
    }

    public abstract void update();
}
