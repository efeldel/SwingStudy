import javax.imageio.ImageIO;
import javax.swing.*;
import java.awt.*;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;



public class MovingImage {
    public static void main(String[] args) throws Exception{
        int coordX = 0;
        int coordY = 0;
        int dx = 0;
        int dy = 0;
        BufferedImage image = null;

        JFrame jFrame = new JFrame();
        jFrame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        jFrame.setBounds(500, 200, 800, 800);
        jFrame.setVisible(true);

        try {
            image = ImageIO.read(new File("smile.jpg"));
        } catch (IOException ex) {
            System.out.println("File not found.");
        }
        JLabel picLabel = new JLabel(new ImageIcon(image.getScaledInstance(100,100, Image.SCALE_FAST)));
        jFrame.add(picLabel).setBounds(0,0,100,100);
        while (true) {
        if (coordY == 0 && coordX < 685 ) {
            dx = 1;
            dy = 0;
        } else if (coordX == 685 && coordY < 660) {
            dx = 0;
            dy = 1;
        } else if (coordY == 660 && coordX > 0) {
            dx = -1;
            dy = 0;
        } else if (coordX == 0 && coordY > 0) {
            dx = 0;
            dy = -1;
        }
            coordX += dx;
            coordY += dy;
            picLabel.setLocation(coordX,coordY);
            jFrame.repaint();
            Thread.sleep(5);
        }
    }
}

