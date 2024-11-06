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
 * Vedi <a href=
 * "https://github.com/mapio/labprog/blob/master/esercizi/bounding_box/Testo.md">testo</a>,
 */
public class BoundingBox {

  public static void main(String[] args) {
    int Nrows = 0, Nlines = 0, linescount = 0, startOffset = 0, endOffset = 0;
    int tempStartOffset = 0, tempEndOffset = 0;
    boolean external = false;
    String formattedLine, linea = "";

    try (Scanner s = new Scanner(System.in)) {
      while (s.hasNext()) {

        linea = s.nextLine();

        if (Nlines == 0) {
          Nrows = linea.length();
          startOffset = linea.length();
          endOffset = linea.length();
        }

        if (linea.charAt(0) == '*' || linea.charAt(linea.length() - 1) == '*') {
          external = true;

        } else {

          formattedLine = linea.replace(".", " ");
          if (formattedLine.strip().length() > 0) {
            tempStartOffset = 0;
            tempEndOffset = 0;

            tempStartOffset =
                linea.length() - formattedLine.stripLeading().length(); // cound `.` leading .
            tempEndOffset =
                linea.length() - formattedLine.stripTrailing().length(); // count `.` trailing

            startOffset =
                tempStartOffset < startOffset ? tempStartOffset : startOffset; // min start offset
            endOffset = tempEndOffset < endOffset ? tempEndOffset : endOffset; // min end offset

            Nlines += 1;
          }
        }

        linescount += 1;
      }
    }

    if (external) {
      System.out.printf("%d %d\n", linescount, Nrows);
    } else {
      System.out.printf("%d %d\n", Nlines, Nrows - startOffset - endOffset);
    }
  }
}
