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

/** Esercizio 4.3 di PDJ. */
public class SumClient {

  /** . */
  private SumClient() {}

  /**
   * Sum maximum 100 numbers
   * @param args not used
   */
  public static void main(String[] args) {
    // REQUIRES: System.in contain some integer numbers
    // MODIFIES: System.in and System.out
    // EFFECTS: Read max of 100 integer numbers on System.in and write in System.out their sum
    Scanner sc = new Scanner(System.in);
    ArrayList<Integer> nums = new ArrayList<Integer>();

    for (int i =0;i<100 && sc.hasNext();i++){
      nums.add(sc.nextInt());
    }
    sc.close();
    int[] arr = new int[nums.size()];
    for (int i = 0; i < arr.length; i++) {
        arr[i] = nums.get(i);
    }
    System.out.printf("Sum: %d",sum(arr));
    System.out.printf("Sum: %d",sumE(arr));
      
    }
    // is more convenient the first implementation, as if the array is empty
    // the for loop wont iterate, and the function just return sum variable which value `0`
  
  /**
   * Sum all the elements of the array
   * @param nums numbers to sum
   * @return sum
   */
  public static int sum(int[] nums){
    // EFFECTS: return 0 if nums is empty
    int sum = 0;
    for (int n : nums) {
      sum+=n;
    }
    return sum;
  }

   /**
   * Sum all the elements of the array
   * @param nums numbers to sum
   * @return sum
   */
  public static int sumE(int[] nums){
    // EFFECTS: return 0 if nums is empty, by throwing and catching an Exception, else return the sum of all elements
    try {
      int sum = 0;
      if (nums.length == 0){
        throw new Exception("Empty array");
      }
      for (int n : nums) {
      sum+=n; }
      return sum;

    } catch (Exception e) {
      return 0;
    }
  }


}

  // Il main di questa classe legge dal flusso di ingresso una sequenza di al
  // più 100 interi e ne emette la somma nel flusso d'uscita.

  /*
   * A specification for a procedure that computes the
    sum of the elements in an array of integers might
    require a nonempty array, return 0 if the array is
    empty, or throw an exception if the array is empty.
    Discuss which alternative is best and provide the
    specification for the procedure.
   */

