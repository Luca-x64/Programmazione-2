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

import it.unimi.di.prog2.h24.digraph.DiGraphs;
import it.unimi.di.prog2.h24.digraph.ImplicitDiGraph;
import java.io.IOException;
import java.util.AbstractSet;
import java.util.Collection;
import java.util.Iterator;
import java.util.List;
import java.util.NoSuchElementException;
import java.util.Set;
import java.util.function.Function;

/** Tests <em>directed graph</em> package generating a Dot file. */
public class DiGraphDotClient {

  /** . */
  private DiGraphDotClient() {}

  /**
   * Generates an {@link ImplicitDiGraph}.
   *
   * <p>More precisely, generates a graph with nodes in the range {@code [start, stop[]} and arcs
   * {@code (x, x + 1)} and {@code (x, 2 * x)} and prints its Dot serialization on the standard
   * output.
   *
   * @param args the {@code start} and {@code stop} values.
   * @throws IOException in case of I/O errors.
   */
  public static void main(String[] args) throws IOException {

    final int start = Integer.parseInt(args[0]);
    final int stop = Integer.parseInt(args[1]);

    if (start >= stop) {
      System.err.println("Start must be less than stop");
      System.exit(1);
    }

    Set<Integer> nodes =
        new AbstractSet<Integer>() {

          private int next = start;

          @Override
          public Iterator<Integer> iterator() {
            return new Iterator<Integer>() {
              @Override
              public boolean hasNext() {
                return next < stop;
              }

              @Override
              public Integer next() {
                if (!hasNext()) throw new NoSuchElementException();
                return next++;
              }
            };
          }

          @Override
          public int size() {
            return stop - start;
          }
        };

    Function<Integer, Collection<Integer>> delta =
        new Function<Integer, Collection<Integer>>() {
          @Override
          public Collection<Integer> apply(Integer t) {
            return List.of(t + 1, 2 * t);
          }
        };

    ImplicitDiGraph<Integer> g = new ImplicitDiGraph<Integer>(nodes, delta);
    System.out.println(
        DiGraphs.toDot(
            g, "node [shape=point];\nedge [arrowhead=none];\nratio = expand\nsize = \"10,10!\""));
  }
}
