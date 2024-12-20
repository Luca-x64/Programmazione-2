package it.unimi.di.prog2.e19;


import java.util.Iterator;
import java.util.NoSuchElementException;
import java.util.Objects;
import java.util.StringJoiner;

public class IteratorUtils {


    private IteratorUtils(){};

    public static <T> Iterator<T> concatenate(Iterator<T> t1,Iterator<T> t2){
        Objects.requireNonNull(t1);
        Objects.requireNonNull(t2);

        return new Iterator<T>(){

            @Override
            public boolean hasNext() {
                return t1.hasNext() || t2.hasNext();
            }

            @Override
            public T next() throws NoSuchElementException{
                if(!hasNext()) throw new NoSuchElementException();
            return t1.hasNext()?t1.next():t2.next();
            }

        };

    }

    public static <T> Iterator<T> EmptyIterator(){
        return new Iterator<T>(){

            @Override
            public boolean hasNext() {
                return false;
            }

            @Override
            public T next() {
                throw new NoSuchElementException();
            }
            
        };
    }

    

    public static String join(Iterator<Integer> it,String sep){
        StringJoiner sj = new StringJoiner(sep);

        while(it.hasNext()){
            sj.add(String.valueOf(it.next()));
        }

        return sj.toString();
    }

}
