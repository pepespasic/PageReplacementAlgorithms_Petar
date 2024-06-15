package Test;

import Algorithms.LRU;
import Algorithms.OptimalReplacement;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class LRUTest {

    @Test
    void lru() {
        LRU l = new LRU();
        assertEquals(12,l.lru(new int[]{7, 0, 1, 2, 0, 3, 0, 4, 2, 3, 0, 3, 2, 1, 2, 0, 1, 7, 0, 1},3));
    }
}