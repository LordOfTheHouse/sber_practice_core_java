package practice.basic_sintax;


public class FirstArray {

    private int[] arr;

    /*Конструктор*/
    public FirstArray(int[] a){
        arr = a;
    }
 
    /* Алгоритм для сортировки пузырьком (задание 1)
     * Сравниваем каждый соседний элемент
     */
    public void bubbleSort(){
        for(int i = 0; i < arr.length-1; ++i){
            for(int j = 0; j < arr.length-i-1; j++){
                if (arr[j] > arr[j+1]){
                    int buff = arr[j];
                    arr[j] = arr[j+1];
                    arr[j+1] = buff;
                }
            }
        }
    }

    /* Алгоритм для быстрой сортировки (задание 2)
    * 1) Выбираем опорный элемент.
    * 2) Сравнить все остальные элементы с опорным и переставить их
    * в массиве так, чтобы разбить массив на три непрерывных отрезка.
    * 3) Для отрезков значения в которых меньше и больше опорныъ значений выполнить 
    * рекурсивно ту же последовательность операций.
     */
    public void quickSort(int low, int high) 
    {
        if (arr.length != 0 || low < high) {

            int middle = low + (high - low) / 2;
            int pivot = arr[middle];

            int i = low, j = high;
            while (i <= j) {
                while (arr[i] < pivot) 
                {
                    i++;
                }
                while (arr[j] > pivot) 
                {
                    j--;
                }
                if (i <= j) 
                {
                    int buff = arr[i];
                    arr[i] = arr[j];
                    arr[j] = buff;
                    i++;
                    j--;
                }
            }
            if (low < j) quickSort(low, j);
            if (high > i) quickSort(i, high);
        }
    }   

    /*Возвращает последовательность по типу 
    7 14 21 28 35 42 49 56 63 70 77 84 91 98 (задание 3)*/
    static public int[] sequenceWithDifferenceOfSeven(int n){
        int[] sequence = new int[n]; // n - количестов элементов 
        //последовательности
        for(int i=1; i<=n;i++)
            sequence[i-1] = i * 7;
        return sequence;
    }

    /*Возвращает максимальное число в последовательности (задание 4-5) */
    static public double maxElementArr(double arr2[]){
        double max = arr2[0];
        for(double el: arr2){
            if(el > max) {
                max = el;
            }
        }
        return max;
    }

     /*Возвращает среднее арифметическое значение последовательности (задание 4-5) */
     static public double averagetArr(double arr2[]){
        double sum = 0;
        for(double el: arr2){
            sum += el;
        }
        return sum / arr2.length;
    }

    /*Выводит звездочки (задание 6)*/
    static public void printStars(int numbersOfStars, int rows){
        for(int i=0; i < rows; ++i){
            for(int j = 0; j < numbersOfStars; ++j){
                System.out.print("* ");
            }
            System.out.println();
        }
    }
    
    /*Поиск чисел Фибоначчи (Задание 7) 
     * Каждый следующий член последовательности равен сумме двух предыдущих
    */

    static public int[] fibonacci(int n){
        int[] a = new int[n];
        a[0] = 1;
        a[1] = 1;
        for(int i=2; i < n; ++i){
            a[i] = a[i-1] + a[i-2];
        }
        return a;
    }

    /*Возвращает массив */
    public int[] getArr(){
        return arr;
    }

    /*Выводит массив*/
    public void printArray(){
        for (int el: arr){
            System.out.print(el + " ");
        }
        System.out.println();
    }
}
