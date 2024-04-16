package lessons_swing.Lesson5;

import java.awt.Dimension;
import java.awt.Toolkit;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.JButton;
import javax.swing.JCheckBox;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.UIManager;
import javax.swing.UIManager.LookAndFeelInfo;
import javax.swing.UnsupportedLookAndFeelException;

public class Lesson5 {

  public static void main(String[] args) {
    var jFrame = getFrame();
    var jPanel = new JPanel();
    jFrame.add(jPanel);
    JButton jB1 = new JButton("Metal");
    JButton jB2 = new JButton("Nimbus");
    JButton jB3 = new JButton("Motif");
    JButton jB4 = new JButton("Windows");
    jPanel.add(jB1);
    jPanel.add(jB2);
    jPanel.add(jB3);
    jPanel.add(jB4);
    jB1.addActionListener(new ActionListener() {
      @Override
      public void actionPerformed(ActionEvent e) {
        try {
          UIManager.setLookAndFeel("javax.swing.plaf.metal.MetalLookAndFeel");
        } catch (Exception ex) {
          throw new RuntimeException(ex);
        }
      }
    });
    jB2.addActionListener(new ActionListener() {
      @Override
      public void actionPerformed(ActionEvent e) {
        try {
          UIManager.setLookAndFeel("javax.swing.plaf.nimbus.NimbusLookAndFeel");
        } catch (Exception ex) {
          throw new RuntimeException(ex);
        }
      }
    });
    jB3.addActionListener(new ActionListener() {
      @Override
      public void actionPerformed(ActionEvent e) {
        try {
          UIManager.setLookAndFeel("com.sun.java.swing.plaf.motif.MotifLookAndFeel");
        } catch (Exception ex) {
          throw new RuntimeException(ex);
        }
      }
    });
    jB4.addActionListener(new ActionListener() {
      @Override
      public void actionPerformed(ActionEvent e) {
        try {
          UIManager.setLookAndFeel("com.sun.java.swing.plaf.windows.WindowsLookAndFeel");
        } catch (Exception ex) {
          throw new RuntimeException(ex);
        }
      }
    });
    JCheckBox checkBox = new JCheckBox("Test");
    jPanel.add(checkBox);

    //просмотр готовых шаблонов
    UIManager.LookAndFeelInfo[] lookAndFeelInfos = UIManager.getInstalledLookAndFeels();
    for (UIManager.LookAndFeelInfo lookAndFeelInfo:lookAndFeelInfos) {
      System.out.println(lookAndFeelInfo.getName());
      System.out.println(lookAndFeelInfo.getClassName());
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
