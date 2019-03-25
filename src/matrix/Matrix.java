package matrix;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

class Matrix {
  private ArrayList<ArrayList<Integer>> matrix;

  Matrix(ArrayList<ArrayList<Integer>> matrix) {
    this.matrix = matrix;
  }

  private Matrix addSubOperation(Matrix anotherMatrix, Operable operator) {
    ArrayList<ArrayList<Integer>> output = new ArrayList<>();
    int numberOfRows = this.matrix.size();
    for (int row = 0; row < numberOfRows; row++) {
      int numberOfColumns = matrix.get(row).size();
      output.add(new ArrayList<>());
      for (int column = 0; column < numberOfColumns; column++) {
        Integer mainMatrixNumber = matrix.get(row).get(column);
        Integer givenMatrixNumber = anotherMatrix.matrix.get(row).get(column);
        int result = operator.operate(mainMatrixNumber, givenMatrixNumber);
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
    return addSubOperation(anotherMatrix, new Add());
  }

  Matrix subtract(Matrix anotherMatrix) {
    return addSubOperation(anotherMatrix, new Subtract());
  }

  Matrix multiply(Integer multiplier) {
    ArrayList<ArrayList<Integer>> output = new ArrayList<>();
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
    ArrayList<ArrayList<Integer>> output = new ArrayList<>();
    for (int row = 0; row < this.matrix.size(); row++) {
      output.add(new ArrayList<>());
      for (int column = 0; column < matrix.get(row).size(); column++) {
        Integer integer1 = matrix.get(column).get(row);
        output.get(row).add(integer1);
      }
    }
    return new Matrix(output);
  }

  Matrix multiplyByMatrix(Matrix anotherMatrix) {
    ArrayList<ArrayList<Integer>> output = new ArrayList<>();
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

  private Matrix adjoint() {
    ArrayList<ArrayList<Integer>> output = new ArrayList<>();

    for (int row = 0; row < this.matrix.size(); row++) {
      output.add(new ArrayList<>());
      for (int column = 0; column < this.matrix.get(row).size(); column++) {
        int pow = (int) Math.round(Math.pow(-1, row + column));
        int value = this.determinantOfTwoByTwo(this.coFactor(row, column)) * pow;
        output.get(row).add(value);
      }
    }
    return new Matrix(output);
  }

  Matrix inverse() {
    Matrix adjoinedMatrix = this.transpose().adjoint();
    int determinant = this.determinant(this);
    return adjoinedMatrix.multiply(1 / determinant);
  }

  private Integer determinantOfTwoByTwo(Matrix matrix) {
    Integer firstNumber = matrix.matrix.get(0).get(0);
    Integer thirdNumber = matrix.matrix.get(1).get(1);
    Integer secondNumber = matrix.matrix.get(0).get(1);
    Integer fourthNumber = matrix.matrix.get(1).get(0);
    return firstNumber * thirdNumber - secondNumber * fourthNumber;
  }

  private Matrix coFactor(int rowToIgnore, int columnToIgnore) {
    ArrayList<ArrayList<Integer>> output = new ArrayList<>();

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


  Integer determinant(Matrix matrix) {
    int determinant = 0;
    if (matrix.matrix.size() == 2) {
      return determinantOfTwoByTwo(matrix);
    }

    for (int column = 0; column < matrix.matrix.size(); column++) {
      int sign = (int) Math.round(Math.pow(-1, column));
      Integer number = matrix.matrix.get(0).get(column);
      Integer coFactorDeterminant = determinant(coFactor(0, column));
      determinant += number * coFactorDeterminant * sign;
    }
    return determinant;
  }
}
