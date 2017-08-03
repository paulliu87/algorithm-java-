// package whatever; // don't place package name!

import java.io.*;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.concurrent.ThreadLocalRandom;

//param: give a int[][] matrix and int target, find the target inside the matrix and change all the numbers on the same row and colum to zero
//param: void change inplace
//unsorted time complexity O(m * n) + O(m+n*(m*n)) space complexity O(m * n)
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
        HashSet[] coordinates = findTarget(matrix, target);
        zeroRowCol(matrix, coordinates);
    }

    private static HashSet[] findTarget(int[][] matrix, int target) {
        HashSet<Integer> rows = new HashSet<Integer>();
        HashSet<Integer> cols = new HashSet<Integer>();
        for (int i = 0; i < matrix.length; i++) {
            for (int j = 0; j < matrix[0].length; j++) {
                if (matrix[i][j] == target) {
                    rows.add(i);
                    cols.add(j);
                }
            }
        }
        
        HashSet[] coordinates = {rows, cols};
        return coordinates;
    }

    private static void zeroCol(int[][] matrix, int colIndex) {
        for (int rowIndex = 0; rowIndex < matrix.length; rowIndex++) {
            matrix[rowIndex][colIndex] = 0;
        }
    }

    private static void zeroRow(int[][] matrix, int rowIndex) {
        for (int colIndex = 0; colIndex < matrix[0].length; colIndex++) {
            matrix[rowIndex][colIndex] = 0;
        }
    }

    private static void zeroRowCol(int[][] matrix, HashSet[] coordinates) {
        HashSet<Integer> rows = coordinates[0];
        HashSet<Integer> cols = coordinates[1];
        for (Integer row : rows) {
            zeroRow(matrix, row);
        }
        for (Integer col : cols) {
            zeroCol(matrix, col);
        }
        return;
    }

    public static void main(String[] args) {
        int[][] matrix = randMatrix(20,20);
        int target = matrix[11][13];

        printMatrix(matrix);
        printSpace();

        System.out.println(target);
        printSpace();

        zeroTargetRowCol(matrix, target);

        printMatrix(matrix);
        printSpace();
    }
}
