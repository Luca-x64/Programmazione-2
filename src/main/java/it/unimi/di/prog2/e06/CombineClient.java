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

package it.unimi.di.prog2.e06;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

/** Esercizio 4.4 di PDJ. */
public class CombineClient {

  /** . */
  private CombineClient() {}

  /**
   * Decodifica una stringa contenente interi separati da spazi.
   *
   * @param string la stringa in ingresso, non può essere {@code null} e deve contenere interi
   *     separati da spazi.
   * @return gli interi contenuti nella stringa.
   */
  private static int[] parseInts(String string) {
    List<Integer> list = new ArrayList<>();
    try (Scanner sl = new Scanner(string)) {
      while (sl.hasNextInt()) 
        list.add(sl.nextInt());
    }

    int[] result = new int[list.size()];
    for (int i = 0; i < list.size(); i++) result[i] = list.get(i);
    return result;
  }


  /**
   * multiply each element of array A, with the sum of all element of B
   * @param args not used
   */
  public static void main(String[] args) {
    // REQUIRES: System.in contains 2 lines of numbers separated by space
    // MODIFES: System.in and System.out
    // EFFECTS: 
    Scanner sc = new Scanner(System.in);
    int[] a = parseInts(sc.nextLine());
    int[] b = parseInts(sc.nextLine());
    sc.close();
    int[] sum = combine(a, b);
    for (int i : sum) {
      System.out.print("Combined= "+String.valueOf(i) +" ");
    }
  }

  /** Combine 2 arrays
   * 
   * @param a array A
   * @param b array B
   * @return Array A multiplied each element with the sum of all B elements
   */
  public static int[] combine(int[] a,int[] b)   {
    // REQUIRES a and b are arrays of integer numbes
    // if a or b is {@code null} throw NullPointerException
    // if a or b is empty, the return will be an array of 0
    if (a == null){
      throw new NullPointerException("a is null");
    }
    if (b == null){
      throw new NullPointerException("b is null");
    }
    if (a.length == 0 || b.length == 0){
      return new int[a.length];
    }
    int bsum = SumClient.sum(b);
    for (int i = 0; i < a.length; i++) {
      a[i] *= bsum;
    }
    return a;
  }


  // Il main di questa classe legge due righe dal flusso di ingresso ciascuna
  // delle quali contiene gli interi (separati da spazi) di uno dei due array da
  // combinare e ne emette il risultato della combinazione (separando gli interi
  // uno per linea). Può avvalersi della funzione precedente per decodificare
  // ciascuna delle due linee in ingresso.

}
