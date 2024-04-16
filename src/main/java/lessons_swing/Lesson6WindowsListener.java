package lessons_swing;

import java.awt.Dimension;
import java.awt.Toolkit;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;
import javax.swing.JFrame;

public class Lesson6WindowsListener {

  public static void main(String[] args) {
    var jFrame = getFrame();
    //настраиваем действия окна
    jFrame.addWindowListener(new WindowAdapter() {
      @Override
      public void windowClosing(WindowEvent e) {
        super.windowClosing(e);
        int i = 0;
        System.out.println(i);
      }
    });

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
