package test.util;

import base.types.IntegerArrayType;
import base.utils.FilterMapIterator;
import base.utils.NextArrayIteratorOptimized;
import org.testng.annotations.Test;

import java.util.Arrays;

import static org.testng.Assert.assertEquals;
import static org.testng.Assert.assertFalse;

public class FilterMapIteratorTest {

    @Test
    public void testFilterMapIterator() {
        NextArrayIteratorOptimized originalIter = new NextArrayIteratorOptimized(4);
        FilterMapIterator<IntegerArrayType, Integer> iter =
                new FilterMapIterator<>(originalIter,
                        x -> Arrays.stream(x.getAry()).sum() == 2,
                        x -> getValue(x.getAry()));
        assertEquals((int)iter.next(), 3);
        assertEquals((int)iter.next(), 5);
        assertEquals((int)iter.next(), 6);
        assertEquals((int)iter.next(), 9);
        assertEquals((int)iter.next(), 10);
        assertEquals((int)iter.next(), 12);
        assertFalse(iter.hasNext());
    }

    public static int getValue(int[] ary) {
        int sum = 0;
        int val = 1;
        for (int i = ary.length - 1; i >= 0; i--) {
            if (ary[i] == 1) {
                sum += val;
            }
            val *= 2;
        }
        return sum;
    }

}
