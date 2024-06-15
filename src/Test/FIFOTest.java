package Test;

import Algorithms.FIFO;
import Algorithms.LRU;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class FIFOTest {

    @Test
    void fifo() {
        FIFO b = new FIFO();
        assertEquals(15,b.fifo(new int[]{7, 0, 1, 2, 0, 3, 0, 4, 2, 3, 0, 3, 2, 1, 2, 0, 1, 7, 0, 1},3));
    }
}