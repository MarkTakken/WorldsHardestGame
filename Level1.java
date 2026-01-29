import java.util.ArrayList;

class Level1 extends Game
{
    ArrayList<Enemy> radius30 = new ArrayList<Enemy>();
    ArrayList<Enemy> radius60 = new ArrayList<Enemy>();
    ArrayList<Enemy> radius90 = new ArrayList<Enemy>();
    ArrayList<Enemy> radius120 = new ArrayList<Enemy>();
    ArrayList<Enemy> radius150 = new ArrayList<Enemy>();
    ArrayList<Enemy> radius180 = new ArrayList<Enemy>();
    ArrayList<Enemy> radius210 = new ArrayList<Enemy>();
    ArrayList<Enemy> radius240 = new ArrayList<Enemy>();
    ArrayList<Enemy> radius270 = new ArrayList<Enemy>();
    Level1()
    {
        player = new Player(75,315,12,4);
        checkpoints.add(new Checkpoint(75,315,50,50));
        keysLeft.add(new Key(300,400));
        keysLeft.add(new Key(300,225));
        keysLeft.add(new Key(550,400));
        keysLeft.add(new Key(550,225));
        barriers.add(new Barrier(0,325,30,330));
        barriers.add(new Barrier(850,325,30,330));
        barriers.add(new Barrier(425,0,430,30));
        barriers.add(new Barrier(425,630,430,30));
        barriers.add(new Barrier(0,0,140,270));
        barriers.add(new Barrier(0,630,140,270));
        barriers.add(new Barrier(850,0,140,270));
        barriers.add(new Barrier(850,630,140,270));
        barriers.add(new Barrier(180,560,45,45));
        barriers.add(new Barrier(180,65,45,45));
        barriers.add(new Barrier(670,560,45,45));
        barriers.add(new Barrier(670,65,45,45));
        barriers.add(new Barrier(775,315,50,50));
        barriers.add(new Barrier(165,495,25,25));
        barriers.add(new Barrier(165,130,25,25));
        barriers.add(new Barrier(685,495,25,25));
        barriers.add(new Barrier(685,130,25,25));
        barriers.add(new Barrier(245,575,25,25));
        barriers.add(new Barrier(245,50,25,25));
        barriers.add(new Barrier(605,575,25,25));
        barriers.add(new Barrier(605,50,25,25));
        barriers.add(new Barrier(155,455,15,20));
        barriers.add(new Barrier(155,170,15,20));
        barriers.add(new Barrier(695,455,15,20));
        barriers.add(new Barrier(695,170,15,20));
        barriers.add(new Barrier(290,585,22,15));
        barriers.add(new Barrier(290,40,22,15));
        barriers.add(new Barrier(560,585,22,15));
        barriers.add(new Barrier(560,40,22,15));
        ignoringEnemies.add(new Enemy(425,315,0,1));
        radius30.add(new Enemy(455,315,1,1));
        radius30.add(new Enemy(425,285,1,1,Math.PI/2));
        radius30.add(new Enemy(395,315,1,1,Math.PI));
        radius30.add(new Enemy(425,345,1,1,3*Math.PI/2));
        radius60.add(new Enemy(485,315,2,1));
        radius60.add(new Enemy(425,255,2,1,Math.PI/2));
        radius60.add(new Enemy(365,315,2,1,Math.PI));
        radius60.add(new Enemy(425,375,2,1,3*Math.PI/2));
        radius90.add(new Enemy(425+90,315,3,1));
        radius90.add(new Enemy(425,315-90,3,1,Math.PI/2));
        radius90.add(new Enemy(425-90,315,3,1,Math.PI));
        radius90.add(new Enemy(425,315+90,3,1,3*Math.PI/2));
        radius120.add(new Enemy(425+120,315,4,1));
        radius120.add(new Enemy(425,315-120,4,1,Math.PI/2));
        radius120.add(new Enemy(425-120,315,4,1,Math.PI));
        radius120.add(new Enemy(425,315+120,4,1,3*Math.PI/2));
        radius150.add(new Enemy(425+150,315,5,1));
        radius150.add(new Enemy(425,315-150,5,1,Math.PI/2));
        radius150.add(new Enemy(425-150,315,5,1,Math.PI));
        radius150.add(new Enemy(425,315+150,5,1,3*Math.PI/2));
        radius180.add(new Enemy(425+180,315,6,1));
        radius180.add(new Enemy(425,315-180,6,1,Math.PI/2));
        radius180.add(new Enemy(425-180,315,6,1,Math.PI));
        radius180.add(new Enemy(425,315+180,6,1,3*Math.PI/2));
        radius210.add(new Enemy(425+210,315,7,1));
        radius210.add(new Enemy(425,315-210,7,1,Math.PI/2));
        radius210.add(new Enemy(425-210,315,7,1,Math.PI));
        radius210.add(new Enemy(425,315+210,7,1,3*Math.PI/2));
        radius240.add(new Enemy(425+240,315,8,1));
        radius240.add(new Enemy(425,315-240,8,1,Math.PI/2));
        radius240.add(new Enemy(425-240,315,8,1,Math.PI));
        radius240.add(new Enemy(425,315+240,8,1,3*Math.PI/2));
        radius270.add(new Enemy(425+270,315,9,1));
        radius270.add(new Enemy(425,315-270,9,1,Math.PI/2));
        radius270.add(new Enemy(425-270,315,9,1,Math.PI));
        radius270.add(new Enemy(425,315+270,9,1,3*Math.PI/2));
        for (Enemy enemy : radius30)
            ignoringEnemies.add(enemy);
        for (Enemy enemy : radius60)
            ignoringEnemies.add(enemy);
        for (Enemy enemy : radius90)
            ignoringEnemies.add(enemy);
        for (Enemy enemy : radius120)
            ignoringEnemies.add(enemy);
        for (Enemy enemy : radius150)
            ignoringEnemies.add(enemy);
        for (Enemy enemy : radius180)
            ignoringEnemies.add(enemy);
        for (Enemy enemy : radius210)
            ignoringEnemies.add(enemy);
        for (Enemy enemy : radius240)
            ignoringEnemies.add(enemy);
        for (Enemy enemy : radius270)
            ignoringEnemies.add(enemy);
    }
    
    public void update()
    {
        interactAll();
        updatePlayer();
        for (Enemy enemy : radius30) 
            enemy.moveInCircle(425,315,30,"ccw");
        for (Enemy enemy : radius60)
            enemy.moveInCircle(425,315,60,"ccw");
        for (Enemy enemy : radius90)
            enemy.moveInCircle(425,315,90,"ccw");
        for (Enemy enemy : radius120)
            enemy.moveInCircle(425,315,120,"ccw");
        for (Enemy enemy : radius150)
            enemy.moveInCircle(425,315,150,"ccw");
        for (Enemy enemy : radius180)
            enemy.moveInCircle(425,315,180,"ccw");
        for (Enemy enemy : radius210)
            enemy.moveInCircle(425,315,210,"ccw");
        for (Enemy enemy : radius240)
            enemy.moveInCircle(425,315,240,"ccw");
        for (Enemy enemy : radius270)
            enemy.moveInCircle(425,315,270,"ccw");
    }
}
