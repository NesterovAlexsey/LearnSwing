package lessons_swing;

import java.awt.Dimension;
import java.awt.Toolkit;
import javax.swing.JFrame;
import javax.swing.JPanel;

public class Template {
  static JFrame jFrame = getFrame();
  static JPanel jPanel = new JPanel();

  public static void main(String[] args) throws Exception{
    jFrame.add(jPanel);

  }

  static JFrame getFrame() {
    var jFrame = new JFrame() {};
    jFrame.setVisible(true);
    jFrame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    jFrame.setTitle("My First App");

    //задание нужного размера экрана относительно размера кнопки
    Toolkit toolkit = Toolkit.getDefaultToolkit();
    Dimension dimension = toolkit.getScreenSize();
    jFrame.setBounds(dimension.width/4, dimension.height/4, 500, 300);

    return jFrame;
  }
}
