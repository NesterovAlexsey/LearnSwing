package Swing_For_work_test;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.ButtonGroup;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JRadioButton;
import javax.swing.JScrollPane;
import javax.swing.JTextArea;

public class BookGUI extends JFrame {
  private BookService bookService;

  //Это приватное поле bookComboBox типа JComboBox<String>, которое представляет выпадающий список книг.
  private JComboBox<String> bookComboBox;

  //Это приватное поле commentTextArea типа JTextArea, предназначенное для ввода комментариев к выбранной книге.
  private JTextArea commentTextArea;

  //Это приватные поля highPriorityRadioButton и lowPriorityRadioButton типа JRadioButton,
  // которые представляют радиокнопки для выбора приоритета книги.
  private JRadioButton highPriorityRadioButton;
  private JRadioButton lowPriorityRadioButton;

  //Это приватное поле submitButton типа JButton, представляющее кнопку "Submit"
  // для отправки информации о выбранной книге.
  private JButton submitButton;

  //Это конструктор класса BookGUI, который принимает объект bookService типа BookService,
  // чтобы иметь доступ к операциям CRUD с книгами.
  public BookGUI(BookService bookService) {
    this.bookService = bookService;

    //Это методы, используемые для настройки основных атрибутов окна приложения,
    // таких как заголовок, размер и операция закрытия.
    setTitle("Book Selector");
    setSize(400, 300);
    setDefaultCloseOperation(EXIT_ON_CLOSE);

    //Это создание выпадающего списка книг и заполнение его элементами.
    bookComboBox = new JComboBox<>(new String[]{"Book 1", "Book 2", "Book 3"});

    //Это создание текстовой области для ввода комментариев, с указанием количества строк и столбцов.
    commentTextArea = new JTextArea(5, 20);

    //Это создание радиокнопок для выбора приоритета книги.
    highPriorityRadioButton = new JRadioButton("High Priority");
    lowPriorityRadioButton = new JRadioButton("Low Priority");

    //Это создание кнопки "Submit" для отправки информации о выбранной книге.
    submitButton = new JButton("Submit");

    //Это создание группы кнопок-переключателей,
    // чтобы они работали вместе и пользователь мог выбрать только одну радиокнопку.
    ButtonGroup priorityGroup = new ButtonGroup();
    priorityGroup.add(highPriorityRadioButton);
    priorityGroup.add(lowPriorityRadioButton);

    //Это установка обработчика событий на кнопку "Submit",
    // который вызывает метод actionPerformed, когда пользователь щелкает на кнопке.
    submitButton.addActionListener(new ActionListener() {
      @Override
      public void actionPerformed(ActionEvent e) {
        //Это получение выбранной книги из выпадающего списка,
        // введенного комментария и выбранного приоритета.
        String selectedBook = (String) bookComboBox.getSelectedItem();
        String comment = commentTextArea.getText();
        String priority = highPriorityRadioButton.isSelected() ? "High" : "Low";

        // Создаем объект BookDTO
        BookDTO bookDTO = new BookDTO(selectedBook, comment, priority);

        // Вызываем метод сервисного слоя для сохранения книги в базу данных
        bookService.saveBook(bookDTO);

        // Очищаем поля после сохранения
        commentTextArea.setText("");
        priorityGroup.clearSelection();
      }
    });

    //Это настройка и добавление всех компонентов интерфейса на панель,
    // которая затем добавляется к главному окну.
    JPanel panel = new JPanel();
    panel.add(new JLabel("Select Book:"));
    panel.add(bookComboBox);
    panel.add(new JLabel("Comment:"));
    panel.add(new JScrollPane(commentTextArea));
    panel.add(highPriorityRadioButton);
    panel.add(lowPriorityRadioButton);
    panel.add(submitButton);

    add(panel);
    setVisible(true);
  }

  public static void main(String[] args) {
    // Создаем сервисный слой и передаем его в конструктор GUI
    BookService bookService = new BookService();
    new BookGUI(bookService);
  }
}