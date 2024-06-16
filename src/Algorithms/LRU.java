package Algorithms;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.Random;

public class LRU {
    public int pageFaults;

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
     * Replaces least recently used element with current element if
     * not present in array of frames.
     * @param b array of references
     * @param frames frame size
     * @return pageFaults
     */
    public int lru(int[] b, int frames) {
        if (frames < 1) {
            throw new IllegalArgumentException("Frames can't be zero or negative.");
        }
        pageFaults = 0;
        int[] arr = new int[frames];
        int i = 0;
        int index = 0;
        int lruIndex;
        ArrayList<Integer> list = new ArrayList<>();
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
                    lruIndex = i - frames;
                    for (int k = lruIndex; k < i; k++) {
                        list.add(b[k]);
                    }
                    Collections.sort(list);
                    for (int k = list.size() - 1; k > 0; k--) {
                        if (list.get(k).equals(list.get(k - 1))) {
                            lruIndex--;
                        }
                    }
                    for (int m = 0; m < arr.length; m++) {
                        if (b[lruIndex] == arr[m]) {
                            arr[m] = b[i];
                            pageFaults++;
                            break;
                        }
                    }
                    list.clear();
                }
                System.out.println(Arrays.toString(arr));
            }
            i++;
        }
        return pageFaults;
    }

    /**
     * Throws illegal argument exception if frames are less than one.
     * Generates random array and replaces least recently used element with current element if
     * not present in array of frames.
     * @param n reference string size
     * @param frames frame size
     * @return pageFaults
     */
    public int lruRandom(int n, int frames) {
        if(frames < 1) {
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
        int index = 0;
        int i = 0;
        int lruIndex;
        ArrayList<Integer> list = new ArrayList<>();
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
                    lruIndex = i - frames;
                    for (int k = lruIndex; k < i; k++) {
                        list.add(b[k]);
                    }
                    Collections.sort(list);
                    for (int k = list.size() - 1; k > 0; k--) {
                        if (list.get(k).equals(list.get(k - 1))) {
                            lruIndex--;
                        }
                    }
                    for (int m = 0; m < arr.length; m++) {
                        if (b[lruIndex] == arr[m]) {
                            arr[m] = b[i];
                            pageFaults++;
                            break;
                        }
                    }
                    list.clear();
                }
                System.out.println(Arrays.toString(arr));
            }
            i++;
        }
        return pageFaults;
    }
}
