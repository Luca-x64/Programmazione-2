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

package it.unimi.di.prog2.e10;

import java.util.Objects;

import it.unimi.di.prog2.e05.GcdClient;

/**
 * A rational number is an immutable number that can be expressed as the
 * quotient or fraction \( p/q
 * \) of two {@code int}s, a numerator \( p \) and a non-zero denominator \( q
 * \).
 */
public class RationalNumber {

  // EXERCISE: complete following the specification (with particular attention
  // to the eventual exceptions) and provide an implementation (including the
  // equals, hashCode, and toString methods); add methods that are adequate to
  // the specification.

  /**
   * n numerator
   * d denominator
   */
  private final int n, d;

  /**
   * Creates a new rational number.
   *
   * @param numerator   the numerator.
   * @param denominator the denominator.
   * @throws IllegalAIllegalArgumentException if denominator is 0
   */
  public RationalNumber(int numerator, int denominator) {
    if (denominator == 0)
      throw new IllegalArgumentException("denominator cant be null");
    else if (denominator < 0) {
      numerator = -numerator;
      denominator = -denominator;
    }

    int gcd = GcdClient.gcd(numerator > 0 ? numerator : -numerator, denominator > 0 ? denominator : -denominator);
    n = numerator / gcd;
    d = denominator / gcd;
  }

  /**
   * Returns the sum of this rational number and another one.
   *
   * @param other the other rational number.
   * @return the sum of this rational number and {@code other}.
   */
  public RationalNumber add(RationalNumber other) {
    return new RationalNumber(d * other.n + n * other.d, other.d * d);
  }

  /**
   * Returns the product of this rational number and another one.
   *
   * @param other the other rational number.
   * @return the product of this rational number and {@code other}.
   */
  public RationalNumber mul(RationalNumber other) {
    return new RationalNumber(n * other.n, d * other.d);
  }

  @Override
  public String toString() {
    return d + "/" + n;
  }

  @Override
  public boolean equals(Object obj) {
    if (obj == null || !(obj instanceof RationalNumber frac)) return false;
    return n == frac.n && d == frac.d;
  }


  @Override
  public int hashCode() {
    return  Objects.hash(n,d);
  }
}
