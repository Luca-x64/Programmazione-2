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

import java.util.Scanner;

/**
 * Vedi <a
 * href="https://github.com/mapio/labprog/blob/master/esercizi/lettera_piu_frequente/Testo.md">testo</a>,
 */
public class LetteraPiùFrequente {

  public static void main(String[] args) {
    String parolaconcat = "";
    try (Scanner s = new Scanner(System.in)) {
      while (s.hasNext()) {
        parolaconcat += s.nextLine();
        ;
      }
    }
    System.out.println(countMaxChar(parolaconcat.toLowerCase().replace(" ", "")));
  }

  private static int countMaxChar(String parola) {
    int max_cnt = 0;
    int i = 0;
    while (parola.length() > 0) {
      String newParola = parola.replace(Character.toString(parola.charAt(i)), "");
      int tempOccorencies = parola.length() - newParola.length();
      max_cnt = tempOccorencies > max_cnt ? tempOccorencies : max_cnt; // find max
      parola = newParola;
    }

    return max_cnt;
  }
}
