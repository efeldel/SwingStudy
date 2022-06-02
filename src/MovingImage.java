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
    int place = 0;
    int size = 0;
    BufferedImage image = null;
    JFrame jframe = null;
    static boolean isWinner = false;

    MovingImage(BufferedImage image, JFrame jframe, int size, int place) {
        this.jframe = jframe;
        this.size = size;
        this.image = image;
        this.place = place;
    }
    @Override
    public void run() {
        try {
            Thread.sleep(3000);
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }
        JLabel label = new JLabel(new ImageIcon(image.getScaledInstance(size, size, Image.SCALE_FAST)));
        while (!isWinner) {
            coordX += 1 + (int) (Math.random()*5);
            coordY = (place - 1) * (size + 50);
            jframe.add(label);
            label.setBounds(coordX,coordY,size,size);
            label.setLocation(coordX, coordY);
                try {
                    Thread.sleep(1);
                } catch (InterruptedException e) {
                    throw new RuntimeException(e);
                }
            jframe.repaint();
                if (coordX + size >= jframe.getWidth() - 15) isWinner = true;
        }
    }

    public static void main(String[] args) throws InterruptedException {

        BufferedImage car = null;

        JFrame jFrame = new JFrame("Racing cars");
        jFrame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        jFrame.setBounds(500, 200, 1000, 800);
        jFrame.getContentPane().setBackground(Color.white);
        jFrame.setVisible(true);


        try {
            car = ImageIO.read(new File("smile.jpg"));
        } catch (IOException ex) {
            System.out.println("File not found.");
        }
        new MovingImage(car, jFrame, 100, 1).start();
        new MovingImage(car, jFrame, 100, 2).start();
        new MovingImage(car, jFrame, 100, 3).start();
        new MovingImage(car, jFrame, 100, 4).start();
        new MovingImage(car, jFrame, 100, 5).start();


    }
}

