package lessons_swing.Lesson3;

import java.awt.Dimension;
import java.awt.Toolkit;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JPanel;

public class Main {
  public static void main(String[] args) {

    JFrame jFrame = getFrame();
    JPanel jPanel = new JPanel();
    jFrame.add(jPanel);
    jPanel.add(new JButton("submit"));

  }

  static JFrame getFrame() {
    var jFrame = new JFrame() {};
    jFrame.setVisible(true);
    jFrame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    jFrame.setTitle("My First App");

    Toolkit toolkit = Toolkit.getDefaultToolkit();
    Dimension dimension = toolkit.getScreenSize();

    jFrame.setBounds(dimension.width/4, dimension.height/4, 500, 300);
    return jFrame;
  }
}
