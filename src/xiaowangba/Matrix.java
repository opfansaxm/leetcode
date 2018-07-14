package xiaowangba;

/**
 * Created by panhe on 2018/5/24.
 */

import java.util.ArrayList;

public class Matrix {
    enum Status {
        UP, DOWN, LEFT, RIGHT
    }

    public static ArrayList<Integer> printMatrix(int[][] matrix) {
        ArrayList<Integer> array = new ArrayList<>();
        int row = matrix.length;
        int column = matrix[0].length;
        int total = row * column;
        Status status = Status.RIGHT;
        int i = 0;
        int j = 0;
        int step = 0;
        int startRow = 0;
        int startCol = 0;
        while (step < total) {
            System.out.println(matrix[i][j]);
            array.add(matrix[i][j]);
            switch (status) {
                case RIGHT:
                    if (j < column - 1) {
                        j++;
                    } else {
                        i++;
                        status = Status.DOWN;
                        column--;
                    }
                    break;
                case DOWN:
                    if (i < row - 1) {
                        i++;
                    } else {
                        j--;
                        status = Status.LEFT;
                        row--;
                    }
                    break;
                case LEFT:
                    if (j > startCol) {
                        j--;
                    } else {
                        i--;
                        status = Status.UP;
                        startCol++;
                    }
                    break;
                case UP:
                    if (i > startRow + 1) {
                        i--;
                    } else {
                        j++;
                        status = Status.RIGHT;
                        startRow++;
                    }
                    break;
            }
            step++;
        }
        return array;
    }

    public static void main(String[] args) {
        int[][] matrix = {{1,2,3,4},{5,6,7,8},{9,10,11,12},{13,14,15,16}};
        ArrayList<Integer> arrayList = printMatrix(matrix);
        for (Integer value : arrayList) {
            System.out.println(value);
        }
        System.out.println();
    }
}
