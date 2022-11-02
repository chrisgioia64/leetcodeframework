package test.util;

import base.utils.NextArrayIteratorNaive;
import base.utils.NextArrayIteratorOptimized;
import org.testng.annotations.Test;

import static org.testng.Assert.*;

public class NextIteratorTest {

    @Test(timeOut = 2000)
    public void testNextIteratorNaive() {
        NextArrayIteratorNaive iter = new NextArrayIteratorNaive(3);
        assertTrue(iter.hasNext());
        assertEquals(iter.next().getAry(), new int[] {0, 0, 0});
        assertEquals(iter.next().getAry(), new int[] {0, 0, 1});
        assertEquals(iter.next().getAry(), new int[] {0, 1, 0});
        assertEquals(iter.next().getAry(), new int[] {0, 1, 1});
        assertEquals(iter.next().getAry(), new int[] {1, 0, 0});
        assertEquals(iter.next().getAry(), new int[] {1, 0, 1});
        assertEquals(iter.next().getAry(), new int[] {1, 1, 0});
        assertEquals(iter.next().getAry(), new int[] {1, 1, 1});
        assertFalse(iter.hasNext());
    }

    @Test(timeOut = 2000)
    public void testNextIteratorOptimized() {
        NextArrayIteratorOptimized iter = new NextArrayIteratorOptimized(3);
        assertTrue(iter.hasNext());
        assertEquals(iter.next().getAry(), new int[] {0, 0, 0});
        assertEquals(iter.next().getAry(), new int[] {0, 0, 1});
        assertEquals(iter.next().getAry(), new int[] {0, 1, 0});
        assertEquals(iter.next().getAry(), new int[] {0, 1, 1});
        assertEquals(iter.next().getAry(), new int[] {1, 0, 0});
        assertEquals(iter.next().getAry(), new int[] {1, 0, 1});
        assertEquals(iter.next().getAry(), new int[] {1, 1, 0});
        assertEquals(iter.next().getAry(), new int[] {1, 1, 1});
        assertFalse(iter.hasNext());
    }

    @Test
    public void testGenerateArray() {
        assertEquals(NextArrayIteratorNaive.generateArray(4, 0), new int[] {0, 0, 0, 0});
        assertEquals(NextArrayIteratorNaive.generateArray(4, 1), new int[] {0, 0, 0, 1});
        assertEquals(NextArrayIteratorNaive.generateArray(4, 2), new int[] {0, 0, 1, 0});
        assertEquals(NextArrayIteratorNaive.generateArray(4, 7), new int[] {0, 1, 1, 1});
        assertEquals(NextArrayIteratorNaive.generateArray(4, 8), new int[] {1, 0, 0, 0});
        assertEquals(NextArrayIteratorNaive.generateArray(4, 10), new int[] {1, 0, 1, 0});
        assertEquals(NextArrayIteratorNaive.generateArray(4, 15), new int[] {1, 1, 1, 1});

        expectFailure(4, 16);
        expectFailure(4, 17);
        expectFailure(4, 100);
        expectFailure(4, -1);
        expectFailure(4, -100);
        expectFailure(1, 2);
        expectFailure(2, 4);
    }

    private void expectFailure(int n, int index) {
        try {
            NextArrayIteratorNaive.generateArray(n, index);
            fail("should have thrown an exception");
        } catch (IllegalArgumentException ex) {
        }
    }

}
