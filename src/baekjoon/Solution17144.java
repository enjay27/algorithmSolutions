package baekjoon;

import java.awt.*;
import java.util.ArrayList;
import java.util.Scanner;
import java.util.List;

public class Solution17144 {
    static int width;
    static int height;
    static int time;
    static int[][] house;
    static int[][] diffused;
    static int[] moveX = {0, 1, 0, -1};
    static int[] moveY = {-1, 0, 1, 0};
    static List<Point> cleaner = new ArrayList<>();
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        height = sc.nextInt();
        width = sc.nextInt();
        time = sc.nextInt();
        house = new int[height][width];
        diffused = new int[height][width];
        for (int i = 0; i < height; i++) {
            for (int j = 0; j < width; j++) {
                house[i][j] = sc.nextInt();
                if (house[i][j] == -1) {
                    cleaner.add(new Point(j, i));
                }
            }
        }

        for (int i = 0; i < time; i++) {
            diffuse();
            clean();
        }
        int sum = 0;
        for (int[] ints : house) {
            for (int anInt : ints) {
                if (anInt != -1) {
                    sum += anInt;
                }
            }
        }
        System.out.println(sum);
    }

    static void print() {
        for (int[] ints : house) {
            for (int anInt : ints) {
                System.out.print(anInt + " ");
            }
            System.out.println();
        }
    }

    static void diffuse() {
        for (int i = 0; i < height; i++) {
            for (int j = 0; j < width; j++) {
                if (house[i][j] == -1) continue;
                for (int k = 0; k < 4; k++) {
                    int curX = j + moveX[k];
                    int curY = i + moveY[k];
                    if (curX < 0 || curX >= width || curY < 0 || curY >= height) continue;
                    if (house[curY][curX] == -1) continue;
                    diffused[curY][curX] -= house[curY][curX] / 5;
                    diffused[i][j] += house[curY][curX] / 5;
                }
            }
        }
        for (int i = 0; i < height; i++) {
            for (int j = 0; j < width; j++) {
                house[i][j] += diffused[i][j];
                diffused[i][j] = 0;
            }
        }
    }

    static void clean() {
        int curX = cleaner.get(0).x;
        int curY = cleaner.get(0).y - 1;
        int direction = 0;
        while (!(curX == cleaner.get(0).x && curY == cleaner.get(0).y)) {
            curX += moveX[direction];
            curY += moveY[direction];
            if (curX < 0 || curX >= width || curY < 0 || curY > cleaner.get(0).y) {
                curX -= moveX[direction];
                curY -= moveY[direction];
                direction++;
                curX += moveX[direction];
                curY += moveY[direction];
            }
            if (house[curY][curX] != -1)
                house[curY - moveY[direction]][curX - moveX[direction]] = house[curY][curX];
            else
                house[curY - moveY[direction]][curX - moveX[direction]] = 0;
        }

        curX = cleaner.get(1).x;
        curY = cleaner.get(1).y + 1;
        direction = 2;
        while (!(curX == cleaner.get(1).x && curY == cleaner.get(1).y)) {
            curX += moveX[direction];
            curY += moveY[direction];
            if (curX < 0 || curX >= width || curY < cleaner.get(1).y || curY >= height) {
                curX -= moveX[direction];
                curY -= moveY[direction];
                direction--;
                if (direction < 0) {
                    direction += 4;
                }
                curX += moveX[direction];
                curY += moveY[direction];
            }
            if (house[curY][curX] != -1)
                house[curY - moveY[direction]][curX - moveX[direction]] = house[curY][curX];
            else
                house[curY - moveY[direction]][curX - moveX[direction]] = 0;
        }
    }
}
