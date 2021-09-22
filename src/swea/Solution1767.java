package swea;

import java.awt.*;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Scanner;
import java.util.List;

public class Solution1767 {
    static int size;
    static int[][] map;
    static List<Point> processors;
    static int[] moveX = {0, 1, 0, -1};
    static int[] moveY = {-1, 0, 1, 0};
    static int connected;
    static int length;

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int test = sc.nextInt();
        for (int tc = 1; tc <= test; tc++) {
            size = sc.nextInt();
            map = new int[size][size];
            processors = new ArrayList<>();
            for (int i = 0; i < size; i++) {
                for (int j = 0; j < size; j++) {
                    int input = sc.nextInt();
                    map[i][j] = input;
                    if (input == 1) {
                        processors.add(new Point(j, i));
                    }
                }
            }
            connected = 0;
            length = 0;
            tracking(0, 0, 0);
            System.out.printf("#%d %d\n", tc, length);
        }
    }

    static void tracking(int index, int curLength, int curCore) {
        if (index >= processors.size()) {
            if (curCore > connected) {
                length = curLength;
                connected = curCore;
            } else if (curCore == connected) {
                length = Math.min(length, curLength);
            }
            return;
        }
        if (processors.size() - index < connected - curCore) {
            if (curCore > connected) {
                length = curLength;
                connected = curCore;
            } else if (curCore == connected) {
                length = Math.min(length, curLength);
            }
            return;
        }

        for (int i = 0; i < 4; i++) {
            int x = processors.get(index).x;
            int y = processors.get(index).y;
            int connect = connect(x + moveX[i], y + moveY[i], i, 0);
            if (connect != -1) {
                curLength += connect;
                curCore++;
            }
            tracking(index + 1, curLength, curCore);
            if (connect != -1) {
                disconnect(x + moveX[i], y + moveY[i], i);
                curLength -= connect;
                curCore--;
            }
        }
    }

    private static void print() {
        for (int[] ints : map) {
            for (int anInt : ints) {
                System.out.print(anInt + " ");
            }
            System.out.println();
        }
        System.out.println(connected + " " + length + "-------------------------");
    }

    static int connect(int curX, int curY, int direction, int curLength) {
        if (curX < 0 || curX >= size || curY < 0 || curY >= size) {
            return curLength;
        }
        if (map[curY][curX] != 0) {
            return -1;
        }

        int connect = connect(curX + moveX[direction], curY + moveY[direction], direction, curLength + 1);
        if (connect != -1) {
            map[curY][curX] = 2;
        }
        return connect;
    }

    static boolean disconnect(int curX, int curY, int direction) {
        if (curX < 0 || curX >= size || curY < 0 || curY >= size) {
            return true;
        }
        if (map[curY][curX] != 2) {
            return false;
        }

        boolean disconnect = disconnect(curX + moveX[direction], curY + moveY[direction], direction);
        if (disconnect) {
            map[curY][curX] = 0;
        }
        return disconnect;
    }
}
