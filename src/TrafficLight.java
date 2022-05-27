import javax.swing.*;
import java.awt.*;
import java.awt.geom.Ellipse2D;
import java.awt.geom.Path2D;
import java.awt.geom.Point2D;
import java.awt.geom.RoundRectangle2D;

public class TrafficLight {

    public static void main(String[] args) {
        JFrame jFrame = getFrame();
        jFrame.add(new TrafficWindow());
    }

    static class TrafficWindow extends JComponent {
        @Override
        protected void paintComponent(Graphics g) {
            Graphics2D g2 = (Graphics2D) g;
            Ellipse2D el1 = new Ellipse2D.Double(210,210,80,80);
            Ellipse2D el2 = new Ellipse2D.Double(210,310,80,80);
            Ellipse2D el3 = new Ellipse2D.Double(210,410,80,80);
            g2.fillRoundRect(200,200,100,300,20,20);
            g2.fillRoundRect(230,505,40,50,10,10);
            g2.setPaint(Color.red);
            g2.fill(el1);
            g2.setPaint(Color.yellow);
            g2.fill(el2);
            g2.setPaint(Color.green);
            g2.fill(el3);
        }

    }

    static JFrame getFrame() {
        JFrame jFrame = new JFrame() {};
        jFrame.setVisible(true);
        jFrame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        jFrame.setBounds(500,200, 500,800);
        jFrame.setTitle("Светофор");
        return jFrame;
    }
}
