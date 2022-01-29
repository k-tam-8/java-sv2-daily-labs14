package day04;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class PairFinderTest {
    @Test
    void name() {
        PairFinder pf = new PairFinder();
        int[] arr = {5, 1, 4, 5};
        int[] arr2 = {7, 1, 5, 7, 3, 3, 5, 7, 6, 7};

        assertEquals(1, pf.findPairs(arr));
        assertEquals(4, pf.findPairs(arr2));
    }
}