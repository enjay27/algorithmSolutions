package baekjoon;

import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

public class Solution2564 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int width = sc.nextInt();
        int height = sc.nextInt();
        int number = sc.nextInt();

        // 1: 북, 2: 남, 3: 서, 4: 동
        // 왼쪽으로부터, 위쪽으로부터 거리
        // 남서 +-, 북서 ++, 북동 -+, 남동 --
        int[][] shops = new int[number][2];
        for (int i = 0; i < number; i++) {
            shops[i][0] = sc.nextInt();
            shops[i][1] = sc.nextInt();
        }

        int dir = sc.nextInt();
        int location = sc.nextInt();
        Map<Integer, Integer> opposite = new HashMap<>();
        opposite.put(1, 2);
        opposite.put(2, 1);
        opposite.put(3, 4);
        opposite.put(4, 3);
        int distance = 0;
        for (int i = 0; i < number; i++) {
            if (dir == shops[i][0]) {
                distance += Math.abs(shops[i][1] - location);
            } else if (dir == opposite.get(shops[i][0])) {
                distance += height + Math.min(shops[i][1] + location, 2 * width - shops[i][1] - location);
            } else {
                if (dir == 1 && shops[i][0] == 3 || dir == 3 && shops[i][0] == 1) {
                    distance += location + shops[i][1];
                } else if (dir == 2 && shops[i][0] == 3 || dir == 3 && shops[i][0] == 2) {
                    if (dir == 2) {
                        distance += location + height - shops[i][1];
                    } else {
                        distance += shops[i][1] + height - location;
                    }
                } else if (dir == 2 && shops[i][0] == 4 || dir == 4 && shops[i][0] == 2) {
                    distance += width + height - location - shops[i][1];
                } else {
                    if (dir == 1) {
                        distance += width - location + shops[i][1];
                    } else {
                        distance += width - shops[i][1] + location;
                    }
                }
            }
        }
        System.out.println(distance);
    }
}
