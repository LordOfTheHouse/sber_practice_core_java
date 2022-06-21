package practice.oop_one.task_three;

public class TestMatrix {
    public static void main(String[] args) {
        int[][] arrs = {{3, -1, 2}, {4, 2, 0}, {-5, 6, 1}};
        int[][] arrs2 = {{8}, {7}, {2}};
        int[][] arrs3 = {{-3, 1, -2}, {-4, -2, 0}, {5, -6, -1}}; 

        Matrix m = new Matrix(arrs);
        Matrix m2 = new Matrix(arrs2);

        Matrix m3 = new Matrix(m.multiplication(m2));
        m3.printMatrix();

        m2 = new Matrix(arrs3);
        m3 = new Matrix(m.sum(m2));
        m3.printMatrix();

        m2.myltiplyMatrixOnValue(5);
        m2.printMatrix();

        m3.setValue(1, 1, 10);
        m3.printMatrix();
    }
}
