package Swing_For_work_test;

public class BookDTO {
    private String bookTitle;
    private String comment;
    private String priority;

    public BookDTO(String bookTitle, String comment, String priority) {
      this.bookTitle = bookTitle;
      this.comment = comment;
      this.priority = priority;
    }

  public String getBookTitle() {
    return bookTitle;
  }
}

