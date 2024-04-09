package lessons_swing;

import java.awt.Dimension;
import java.awt.Toolkit;
import javax.swing.JFrame;

public class Lesson_1 {
  public static void main(String[] args) {

    var jFrame = new JFrame() {};
    jFrame.setVisible(true);
    jFrame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    jFrame.setTitle("My First App");

    Toolkit toolkit = Toolkit.getDefaultToolkit();
    Dimension dimension = toolkit.getScreenSize();

    jFrame.setBounds(dimension.width/4, dimension.height/4, 500, 300);
  }
}
