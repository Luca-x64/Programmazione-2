package it.unimi.di.prog2.e05;

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

import java.util.Scanner;

/**
 * Esercizio 3.1 di PDJ.
 *
 * @author Ghirimoldi Luca
 */
public class GcdClient {

  /**
   * Take 2 number in input, and print gcd
   *
   * @param args args not used
   */
  public static void main(String[] args) {
    // REQUIRES: System.in contains some line, each containing 2 numbers separated by a space
    // MODIFIES: System.in and System.out
    // EFFECTS:  Read some line of text from System.in, each line contains 2 numbers
    // write in System.out the gcd for each line
    Scanner sc = new Scanner(System.in);
    while (sc.hasNext()) {
      int n1 = sc.nextInt();
      int n2 = sc.nextInt();
      System.out.println(gcd(n1, n2));
    }
    sc.close();
  }

  /**
   * calculate gcd of 2 numbers
   *
   * <p>calculate gcd of the 2 numbers
   *
   * @param n1 first number
   * @param n2 second number
   * @return gcd of the 2 numbers
   */
  public static int gcd(int n1, int n2) {
    // MODIFIES: n1 , n2
    // EFFECTS: return gcd of 2 numbers
    while (n2 != 0) {
      int temp = n2;
      n2 = n1 % n2;
      n1 = temp;
    }
    return n1;
  }

  /** . */
  private GcdClient() {}
}
