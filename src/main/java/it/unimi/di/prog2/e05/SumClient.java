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

public class SumClient {

  /** Default constructor */
  public SumClient() {}

  /**
   * Print the sum of all number passed in program argument
   *
   * @param args number to sum
   */
  public static void main(String[] args) {
    // REQUIRES: args contains some numbers
    // MODIFES: System.out
    // EFFECTS: Write in System.out the sum of all numbers passed as argument
    int[] arr = new int[args.length];
    for (int i = 0; i < args.length; i++) {
      arr[i] = Integer.parseInt(args[i]);
    }
    System.out.println(sum(arr));
  }

  /**
   * calculate the sum of all elements of the given array
   *
   * @param numbers array of numbers
   * @return int sum
   */
  public static int sum(int[] numbers) {
    // EFFECTS: return the sum of all of the numbers in the array
    int total = 0;
    for (int element : numbers) {
      total += element;
    }
    return total;
  }

  // Aggiunga qui un main che invochi il metodo sum (che può sviluppare in
  // questa o altra classe) descritto dall'esercizio

  // Il main riceve un elenco di interi come parametri sulla linea di comando e
  // ne emette la somma nel flusso d'ingresso.

}
