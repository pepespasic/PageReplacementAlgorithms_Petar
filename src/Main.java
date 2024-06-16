import Algorithms.FIFO;
import Algorithms.LRU;
import Algorithms.OptimalReplacement;

public class Main {
    public static void main(String[] args) {
//        fifo();
//        lru();
//        optimal();
        fifoRandom();
        lruRandom();
        optimalRandom();
    }

    public static void fifo() {
        System.out.println("FIFO:");
        FIFO b = new FIFO();
        int [] a = {7,0,1,2,0,3,0,4,2,3,0,3,2,1,2,0,1,7,0,1};
        System.out.println(b.fifo(a, 3));
        System.out.println();

        int[] d = {8,1,0,7,3,0,3,4,5,3,5,2,0,6,8,4,8,1,5,3};
        System.out.println(b.fifo(d, 3));
        System.out.println();

        int[] f = {4,6,4,8,6,3,6,0,5,9,2,1,0,4,6,3,0,6,8,4};
        System.out.println(b.fifo(f, 3));
        System.out.println();
    }

    public static void lru() {
        System.out.println();
        System.out.println("LRU:");
        LRU d = new LRU();
        int [] c = {7,0,1,2,0,3,0,4,2,3,0,3,2,1,2,0,1,7,0,1};
        System.out.println(d.lru(c, 3));
        System.out.println();

        int[] k = {8,1,0,7,3,0,3,4,5,3,5,2,0,6,8,4,8,1,5,3};
        System.out.println(d.lru(k, 3));
        System.out.println();

        int[] f = {4,6,4,8,6,3,6,0,5,9,2,1,0,4,6,3,0,6,8,4};
        System.out.println(d.lru(f, 3));
        System.out.println();
    }

    public static void optimal() {
        System.out.println();
        System.out.println("OPT:");
     OptimalReplacement f = new OptimalReplacement();
        int [] g = {7,0,1,2,0,3,0,4,2,3,0,3,2,1,2,0,1,7,0,1};
        System.out.println(f.optimal(g, 3));
        System.out.println();

        int[] k = {8,1,0,7,3,0,3,4,5,3,5,2,0,6,8,4,8,1,5,3};
        System.out.println(f.optimal(k, 3));
        System.out.println();

        int[] j = {4,6,4,8,6,3,6,0,5,9,2,1,0,4,6,3,0,6,8,4};
        System.out.println(f.optimal(j, 3));
        System.out.println();
    }

    public static void fifoRandom() {
        System.out.println();
        System.out.println("FIFO Random:");
        FIFO a = new FIFO();
        System.out.println(a.fifoRandom(15,3));
        System.out.println();

        System.out.println(a.fifoRandom(15, 5));
        System.out.println();

        System.out.println(a.fifoRandom(15, 7));
        System.out.println();
    }

    public static void lruRandom() {
        System.out.println();
        System.out.println("LRU Random:");
        LRU b = new LRU();
        System.out.println(b.lruRandom(15,3));
        System.out.println();

        System.out.println(b.lruRandom(15, 5));
        System.out.println();

        System.out.println(b.lruRandom(15, 7));
        System.out.println();
    }

    public static void optimalRandom() {
        System.out.println();
        System.out.println("OPT Random:");
        OptimalReplacement c = new OptimalReplacement();
        System.out.println(c.optimalRandom(15,3));
        System.out.println();

        System.out.println(c.optimalRandom(15, 5));
        System.out.println();

        System.out.println(c.optimalRandom(15, 7));
        System.out.println();
    }


}
