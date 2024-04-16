package lessons_swing;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.Toolkit;
import java.awt.event.ActionEvent;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;
import javax.swing.AbstractAction;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JPanel;

public class Lesson7_Action {
  static JFrame jFrame = getFrame();
  static JPanel jPanel = new JPanel();

  public static void main(String[] args) {
    JButton jButton = new JButton(new MyAction());
    jButton.setText("Test");
    jPanel.add(jButton);
    jFrame.add(jPanel);

  }

  static class MyAction extends AbstractAction {
    MyAction() {
      putValue(AbstractAction.SHORT_DESCRIPTION, "My small action");
    }

    @Override
    public void actionPerformed(ActionEvent e) {
      jPanel.setBackground(Color.BLUE);
    }
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
