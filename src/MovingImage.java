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
//        int dx = 1;
//        int dy = 1;
        BufferedImage sun = null;
        BufferedImage earth = null;

        JFrame jFrame = new JFrame();
        jFrame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        jFrame.setBounds(500, 200, 800, 800);
        //jFrame.getContentPane().setLayout(null);
        jFrame.getContentPane().setBackground(Color.black);
        jFrame.setVisible(true);


        try {
            sun = ImageIO.read(new File("sun.png"));
            earth = ImageIO.read(new File("earth.png"));
        } catch (IOException ex) {
            System.out.println("File not found.");
        }

        JLabel sunLabel = new JLabel(new ImageIcon(sun.getScaledInstance(200, 200, Image.SCALE_FAST)));
        jFrame.add(sunLabel);
        sunLabel.setBounds(300,300,200,200);

//        while (true) {
//            if (coordY == 0) {
//                dy = 1;
//            } else if (coordX == 685) {
//                dx = -1;
//            } else if (coordY == 660) {
//                dy = -1;
//            } else if (coordX == 0) {
//                dx = 1;
//            }
//            coordX += dx;
//            coordY += dy;
//            picLabel.setLocation(coordX, coordY);
//            jFrame.repaint();
//            Thread.sleep(5);
//        }
    }
}

