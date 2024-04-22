package lessons_swing.MyFirstApp;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.File;

  public class VFPanel extends JPanel {

    private JCheckBox autoTemplateCheckBox;
    private JCheckBox fileTemplateCheckBox;
    private JCheckBox createTemplateCheckBox;
    private JTextArea textArea;
    private JButton convertButton;
    private JButton resetButton;
    private JLabel resultLabel;
    private JButton copyButton;

    public VFPanel() {
      setLayout(new BorderLayout());

      // Первая часть: выбор шаблона
      JPanel templatePanel = new JPanel();
      templatePanel.setLayout(new BoxLayout(templatePanel, BoxLayout.Y_AXIS));
      autoTemplateCheckBox = new JCheckBox("Автоматический");
      fileTemplateCheckBox = new JCheckBox("Шаблон из файла");
      createTemplateCheckBox = new JCheckBox("Создать шаблон");
      ButtonGroup templateGroup = new ButtonGroup();
      templateGroup.add(autoTemplateCheckBox);
      templateGroup.add(fileTemplateCheckBox);
      templateGroup.add(createTemplateCheckBox);
      templatePanel.add(autoTemplateCheckBox);
      templatePanel.add(fileTemplateCheckBox);
      templatePanel.add(createTemplateCheckBox);

      // Вторая часть: внесение изменяемого текста
      JPanel textPanel = new JPanel();
      textPanel.setLayout(new BorderLayout());
      textArea = new JTextArea();
      JScrollPane scrollPane = new JScrollPane(textArea);
      textPanel.add(scrollPane, BorderLayout.CENTER);

      // Кнопки: преобразовать и сбросить
      JPanel buttonPanel = new JPanel();
      convertButton = new JButton("Преобразовать");
      resetButton = new JButton("Сбросить");
      buttonPanel.add(convertButton);
      buttonPanel.add(resetButton);

      // Третья часть: результат
      JPanel resultPanel = new JPanel();
      resultPanel.setLayout(new BorderLayout());
      resultLabel = new JLabel("Результат:");
      copyButton = new JButton("Копировать");
      resultPanel.add(resultLabel, BorderLayout.NORTH);
      resultPanel.add(copyButton, BorderLayout.SOUTH);

      // Добавление всех компонентов на панель
      add(templatePanel, BorderLayout.NORTH);
      add(textPanel, BorderLayout.CENTER);
      add(buttonPanel, BorderLayout.SOUTH);
      add(resultPanel, BorderLayout.EAST);

      // Логика:
      // next step is logic, should be:

      // Обработчики событий
      convertButton.addActionListener(new ActionListener() {
        @Override
        public void actionPerformed(ActionEvent e) {
          // Логика для преобразования текста
        }
      });

      resetButton.addActionListener(new ActionListener() {
        @Override
        public void actionPerformed(ActionEvent e) {
          // Логика для сброса данных
        }
      });

      fileTemplateCheckBox.addActionListener(new ActionListener() {
        @Override
        public void actionPerformed(ActionEvent e) {
          if (fileTemplateCheckBox.isSelected()) {
            // Логика для активации выбора файла
          }
        }
      });

      createTemplateCheckBox.addActionListener(new ActionListener() {
        @Override
        public void actionPerformed(ActionEvent e) {
          if (createTemplateCheckBox.isSelected()) {
            // Логика для активации создания шаблона
          }
        }
      });
    }

    public static void main(String[] args) {
      JFrame frame = new JFrame("VF");
      frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
      VFPanel panel = new VFPanel();
      frame.getContentPane().add(panel);
      frame.pack();
      frame.setLocationRelativeTo(null); // Панель появляется по центру
      frame.setVisible(true);
    }
  }
