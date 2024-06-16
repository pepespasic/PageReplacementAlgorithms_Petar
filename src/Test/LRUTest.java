package Test;

import Algorithms.LRU;
import Algorithms.OptimalReplacement;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class LRUTest {

    @Test
    void lru() {
        LRU l = new LRU();
        assertEquals(12, l.lru(new int[]{7,0,1,2,0,3,0,4,2,3,0,3,2,1,2,0,1,7,0,1},3));
        System.out.println();
        assertEquals(15, l.lru(new int[]{8,1,0,7,3,0,3,4,5,3,5,2,0,6,8,4,8,1,5,3},3));
        System.out.println();
        assertEquals(16, l.lru(new int[]{4,6,4,8,6,3,6,0,5,9,2,1,0,4,6,3,0,6,8,4},3));
    }
}