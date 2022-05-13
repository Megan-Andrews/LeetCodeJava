import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.BeforeEach;

import static org.junit.jupiter.api.Assertions.*;

public class _4findMedianSortedArraysTest {
    Solution solution = new Solution();

    @Test
    void testOne() {
        double result = solution.findMedianSortedArrays(new int[]{1,3}, new int[]{2});
        assertEquals( 2, result);
    }
    @Test
    void testTwo() {
        double result = solution.findMedianSortedArrays(new int[]{1,2}, new int[]{3,4});
        assertEquals( 2.5, result);
    }

}
