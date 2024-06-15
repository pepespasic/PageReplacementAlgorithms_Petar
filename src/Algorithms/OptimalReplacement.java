package Algorithms;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.Random;

public class OptimalReplacement {
    public int pageFaults;
    public boolean unique;
    public boolean contains;



    public void optimal(int[] b, int frames) {
        if (frames < 1) {
            throw new IllegalArgumentException("Frames can't be zero or negative.");
        }
        pageFaults = 0;
        int count = 1;
        int[] arr = new int[frames];
        int[] indexes = new int[frames];
        int i = 0;
        int index = 0;
        int optIndex;
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
                        arr[index] = b[i];
                        pageFaults++;
                        System.out.println(Arrays.toString(arr));
                        index++;
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
                    contains = false;
                    for (int l = 0; l < arr.length; l++) {
                        if (b[i] == arr[l]) {
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
        System.out.print("Page faults: ");
        System.out.print(pageFaults);
    }

    public void optimalRandom(int n, int frames) {
        if (frames < 1) {
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
        int[] indexes = new int[frames];
        int i = 0;
        int index = 0;
        int optIndex;
        while (i < n) {
            if (pageFaults < frames) {
                if (i == 0) {
                    arr[index] = b[i];
                    pageFaults++;
                    System.out.println(Arrays.toString(arr));
                    index++;
                } else if (i == 1) {
                    if (b[i] != arr[0]) {
                        arr[index] = b[i];
                        pageFaults++;
                        System.out.println(Arrays.toString(arr));
                        index++;
                    }
                } else {
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
                }

            } else {
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
                    for (int l = 0; l < arr.length; l++) {
                        if (b[i] == arr[l]) {
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
        System.out.print("Page faults: ");
        System.out.print(pageFaults);
    }
}
