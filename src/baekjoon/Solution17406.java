package baekjoon;

import java.util.*;

public class Solution17406 {
    static int[][] rectangle;
    static int top;
    static int left;
    static int bottom;
    static int right;
    static int times;
    static int min = Integer.MAX_VALUE;
    Queue<Integer> queue = new PriorityQueue<>(Comparator.comparingInt(a -> a));

    static List<List<Integer>> permutation = new ArrayList<>();

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int height = sc.nextInt();
        int width = sc.nextInt();
        times = sc.nextInt();

        rectangle = new int[height][width];
        int[][] origin = new int[height][width];
        for (int i = 0; i < height; i++) {
            for (int j = 0; j < width; j++) {
                int input = sc.nextInt();
                rectangle[i][j] = input;
                origin[i][j] = input;
            }
        }

        int[][] time = new int[times][3];
        for (int i = 0; i < times; i++) {
            time[i][0] = sc.nextInt();
            time[i][1] = sc.nextInt();
            time[i][2] = sc.nextInt();
        }

        recursive(new ArrayList<>());

        for (List<Integer> integers : permutation) {
            for (Integer integer : integers) {
                int r = time[integer][0];
                int c = time[integer][1];
                int s = time[integer][2];
                top = r - s - 1;
                left = c - s - 1;
                bottom = r + s - 1;
                right = c + s - 1;
                while (top < bottom) {
                    int temp = rectangle[top][right];
                    for (int j = right; j > left; j--) {
                        rectangle[top][j] = rectangle[top][j - 1];
                    }
                    for (int j = top; j < bottom; j++) {
                        rectangle[j][left] = rectangle[j + 1][left];
                    }
                    for (int j = left; j < right; j++) {
                        rectangle[bottom][j] = rectangle[bottom][j + 1];
                    }
                    for (int j = bottom; j > top; j--) {
                        rectangle[j][right] = rectangle[j - 1][right];
                    }
                    rectangle[top + 1][right] = temp;
                    top++;
                    left++;
                    bottom--;
                    right--;
                }
            }

            for (int[] ints : rectangle) {
                int sum = 0;
                for (int anInt : ints) {
                    System.out.print(anInt + " ");
                    sum += anInt;
                }
                min = Math.min(sum, min);
                System.out.println(" => " + sum + " min : " + min);
                System.out.println();
            }

            for (int i = 0; i < height; i++) {
                for (int j = 0; j < width; j++) {
                    rectangle[i][j] = origin[i][j];
                }
            }
            System.out.println();
        }

        System.out.println(min);
    }

    static void recursive(List<Integer> selected) {
        if (selected.size() == times) {
            permutation.add(new ArrayList<>(selected));
            return;
        }

        for (int i = 0; i < times; i++) {
            if (selected.contains(i)) continue;
            selected.add(i);
            recursive(selected);
            selected.remove(selected.size() - 1);
        }
    }
}
