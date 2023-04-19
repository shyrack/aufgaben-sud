package sud.aufgaben;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.Graphics;
import java.awt.Point;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.util.ArrayList;
import java.util.Random;
import javax.swing.JFrame;
import javax.swing.JPanel;

public class Snake extends JPanel implements Runnable, KeyListener {

    private static final long serialVersionUID = 1L;
    private static final int WIDTH = 200;
    private static final int HEIGHT = 200;
    private static final int DOT_SIZE = 10;
    private static final int ALL_DOTS = 397;
    private static final int RAND_POS = 19;
    private static final int DELAY = 140;

    private final int[] x = new int[ALL_DOTS];
    private final int[] y = new int[ALL_DOTS];
    private int dots;
    private int apple_x;
    private int apple_y;
    private boolean leftDirection = false;
    private boolean rightDirection = true;
    private boolean upDirection = false;
    private boolean downDirection = false;
    private boolean inGame = true;

    public Snake() {
        addKeyListener(this);
        setBackground(Color.black);
        setPreferredSize(new Dimension(WIDTH, HEIGHT));
        setFocusable(true);
        initGame();
    }

    public void initGame() {
        dots = 3;
        for (int i = 0; i < dots; i++) {
            x[i] = 50 - i * DOT_SIZE;
            y[i] = 50;
        }
        locateApple();
        new Thread(this).start();
    }

    public void locateApple() {
        Random rand = new Random();
        apple_x = rand.nextInt(RAND_POS) * DOT_SIZE;
        apple_y = rand.nextInt(RAND_POS) * DOT_SIZE;
    }
    
    public void checkApple() {
        if (x[0] == apple_x && y[0] == apple_y) {
            dots++;
            locateApple();
        }
    }
    
    public void checkCollision() {
        for (int i = dots; i > 0; i--) {
            if (i > 4 && x[0] == x[i] && y[0] == y[i]) {
                inGame = false;
            }
        }
        if (x[0] < 0 || x[0] >= WIDTH || y[0] < 0 || y[0] >= HEIGHT) {
            inGame = false;
        }
        if (!inGame) {
            System.out.println("Game over!");
        }
    }
    
    public void move() {
        for (int i = dots; i > 0; i--) {
            x[i] = x[i - 1];
            y[i] = y[i - 1];
        }
        if (leftDirection) {
            x[0] -= DOT_SIZE;
        }
        if (rightDirection) {
            x[0] += DOT_SIZE;
        }
        if (upDirection) {
            y[0] -= DOT_SIZE;
        }
        if (downDirection) {
            y[0] += DOT_SIZE;
        }
    }
    
    public void paintComponent(Graphics g) {
        super.paintComponent(g);
        draw(g);
    }
    
    public void draw(Graphics g) {
        if (inGame) {
            g.setColor(Color.red);
            g.fillOval(apple_x, apple_y, DOT_SIZE, DOT_SIZE);
            for (int i = 0; i < dots; i++) {
                g.setColor(Color.white);
                g.fillRect(x[i], y[i], DOT_SIZE, DOT_SIZE);
            }
        } else {
            gameOver(g);
        }
    }
    
    public void gameOver(Graphics g) {
        String msg = "Game Over";
        g.setColor(Color.white);
        g.drawString(msg, (WIDTH - g.getFontMetrics().stringWidth(msg)) / 2, HEIGHT / 2);
    }
    
    public void keyPressed(KeyEvent e) {
        int key = e.getKeyCode();
    
        if (key == KeyEvent.VK_LEFT && !rightDirection) {
            leftDirection = true;
            upDirection = false;
            downDirection = false;
        } else if (key == KeyEvent.VK_RIGHT && !leftDirection) {
            rightDirection = true;
            upDirection = false;
            downDirection = false;
        } else if (key == KeyEvent.VK_UP && !downDirection && !isMovingVertically()) {
            upDirection = true;
            rightDirection = false;
            leftDirection = false;
        } else if (key == KeyEvent.VK_DOWN && !upDirection && !isMovingVertically()) {
            downDirection = true;
            rightDirection = false;
            leftDirection = false;
        }
    }
    
    private boolean isMovingVertically() {
        return upDirection || downDirection;
    }
    
    public void keyReleased(KeyEvent e) {
    }
    
    public void keyTyped(KeyEvent e) {
    }
    
    public void run() {
        while (inGame) {
            checkApple();
            checkCollision();
            move();
            repaint();
            try {
                Thread.sleep(DELAY);
            } catch (InterruptedException e) {
                System.out.println("Error: " + e.getMessage());
            }
        }
    }
    
    public static void main(String[] args) {
        JFrame frame = new JFrame("Snake");
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.add(new Snake());
        frame.pack();
        frame.setLocationRelativeTo(null);
        frame.setVisible(true);
    }
}