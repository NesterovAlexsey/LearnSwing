package lessons_swing.Lesson3;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.Toolkit;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.beans.EventHandler;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JPanel;

public class Main {
  public static void main(String[] args) {

    JFrame jFrame = getFrame();
    JPanel jPanel = new JPanel();
    jFrame.add(jPanel);
    var jButton = new JButton("submit");
    jPanel.add(jButton);
    jButton.addActionListener(new ActionListener() {
      @Override
      public void actionPerformed(ActionEvent e) {
        jPanel.setBackground(Color.GREEN);
        jFrame.setTitle(((JButton)e.getSource()).getText());
      }
    });

    var button = new JButton("Events");
    jPanel.add(button);
    //
    button.addActionListener(EventHandler.create(ActionListener.class, jFrame, "title", "source.text"));
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
