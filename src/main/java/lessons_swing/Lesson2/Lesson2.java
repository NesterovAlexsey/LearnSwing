package lessons_swing.Lesson2;

import java.awt.Dimension;
import java.awt.Toolkit;
import javax.swing.JFrame;

public class Lesson2 {
  public static void main(String[] args) {

    JFrame jFrame = getFrame();

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
