package matrix;

import java.util.ArrayList;

import static java.util.Arrays.asList;

public class Main {
    public static void main(String[] args) {
        ArrayList<Integer> row1 = new ArrayList<>(asList(1, 0, 5));
        ArrayList<Integer> row2 = new ArrayList<>(asList(2, 1, 6));
        ArrayList<Integer> row3 = new ArrayList<>(asList(3, 4, 0));
        Matrix matrix1 = new Matrix(new ArrayList<>(asList(row1, row2, row3)));
        Matrix matrix2 = new Matrix(new ArrayList<>(asList(row1, row2, row3)));
//        matrix1.multiplyByMatrix(matrix2);
//        matrix1.determinantThreeByThree();
        matrix1.inverse();
    }
}