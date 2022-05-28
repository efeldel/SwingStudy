import javax.imageio.ImageIO;
import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.geom.Ellipse2D;
import java.awt.geom.Line2D;
import java.awt.geom.Point2D;
import java.awt.geom.Rectangle2D;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;


public class MovingImage {
    private static BufferedImage image;
    static int coordX = 0;
    public static void main(String[] args) {
        JFrame jFrame = new JFrame();
        jFrame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        jFrame.setBounds(500, 200, 800, 800);
        jFrame.setVisible(true);
        JComponent myComp = new JComponent() {
            @Override
            protected void paintComponent(Graphics g) {
                super.paintComponent(g);
                Graphics2D g2 = (Graphics2D) g;
                Ellipse2D el = new Ellipse2D.Double(coordX,0,100,100);
                g2.setPaint(Color.red);
                g2.draw(el);
            }
        };
        jFrame.add(myComp);

        ActionListener moveAL = new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                    coordX += 10;
                    jFrame.update(myComp.getGraphics());
            }
        };

        Timer myTimer = new Timer(300, moveAL);
        myTimer.start();

/*
        try {
            image = ImageIO.read(new File("smile.jpg"));
        } catch (IOException ex) {
            System.out.println("File not found.");
        }
        JLabel picLabel = new JLabel(new ImageIcon(image));*/
    }
}

