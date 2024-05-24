package lessons_swing;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.Toolkit;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import javax.swing.JComponent;
import javax.swing.JFrame;
import javax.swing.JPanel;

public class Lesson9_MouseListener {
  static JFrame jFrame = getFrame();

  public static void main(String[] args) throws Exception{
    //Вариант 3 - отрисовывание положение мышки, реакция на движение мыши
    JComponent jComponent = new MyComponent();
    jFrame.add(jComponent);
    jFrame.addMouseMotionListener(new MouseAdapter() {
      @Override
      public void mouseMoved(MouseEvent e) {
        super.mouseMoved(e);
        MyComponent.xCoord = e.getX();
        MyComponent.yCoord = e.getY();
        jComponent.repaint();
      }
    });


  }

  static class MyComponent extends JComponent
  {
    public static int xCoord;
    public static int yCoord;
    @Override
    protected void paintComponent(Graphics g)
    {
      super.paintComponent(g);
      ((Graphics2D)g).drawString("Coordinates x: " + xCoord + "; y: " + yCoord, 50, 50);
    }
  }

    /*
    Вариант 2
    если нам необходимо слушать только конкретное событие - например клик мышью
    jFrame.add(jPanel);
    jPanel.addMouseListener(new MouseAdapter() {
      @Override
      public void mouseClicked(MouseEvent e) {
        super.mouseClicked(e);
        jPanel.setBackground(Color.BLUE);
      }
      });
     */


    /*
    Вариант 1
    если нам нужно добавить все возможные методы работы с мышью:
    jFrame.add(jPanel);
    jPanel.add(new MouseListener() {
      @Override
      public void mouseClicked(MouseEvent e) {
      }
      @Override
      public void mousePressed(MouseEvent e) {
      }
      //кнопка мыши отпускаеться
      @Override
      public void mouseReleased(MouseEvent e) {
      }
      @Override
      public void mouseEntered(MouseEvent e) {
      }
      @Override
      public void mouseExited(MouseEvent e) {
      }
    }
     */

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
