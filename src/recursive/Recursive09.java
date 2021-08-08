package recursive;

import java.util.Arrays;

public class Recursive09 {

    public static void main(String[] args) {
        int[] arr = {1,3,5};
        int[] des = new int[2];
    }

    private static void permutation(int[] arr, int[] destination, int index) {
        if (index == arr.length) {
            System.out.println(Arrays.toString(destination));
            return;
        }
    }
}