import javax.imageio.ImageIO;
import javax.swing.*;
import java.awt.*;
import java.awt.geom.Point2D;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;

public class MovingImage {
    public static void main(String[] args) throws Exception {
        int coordX = 0;
        int coordY = 0;
        int t = 0;
        BufferedImage sun = null;
        BufferedImage earth = null;

        JFrame jFrame = new JFrame();
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

        JLabel sunLabel = new JLabel(new ImageIcon(sun.getScaledInstance(200, 200, Image.SCALE_FAST)));
        JLabel earthLabel = new JLabel(new ImageIcon(earth.getScaledInstance(50, 50, Image.SCALE_FAST)));
        jFrame.add(sunLabel);
        sunLabel.setBounds(285, 260,200,200);
        jFrame.add(earthLabel);
        earthLabel.setBounds(0, 260,200,200);

        while (true) {
            if (t == 360) t = 0;
            coordX = (int) (285 + (285 * Math.cos(t * Math.PI / 180)));
            coordY = (int) (260 + (285 * Math.sin(t * Math.PI / 180)));
            earthLabel.setLocation(coordX, coordY);
            jFrame.repaint();
            Thread.sleep(50);
            t++;
        }
    }
}

