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

package it.unimi.di.prog2.e09;

import java.util.ArrayList;
import java.util.Collections;
import java.util.LinkedList;
import java.util.List;
import java.util.Objects;

import it.unimi.di.prog2.h08.impl.NegativeExponentException;

/**
 * {@code SparsePoly}s are immutable polynomials with integer coefficients such that the number of
 * nonzero coefficient is small with respect to the degree.
 *
 * <p>A typical {@code Poly} is \( p = c_0 + c_1 x + c_2 x^2 + \cdots + c_n x^n \).
 */
public class SparsePoly {

  /**
   * A record holding a term of the polynomial.
   *
   * @param coeff the coefficient.
   * @param degree the degree.
   */
  public record Term(int coeff, int degree) {
    /**
     * Builds a term.
     *
     * @throws NegativeExponentException if if {@code degree} &lt; 0.
     */
    public Term { // using the compact constructor
      if (degree < 0)
        throw new NegativeExponentException("A term cannot have a negative exponent.");
    }
  }

  /** The array of terms (in increasing non-zero degree). */
  private final List<Term> terms;

  /** Initializes this to be the zero polynomial, that is \( p = 0 \). */
  public SparsePoly() {
    terms = Collections.emptyList();
  }

  /**
   * Initializes this to be the polynomial \(p = cx^n\).
   *
   * @param c the coefficient.
   * @param n the degree.
   * @throws NegativeExponentException if {@code n} &lt; 0.
   */
  public SparsePoly(int c, int n) throws NegativeExponentException {
    if (n<0) throw new NegativeExponentException("Degree must be greater or equal 0");
    terms = c==0?Collections.emptyList():List.of(new Term(c,n));
  }

  private SparsePoly(final List<Term> list){
    terms=Collections.unmodifiableList(list);
  }

  /**
   * Returns the coefficient of the term of given exponent.
   *
   * @param d the exponent of the term to consider.
   * @return the coefficient of the considered term.
   */
  public int coeff(int d) {
    if (d < 0 || d > degree()) return 0;
    for (Term term : terms ){
      if (term.coeff == d) {
        return term.coeff;
      }
    }
    return 0;  
  }

  /**
   * Returns the degree of this polynomial.
   *
   * @return the largest exponent with a non-zero coefficient; returns 0 if this is the zero {@code
   *     Poly}.
   */
  public int degree() {
    return terms.isEmpty()?0: terms.get(terms.size()-1).degree; // replace this with the actual implementation //
  }

  /**
   * Performs polynomial addition.
   *
   * <p>If \( p \) is this polynomial, returns \( p + q \).
   *
   * @param q the polynomial to add to this one.
   * @return the sum among this and the given polynomial.
   * @throws NullPointerException if {@code q} is {@code null}.
   */
  public SparsePoly add(SparsePoly q) throws NullPointerException {
    Objects.requireNonNull(q,"Polynomial is null");

    final List<Term> list = new LinkedList<>(terms);

    for (Term elem:q.terms){
      int tempCoeff = coeff(elem.degree);
      if ( tempCoeff != 0 ){ //aggiorna elemento lista con somma dei coeff dei due polinomi
        final int indexElemento = list.indexOf(new Term(tempCoeff,elem.degree)); //brutta questa new term TODO
        final Term elementoList = list.get(indexElemento);
        final Term newTerm = new Term(elementoList.coeff+tempCoeff,elem.degree);
        list.set(indexElemento,newTerm);
      }else{
        if (elem.degree > degree()) list.add(elem);
        else{
          int i;
          for (i =0;list.get(i).degree<elem.degree;i++)  list.set(i,elem);
        }
      }
    }


    return new SparsePoly(list);
  }

  /**
   * Performs polynomial multiplication.
   *
   * <p>If \( p \) is this polynomial, returns \( p q \).
   *
   * @param q the polynomial to multiply by this one.
   * @return the product among this and the given polynomial.
   * @throws NullPointerException if {@code q} is {@code null}.
   */
  public SparsePoly mul(SparsePoly q) throws NullPointerException {
    Objects.requireNonNull(q,"Polynomial cant be null");
    List<Term> list = new ArrayList<>();
    for(Term termP:terms){
      for (Term termQ:q.terms){
      list.add(new Term(termP.coeff*termQ.coeff,termP.degree*termQ.degree));
      }
    }
    return new SparsePoly(list);
  }

  /**
   * Performs polynomial subtraction.
   *
   * <p>If \( p \) is this polynomial, returns \( p - q \).
   *
   * @param q the polynomial to subtract from this one.
   * @return the subtraction among this and the given polynomial.
   * @throws NullPointerException if {@code q} is {@code null}.
   */
  public SparsePoly sub(SparsePoly q) throws NullPointerException {
    Objects.requireNonNull(q);
    return q.add(minus());
  }

  /**
   * Returns the negate polynomial.
   *
   * <p>If \( p \) is this polynomial, returns \( -p \).
   *
   * @return this polynomial multiplied by \( -1 \).
   */
  public SparsePoly minus() {
    List<Term> list = new ArrayList<>();
    for (Term elem:terms) list.add(new Term(- elem.coeff,elem.degree));
    return new SparsePoly(list);
  }
}
