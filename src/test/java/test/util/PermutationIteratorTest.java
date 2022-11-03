package test.util;

import base.utils.PermutationIterator;
import base.utils.PermutationValuesIterator;
import org.testng.annotations.Test;

import java.util.Arrays;

import static org.testng.Assert.assertEquals;
import static org.testng.Assert.assertFalse;

public class PermutationIteratorTest {

    @Test
    public void test1() {
        PermutationIterator iter = new PermutationIterator(3);
        assertEquals(iter.next(), new int[] {0,1,2});
        assertEquals(iter.next(), new int[] {0,2,1});
        assertEquals(iter.next(), new int[] {1,0,2});
        assertEquals(iter.next(), new int[] {1,2,0});
        assertEquals(iter.next(), new int[] {2,0,1});
        assertEquals(iter.next(), new int[] {2,1,0});
        assertFalse(iter.hasNext());
    }

    @Test
    public void test2() {
        PermutationIterator iter = new PermutationIterator(4);
        assertEquals(iter.next(), new int[] {0,1,2,3});
        assertEquals(iter.next(), new int[] {0,1,3,2});
        assertEquals(iter.next(), new int[] {0,2,1,3});
        assertEquals(iter.next(), new int[] {0,2,3,1});
        assertEquals(iter.next(), new int[] {0,3,1,2});
        assertEquals(iter.next(), new int[] {0,3,2,1});
        assertEquals(iter.next(), new int[] {1,0,2,3});
        assertEquals(iter.next(), new int[] {1,0,3,2});
        assertEquals(iter.next(), new int[] {1,2,0,3});
    }

    @Test
    public void test3() {
        PermutationValuesIterator iter = new PermutationValuesIterator(new int[] {0,1,2,3});
        while (iter.hasNext()) {
            System.out.println(Arrays.toString(iter.next()));
        }

        System.out.println("----");
        PermutationIterator iter2 = new PermutationIterator(4);
        while (iter2.hasNext()) {
            System.out.println(Arrays.toString(iter2.next()));
        }

    }

}
