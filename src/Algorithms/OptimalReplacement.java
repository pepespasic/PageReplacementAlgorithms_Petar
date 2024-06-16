package Algorithms;
import java.util.Arrays;
import java.util.Random;

public class OptimalReplacement {
    public int pageFaults;
    public boolean contains;

    /**
     * Throws illegal argument exception if frames are less than one.
     * Returns true if an element is present in
     * array of frames false otherwise.
     * @param arr array of frames
     * @param index index of frames array
     * @param elem current element in array of references
     * @return true or false
     */
    public boolean contains(int[] arr, int index, int elem){
        for(int i = 0; i < index; i++) {
            if (elem == arr[i]) {
                return true;
            }
        }
        return false;
    }

    /**
     * Throws illegal argument exception if frames are less than one.
     * Replaces element that will not be used for longest time in
     * the future with current element if not present in array of frames.
     * @param b array of references
     * @param frames frame size
     * @return pageFaults
     */
    public int optimal(int[] b, int frames) {
        if (frames < 1) {
            throw new IllegalArgumentException("Frames can't be zero or negative.");
        }
        pageFaults = 0;
        int[] arr = new int[frames];
        int[] indexes = new int[frames];
        int i = 0;
        int index = 0;
        int optIndex;
        while (i < b.length) {
            if (pageFaults < frames) {
                if (!contains(arr, index, b[i])) {
                    pageFaults++;
                    arr[index++] = b[i];
                }
                System.out.println(Arrays.toString(arr));
                if (index == frames) {
                    index = 0;
                }
            }
            else {
                index = 0;
                for (int j = index; j < arr.length; j++) {
                    if (b[i] == arr[j]) {
                        break;
                    } else {
                        index++;
                    }
                }
                if (index == arr.length) {
                    contains = false;
                    for (int j : arr) {
                        if (b[i] == j) {
                            contains = true;
                            break;
                        }
                    }
                    if (!contains) {
                        for (int r = 0; r < frames; r++) {
                            indexes[r] = -1;
                        }
                        optIndex = i + 1;
                        for (int c = 0; c < arr.length; c++) {
                            for (int d = optIndex; d < b.length; d++){
                                if (b[d] == arr[c]) {
                                    indexes[c] = d;
                                    break;
                                }
                            }
                        }
                        int removeIndex = 0;
                        int maxIndex = indexes[0];
                        for (int n = 0; n < arr.length; n++) {
                            if (indexes[n] == -1) {
                                removeIndex = n;
                                break;
                            }
                            else if (indexes[n] > maxIndex){
                                maxIndex = indexes[n];
                                removeIndex = n;
                            }
                        }
                        arr[removeIndex] = b[i];
                        pageFaults++;
                    }
                }
                System.out.println(Arrays.toString(arr));
            }
            i++;
        }
        return pageFaults;
    }

    /**
     * Throws illegal argument exception if frames are less than one.
     * Replaces element that will not be used for longest time in
     * the future with current element if not present in array of frames.
     * @param n reference string size
     * @param frames frame size
     * @return pageFaults
     */
    public int optimalRandom(int n, int frames) {
        if (frames < 1) {
            throw new IllegalArgumentException("Frames can't be zero or negative.");
        }
        int[] b = new int[n];
        Random rand = new Random();
        for (int i = 0; i < n; i++) {
            int num = rand.nextInt(10);
            b[i] = num;
        }
        System.out.println(Arrays.toString(b));
        System.out.println();
        pageFaults = 0;
        int[] arr = new int[frames];
        int[] indexes = new int[frames];
        int i = 0;
        int index = 0;
        int optIndex;
        while (i < n) {
            if (pageFaults < frames) {
                if (!contains(arr, index, b[i])) {
                    pageFaults++;
                    arr[index++] = b[i];
                }
                System.out.println(Arrays.toString(arr));
                if (index == frames) {
                    index = 0;
                }
            }
            else {
                index = 0;
                for (int j = index; j < arr.length; j++) {
                    if (b[i] == arr[j]) {
                        break;
                    } else {
                        index++;
                    }
                }
                if (index == arr.length) {
                    contains = false;
                    for (int j : arr) {
                        if (b[i] == j) {
                            contains = true;
                            break;
                        }
                    }
                    if (!contains) {
                        for (int r = 0; r < frames; r++) {
                            indexes[r] = -1;
                        }
                        optIndex = i + 1;
                        for (int c = 0; c < arr.length; c++) {
                            for (int d = optIndex; d < b.length; d++) {
                                if (b[d] == arr[c]) {
                                    indexes[c] = d;
                                    break;
                                }
                            }
                        }
                        int removeIndex = 0;
                        int maxIndex = indexes[0];
                        for (int g = 0; g < arr.length; g++) {
                            if (indexes[g] == -1) {
                                removeIndex = g;
                                break;
                            } else if (indexes[g] > maxIndex) {
                                maxIndex = indexes[g];
                                removeIndex = g;
                            }
                        }
                        arr[removeIndex] = b[i];
                        pageFaults++;
                    }
                }
                System.out.println(Arrays.toString(arr));
            }
            i++;
        }
        return pageFaults;
    }
}
