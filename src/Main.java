import Algorithms.FIFO;
import Algorithms.LRU;
import Algorithms.OptimalReplacement;

public class Main {
    public static void main(String[] args) {

        FIFO b = new FIFO();
        int [] a = {7,0,1,2,0,3,0,4,2,3,0,3,2,1,2,0,1,7,0,1};
        b.fifo(a, 3);
        System.out.println();

        LRU d = new LRU();
        int [] c = {7,0,1,2,0,3,0,4,2,3,0,3,2,1,2,0,1,7,0,1};
        d.lru(c, 3);
        System.out.println();

        OptimalReplacement f = new OptimalReplacement();
        int [] g = {7,0,1,2,0,3,0,4,2,3,0,3,2,1,2,0,1,7,0,1};
        f.optimal(g, 3);
        System.out.println();

    }
}
