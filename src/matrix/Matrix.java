package matrix;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

class Matrix {
    private List<ArrayList<Integer>> matrix;

    Matrix(List<ArrayList<Integer>> matrix) {
        this.matrix = matrix;
    }

    private Matrix addSubOeration(Matrix anotherMatrix, Operable operator) {
        List<ArrayList<Integer>> output = new ArrayList<>();
        for (int row = 0; row < this.matrix.size(); row++) {
            output.add(new ArrayList<>());
            for (int column = 0; column < matrix.get(row).size(); column++) {
                Integer integer1 = matrix.get(row).get(column);
                Integer integer2 = anotherMatrix.matrix.get(row).get(column);
                int result = operator.operate(integer1, integer2);
                output.get(row).add(result);
            }
        }
        return new Matrix(output);
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof Matrix)) return false;
        Matrix matrix1 = (Matrix) o;
        return Objects.equals(matrix, matrix1.matrix);
    }

    Matrix add(Matrix anotherMatrix) {
        return addSubOeration(anotherMatrix, new Add());
    }

    Matrix subtract(Matrix anotherMatrix) {
        return addSubOeration(anotherMatrix, new Subtract());
    }

    Matrix multiply(Integer multiplier) {
        List<ArrayList<Integer>> output = new ArrayList<>();
        for (int row = 0; row < this.matrix.size(); row++) {
            output.add(new ArrayList<>());
            for (int column = 0; column < matrix.get(row).size(); column++) {
                Integer integer1 = matrix.get(row).get(column);
                output.get(row).add(integer1 * multiplier);
            }
        }
        return new Matrix(output);
    }

    Matrix transpose() {
        List<ArrayList<Integer>> output = new ArrayList<>();
        for (int row = 0; row < this.matrix.size(); row++) {
            output.add(new ArrayList<>());
            for (int column = 0; column < matrix.get(row).size(); column++) {
                Integer integer1 = matrix.get(column).get(row);
                output.get(row).add(integer1);
            }
        }
        return new Matrix(output);
    }

    private Integer getValueByIndex(Matrix matrix, int row, int column) {
        return matrix.matrix.get(row).get(column);
    }

    private Integer determinant(Matrix matrix1) {
        Integer determinant = getDeterminant(matrix1);
        return determinant;
    }

    private int getDeterminant(Matrix matrix1) {
        return getValueByIndex(matrix1, 0, 0) * getValueByIndex(matrix1, 1, 1) - getValueByIndex(matrix1, 0, 1) * getValueByIndex(matrix1, 1, 0);
    }

    Matrix getCoFactor(int rowToIgnore, int columnToIgnore) {
        List<ArrayList<Integer>> output = new ArrayList<>();

        for (int row = 0; row < this.matrix.size(); row++) {
            ArrayList<Integer> output1 = new ArrayList<>();
            if (row == rowToIgnore) continue;
            for (int column = 0; column < this.matrix.get(row).size(); column++) {
                if (column == columnToIgnore) continue;
                Integer integer1 = matrix.get(row).get(column);
                output1.add(integer1);
            }
            output.add(output1);
        }
        return new Matrix(output);
    }

    Integer determinantThreeByThree(Matrix matrix1) {
        int determinant = 0;
        for (int column = 0; column < matrix1.matrix.size(); column++) {
            int pow = (int) Math.round(Math.pow(-1, column));
            determinant += matrix1.matrix.get(0).get(column) * determinant(getCoFactor(0, column)) * pow;
        }
        return determinant;
    }

    Matrix multiplyByMatrix(Matrix anotherMatrix) {
        List<ArrayList<Integer>> output = new ArrayList<>();
        for (int row = 0; row < this.matrix.size(); row++) {
            output.add(new ArrayList<>());
            multiplyColumn(anotherMatrix, output, row);
        }
        return new Matrix(output);
    }

    private void multiplyColumn(Matrix anotherMatrix, List<ArrayList<Integer>> output, int row) {
        for (int column = 0; column < anotherMatrix.matrix.get(row).size(); column++) {
            int sum = 0;
            for (int k = 0; k < anotherMatrix.matrix.size(); k++) {
                sum += this.matrix.get(row).get(k) * anotherMatrix.matrix.get(k).get(column);
            }
            output.get(row).add(sum);
        }
    }

    Matrix adjoint() {
        List<ArrayList<Integer>> output = new ArrayList<>();

        for (int row = 0; row < this.matrix.size(); row++) {
            output.add(new ArrayList<>());
            for (int column = 0; column < this.matrix.get(row).size(); column++) {
                int pow = (int) Math.round(Math.pow(-1, row + column));
                int value = this.determinant(this.getCoFactor(row, column)) * pow;
                output.get(row).add(value);
            }
        }
        return new Matrix(output);
    }

    Matrix inverse() {
        Matrix adjointMatrix = this.transpose().adjoint();
        int determinant = this.determinantThreeByThree(this);
        Matrix output = adjointMatrix.multiply(1 / determinant);
        return output;
    }

}