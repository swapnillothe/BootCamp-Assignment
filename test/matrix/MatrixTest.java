package matrix;

import org.junit.jupiter.api.Test;

import java.util.ArrayList;

import static java.util.Arrays.asList;
import static org.junit.jupiter.api.Assertions.assertEquals;

class MatrixTest {

    @Test
    void shouldAddTwoMatrixOfSameSize() {
        ArrayList<Integer> row1 = new ArrayList<>(asList(2, 1, 6));
        ArrayList<Integer> row2 = new ArrayList<>(asList(1, 0, 5));

        Matrix matrix1 = new Matrix(new ArrayList<>(asList(row1, row2)));
        Matrix matrix2 = new Matrix(new ArrayList<>(asList(row1, row2)));

        ArrayList<Integer> expectedRow1 = new ArrayList<>(asList(4, 2, 12));
        ArrayList<Integer> expectedRow2 = new ArrayList<>(asList(2, 0, 10));

        Matrix expectedMatrix = new Matrix(new ArrayList<>(asList(expectedRow1, expectedRow2)));
        assertEquals(expectedMatrix, matrix1.add(matrix2));
    }

    @Test
    void shouldSubtractTwoMatrixOfSameSize() {
        ArrayList<Integer> matrix1Row1 = new ArrayList<>(asList(10, 11, 12));
        ArrayList<Integer> matrix1Row2 = new ArrayList<>(asList(5, 4, 3));

        ArrayList<Integer> matrix2Row1 = new ArrayList<>(asList(8, 9, 10));
        ArrayList<Integer> matrix2Row2 = new ArrayList<>(asList(2, 1, 0));

        Matrix matrix1 = new Matrix(new ArrayList<>(asList(matrix1Row1, matrix1Row2)));
        Matrix matrix2 = new Matrix(new ArrayList<>(asList(matrix2Row1, matrix2Row2)));

        ArrayList<Integer> expectedRow1 = new ArrayList<>(asList(2, 2, 2));
        ArrayList<Integer> expectedRow2 = new ArrayList<>(asList(3, 3, 3));

        Matrix expectedMatrix = new Matrix(new ArrayList<>(asList(expectedRow1, expectedRow2)));
        assertEquals(expectedMatrix, matrix1.subtract(matrix2));
    }

    @Test
    void shouldMultiplyTheMatrixWithGivenNumber() {
        ArrayList<Integer> m1row1 = new ArrayList<>(asList(1, 2, 3));
        ArrayList<Integer> m1row2 = new ArrayList<>(asList(4, 5, 6));

        Matrix matrix1 = new Matrix(new ArrayList<>(asList(m1row1, m1row2)));

        ArrayList<Integer> expectedRow1 = new ArrayList<>(asList(2, 4, 6));
        ArrayList<Integer> expectedRow2 = new ArrayList<>(asList(8, 10, 12));

        Matrix expectedMatrix = new Matrix(new ArrayList<>(asList(expectedRow1, expectedRow2)));
        assertEquals(expectedMatrix, matrix1.multiply(2));
    }

    @Test
    void shouldTransposeTheGivenMatrix() {
        ArrayList<Integer> row1 = new ArrayList<>(asList(1, 2, 3));
        ArrayList<Integer> row2 = new ArrayList<>(asList(4, 5, 6));
        ArrayList<Integer> row3 = new ArrayList<>(asList(7, 8, 9));


        Matrix matrix1 = new Matrix(new ArrayList<>(asList(row1, row2, row3)));

        ArrayList<Integer> expectedRow1 = new ArrayList<>(asList(1, 4, 7));
        ArrayList<Integer> expectedRow2 = new ArrayList<>(asList(2, 5, 8));
        ArrayList<Integer> expectedRow3 = new ArrayList<>(asList(3, 6, 9));

        Matrix expectedMatrix = new Matrix(new ArrayList<>(asList(expectedRow1, expectedRow2, expectedRow3)));
        assertEquals(expectedMatrix, matrix1.transpose());
    }

    @Test
    void shouldGiveDeterminantOfThreeByThree() {
        ArrayList<Integer> row1 = new ArrayList<>(asList(6, 1, 1));
        ArrayList<Integer> row2 = new ArrayList<>(asList(4, -2, 5));
        ArrayList<Integer> row3 = new ArrayList<>(asList(2, 8, 7));

        Matrix matrix1 = new Matrix(new ArrayList<>(asList(row1, row2, row3)));

        assertEquals(-306, matrix1.determinant(matrix1));

    }

    @Test
    void multiplyByMatrix() {
        ArrayList<Integer> m1row1 = new ArrayList<>(asList(1, 2, 3));
        ArrayList<Integer> m1row2 = new ArrayList<>(asList(4, 5, 6));

        ArrayList<Integer> m2row1 = new ArrayList<>(asList(7, 8));
        ArrayList<Integer> m2row2 = new ArrayList<>(asList(9, 10));
        ArrayList<Integer> m2row3 = new ArrayList<>(asList(11, 12));

        Matrix matrix1 = new Matrix(new ArrayList<>(asList(m1row1, m1row2)));
        Matrix matrix2 = new Matrix(new ArrayList<>(asList(m2row1, m2row2, m2row3)));

        ArrayList<Integer> expectedRow1 = new ArrayList<>(asList(58, 64));
        ArrayList<Integer> expectedRow2 = new ArrayList<>(asList(139, 154));

        Matrix expectedMatrix = new Matrix(new ArrayList<>(asList(expectedRow1, expectedRow2)));
        assertEquals(expectedMatrix, matrix1.multiplyByMatrix(matrix2));

    }

    @Test
    void shouldGiveInverseOfGivenMatrix() {
        ArrayList<Integer> row1 = new ArrayList<>(asList(1, 2, 3));
        ArrayList<Integer> row2 = new ArrayList<>(asList(0, 1, 4));
        ArrayList<Integer> row3 = new ArrayList<>(asList(5, 6, 0));
        Matrix matrix1 = new Matrix(new ArrayList<>(asList(row1, row2, row3)));

        ArrayList<Integer> expectedRow1 = new ArrayList<>(asList(-24, 18, 5));
        ArrayList<Integer> expectedRow2 = new ArrayList<>(asList(20, -15, -4));
        ArrayList<Integer> expectedRow3 = new ArrayList<>(asList(-5, 4, 1));
        Matrix expectedMatrix = new Matrix(new ArrayList<>(asList(expectedRow1, expectedRow2, expectedRow3)));

        assertEquals(expectedMatrix, matrix1.inverse());

    }
}