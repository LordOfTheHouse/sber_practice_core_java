package practice.file;

import java.io.*;

public class TestWorkFile {

    public static void main(String[] args) {
        // Удаление лишних пробелов из Бородино.txt
        WorkFileTask1.deleteWhitespaceFromFile("practice\\file\\borodino.txt",
                "practice\\file\\borodinoCopy.txt");
        // Сортировка имен по алфавиту
        WorkFileTask2.sortedNameFromFile("practice\\file\\LastName.txt",
                "practice\\file\\SortedName.txt");
        // Запись и чтение объекта
        try (FileOutputStream outputStream = new FileOutputStream("practice\\file\\save.txt");
                ObjectOutputStream objectOutputStream = new ObjectOutputStream(outputStream);
                FileInputStream fileInputStream = new FileInputStream("practice\\file\\save.txt");
                ObjectInputStream objectInputStream = new ObjectInputStream(fileInputStream)) {
            Hero harry = new Hero("Harry");
            System.out.println(harry.getHp());
            harry.receivedDamage(10);
            objectOutputStream.writeObject(harry);
            harry = (Hero) objectInputStream.readObject();
            System.out.println(harry.getHp());
        } catch (IOException ex) {
            ex.printStackTrace();
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }
    }
}
