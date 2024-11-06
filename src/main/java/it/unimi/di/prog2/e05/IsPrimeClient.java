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

public class IsPrimeClient {

  /**
   * Given a number, print {@code true} if its a prime number
   *
   * @param args number
   */
  public static void main(String[] args) {
    // REQUIRES: a number in args
    // MODIFIES: System.out
    // EFFECTS: Write in System.out true if the number given in args its a prime number,

    System.out.println(isPrime(Integer.valueOf(args[0])) ? "true" : "");
  }

  /** Constructor IsPrimeClient */
  public IsPrimeClient() {}

  /**
   * return true if the number in input is a prime number
   *
   * @param n number
   * @return true only if n is a prime number
   */
  public static boolean isPrime(int n) {
    // EFFECTS: return true if n is a prime number
    if (n % 2 == 0 && n > 2) {
      return false;
    }
    for (int i = n / 2; i > 2 && n % 2 != 0; i -= 2) {
      if (n % i == 0) return false;
    }
    return true;
  }
}
  // Aggiunga qui un main che invochi il metodo isPrime (che può sviluppare in
  // questa o altra classe) descritto dall'esercizio 3.3 di PDJ.

  // Il main riceve un intero come parametro sulla linea di comando ed emette
  // "true" nel flusso d'uscita se e solo se esso è primo.
