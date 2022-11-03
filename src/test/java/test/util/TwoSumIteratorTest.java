package test.util;

import base.utils.TwoSumInputIterator;
import base.utils.TwoSumTargetIterator;
import org.testng.annotations.Test;

import java.util.Arrays;

import static org.testng.Assert.assertEquals;

public class TwoSumIteratorTest {

    @Test
    public void test1() {
        TwoSumInputIterator iter = new TwoSumInputIterator(3);
        assertEquals(iter.next().getAry(), new int[] {1, 2});
        assertEquals(iter.next().getAry(), new int[] {2, 1});
        assertEquals(iter.next().getAry(), new int[] {1, 2, 3});
        assertEquals(iter.next().getAry(), new int[] {1, 3, 2});
        assertEquals(iter.next().getAry(), new int[] {2, 1, 3});
    }

    @Test
    public void test2() {
        TwoSumInputIterator iter = new TwoSumInputIterator(5);
        while (iter.hasNext()) {
            System.out.println(iter.next());
        }
    }

    @Test
    public void testTwoSumTargetIterator() {
        TwoSumTargetIterator iter = new TwoSumTargetIterator(Arrays.asList(3));
        while (iter.hasNext()) {
            System.out.println(iter.next());
        }
    }
}
