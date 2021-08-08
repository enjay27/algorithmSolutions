package swea;

import java.util.Arrays;
import java.util.Scanner;

public class Solution1873 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int test = sc.nextInt();

        for (int test_case = 1; test_case <= test; test_case++) {
            int height = sc.nextInt();
            int width = sc.nextInt();
            char[][] map = new char[height][width];

            int dir = 0;
            int x = 0;
            int y = 0;

            for (int i = 0; i < height; i++) {
                map[i] = sc.next().toCharArray();
                char[] chars = map[i];
                for (int j = 0, charsLength = chars.length; j < charsLength; j++) {
                    char c = chars[j];
                    if (c == '^' || c == 'v' || c == '<' || c == '>') {
                        y = i;
                        x = j;
                        switch (c) {
                            case '^':
                                dir = 0;
                                break;
                            case '>':
                                dir = 1;
                                break;
                            case 'v':
                                dir = 2;
                                break;
                            case '<':
                                dir = 3;
                                break;
                        }
                    }
                }
            }



            int[] dirX = {0, 1, 0, -1};
            int[] dirY = {-1, 0, 1, 0};

            int inputSize = sc.nextInt();
            String inputScan = sc.next();
            char[] input = inputScan.toCharArray();
            for (char c : input) {
                boolean canMove = false;
                switch (c) {
                    case 'U':
                        dir = 0;
                        if (y - 1 >= 0) {
                            if (map[y - 1][x] == '.') {
                                canMove = true;
                            }
                        }
                        if (canMove) {
                            map[y - 1][x] = '^';
                            map[y][x] = '.';
                            y += dirY[dir];
                        } else {
                            map[y][x] = '^';
                        }
                        break;
                    case 'D':
                        dir = 2;
                        if (y + 1 < height) {
                            if (map[y + 1][x] == '.') {
                                canMove = true;
                            }
                        }
                        if (canMove) {
                            map[y + 1][x] = 'v';
                            map[y][x] = '.';
                            y += dirY[dir];
                        } else {
                            map[y][x] = 'v';
                        }
                        break;
                    case 'L':
                        dir = 3;
                        if (x - 1 >= 0) {
                            if (map[y][x - 1] == '.') {
                                canMove = true;
                            }
                        }
                        if (canMove) {
                            map[y][x - 1] = '<';
                            map[y][x] = '.';
                            x += dirX[dir];
                        } else {
                            map[y][x] = '<';
                        }
                        break;
                    case 'R':
                        dir = 1;
                        if (x + 1 < width) {
                            if (map[y][x + 1] == '.') {
                                canMove = true;
                            }
                        }
                        if (canMove) {
                            map[y][x + 1] = '>';
                            map[y][x] = '.';
                            x += dirX[dir];
                        } else {
                            map[y][x] = '>';
                        }
                        break;
                    case 'S':
                        int bulletX = x;
                        int bulletY = y;
                        while (bulletX != -1) {
                            bulletX += dirX[dir];
                            bulletY += dirY[dir];
                            if (bulletX >= width || bulletX < 0)
                                break;
                            if (bulletY >= height || bulletY < 0)
                                break;

                            switch (map[bulletY][bulletX]) {
                                case '*':
                                    map[bulletY][bulletX] = '.';
                                    bulletX = -1;
                                    break;
                                case '#':
                                    bulletX = -1;
                                    break;
                            }
                        }
                        break;
                }
            }
            System.out.print("#" + test_case + " ");
            for (char[] chars : map) {
                for (char aChar : chars) {
                    System.out.print(aChar);
                }
                System.out.println();
            }

        }
    }
}
