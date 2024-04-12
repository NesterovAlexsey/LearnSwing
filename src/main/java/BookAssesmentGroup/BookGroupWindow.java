package BookAssesmentGroup;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.time.LocalDateTime;

public class BookGroupWindow extends JFrame {

  private JTextField groupNameTextField;
  private JTextField descriptionTextField;
  private JTextField assessmentTextField;

  public BookGroupWindow() {
    setTitle("Book Group");
    setSize(400, 200);
    setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

    JPanel panel = new JPanel();
    panel.setLayout(new GridLayout(4, 2));

    JLabel groupNameLabel = new JLabel("Book Group Name:");
    groupNameTextField = new JTextField();
    JLabel descriptionLabel = new JLabel("Book Group Description:");
    descriptionTextField = new JTextField();
    JLabel assessmentLabel = new JLabel("Assessment:");
    assessmentTextField = new JTextField();
    JButton saveButton = new JButton("Save");
    JButton cancelButton = new JButton("Cancel");

    panel.add(groupNameLabel);
    panel.add(groupNameTextField);
    panel.add(descriptionLabel);
    panel.add(descriptionTextField);
    panel.add(assessmentLabel);
    panel.add(assessmentTextField);
    panel.add(saveButton);
    panel.add(cancelButton);

    saveButton.addActionListener(new ActionListener() {
      @Override
      public void actionPerformed(ActionEvent e) {
        saveData();
      }
    });

    cancelButton.addActionListener(new ActionListener() {
      @Override
      public void actionPerformed(ActionEvent e) {
        dispose();
      }
    });

    add(panel);
    setVisible(true);
  }

  private void saveData() {
    String groupName = groupNameTextField.getText();
    String description = descriptionTextField.getText();
    int assessment = Integer.parseInt(assessmentTextField.getText());

    // Создание объекта DTO и передача его в слой сервиса для сохранения в базу данных
    BookGroupDTO dto = new BookGroupDTO(groupName, description, assessment);
    BookGroupService.save(dto);

    dispose(); // Закрытие окна после сохранения данных
  }

  public static void main(String[] args) {
    new BookGroupWindow();
  }
}

class BookGroupDTO {
  private int id;
  private String groupName;
  private String description;
  private int assessment;
  private LocalDateTime creationDate;

  public BookGroupDTO(String bookGroupName, String bookGroupDescription, int assessment) {
    this.groupName = bookGroupName;
    this.description = bookGroupDescription;
    this.assessment = assessment;
    this.creationDate = LocalDateTime.now();
  }
}

class BookGroupService {
  public static void save(BookGroupDTO dto) {
    // Реализация сохранения DTO в базу данных
  }
}

