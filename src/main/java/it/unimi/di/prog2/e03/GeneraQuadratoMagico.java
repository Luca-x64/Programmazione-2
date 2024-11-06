package it.unimi.di.prog2.e03;

/*

Copyright 2024 Massimo Santini

This file is part of "Programmazione 2 @ UniMI" teaching material.

This is free software: you can redistribute it and/or modify
it under the terms of the GNU General Public License as published by
the Free Software Foundation, either version 3 of the License, or
(at your option) any later version.

This material is distributed in the hope that it will be useful,
but WITHOUT ANY WARRANTY; without even the implied warranty of
MERCHANTABILITY or FITNESS FOR A PARTICULAR PURPOSE.  See the
GNU General Public License for more details.

You should have received a copy of the GNU General Public License
along with this file.  If not, see <https://www.gnu.org/licenses/>.

*/

public class GeneraQuadratoMagico {

  public static void main(String[] args) {
    final int N = Integer.parseInt(args[0]);
    int startIndex = N / 2;
    int matrix[][] = new int[N][N];
    int outMatrix[][] = insert(startIndex, matrix, N);
    printMatrix(outMatrix);
  }

  private static void printMatrix(int[][] outMatrix) {
    for (int[] line : outMatrix) {
      for (int element : line) {
        System.out.printf("%d ", element);
      }
      System.out.println();
    }
  }

  private static int[][] insert(int startIndex, int[][] matrix, int N) {
    matrix[0][startIndex] = 1;
    int line = 0, col = startIndex;
    for (int i = 1; i < N * N; i++) {

      int upRightLine = (line - 1) % N;
      if (upRightLine == -1) {
        upRightLine = N - 1;
      }

      int downLeftCol = (col + 1) % N;

      int upRight = matrix[upRightLine][downLeftCol];

      if (upRight == 0) {
        line = upRightLine;
        col = downLeftCol;
        matrix[line][col] = i + 1; // up-right position = i + 1
      } else {
        line = (line + 1) % N;
        matrix[line][col] = i + 1; // down-left position = i +1
      }
    }
    return matrix;
  }
}
