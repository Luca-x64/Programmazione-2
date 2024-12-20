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

package it.unimi.di.prog2.e19;
import java.util.Iterator;
import java.util.List;
import java.util.StringJoiner;

import static it.unimi.di.prog2.e19.IteratorUtils.EmptyIterator;
import static it.unimi.di.prog2.e19.IteratorUtils.concatenate;
import it.unimi.di.prog2.h08.impl.EmptyException;

/**
 * Ordered list of integers without duplicates. See PDF 6.6 public class OrderedIntList {
 *
 * <p>// Specify and implement (writing the AF and RI) the // ordered list of integers without
 * duplicates described // in paragraph 6 of chapter 6 of the PDJ textbook.
 *
 * <p>}
 
  * Mutable
  list of ordered int
  */
public class OrderedIntList{
    private boolean empty;
    private OrderedIntList left,right;
    private int val;
    

    public OrderedIntList(){
        empty = true;
        left=right=null;
    }

    void addEl(int el) throws IllegalArgumentException {
        if(el==val) throw new IllegalArgumentException("Duplicate");
        if (isEmpty()) {
            val = el;
            empty=false;
            right = new OrderedIntList();
            left = new OrderedIntList();
        }else if (el<val) left.addEl(el);
        else right.addEl(el);
        
    }

    // boolean remEl(int el) throws NullPointerException {
    //     if (isEmpty()) throw new NullPointerException(); 
    //     if(el == val){
    //         if(right.isEmpty() && left.isEmpty()) empty=false;
    //         try {
    //             int least = right.least();
    //             right.remEl(least);
    //         } catch (EmptyException e) {
    //             empty = left.empty;
    //             val=left.val;
    //             right = left.right;
    //             left=left.left;
    //             return true;
    //         }
    //     }
    //     return el < val ? left.remEl(val) : right.remEl(val);
    // }


    boolean isEmpty(){
        return empty;
    }

    // /**
    //  * TODO
    //  * @param el
    //  * @return
    //  */
    // boolean isIn(int el){
    //     if (empty) return false;
    //     if (el == val) return true;
    //     if (el<val) return left.isIn(el);
    //     else return right.isIn(el);
    // }

    // /**
    //  * TODO
    //  * @return
    //  */
    // int size(){
    //     return empty?0:1+left.size()+right.size();
    // }

    /**
     * TODO
     * @return
     */
    public int least() throws EmptyException {
        if (empty) throw new EmptyException("least");
        try { return left.least();
        }catch (EmptyException e){
            return val;
        }
        
    }

    public Iterator<Integer> smallToBig() {
        return isEmpty()? EmptyIterator(): concatenate( concatenate(left.smallToBig(), List.of(val).iterator()),right.smallToBig());  
    }

    public Iterator<Integer> bigToSmall() {
        return isEmpty()? EmptyIterator(): concatenate(concatenate(right.bigToSmall(), List.of(val).iterator()), left.bigToSmall());  
    }

    @Override
    public boolean equals(Object obj) {
        if (!(obj instanceof OrderedIntList other)) return false;
        if (isEmpty() != other.isEmpty()) return false;
        if (isEmpty()) return true;

        final Iterator<Integer> thisIt = smallToBig(),otherIt = other.smallToBig();
        while (thisIt.hasNext() && otherIt.hasNext())
        if (! thisIt.next().equals(otherIt.next())) return false;
    return !(thisIt.hasNext() || otherIt.hasNext());
    }

    @Override
    public String toString() { //TODO CHECK
        StringJoiner sj = new StringJoiner(",");
        sj.add(String.valueOf(val));
        if (empty) return sj.toString();
        sj.add(left.toString());
        sj.add(right.toString());
        return sj.toString();
    }

    @Override
    public int hashCode() {
        int result = 0;
    final Iterator<Integer> it = smallToBig();
    while (it.hasNext()) result = 31 * result + it.next().hashCode();
    return result;
    }
    

}

