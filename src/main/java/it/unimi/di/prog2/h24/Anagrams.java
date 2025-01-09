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

package it.unimi.di.prog2.h24;

import java.io.IOException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Comparator;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Objects;
import java.util.Set;

/**
 * A simple program that reads a list of words from standard input and prints all anagrams of size
 * at least 2.
 */
public class Anagrams {

  /** . */
  private Anagrams() {}

  /**
   * Returns the signature of a word, that is, the word obtained by sorting its letters.
   *
   * @param word the word.
   * @return the signature of the word.
   */
  public static String signature(final String word) {
    char[] chars = Objects.requireNonNull(word).toCharArray();
    Arrays.sort(chars);
    return new String(chars);
  }

  /**
   * Reads a list of words from standard input and prints all anagrams of size at least 2.
   *
   * @param args not used.
   * @throws IOException in case some read error occurs.
   */
  public static void main(String[] args) throws IOException {
    List<String> words =
        new ArrayList<>(Arrays.asList(new String(System.in.readAllBytes()).split("\n")));

    // Builds the map signature(w) -> { s : s is anagram of w }

    final Map<String, Set<String>> signature2anagrams = new HashMap<>();
    for (final String word : words) {
      final String signature = signature(word);
      Set<String> anagrams = signature2anagrams.get(signature);
      if (anagrams == null) {
        anagrams = new HashSet<>();
        signature2anagrams.put(signature, anagrams);
      }
      anagrams.add(word);
    }

    // Extract the list of all anagrams and (reverse) sorts it based on list size

    List<Set<String>> lisfOfAnagrams = new ArrayList<>(signature2anagrams.values());
    lisfOfAnagrams.sort(
        new Comparator<Set<String>>() {
          public int compare(Set<String> o1, Set<String> o2) {
            return Integer.compare(o1.size(), o2.size());
          }
        }.reversed());

    // Prints the list of anagrams (of size at least 1)

    for (final Set<String> anagrams : lisfOfAnagrams) {
      if (anagrams.size() == 1) break;
      System.out.println(anagrams);
    }
  }
}
