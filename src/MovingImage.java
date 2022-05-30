import javax.imageio.ImageIO;
import javax.swing.*;
import java.awt.*;
import java.awt.geom.Point2D;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;

public class MovingImage extends Thread {
    int coordX = 0;
    int place = 0;
    int size = 0;
    BufferedImage image = null;
    JFrame jframe = null;

    MovingImage(BufferedImage image, JFrame jframe, int size, int place) {
        this.jframe = jframe;
        this.size = size;
        this.image = image;
        this.coordY = place;
    }
    @Override
    public void run() {
        JLabel label = new JLabel(new ImageIcon(image.getScaledInstance(size, size, Image.SCALE_FAST)));
        while (true) {
            coordX += 1 + (int)  Math.random()*5;
            coordY = (int) place * 100;
            jframe.add(label);
            label.setBounds(coordX,coordY,size,size);
            label.setLocation(coordX, coordY);
                try {
                    Thread.sleep(50);
                } catch (InterruptedException e) {
                    throw new RuntimeException(e);
                }
        }
    }

    public static void main(String[] args) {

        BufferedImage car = null;

        JFrame jFrame = new JFrame("Racing cars");
        jFrame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        jFrame.setBounds(500, 200, 800, 1000);
        jFrame.getContentPane().setBackground(Color.white);
        jFrame.setVisible(true);


        try {
            car = ImageIO.read(new File("smile.png"));
        } catch (IOException ex) {
            System.out.println("File not found.");
        }

        new MovingImage(car, jFrame, 100, 0).start();
        new MovingImage(car, jFrame, 100, 150).start();
        new MovingImage(car, jFrame, 100, 300).start();
        new MovingImage(car, jFrame, 100, 450).start();
        new MovingImage(car, jFrame, 100, 600).start();


    }
}

