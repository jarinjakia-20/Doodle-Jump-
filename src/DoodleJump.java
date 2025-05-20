import javax.swing.*;
import java.awt.*;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.awt.image.BufferedImage;
import java.util.Random;

public class DoodleJump extends JPanel implements Runnable, KeyListener {
    final int WIDTH = 400;
    final int HEIGHT = 533;

    boolean gameOver = false;
    boolean isRunning;
    Thread thread;
    BufferedImage view;
    BufferedImage background, platformImg, doodleImg;

    class Platform {
        int x, y;
    }

    Platform[] platforms;

    int doodleX = 100, doodleY = 100;
    int baseHeight = 150;
    float velocityY = 0;
    boolean moveRight, moveLeft;

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

        platformImg = new BufferedImage(68, 14, BufferedImage.TYPE_INT_ARGB);
        Graphics2D gPlat = platformImg.createGraphics();
        gPlat.setPaint(Color.GREEN);
        gPlat.fillRect(0, 0, 68, 14);

        doodleImg = new BufferedImage(60, 60, BufferedImage.TYPE_INT_ARGB);
        Graphics2D gDoodle = doodleImg.createGraphics();
        gDoodle.setPaint(Color.ORANGE);
        gDoodle.fillOval(0, 0, 60, 60);
    }

    private void initializePlatforms() {
        platforms = new Platform[10];
        Random rand = new Random();
        for (int i = 0; i < platforms.length; i++) {
            platforms[i] = new Platform();
            platforms[i].x = rand.nextInt(WIDTH - 68);
            platforms[i].y = rand.nextInt(HEIGHT);
        }
    }

    private void updateGame() {
        if (moveRight) doodleX += 4;
        if (moveLeft) doodleX -= 4;

        if (doodleX > WIDTH) doodleX = 0;
        if (doodleX < 0) doodleX = WIDTH;

        velocityY += 0.2;
        doodleY += velocityY;

        for (Platform p : platforms) {
            if ((doodleX + 50 > p.x) &&
                    (doodleX + 10 < p.x + 68) &&
                    (doodleY + 60 >= p.y) &&
                    (doodleY + 60 <= p.y + 14) &&
                    velocityY > 0) {
                velocityY = -10;
            }
        }

        if (doodleY < baseHeight) {
            doodleY = baseHeight;
            for (Platform p : platforms) {
                p.y -= (int) velocityY;
                if (p.y > HEIGHT) {
                    p.y = 0;
                    p.x = new Random().nextInt(WIDTH - 68);
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
            g2.drawImage(platformImg, p.x, p.y, null);
        }

        Graphics g = getGraphics();
        if (gameOver) {
            g2.setColor(Color.BLACK);
            g2.setFont(new Font("Arial", Font.BOLD, 40));
            g2.drawString("GAME OVER", WIDTH / 2 - 120, HEIGHT / 2);
        }
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
    public void keyTyped(KeyEvent e) {}
}
