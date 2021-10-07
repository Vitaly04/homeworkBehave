package task1;

import java.util.Iterator;
import java.util.Random;

public class Randoms implements Iterable<Integer> {
    protected Random random;
    private int min;
    private int max;
    private Integer number;

    public Randoms(int min, int max) {
        this.min = min;
        this.max = max;
        this.random = new Random();
        this.number = random.nextInt((max - min) + 1) + min;
    }

    @Override
    public Iterator<Integer> iterator() {
        return new Iterator<Integer>() {

            @Override
            public boolean hasNext() {
                return true;
            }

            @Override
            public Integer next() {
                return random.nextInt((max - min) + 1) + min;
            }
        };
    }

}

