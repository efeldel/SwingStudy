import javax.imageio.ImageIO;
import javax.swing.*;
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
        JLabel picLabel = new JLabel(new ImageIcon(image));
        picLabel.setBounds(0,0,210,178);
        jFrame.add(picLabel);
        ActionListener moveAL = new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                if (coordY <= 800) {
                    coordX += 10;
                    coordY += 10;

                } else {
                    coordX = 0;
                    coordY = 0;
                }
                picLabel.setLocation(coordX,coordY);
                jFrame.repaint();
            }
        };

        Timer myTimer = new Timer(50, moveAL);
        myTimer.start();
    }
}

