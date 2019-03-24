package matrix;

import java.util.ArrayList;
import java.util.List;

public class Matrix {
    private List<ArrayList<Integer>> matrix;

    Matrix(List<ArrayList<Integer>> matrix) {
        this.matrix = matrix;
    }

    public Matrix add(Matrix anotherMatrix) {
        List<ArrayList<Integer>> output = new ArrayList<>();
        for (int i = 0; i < this.matrix.size(); i++) {
            output.add(new ArrayList<>());
            for (int j = 0; j < matrix.get(i).size(); j++) {
                Integer integer1 = matrix.get(i).get(j);
                Integer integer2 = anotherMatrix.matrix.get(i).get(j);
                output.get(i).add(integer1 + integer2);
            }
        }
        this.print(new Matrix(output));
        return new Matrix(output);
    }

    Matrix subtract(Matrix anotherMatrix) {
        List<ArrayList<Integer>> output = new ArrayList<>();
        for (int i = 0; i < this.matrix.size(); i++) {
            output.add(new ArrayList<>());
            for (int j = 0; j < matrix.get(i).size(); j++) {
                Integer integer1 = matrix.get(i).get(j);
                Integer integer2 = anotherMatrix.matrix.get(i).get(j);
                output.get(i).add(integer1 - integer2);
            }
        }
        this.print(new Matrix(output));
        return new Matrix(output);
    }


    Matrix multiply(Integer multiplier) {
        List<ArrayList<Integer>> output = new ArrayList<>();
        for (int i = 0; i < this.matrix.size(); i++) {
            output.add(new ArrayList<>());
            for (int j = 0; j < matrix.get(i).size(); j++) {
                Integer integer1 = matrix.get(i).get(j);
                output.get(i).add(integer1 * multiplier);
            }
        }
//        this.print(new Matrix(output));
        return new Matrix(output);
    }

    Matrix transpose() {
        List<ArrayList<Integer>> output = new ArrayList<>();
        for (int i = 0; i < this.matrix.size(); i++) {
            output.add(new ArrayList<>());
            for (int j = 0; j < matrix.get(i).size(); j++) {
                Integer integer1 = matrix.get(j).get(i);
                output.get(i).add(integer1);
            }
        }
//        this.print(new Matrix(output));
        return new Matrix(output);
    }

    Integer determinant(Matrix matrix1) {
        List<ArrayList<Integer>> output = new ArrayList<>();
        Integer determinant = matrix1.matrix.get(0).get(0) * matrix1.matrix.get(1).get(1) - matrix1.matrix.get(0).get(1) * matrix1.matrix.get(1).get(0);
//        System.out.println(determinant);
        return determinant;
    }

    Matrix getCoFactor(int row, int column) {
        List<ArrayList<Integer>> output = new ArrayList<>();
        for (int i = 0; i < this.matrix.size(); i++) {
            ArrayList<Integer> output1 = new ArrayList<>();
            if (i == row) {
                continue;
            }
            for (int j = 0; j < this.matrix.get(i).size(); j++) {
                if (j == column) {
                    continue;
                }
                Integer integer1 = matrix.get(i).get(j);
                output1.add(integer1);
            }
            output.add(output1);
        }
//        this.print(new Matrix(output));
        return new Matrix(output);
    }

    Integer determinantThreeByThree(List<ArrayList<Integer>> matrix) {
        int determinant = 0;
        for (int i = 0; i < this.matrix.size(); i++) {
            int pow = (int) Math.round(Math.pow(-1, i));
            determinant += this.matrix.get(0).get(i) * determinant(getCoFactor(0, i)) * pow;
        }
        return determinant;
    }


    Matrix multiplyByMatrix(Matrix anotherMatrix) {
        List<ArrayList<Integer>> output = new ArrayList<>();
        for (int i = 0; i < this.matrix.size(); i++) {
            output.add(new ArrayList<>());
            for (int j = 0; j < anotherMatrix.matrix.get(i).size(); j++) {
                int sum = 0;
                for (int k = 0; k < anotherMatrix.matrix.size(); k++) {
                    sum += this.matrix.get(i).get(k) * anotherMatrix.matrix.get(k).get(j);
                }
                output.get(i).add(sum);
            }
        }
        this.print(new Matrix(output));
        return new Matrix(output);
    }

    private void print(Matrix anotherMatrix) {
        for (int i = 0; i < anotherMatrix.matrix.size(); i++) {
            for (int j = 0; j < anotherMatrix.matrix.get(i).size(); j++) {
                Integer integer2 = anotherMatrix.matrix.get(i).get(j);
                System.out.println(integer2);
            }
        }
    }

    Matrix adjoint() {
        List<ArrayList<Integer>> output = new ArrayList<>();
        for (int i = 0; i < this.matrix.size(); i++) {
            output.add(new ArrayList<>());
            for (int j = 0; j < this.matrix.get(i).size(); j++) {
                int pow = (int) Math.round(Math.pow(-1, i + j));
                int value = this.determinant(this.getCoFactor(i, j)) * pow;
                output.get(i).add(value);
            }
        }
//        this.print(new Matrix(output));
        return new Matrix(output);
    }

    Matrix inverse() {
        Matrix adjointMatrix = this.transpose().adjoint();
        int determinant = this.determinantThreeByThree(this.matrix);
        Matrix output = adjointMatrix.multiply(1 / determinant);
        this.print(output);
        return output;
    }
}