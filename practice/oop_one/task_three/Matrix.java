package practice.oop_one.task_three;

public class Matrix {
    
    private int matrix[][];
    private int row;
    private int column;
    
    public Matrix(int row, int column){
        this.row = row;
        this.column = column; 
        matrix = new int[row][column];
    }

    public Matrix(int[][] matrix){
        this.matrix = matrix;
        row = matrix.length;
        column = matrix[0].length;
    }

    /*Суммирует две матрицы
     * Каждый элемент i-строки j-столбца первой матрицы
     * складываем с элементом i-строки j-столбца второй матрицы
    */
    public int[][] sum(Matrix m){
        int[][] sumM = new int[row][column];
        if(row != m.getRow() || column != m.getColumn()){
            System.out.println("Error - the number of rows or columns is not equal");
        }else{
            for(int i = 0; i < row; i++){
                for(int j = 0; j < column; j++){
                    sumM[i][j] = matrix[i][j] + m.getMatrix()[i][j];
                }
            }
        }
        return sumM;
    }

    /*Умножает матрицу на число
     * Каждый элемент i-строки j-столбца матрицы
     * умножается на число
    */
    public void myltiplyMatrixOnValue(int value){
        for(int i = 0; i < row; i++){
            for(int j = 0; j < column; j++){
                matrix[i][j] = matrix[i][j] * value;
            }
        }
    }
    
    /*Перемножает две матрицы
     * Каждый элемент i-строки j-столбца новой матрицы
     * складывается из произведений i-строки и каждого столбца первой матрицы на 
     * каждую строку j-столбца второй матрицы
    */
    public int[][] multiplication(Matrix m){
        int[][] multMatrix = new int[row][m.getColumn()];
        if (column != m.getRow()){
            System.out.println("Error - rows and columns is not equal");
        }else{
            for(int i = 0; i < row; i++){
                for(int j = 0; j < m.getColumn(); j++){
                    for(int k = 0; k < m.getRow(); k++){
                        multMatrix[i][j] += matrix[i][k]*m.getMatrix()[k][j];
                    } 
                }
            }
        }
        return multMatrix;
    }

    /*Выводит матрицу */
    public void printMatrix(){
        for(int i = 0; i < row; i++){
            for(int j = 0; j < column; j++){
                System.out.print(matrix[i][j] + " ");
            }
            System.out.println();
        }
    }

    /*Меняет элементы у матрицы*/
    public void setValue(int row, int column, int value){
        if(row > this.row || column > this.column){
            System.out.println("Error - index of range");
        }else{
            matrix[row][column] = value;
        }
    }

    public int getRow() {
        return row;
    }

    public int getColumn() {
        return column;
    }

    public int[][] getMatrix() {
        return matrix;
    }

}
