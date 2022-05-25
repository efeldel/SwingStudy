import javax.swing.*;
import java.awt.*;

public class TrafficLight {

    public static void main(String[] args) {
        JFrame jFrame = getFrame();
        jFrame.add(new TrafficWindow());
    }

    static class TrafficWindow extends JComponent {
        @Override
        protected void paintComponent(Graphics g) {
             Graphics2D g2 = (Graphics2D) g;
             g2.fillRoundRect(200,200,100,300,20,20);
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
