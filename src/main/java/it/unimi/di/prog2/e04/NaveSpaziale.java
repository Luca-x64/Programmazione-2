package it.unimi.di.prog2.e04;

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

public class NaveSpaziale {

  /** sequence */
  private String sequence = "";

  /**
   * Main
   *
   * @param args args
   */
  public static void main(String[] args) {
    int n1 = Integer.valueOf(args[0]);
    int n2 = Integer.valueOf(args[1]);
    System.out.println(new NaveSpaziale(n1, n2));
  }

  /**
   * navespaziale
   *
   * @param n1 number 1
   * @param n2 number 2
   */
  private NaveSpaziale(int n1, int n2) {
    // if (n2 %2 != 0 || n2 < 4*n1)
    boolean dispari = n2 % 2 == 1;
    if (dispari) {
      n2--;
    }
    while (n1 != n2) {
      if (4 * (n1 + 1) <= n2 && 16 * n1 > n2) {
        n1++;
        sequence += "P";
      } else if (4 * n1 <= n2) { // n2 > 4*n1  //|  4*n1 > n2
        sequence += "S";
        n1 *= 4;
      } else {
        n1++;
        sequence += "P";
      }
    }
    if (dispari) {

      sequence = sequence + "P";
    }
  }

  @Override
  public String toString() {
    return this.sequence;
  }
}
