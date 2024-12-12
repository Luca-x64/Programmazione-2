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

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Iterator;

import javax.crypto.NullCipher;

import it.unimi.di.prog2.h08.impl.EmptyException;

/**
 * Ordered list of integers without duplicates. See PDF 6.6 public class OrderedIntList {
 *
 * <p>// Specify and implement (writing the AF and RI) the // ordered list of integers without
 * duplicates described // in paragraph 6 of chapter 6 of the PDJ textbook.
 *
 * <p>}
 */


public class OrderedIntList{
    private boolean empty;
    private OrderedIntList left,right;
    private int val;
    

    public OrderedIntList(){
        empty = true;
        left=right=null;
    }

    void addEl(int el) /* throws DuplicateException */ {
        
    }

    void remEl(int el){
   
     
    }

    /**
     * TODO
     * @param el
     * @return
     */
    boolean isIn(int el){
        if (empty) return false;
        if (el == val) return true;
        if (el<val) return left.isIn(el);
        else return right.isIn(el);
    }

    /**
     * TODO
     * @return
     */
    int size(){
        return empty?0:1+left.size()+right.size();
    }

    /**
     * TODO
     * @return
     */
    public int least()  {
        if (empty) throw new EmptyException("least");
        try { return left.least(); }
        catch (EmptyException e){
            return val;
        }
        
    }

    public Iterator smallToBig() {
       return new Iterator<Integer>(){

        @Override
        public boolean hasNext() {
            // TODO Auto-generated method stub
            throw new UnsupportedOperationException("Unimplemented method 'hasNext'");
        }

        @Override
        public Integer next() {
            // TODO Auto-generated method stub
            throw new UnsupportedOperationException("Unimplemented method 'next'");
        }

       };
    }

    public Iterator bigToSmall() {
        
        return new Iterator<Integer>(){

            @Override
            public boolean hasNext() {
                // TODO Auto-generated method stub
                throw new UnsupportedOperationException("Unimplemented method 'hasNext'");
            }
    
            @Override
            public Integer next() {
                // TODO Auto-generated method stub
                throw new UnsupportedOperationException("Unimplemented method 'next'");
            }
    
           };
     
    }

    @Override
    public String toString() {
        // TODO Auto-generated method stub
        return super.toString();
    }

    @Override
    protected Object clone() throws CloneNotSupportedException {
         // TODO Auto-generated method stub
        return super.clone();
    }

    @Override
    public int hashCode() {
        // TODO Auto-generated method stub
        return super.hashCode();
    }
    

}

