package lessons_swing.Lesson2;

import java.awt.Dimension;
import java.awt.Font;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.GraphicsEnvironment;
import java.awt.Image;
import java.awt.LinearGradientPaint;
import java.awt.Toolkit;
import java.awt.geom.Line2D;
import javax.swing.ImageIcon;
import javax.swing.JComponent;
import javax.swing.JFrame;

public class Lesson2 {
  public static void main(String[] args) {

    JFrame jFrame = getFrame();
    jFrame.add(new MyComponent());

  }
  static class MyComponent extends JComponent {
    @Override
    protected void paintComponent(Graphics g) {

      Font font = new Font("Verdana", Font.BOLD, 20);

      //------------Check the list of possible fonts
      //String[] fonts = GraphicsEnvironment.getLocalGraphicsEnvironment()
      //        .getAvailableFontFamilyNames();
      //for(String eachFond : fonts)
      //System.out.println(eachFond);

      Graphics2D g2 = (Graphics2D) g;
      g2.setFont(font);
      g2.drawString("My picture", 50, 50);
      Line2D image = new Line2D.Double(70,70,90,90);
      g2.draw(image);
    }
  }

  private static JFrame getFrame() {
    var jFrame = new JFrame();
    jFrame.setVisible(true);
    jFrame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    jFrame.setTitle("My Second App");

    Toolkit toolkit = Toolkit.getDefaultToolkit();
    Dimension dimension = toolkit.getScreenSize();

    jFrame.setBounds(dimension.width/4, dimension.height/4, 500, 300);
    return jFrame;
  }
}
