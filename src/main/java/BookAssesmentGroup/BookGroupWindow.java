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

  private void clearFields() {
    groupNameTextField.setText("");
    descriptionTextField.setText("");
    assessmentTextField.setText("");
  }

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
        // Создаем DTO на основе данных из текстовых полей
        String groupName = groupNameTextField.getText();
        String groupDescription = descriptionTextField.getText();
        int assessment = Integer.parseInt(assessmentTextField.getText());

        BookGroupDTO dto = new BookGroupDTO(groupName, groupDescription, assessment);

        // Вызываем метод save сервисного класса для сохранения DTO
        BookGroupService.save(dto);

        // Очищаем поля после сохранения
        clearFields();
      }
    });

    cancelButton.addActionListener(new ActionListener() {
      @Override
      public void actionPerformed(ActionEvent e) {
        //Метод dispose() вызывается у окна JFrame и используется для закрытия этого окна и
        // освобождения всех связанных с ним ресурсов.
        dispose();
      }
    });

    //добавляет панель panel на фрейм (окно).
    add(panel);

    //устанавливает флаг видимости фрейма на true, что делает его видимым на экране.
    setVisible(true);
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

  public String getGroupName() {
    return groupName;
  }

  public String getGroupDescription() {
    return description;
  }

  public int getAssessment() {
    return assessment;
  }
}

class BookGroupService {
  public static void save(BookGroupDTO dto) {
    System.out.printf("Save data name: %s, description: %s, assessment: %s", dto.getGroupName(), dto.getGroupDescription(), dto.getAssessment());
  }
}

