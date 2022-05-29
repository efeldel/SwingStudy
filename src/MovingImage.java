import javax.imageio.ImageIO;
import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;



public class MovingImage {
    private static BufferedImage image;
    static int coordX = 0;
    static int coordY = 0;
    public static void main(String[] args) {
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
        ActionListener moveAL = new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                if (coordY == 0 && coordX < 685 ) {
                    coordX += 5;
                } else if (coordX == 685 && coordY < 660) {
                    coordY += 5;
                } else if (coordY == 660 && coordX > 0) {
                    coordX -= 5;
                } else if (coordX == 0 && coordY > 0) {
                    coordY -= 5;
                }
                picLabel.setLocation(coordX,coordY);
                jFrame.repaint();
            }
        };

        Timer myTimer = new Timer(10, moveAL);
        myTimer.start();
    }
}

