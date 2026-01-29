import java.awt.Graphics;
import java.awt.Color;
import javax.swing.JFrame;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.Timer;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

class Panel extends JPanel implements ActionListener {
    private static Game game;
    private static JFrame gameWindow, levelWindow, winWindow1, winWindow2;
    private static Timer clock;
    private static int level;
    private static final int CLOCK_FREQUENCY = 16; //16
    private static final int TIME_TO_RESET = 1000;
    private static final int TIME_TO_WIN = 500;
    private static int reset_counter;
    private static int win_counter;
    
    public void paintComponent(Graphics g) {
        super.paintComponent(g);
        game.drawAll(g);
    }

    public void actionPerformed(ActionEvent e) {
        if (game.gameWon()) {
            win_counter ++;
            int times_to_fire = (int) Math.round(TIME_TO_WIN / CLOCK_FREQUENCY);
            if (win_counter == times_to_fire)
            {
                win_counter = 0;
                clock.stop();
                gameEnd();
                return;
            }
        }
        if (game.shouldReset()) {
            reset_counter++;
            int times_to_fire = (int) Math.round(TIME_TO_RESET / CLOCK_FREQUENCY);
            if (reset_counter == times_to_fire) {
                game.reset();
                reset_counter = 0;
            }
            return;
        }
        game.update();
        repaint();
    }
    
    private static void playGame() {
        switch(level)
        {
            case 1:
                game = new Level1();
                gameWindow = new JFrame("Level 1");
                break;
            case 2:
                game = new Level2();
                gameWindow = new JFrame("Level 2");
                break;
            case 3:
                game = new Level3();
                gameWindow = new JFrame("Level 3");
                break;
            case 4:
                game = new Level4();
                gameWindow = new JFrame("Level 4");
                break;
            case 5:
                game = new Level5();
                gameWindow = new JFrame("Level 5");
                break;
        }
        gameWindow.setSize(Game.boardLength(), Game.boardWidth());
        gameWindow.addKeyListener(game.keys);
        Panel panel = new Panel();
        panel.setBackground(Color.WHITE);
        gameWindow.getContentPane().add(panel);
        gameWindow.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        gameWindow.setVisible(true);
        clock = new Timer(CLOCK_FREQUENCY, panel);
        clock.start();
    }

    private static void gameEnd()
    {
        if (level != Game.lastLevel())
            winWindow1.setVisible(true);
        else
            winWindow2.setVisible(true);
    }

    private static void chooseLevel() {
        levelWindow.setVisible(true);
    }
    
    private static void setChooseWindow()
    {
        levelWindow = new JFrame("Choose Level");
        levelWindow.setBounds(50, 50, 387, 200);
        levelWindow.setLayout(null);
        JButton level1 = new JButton("Level 1");
        level1.setBounds(20, 20, 100, 50);
        JButton level2 = new JButton("Level 2");
        level2.setBounds(135,20,100,50);
        JButton level3 = new JButton("Level 3");
        level3.setBounds(250,20,100,50);
        JButton level4 = new JButton("Level 4");
        level4.setBounds(20,85,100,50);
        JButton level5 = new JButton("Level 5");
        level5.setBounds(135,85,100,50);
        levelWindow.add(level1);
        levelWindow.add(level2);
        levelWindow.add(level3);
        levelWindow.add(level4);
        levelWindow.add(level5);
        levelWindow.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        level1.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                level = 1;
                playGame();
                levelWindow.setVisible(false);
            }
        });
        
        level2.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                level = 2;
                playGame();
                levelWindow.setVisible(false);
            }
        });
        
        level3.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                level = 3;
                playGame();
                levelWindow.setVisible(false);
            }
        });
        
        level4.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                level = 4;
                playGame();
                levelWindow.setVisible(false);
            }
        });
        
        level5.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                level = 5;
                playGame();
                levelWindow.setVisible(false);
            }
        });
    }
    
    private static void setEndWindow1()
    {
        winWindow1 = new JFrame();
        winWindow1.setBounds(50, 50, 210, 210);
        winWindow1.setLayout(null);
        JLabel label = new JLabel("You have beaten this level!");
        label.setBounds(20, 20, 170, 20);
        JButton choose = new JButton("Choose level");
        JButton next = new JButton("Next level");
        next.setBounds(23, 50, 150, 50);
        winWindow1.add(next);
        choose.setBounds(23, 110, 150, 50);
        next.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                level++;
                gameWindow.setVisible(false);
                playGame();
                winWindow1.setVisible(false);
            }
        });
        choose.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                chooseLevel();
                gameWindow.setVisible(false);
                winWindow1.setVisible(false);
            }
        });
        winWindow1.add(label);
        winWindow1.add(choose);
        winWindow1.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    }
    
    private static void setEndWindow2()
    {
        winWindow2 = new JFrame();
        winWindow2.setBounds(50, 50, 210, 200);
        winWindow2.setLayout(null);
        JLabel label = new JLabel("You have beaten this level!");
        label.setBounds(20, 20, 170, 20);
        JButton choose = new JButton("Choose level");
        choose.setBounds(23, 50, 150, 50);
        winWindow2.add(label);
        winWindow2.add(choose);
        winWindow2.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        choose.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                chooseLevel();
                gameWindow.setVisible(false);
                winWindow2.setVisible(false);
            }
        });
    }

    public static void main(String[] args) {
        setChooseWindow();
        setEndWindow1();
        setEndWindow2();
        chooseLevel();
    }
}
