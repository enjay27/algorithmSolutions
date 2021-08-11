package baekjoon;

import java.io.BufferedWriter;
import java.io.IOException;
import java.io.OutputStreamWriter;
import java.util.Scanner;

public class Solution16926 {
    public static void main(String[] args) throws IOException {
        Scanner sc = new Scanner(System.in);

        int height = sc.nextInt();
        int width = sc.nextInt();
        int times = sc.nextInt();

        int[][] rectangle = new int[height][width];
        for (int i = 0; i < height; i++) {
            for (int j = 0; j < width; j++) {
                rectangle[i][j] = sc.nextInt();
            }
        }

        boolean isWidth = height > width;

        for (int i = 0; i < times; i++) {
            int top = 0;
            int left = 0;
            int bottom = height - 1;
            int right = width - 1;
            if (isWidth) {
                while (left < width / 2) {
                    int temp = rectangle[bottom][left];
                    for (int j = bottom; j > top; j--) {
                        rectangle[j][left] = rectangle[j - 1][left];
                    }
                    for (int j = left; j < right; j++) {
                        rectangle[top][j] = rectangle[top][j + 1];
                    }
                    for (int j = top; j < bottom; j++) {
                        rectangle[j][right] = rectangle[j + 1][right];
                    }
                    for (int j = right; j > left; j--) {
                        rectangle[bottom][j] = rectangle[bottom][j - 1];
                    }
                    rectangle[bottom][left + 1] = temp;
                    top++;
                    left++;
                    bottom--;
                    right--;
                }
            } else {
                while (top < height / 2) {
                    int temp = rectangle[bottom][left];
                    for (int j = bottom; j > top; j--) {
                        rectangle[j][left] = rectangle[j - 1][left];
                    }
                    for (int j = left; j < right; j++) {
                        rectangle[top][j] = rectangle[top][j + 1];
                    }
                    for (int j = top; j < bottom; j++) {
                        rectangle[j][right] = rectangle[j + 1][right];
                    }
                    for (int j = right; j > left; j--) {
                        rectangle[bottom][j] = rectangle[bottom][j - 1];
                    }
                    rectangle[bottom][left + 1] = temp;
                    top++;
                    left++;
                    bottom--;
                    right--;
                }
            }
        }

        BufferedWriter bw  = new BufferedWriter(new OutputStreamWriter(System.out));

        for (int[] ints : rectangle) {
            for (int anInt : ints) {
                bw.write(anInt + " ");
            }
            bw.newLine();
        }
        bw.flush();
    }
}
