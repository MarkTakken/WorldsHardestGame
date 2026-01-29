public class Level2 extends Game {
//NOT YET TESTED
    Enemy enemy = new Enemy(306, 260, 5, 1);
    Enemy enemy2 = new Enemy(318, 390, 5, 1);
    Enemy enemy3 = new Enemy(330, 260, 5, 1);
    Enemy enemy4 = new Enemy(342, 390, 5, 1);
    Enemy enemy5 = new Enemy(354, 260, 5, 1);
    Enemy enemy6 = new Enemy(366, 390, 5, 1);
    Enemy enemy7 = new Enemy(378, 260, 5, 1);
    Enemy enemy8 = new Enemy(390, 390, 5, 1);
    Enemy enemy9 = new Enemy(402, 260, 5, 1);
    Enemy enemy10 = new Enemy(414, 390, 5, 1);
    Enemy enemy11 = new Enemy(426, 260, 5, 1);
    Enemy enemy12 = new Enemy(438, 390, 5, 1);
    Enemy enemy13 = new Enemy(450, 260, 5, 1);
    Enemy enemy14 = new Enemy(462, 390, 5, 1);
    Enemy enemy15 = new Enemy(474, 260, 5, 1);
    Enemy enemy16 = new Enemy(486, 390, 5, 1);
    Enemy enemy17 = new Enemy(498, 260, 5, 1);
    Enemy enemy18 = new Enemy(510, 390, 5, 1);
    Enemy enemy19 = new Enemy(522, 260, 5, 1);
    Enemy enemy20 = new Enemy(534, 390, 5, 1);
    Enemy enemy21 = new Enemy(546, 260, 5, 1);
    
    Level2() {
        player = new Player(280, 325, 12);
        
        ignoringEnemies.add(enemy);
        ignoringEnemies.add(enemy2);
        ignoringEnemies.add(enemy3);
        ignoringEnemies.add(enemy4);
        ignoringEnemies.add(enemy5);
        ignoringEnemies.add(enemy6);
        ignoringEnemies.add(enemy7);
        ignoringEnemies.add(enemy8);
        ignoringEnemies.add(enemy9);
        ignoringEnemies.add(enemy10);
        ignoringEnemies.add(enemy11);
        ignoringEnemies.add(enemy12);
        ignoringEnemies.add(enemy13);
        ignoringEnemies.add(enemy14);
        ignoringEnemies.add(enemy15);
        ignoringEnemies.add(enemy16);
        ignoringEnemies.add(enemy17);
        ignoringEnemies.add(enemy18);
        ignoringEnemies.add(enemy19);
        ignoringEnemies.add(enemy20);
        ignoringEnemies.add(enemy21);

        barriers.add(new Barrier(425, 250, 124, 3));
        barriers.add(new Barrier(425, 400, 124, 3));
        barriers.add(new Barrier(549, 370, 3, 30));
        barriers.add(new Barrier(549, 280, 3, 30));
        barriers.add(new Barrier(301, 280, 3, 30));
        barriers.add(new Barrier(301, 370, 3, 30));
        keysLeft.add(new Key(425, 325));

        checkpoints.add(new Checkpoint(575, 325, 25, 25));
    }

    public void update() {
        interactAll();
        updatePlayer();
        enemy.moveInVLine(100);
        enemy2.moveInVLine(100);
        enemy3.moveInVLine(100);
    }
}
