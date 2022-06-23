package practice.file;

import java.io.*;

public class WorkFileTask1 {

    public static void deleteWhitespaceFromFile(String pathReader, String pathWriter) {
        try (BufferedReader br = new BufferedReader(new FileReader(pathReader));
                BufferedWriter bw = new BufferedWriter(new FileWriter(pathWriter))) {
            String str;
            while ((str = br.readLine()) != null) {
                bw.write(str.replaceAll("[\\s]{2,}", " ") + "\n");
            }
        } catch (IOException ex) {
            System.out.println(ex.getMessage());
        }
    }

}
