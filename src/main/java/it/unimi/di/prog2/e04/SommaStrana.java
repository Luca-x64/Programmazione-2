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

import java.util.Scanner;

/**
 * Vedi <a href=
 * "https://github.com/mapio/labprog/blob/master/esercizi/somma_strana/Testo.md">testo</a>, ma
 * leggendo gli addendi dal flusso di ingresso.
 */
public class SommaStrana {
  /** sum */
  private String sum = "";

  /**
   * main
   *
   * @param args args
   */
  public static void main(String[] args) {
    Scanner sc = new Scanner(System.in);
    System.out.println(new SommaStrana(sc.nextLine(), sc.nextLine()));
    sc.close();
  }

  /**
   * sommastrana
   *
   * @param n1 number start
   * @param n2 number end
   */
  private SommaStrana(String n1, String n2) {
    int i1 = n1.length() - 1;
    int i2 = n2.length() - 1;
    int riporto = 0;
    while (i1 > -1 || i2 > -1 || riporto != 0) {

      int p1 = i1 > -1 ? Integer.parseInt(Character.toString(n1.charAt(i1))) : 0;
      int p2 = i2 > -1 ? Integer.parseInt(Character.toString(n2.charAt(i2))) : 0;

      int tempSum = p1 + p2 + riporto;
      if (tempSum > 9) {
        tempSum = 19 - (tempSum);
        riporto = 1;
      } else {
        riporto = 0;
      }

      this.sum = Integer.toString(tempSum) + sum;
      i1--;
      i2--;
    }
  }

  @Override
  public String toString() {
    return this.sum;
  }
}
