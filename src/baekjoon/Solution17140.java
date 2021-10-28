package baekjoon;

import java.util.*;

public class Solution17140 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int r = sc.nextInt() - 1;
        int c = sc.nextInt() - 1;
        int k = sc.nextInt();

        int[][] arr = new int[101][101];
        int width = 3;
        int height = 3;
        for (int i = 0; i < 3; i++) {
            for (int j = 0; j < 3; j++) {
                arr[i][j] = sc.nextInt();
            }
        }

//        int i = operateR(3, 3, arr);
//        int i = operateC(3, 3, arr);
//        System.out.println(Arrays.deepToString(arr));
//        System.out.println(i);
        int time = 0;
        while (arr[r][c] != k) {
            time++;
            if (height >= width) {
                width = operateR(width, height, arr);
            } else {
                height = operateC(width, height, arr);
            }
            if (time == 100) {
                time = -1;
                break;
            }
        }
        System.out.println(time);
    }

    static int operateR(int width, int height, int[][] arr) {
        Queue<OrderNumber> queue = new PriorityQueue<>();
        int[] nums = new int[101];
        int maxIndex = 0;
        for (int i = 0; i < height; i++) {
            queue.clear();
            for (int j = 0; j < width; j++) {
                nums[arr[i][j]]++;
            }
            for (int j = 1; j < 101; j++) {
                if (nums[j] == 0) continue;
                queue.offer(new OrderNumber(j, nums[j]));
                nums[j] = 0;
            }
            int index = 0;
            while (!queue.isEmpty()) {
                OrderNumber poll = queue.poll();
                arr[i][index++] = poll.number;
                if (index == 100) break;
                arr[i][index++] = poll.count;
            }
            for (int j = index; j < 101; j++) {
                if (arr[i][j] == 0) break;
                arr[i][j] = 0;
            }
            maxIndex = Math.max(index, maxIndex);
        }

        return maxIndex;
    }

    static int operateC(int width, int height, int[][] arr) {
        Queue<OrderNumber> queue = new PriorityQueue<>();
        int[] nums = new int[101];
        int maxIndex = 0;
        for (int j = 0; j < width; j++) {
            for (int i = 0; i < height; i++) {
                nums[arr[i][j]]++;
            }
            for (int i = 1; i < 101; i++) {
                if (nums[i] == 0) continue;
                queue.offer(new OrderNumber(i, nums[i]));
                nums[i] = 0;
            }
            int index = 0;
            while (!queue.isEmpty()) {
                OrderNumber poll = queue.poll();
                arr[index++][j] = poll.number;
                if (index == 100) break;
                arr[index++][j] = poll.count;
            }
            for (int i = index; i < 101; i++) {
                if (arr[i][j] == 0) break;
                arr[i][j] = 0;
            }
            maxIndex = Math.max(index, maxIndex);
        }

        return maxIndex;
    }

    static class OrderNumber implements Comparable<OrderNumber> {
        int number;
        int count;

        public OrderNumber(int number, int count) {
            this.number = number;
            this.count = count;
        }

        @Override
        public int compareTo(OrderNumber o) {
//            if (this.number + this.count == 0) return -1;
//            else if (o.number + this.number == 0) return 1;
            return this.count != o.count ? this.count - o.count : this.number - o.number;
        }

        @Override
        public String toString() {
            return "OrderNumber{" +
                    "number=" + number +
                    ", count=" + count +
                    '}';
        }
    }
}
