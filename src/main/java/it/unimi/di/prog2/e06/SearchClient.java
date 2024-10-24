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
import java.util.Scanner;

/** Esercizio 4.2 di PDJ. */
public class SearchClient {

  /**  */
  private SearchClient() {
  }

  public static void main(String[] args) {
    // REQUIRES: System.in contains a line of numbers separated by space
    // MODIFES: System.in and System.out
    // EFFECTS: Read the first line of system.in, and the next int  (element)
    // and write in System.Out the index of the given int in the sequence of number

    Scanner sc = new Scanner(System.in);
    String[] line = sc.nextLine().split(" ");
    int[] nums = new int[line.length];
    for (int i = 0; i < line.length; i++) {
      nums[i] = Integer.parseInt(line[i]);
    }
    int num = sc.nextInt();
    sc.close();
    System.out.printf("Index: %d\n", searchLoop(nums, num));
    System.out.printf("Index: %d\n", searchWhile(nums, num));

    /* the first implementation is better (with for loops) because
    even if it do some controls over i < nums.lenght, its hovewer more efficent 
    rather than raising an exception

    */
  }

  /**
   * Search index of a number in an array
   * @param nums array of ordered numbers
   * @param n number to search
   * @return index nums[index] = n, -1 if not found
   */
  public static int searchLoop(int[] nums, int n) {
    // REQUIRES: nums sorted 
    // EFFECTS: return the indexposizion of n in nums, -1 if not found
    for (int i = 0; i < nums.length; i++) {
      if (nums[i] == n) {
        return i;
      }
    }
    return -1;
  }

  /**
   * Search index of a number in an array
   * @param nums array of ordered numbers
   * @param n number to search
   * @return index nums[index] = n, -1 if not found
   */
  public static int searchWhile(int[] nums, int n) {
    // REQUIRES: nums sorted 
    // EFFECTS: return the index posizion of n in nums, -1 if not found
    // Raise IndexOutOfBoundsException if n is not in nums
    int i = 0;
    try {
      while (true) {
        if (nums[i] == n) {
          return i;
        }
        i++;
      }
    } catch (IndexOutOfBoundsException e) {
      return -1;
    }
    
  }

}

// Il main di questa classe legge dal flusso di ingresso una sequenza di
// interi (separati da spazi) e, assumendo che sia ordinata in ordine
// crescente, emette nel flusso d'uscita la posizione dell'intero specificato
// sulla linea di comando (se presente nell'input), o -1 viceversa.

/**
 * 4.2 Implement search as specified in Figure 4.1 in two
 * ways: using for loops, and using while (true)
 * loops that are terminated when accessing the array
 * raises IndexOutOfBoundsException. Which
 * implementation is better? Discuss.
 */