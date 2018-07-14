package linklist;

import java.util.ArrayList;

public class CycleMatrix {
    public ArrayList<Integer> printMatrix(int[][] matrix) {
        int reachRow = matrix.length;
        int reachCol = matrix[0].length;
        int startRow = 0;
        int startCol = 0;
        int i = 0;
        int j = 0;
        int total = reachCol * reachRow;
        int step = 0;
        ArrayList<Integer> result = new ArrayList<>();
        Direction direct = Direction.RIGHT;
        while (step < total) {
            result.add(matrix[i][j]);
            switch (direct) {
                case RIGHT:
                    if (j < reachCol - 1) {
                        j++;
                    } else {
                        i++;
                        direct = Direction.DOWN;
                        reachCol--;
                    }
                    break;
                case DOWN:
                    if (i < reachRow - 1) {
                        i++;
                    } else {
                        j--;
                        direct = Direction.LEFT;
                        reachRow--;
                    }
                    break;
                case LEFT:
                    if (j > startCol) {
                        j--;
                    } else {
                        i--;
                        direct = Direction.UP;
                        startCol++;
                    }
                    break;
                case UP:
                    if (i > startRow + 1) {
                        i--;
                    } else {
                        j++;
                        direct = Direction.RIGHT;
                        startRow++;
                    }
                    break;
            }
            step++;
        }

        return result;
    }

    private enum Direction {
        UP, DOWN, LEFT, RIGHT
    }

    public static void main(String[] args) {
        CycleMatrix cycleMatrix = new CycleMatrix();
        cycleMatrix.printMatrix(new int[][]{{1, 2, 3, 4,}, {5, 6, 7, 8}, {9, 10, 11, 12}, {13, 14, 15, 16}});
    }
}
