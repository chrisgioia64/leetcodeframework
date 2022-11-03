package test.util;

import base.types.IntegerArrayType;
import base.utils.FilterMapIterator;
import base.utils.NextArrayIteratorOptimized;
import base.utils.ProductIterator;
import org.testng.annotations.Test;

import java.util.Arrays;
import java.util.Iterator;

import static org.testng.Assert.*;

public class ProductIteratorTest {

    @Test
    public void testProductIterator() {
        NextArrayIteratorOptimized originalIter = new NextArrayIteratorOptimized(3);
        FilterMapIterator<IntegerArrayType, Integer> filteredIter =
                new FilterMapIterator<>(originalIter,
                        x -> Arrays.stream(x.getAry()).sum() == 2,
                        x -> FilterMapIteratorTest.getValue(x.getAry()));
        ProductIterator<Integer, Integer> productIterator =
                new ProductIterator<>(filteredIter, x -> new SquareIterator(x));

        assertTrue(productIterator.hasNext());
        assertEquals((int)productIterator.next(), 3);
        assertEquals((int)productIterator.next(), 9);
        assertEquals((int)productIterator.next(), 5);
        assertEquals((int)productIterator.next(), 25);
        assertEquals((int)productIterator.next(), 6);
        assertEquals((int)productIterator.next(), 36);
        assertFalse(productIterator.hasNext());
    }

    public static class SquareIterator implements Iterator<Integer> {
        private int number;
        private boolean p1;
        private boolean p2;

        public SquareIterator(int number) {
            this.number = number;
        }

        @Override
        public boolean hasNext() {
            return !p2;
        }

        @Override
        public Integer next() {
            if (!p1) {
                p1 = true;
                return number;
            } else if (!p2) {
                p2 = true;
                return number * number;
            } else {
                throw new IllegalArgumentException();
            }
        }
    }

}
