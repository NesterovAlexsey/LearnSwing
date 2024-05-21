package lessons_swing;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.Toolkit;
import java.awt.event.ActionEvent;
import javax.swing.AbstractAction;
import javax.swing.ActionMap;
import javax.swing.InputMap;
import javax.swing.JButton;
import javax.swing.JComponent;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.KeyStroke;

public class Lesson8_KeyStroke {

  //статический метод, сразу создает нужный фрейм через объявление переменной!
  static JFrame jFrame = getFrame();
  static JPanel jPanel = new JPanel();

  public static void main(String[] args) {
    jFrame.add(jPanel);
    AbstractAction myAction = new MyAction();
    //кнока создаеться сразу с наследованием экшена!
    JButton jButton = new JButton(myAction);
    jButton.setText("Test");
    jPanel.add(jButton);

    //для работы горячих клавиш окно должно быть в фокусе
    jPanel.setFocusable(true);
    jPanel.requestFocusInWindow();

    //создание горячих клавиш
    KeyStroke keyStroke = KeyStroke.getKeyStroke("ctrl B");
    //где горячие клавиши сработают: окно, кнопка, пр.
    InputMap inputMap = jPanel.getInputMap(JComponent.WHEN_ANCESTOR_OF_FOCUSED_COMPONENT);
    //задаем название действие, с которым связана горячая клавиша
    inputMap.put(keyStroke, "changeColor");
    //?
    ActionMap actionMap = jPanel.getActionMap();
    //связываем инпут мап с готовой клавишей с конкретным экшоном
    actionMap.put("changeColor", myAction);
  }

  static class MyAction extends AbstractAction {
    @Override
    public void actionPerformed(ActionEvent e)
    {
      jPanel.setBackground(Color.BLUE);
    }
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
