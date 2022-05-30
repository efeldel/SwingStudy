import javax.imageio.ImageIO;
import javax.swing.*;
import java.awt.*;
import java.awt.geom.Point2D;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;

public class MovingImage extends Thread {
    int coordX = 0;
    int coordY = 0;
    int t = 0;
    int speed = 0;
    int distance = 0;
    int size = 0;
    BufferedImage image = null;
    JFrame jframe = null;

    MovingImage(BufferedImage image, JFrame jframe, int speed, int distance, int size) {
        this.speed = speed;
        this.jframe = jframe;
        this.distance = distance;
        this.size = size;
        this.image = image;
    }
    @Override
    public void run() {
        JLabel label = new JLabel(new ImageIcon(image.getScaledInstance(size, size, Image.SCALE_FAST)));
        while (true) {
            if (t == 360) t = 0;
            coordX = (int) (380 + (distance * Math.cos(t * Math.PI / 180)));
            coordY = (int) (360 + (distance * Math.sin(t * Math.PI / 180)));
            t++;
            jframe.add(label);
            label.setBounds(coordX,coordY,size,size);
            label.setLocation(coordX, coordY);
            if (speed != 0) {
                try {
                    Thread.sleep(1 * speed);
                } catch (InterruptedException e) {
                    throw new RuntimeException(e);
                }
            }
        }
    }

    public static void main(String[] args) {

        BufferedImage sun = null;
        BufferedImage merc = null;
        BufferedImage venus = null;
        BufferedImage earth = null;
        BufferedImage mars = null;
        BufferedImage jupiter = null;
        BufferedImage saturn = null;
        BufferedImage uranus = null;
        BufferedImage neptune = null;

        JFrame jFrame = new JFrame("Solar system");
        jFrame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        jFrame.setBounds(500, 200, 800, 800);
        jFrame.getContentPane().setBackground(Color.black);
        jFrame.setVisible(true);


        try {
            sun = ImageIO.read(new File("sun.png"));
            merc = ImageIO.read(new File("mercury.png"));
            venus = ImageIO.read(new File("venus.png"));
            earth = ImageIO.read(new File("earth.png"));
            mars = ImageIO.read(new File("mars.png"));
            jupiter = ImageIO.read(new File("jupiter.png"));
            saturn = ImageIO.read(new File("saturn.png"));
            uranus = ImageIO.read(new File("uranus.png"));
            neptune = ImageIO.read(new File("neptune.png"));
        } catch (IOException ex) {
            System.out.println("File not found.");
        }
        JLabel sunLabel = new JLabel(new ImageIcon(sun.getScaledInstance(100, 100, Image.SCALE_FAST)));
        jFrame.add(sunLabel);
        sunLabel.setBounds(285, 260,200,200);
        new MovingImage(merc, jFrame, 1, 40,10).start();
        new MovingImage(venus, jFrame, 3, 80,15).start();
        new MovingImage(earth, jFrame, 4, 130,20).start();
        new MovingImage(mars, jFrame, 7, 160,10).start();
        new MovingImage(jupiter, jFrame, 44, 210,50).start();
        new MovingImage(saturn, jFrame, 120, 250,30).start();
        new MovingImage(uranus, jFrame, 376, 300,40).start();
        new MovingImage(neptune, jFrame, 656, 350,40).start();

    }
}

