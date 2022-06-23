package practice.file;

import java.io.*;

public class WorkFileTask2 {

    public static void sortedNameFromFile(String pathReader, String pathWriter) {
        try (BufferedReader br = new BufferedReader(new FileReader(pathReader));
                BufferedWriter bw = new BufferedWriter(new FileWriter(pathWriter))) {
            String str;
            while ((str = br.readLine()) != null) {
                str = str.replace(',', '\r');
                String[] strArr = str.split(" ");
                sort(strArr);
                for (String s : strArr) {
                    bw.write(s + "\n");
                }
            }
        } catch (IOException ex) {
            System.out.println(ex.getMessage());
        }
    }

    private static void sort(String[] strArr) {
        for (int i = 0; i < strArr.length; i++) {
            for (int j = i + 1; j < strArr.length; j++) {
                if (strArr[i].compareTo(strArr[j]) > 0) {
                    String buff = strArr[i];
                    strArr[i] = strArr[j];
                    strArr[j] = buff;
                }
            }
        }
    }

}
