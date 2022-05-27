import javax.imageio.ImageIO;
import javax.swing.*;
import java.awt.*;
import java.awt.geom.Ellipse2D;
import java.awt.geom.Line2D;
import java.awt.geom.Point2D;
import java.awt.geom.Rectangle2D;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;


public class MovingImage {
    private static BufferedImage image;

    public static void main(String[] args) {
        JFrame jFrame = getFrame();

        try {
            image = ImageIO.read(new File("smile.jpg"));
        } catch (IOException ex) {
            System.out.println("File not found.");
        }
        JLabel picLabel = new JLabel(new ImageIcon(image));
        jFrame.add(picLabel);
    }

    static JFrame getFrame() {
        JFrame jFrame = new JFrame() {};
        jFrame.setVisible(true);
        jFrame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        jFrame.setBounds(500,200, 800,800);
        jFrame.setTitle("My window");
        return jFrame;
    }

}
