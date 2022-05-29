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
    JLabel label = null;

    MovingImage(BufferedImage image, JLabel label, int speed, int distance) {
        this.speed = speed;
        this.label = label;
        this.distance = distance;

    }
    @Override
    public void run() {
        while (true) {
            if (t == 360) t = 0;
            coordX = (int) (285 + (distance * Math.cos(t * Math.PI / 180)));
            coordY = (int) (260 + (distance * Math.sin(t * Math.PI / 180)));
            t++;
            label.setLocation(coordX, coordY);
            if (speed != 0) {
                try {
                    Thread.sleep(500 / speed);
                } catch (InterruptedException e) {
                    throw new RuntimeException(e);
                }
            }
        }
    }

    public static void main(String[] args) {

        BufferedImage sun = null;
        BufferedImage earth = null;

        JFrame jFrame = new JFrame("Solar system");
        jFrame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        jFrame.setBounds(500, 200, 800, 800);
        jFrame.getContentPane().setBackground(Color.black);
        jFrame.setVisible(true);


        try {
            sun = ImageIO.read(new File("sun.png"));
            earth = ImageIO.read(new File("earth.png"));
        } catch (IOException ex) {
            System.out.println("File not found.");
        }
        JLabel earthLabel = new JLabel(new ImageIcon(earth.getScaledInstance(10, 10, Image.SCALE_FAST)));
        JLabel sunLabel = new JLabel(new ImageIcon(sun.getScaledInstance(50, 50, Image.SCALE_FAST)));
        jFrame.add(sunLabel);
        sunLabel.setBounds(285, 260,200,200);
        jFrame.add(earthLabel);
        earthLabel.setBounds(0, 260,200,200);
        new MovingImage(earth, earthLabel, 100, 285).start();


    }
}

