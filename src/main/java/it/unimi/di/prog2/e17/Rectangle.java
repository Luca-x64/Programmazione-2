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

package it.unimi.di.prog2.e17;

/** A mutable class representing a rectangle with integer valued base and height. */
public class Rectangle {

  private int base,height;

  /*-
    Decide what fields to use to represent the rectangle and
    provide the AF and IR.

    Check the specification, possibly adding missing exceptions.

    Finish the implementation of the class.
  */


  /*
   * AF(base,heigth) a rectangle with base base and heigth heigth
   * IR: base >0 && height >0
   * 
   * 
   */

  /**
   * Creates a rectangle of given base and height.
   *
   * @param base the base of the rectangle.
   * @param height height of the rectangle.
   */
  public Rectangle(int base, int height) {
    if(base <= 0 || height <=0) throw new IllegalArgumentException();
    this.base=base;
    this.height=height;
  }

  /**
   * Returns the base of the rectangle.
   *
   * @return the base of the rectangle.
   */
  public int base() {
    return base;
  }

  /**
   * Sets the base of the rectangle.
   *
   * @param base the new base of the rectangle.
   */
  public void base(int base) {
    if (base <= 0) throw new IllegalArgumentException();
    this.base=base;
  }

  /**
   * Returns the height of the rectangle.
   *
   * @return the height of the rectangle.
   */
  public int height() {
    return height;
  }

  /**
   * Sets the height of the rectangle.
   *
   * @param height the new height of the rectangle.
   */
  public void height(int height) {
    if (height <= 0) throw new IllegalArgumentException();
    this.height=height;
  }

  @Override
  public String toString() {
    return "Base: " + base+ " Heigth: " + height;
  }
}
