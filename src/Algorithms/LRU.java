package Algorithms;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.Random;

public class LRU {
    public int pageFaults;
    public boolean unique;



    public int lru(int[] b, int frames) {
        if (frames < 1) {
            throw new IllegalArgumentException("Frames can't be zero or negative.");
        }
        pageFaults = 0;
        int count = 1;
        int[] arr = new int[frames];
        int i = 0;
        int index = 0;
        int lruIndex;
        int u;
        int h = 0;
        ArrayList<Integer> list = new ArrayList<>();
        while (i < b.length) {
            if (pageFaults < frames) {
                if (i == 0) {
                    arr[index] = b[i];
                    pageFaults++;
                    System.out.println(Arrays.toString(arr));
                    index++;
                }
                else if (i == 1) {
                    if (b[i] != arr[0]) {
                        arr[index] = b[i];
                        pageFaults++;
                        System.out.println(Arrays.toString(arr));
                        index++;
                    }
                }
                else{
                    unique = true;
                    count += i - 1;
                    for (int k = 0; k < count; k++) {
                        if (b[k] == b[count]) {
                            unique = false;
                            break;
                        }
                    }
                    if (unique) {
                        arr[index] = b[i];
                        pageFaults++;
                        System.out.println(Arrays.toString(arr));
                        index++;
                    }
                    else {
                        System.out.println(Arrays.toString(arr));
                        u = i + 1;
                        do {
                            if (b[u] != b[h]) {
                                h++;
                            } else {
                                u++;
                            }
                        } while (u != h);
                        arr[index] = b[h];
                        pageFaults++;
                        index++;
                        h = 0;
                    }
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
        pageFaults = 0;
        int count = 1;
        int[] arr = new int[frames];
        int index = 0;
        int i = 0;
        int lruIndex;
        int u;
        int h = 0;
        ArrayList<Integer> list = new ArrayList<>();
        while (i < n) {
            if (pageFaults < frames) {
                if (i == 0) {
                    arr[index] = b[i];
                    pageFaults++;
                    System.out.println(Arrays.toString(arr));
                    index++;
                }
                else if (i == 1) {
                    if (b[i] != arr[0]) {
                        arr[index] = b[i];
                        pageFaults++;
                        System.out.println(Arrays.toString(arr));
                        index++;
                    }
                }
                else {
                    unique = true;
                    count += i - 1;
                    for (int k = 0; k < count; k++) {
                        if (b[k] == b[count]) {
                            unique = false;
                            break;
                        }
                    }
                    if (unique) {
                        System.out.println(i);
                        arr[index] = b[i];
                        pageFaults++;
                        System.out.println(Arrays.toString(arr));
                        index++;
                    }
                    else {
                        System.out.println(Arrays.toString(arr));
                        u = i + 1;
                        do {
                            if (b[u] != b[h]) {
                                h++;
                            } else {
                                u++;
                            }
                        } while (u != h);
                        arr[index] = b[h];
                        pageFaults++;
                        index++;
                        h = 0;
                    }
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
