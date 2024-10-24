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

import java.util.ArrayList;
import java.util.Scanner;

/**
 * Vedi <a
 * href="https://github.com/mapio/labprog/blob/master/esercizi/saltapicchio/Testo.md">testo</a>, ma
 * senza il vincolo sul valore massimo per `N`.
 */
public class Saltapicchio {

  /** Saltapicchio boolean */
  private boolean saltapicchio = true;

  /**
   * main
   *
   * @param args args
   */
  public static void main(String[] args) {
    Scanner sc = new Scanner(System.in);
    String[] split = sc.nextLine().split(" ");
    sc.close();
    int n = Integer.parseInt(args[0]);
    System.out.println(new Saltapicchio(n, split));
  }

  /**
   * saltapicchio
   *
   * @param n number
   * @param split split number sequence
   */
  private Saltapicchio(int n, String[] split) {
    ArrayList<Integer> lista = new ArrayList<Integer>();
    for (int i = 0; i < split.length - 1; i++) {
      int diff = Math.abs(Integer.parseInt(split[i]) - Integer.parseInt(split[i + 1]));
      if (!lista.contains(diff)) {
        lista.add(diff);
      }
      if (diff > n - 1 || diff == 0) {
        this.saltapicchio = false;
        break;
      }
    }
    if (this.saltapicchio && lista.size() != n - 1) {
      this.saltapicchio = false;
    }
  }

  @Override
  public String toString() {
    if (this.saltapicchio) {
      return "saltapicchio";
    } else {
      return "";
    }
  }
}
