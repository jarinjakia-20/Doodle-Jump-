import javax.swing.*;
import java.awt.*;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.awt.image.BufferedImage;
import java.util.Random;

abstract class GameObject {
    protected int x, y;
    public int getX() {
        return x;
    }
    public int getY() {
        return y;
    }
    public void setX(int x) {
        this.x = x;
    }
    public void setY(int y) {
        this.y = y;
    }
}

class Platform extends GameObject {
    public Platform(int x, int y) {
        this.x = x;
        this.y = y;
    }
}

public class DoodleJump extends JPanel implements Runnable, KeyListener {
    private static final int WIDTH = 400;
    private static final int HEIGHT = 533;
    private static final int BASE_HEIGHT = 150;
    private static final float GRAVITY = 0.2f;
    private static final int PLATFORM_WIDTH = 68;
    private static final int PLATFORM_HEIGHT = 14;
    private static final int DOODLE_WIDTH = 60;
    private static final int DOODLE_HEIGHT = 60;

    private boolean gameOver = false;
    private boolean isRunning;
    private Thread thread;
    private BufferedImage view;
    private BufferedImage background, platformImg, doodleImg;

    private Platform[] platforms;

    private int doodleX = 100, doodleY = 100;
    private float velocityY = 0;
    private boolean moveRight, moveLeft;

    private int score = 0;

    public DoodleJump() {
        setPreferredSize(new Dimension(WIDTH, HEIGHT));
        setFocusable(true);
        addKeyListener(this);
        loadImages();
        initializePlatforms();
    }

    public static void main(String[] args) {
        JFrame window = new JFrame("Doodle Jump");
        window.setResizable(false);
        window.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        DoodleJump game = new DoodleJump();
        window.add(game);
        window.pack();
        window.setLocationRelativeTo(null);
        window.setVisible(true);
        game.start();
    }

    public void start() {
        view = new BufferedImage(WIDTH, HEIGHT, BufferedImage.TYPE_INT_RGB);
        isRunning = true;
        thread = new Thread(this);
        thread.start();
    }

    private void loadImages() {
        background = new BufferedImage(WIDTH, HEIGHT, BufferedImage.TYPE_INT_RGB);
        Graphics2D gBg = background.createGraphics();
        gBg.setPaint(Color.CYAN);
        gBg.fillRect(0, 0, WIDTH, HEIGHT);

        platformImg = new BufferedImage(PLATFORM_WIDTH, PLATFORM_HEIGHT, BufferedImage.TYPE_INT_ARGB);
        Graphics2D gPlat = platformImg.createGraphics();
        gPlat.setPaint(Color.GREEN);
        gPlat.fillRect(0, 0, PLATFORM_WIDTH, PLATFORM_HEIGHT);

        doodleImg = new BufferedImage(DOODLE_WIDTH, DOODLE_HEIGHT, BufferedImage.TYPE_INT_ARGB);
        Graphics2D gDoodle = doodleImg.createGraphics();
        gDoodle.setPaint(Color.BLACK);
        gDoodle.fillOval(0, 0, DOODLE_WIDTH, DOODLE_HEIGHT);
    }

    private void initializePlatforms() {
        platforms = new Platform[10];
        Random rand = new Random();
        for (int i = 0; i < platforms.length; i++) {
            int x = rand.nextInt(WIDTH - PLATFORM_WIDTH);
            int y = rand.nextInt(HEIGHT);
            platforms[i] = new Platform(x, y);
        }
    }

    private void updateGame() {
        if (moveRight) doodleX += 4;
        if (moveLeft) doodleX -= 4;

        if (doodleX > WIDTH) doodleX = 0;
        if (doodleX < 0) doodleX = WIDTH;

        velocityY += GRAVITY;
        doodleY += velocityY;

        for (Platform p : platforms) {
            if ((doodleX + 50 > p.getX()) &&
                    (doodleX + 10 < p.getX() + PLATFORM_WIDTH) &&
                    (doodleY + DOODLE_HEIGHT >= p.getY()) &&
                    (doodleY + DOODLE_HEIGHT <= p.getY() + PLATFORM_HEIGHT) &&
                    velocityY > 0) {
                velocityY = -10;
                score += 10;
            }
        }

        if (doodleY < BASE_HEIGHT) {
            doodleY = BASE_HEIGHT;
            for (Platform p : platforms) {
                p.setY(p.getY() - (int) velocityY);
                if (p.getY() > HEIGHT) {
                    p.setY(0);
                    p.setX(new Random().nextInt(WIDTH - PLATFORM_WIDTH));
                }
            }
        }

        if (doodleY > HEIGHT) {
            gameOver = true;
            isRunning = false;
        }
    }

    private void drawGame() {
        Graphics2D g2 = (Graphics2D) view.getGraphics();
        g2.drawImage(background, 0, 0, null);
        g2.drawImage(doodleImg, doodleX, doodleY, null);

        for (Platform p : platforms) {
            g2.drawImage(platformImg, p.getX(), p.getY(), null);
        }

        g2.setColor(Color.BLACK);
        g2.setFont(new Font("Arial", Font.BOLD, 20));
        g2.drawString("Score: " + score, 10, 25);

        if (gameOver) {
            g2.setColor(Color.BLACK);
            g2.setFont(new Font("Arial", Font.BOLD, 40));
            g2.drawString("GAME OVER", WIDTH / 2 - 120, HEIGHT / 2);
        }

        Graphics g = getGraphics();
        if (g != null) {
            g.drawImage(view, 0, 0, null);
            g.dispose();
        }
    }

    @Override
    public void run() {
        while (isRunning) {
            updateGame();
            drawGame();
            try {
                Thread.sleep(1000 / 60);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }

    @Override
    public void keyPressed(KeyEvent e) {
        if (e.getKeyCode() == KeyEvent.VK_LEFT) moveLeft = true;
        if (e.getKeyCode() == KeyEvent.VK_RIGHT) moveRight = true;
    }

    @Override
    public void keyReleased(KeyEvent e) {
        if (e.getKeyCode() == KeyEvent.VK_LEFT) moveLeft = false;
        if (e.getKeyCode() == KeyEvent.VK_RIGHT) moveRight = false;
    }

    @Override
    public void keyTyped(KeyEvent e) {
    }
}