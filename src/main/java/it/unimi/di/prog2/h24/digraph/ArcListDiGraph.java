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

package it.unimi.di.prog2.h24.digraph;

import java.util.Collections;
import java.util.HashSet;
import java.util.Objects;
import java.util.Set;

/**
 * A <em>mutable</em> directed graph implementation based on a list of {@link Arc}s and one of
 * nodes.
 *
 * @param <T> the type of the graph nodes.
 */
public class ArcListDiGraph<T> implements DiGraph<T> {

  /**
   * The set of graph nodes.
   *
   * <p>Observe that <em>isolated</em> nodes (node not appearing in any arc) belong to this set.
   */
  private final Set<T> nodes;

  /** The set of graph arcs. */
  private final Set<Arc<T>> arcs = new HashSet<>();

  /** Creates an empty graph. */
  public ArcListDiGraph() {
    nodes = new HashSet<>();
  }

  /**
   * Creates a graph with the same nodes and arcs of the given graph.
   *
   * @param graph the graph to copy.
   * @throws NullPointerException if {@code graph} is {@code null}.
   */
  @SuppressWarnings("this-escape")
  public ArcListDiGraph(DiGraph<? extends T> graph) {
    this();
    DiGraph.fill(Objects.requireNonNull(graph), this);
  }

  @Override
  public void addArc(T source, T destination) {
    arcs.add(new Arc<>(source, destination));
    addNode(source);
    addNode(destination);
  }

  @Override
  public void addNode(T node) {
    nodes.add(node);
  }

  @Override
  public Set<T> nodes() {
    return Collections.unmodifiableSet(nodes);
  }

  @Override
  public Set<Arc<T>> arcs() {
    return Collections.unmodifiableSet(arcs);
  }
}
