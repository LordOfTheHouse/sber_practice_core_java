package practice.oop_one.task_four;

public class TestBook {
    public static void main(String[] args) {
        Book book1 = new Book("Intercace", "Alan Cooper",
                                 "t1@email.ru", 'w', 2000);
        System.out.println(book1);
        book1.getAuthor().setGender('m');
        book1.setYear(1996);
        book1.setTitle("Interface");
        System.out.println(book1);
    } 
}
