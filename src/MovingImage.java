import javax.imageio.ImageIO;
import javax.swing.*;
import java.awt.*;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;



public class MovingImage {
    private static BufferedImage image;
    static int coordX = 0;
    static int coordY = 0;
    public static void main(String[] args) throws Exception{
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
                    coordX += 1;
                } else if (coordX == 685 && coordY < 660) {
                    coordY += 1;
                } else if (coordY == 660 && coordX > 0) {
                    coordX -= 1;
                } else if (coordX == 0 && coordY > 0) {
                    coordY -= 1;
                }
                picLabel.setLocation(coordX,coordY);
                jFrame.repaint();
                Thread.sleep(5);
        }
    }
}

