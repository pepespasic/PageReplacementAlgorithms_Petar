package Test;

import Algorithms.OptimalReplacement;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class OptimalReplacementTest {

    @Test
    void optimal() {
        OptimalReplacement opt = new OptimalReplacement();
        assertEquals(9, opt.optimal(new int[]{7,0,1,2,0,3,0,4,2,3,0,3,2,1,2,0,1,7,0,1},3));
        System.out.println();
        assertEquals(13, opt.optimal(new int[]{8,1,0,7,3,0,3,4,5,3,5,2,0,6,8,4,8,1,5,3},3));
        System.out.println();
        assertEquals(13, opt.optimal(new int[]{4,6,4,8,6,3,6,0,5,9,2,1,0,4,6,3,0,6,8,4},3));
    }
}