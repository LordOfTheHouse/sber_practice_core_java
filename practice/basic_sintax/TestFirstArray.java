package practice.basic_sintax;

import java.io.IOException;
import java.util.Scanner;

public class TestFirstArray {
    public static void main(String[] args) throws IOException{
        // задание 1
        FirstArray arr = new FirstArray(new int[]{6, 8, 2, 3, 13, 9, 10});
        arr.bubbleSort();
        arr.printArray();

        // задание 2
        FirstArray arr2 = new FirstArray(new int[]{6, 8, 2, 3, 13, 9, 10});
        arr2.quickSort(0, 6);
        arr2.printArray();

        // задание 3
        FirstArray sequence = new FirstArray(FirstArray.sequenceWithDifferenceOfSeven(14));
        sequence.printArray();

        // задание 4
        double[] a = new double[10];
        for (int i=0; i<a.length; ++i){
            a[i] = Math.random();
            System.out.println(a[i]);
        }
        System.out.println(FirstArray.maxElementArr(a) + " " + FirstArray.averagetArr(a));

        // задание 5
        for (int i=0; i<a.length; ++i){
            a[i] = (double) (Math.random()*98) + 2;
            System.out.println(a[i]);
        }
        System.out.println(FirstArray.maxElementArr(a) + " " + FirstArray.averagetArr(a));
        
        // задание 6
        FirstArray.printStars(5, 3);

        // задание 7
        FirstArray fib = new FirstArray(FirstArray.fibonacci(11));
        fib.printArray();

        // задание 8
        System.out.println("Что это такое: синий, большой, с усами и полностью набит зайцами?");
        Scanner sc = new Scanner(System.in);
        String rightAnswer = "Троллейбус";
        String change = "Сдаюсь";
        while(true){
            String answerHuman = sc.next();
            if(answerHuman.equals(rightAnswer)){
                System.out.println("Правильно!");
                sc.close();
                break;
            }else if(answerHuman.equals(change)){
                System.out.println("Правильный ответ: троллейбус");
                sc.close();
                break;
            }else{
                System.out.println("Попробуй ещё");
            }
        }
        
    }
}
