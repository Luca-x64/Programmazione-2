package it.unimi.di.prog2.e15;

import java.util.Iterator;
import java.util.NoSuchElementException;

public class IntRange implements Iterable<Integer> {
    private int from = Integer.MIN_VALUE;
    private int to = Integer.MAX_VALUE;
    private int step = 1;

    public IntRange() {}
    

    void setFrom(int value) {
        from = value;
    }

    void setTo(int value) {to=value;
    }

    void setStep(int value) {
        if (value == 0) throw new IllegalArgumentException();
        step=value;
    }


    @Override
    public Iterator<Integer> iterator(){

    if (step > 0 && from > to || step < 0 && from < to) throw new IllegalArgumentException();

        return new Iterator<Integer>(){
            private int next = from;
            private final int step = IntRange.this.step;
            private final int to = IntRange.this.to;

            @Override
            public boolean hasNext() {
                return step > 0 ? next < to : next > to;
            }

            @Override
            public Integer next() {
                if (!hasNext()) {
                    throw new NoSuchElementException();
                }
                int result = next;
                if (step >0 && next >= Integer.MAX_VALUE-step) next = Integer.MAX_VALUE;
                else if (step <0 && next <= Integer.MIN_VALUE-step) next = Integer.MIN_VALUE;
                else next += step;
                return result;
            }
        };
    }
    
}
