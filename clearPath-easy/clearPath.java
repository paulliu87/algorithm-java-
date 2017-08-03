// package whatever; // don't place package name!

import java.io.*;
import java.util.ArrayList;
import java.util.concurrent.ThreadLocalRandom;

class solution {
    // random  a m * n matrix
    private static int[][] randMatrix(int m, int n) {
        int[][] matrix = new int[m][n];
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                int randomNum = ThreadLocalRandom.current().nextInt(0, 100);
                matrix[i][j] = randomNum;
            }
        }
        return matrix;
    }

    //take a matrix and print it
    private static void printMatrix(int[][] matrix) {
        for (int i = 0; i < matrix.length; i++) {
            for (int j = 0; j < matrix[0].length; j++) {
                System.out.print(matrix[i][j] + ", ");

            }
            System.out.println("");
        }
    }

    //create 3 empty space
    private static void printSpace() {
        System.out.println("");
        System.out.println("");
        System.out.println("");
    }

    private static void zeroTargetRowCol(int[][] matrix, int target) {
        ArrayList<int[]> coordinates = findTarget(matrix, target);
        zeroRowCol(matrix, coordinates);
    }

    private static ArrayList<int[]> findTarget(int[][] matrix, int target) {
        ArrayList<int[]> coordinates = new ArrayList<>();
        for(int i = 0; i < matrix.length; i++) {
            for (int j = 0; j < matrix[0].length; j++) {
                int[] coordinate = new int[2];
                if (matrix[i][j] == target) {
                    System.out.println("i,j = " + i + "," + j + "target = " + target);
                    coordinate[0] = i;
                    coordinate[1] = j;
                    coordinates.add(coordinate);
                }
            }
        }
        return coordinates;
    }

    private static void zeroRowCol(int[][] matrix, ArrayList<int[]> coordinates) {
        for (int n = 0; n < coordinates.size(); n++) {
            int[] coordinate = coordinates.get(n);
            for(int i = 0; i < matrix.length; i++) {
                matrix[i][coordinate[1]] = 0;
            }
            for (int i = 0; i < matrix[0].length; i++) {
                matrix[coordinate[0]][i] = 0;
            }
        }
        return;
    }

    public static void main(String[] args) {
        int[][] matrix = randMatrix(20,20);
        int target = matrix[11][6];

        printMatrix(matrix);
        printSpace();

        System.out.println(target);
        printSpace();

        zeroTargetRowCol(matrix, target);

        printMatrix(matrix);
        printSpace();
    }
}
