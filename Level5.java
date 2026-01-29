import java.util.ArrayList;

class Level5 extends Game
{    
    private ArrayList<Enemy> down = new ArrayList<Enemy>();
    private ArrayList<Enemy> up = new ArrayList<Enemy>();
    
    Level5()
    {
        player = new Player(75,315,12,2); //Speed 2
        barriers.add(new Barrier(0,325,30,330));
        barriers.add(new Barrier(850,325,30,330));
        barriers.add(new Barrier(425,0,430,30));
        barriers.add(new Barrier(425,630,430,30));
        barriers.add(new Barrier(0,0,140,270));
        barriers.add(new Barrier(0,630,140,270));
        checkpoints.add(new Checkpoint(75,315,45,45));
        barriers.add(new Barrier(850,0,140,270));
        barriers.add(new Barrier(850,630,140,270));
        checkpoints.add(new Checkpoint(775,315,45,45));
        keysLeft.add(new Key(775,315));
        for (int i = 0; i < 4; i++)
        {
            keysLeft.add(new Key(195+140*i,315));
        }
        keysLeft.add(new Key(160,240));
        keysLeft.add(new Key(265,240));
        keysLeft.add(new Key(405,390));
        keysLeft.add(new Key(545,240));
        keysLeft.add(new Key(685,390));
        for (int i = 0; i < 8; i ++)
        {
            Enemy e = new Enemy(160+70*i,55,8,1);
            down.add(e);
            ignoringEnemies.add(e);
        }
        for (int i = 0; i < 8; i++)
        {
            Enemy e = new Enemy(195+70*i,575,8,1,65);
            down.add(e);
            ignoringEnemies.add(e);
        }
    }
    
    public void update()
    {
        interactAll();
        updatePlayer();
        updateTargeters();
        for (Enemy e : down)
        {
            e.moveInVLine(520);
        }
    }
}
