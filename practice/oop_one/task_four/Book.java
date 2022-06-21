package practice.oop_one.task_four;



public class Book {
    
    private String title;
    private Author author;
    private int year;

    public Book(String title, String nameAuthor, String email, 
                    char gender, int year) {
        this.title = title;
        author = new Author(nameAuthor, email, gender);
        this.year = year;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public void setAuthor(Author author) {
            this.author = author;
        }

    public void setAuthor(String nameAuthor, String email, 
                            char gender) {
        author = new Author(nameAuthor, email, gender);
    }

    public void setYear(int year) {
        this.year = year;
    }

    public String getTitle() {
        return title;
    }

    public Author getAuthor() {
        return author;
    }

    public int getYear() {
        return year;
    }

    @Override
    public String toString() {
        return "Book [author=" + author + ", title=" + title + ", year=" + year + "]";
    }

    
    
}
