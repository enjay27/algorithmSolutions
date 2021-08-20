package baekjoon;

import java.awt.*;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Solution2580 {

    static int[][] sudoku;
    static boolean[][] visited = new boolean[9][9];

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        sudoku = new int[9][9];

        for (int i = 0; i < 9; i++) {
            for (int j = 0; j < 9; j++) {
                sudoku[i][j] = sc.nextInt();
            }
        }

        for (int i = 0; i < 9; i++) {
            for (int j = 0; j < 9; j++) {
                backtracking(j, i);
            }
        }

        for (int i = 0; i < 9; i++) {
            for (int j = 0; j < 9; j++) {
                System.out.print(sudoku[i][j]);
                if (j != 8) System.out.print(" ");
            }
            System.out.println();
        }
    }

    static List<Point> validate(Point point, int direction) {
        List<Point> result = new ArrayList<>();

        switch (direction) {
            case 0:
                int startX = point.x - point.x % 3;
                int startY = point.y - point.y % 3;
                for (int i = startY; i < startY + 3; i++) {
                    for (int j = startX; j < startX + 3; j++) {
                        if (sudoku[i][j] == 0) {
                            result.add(new Point(j, i, direction));
                        }
                    }
                }
                break;
            case 1:
                for (int i = 0; i < 9; i++) {
                    if (sudoku[i][point.x] == 0) {
                        result.add(new Point(point.x, i, direction));
                    }
                }
                break;
            case 2:
                for (int i = 0; i < 9; i++) {
                    if (sudoku[point.y][i] == 0) {
                        result.add(new Point(i, point.y, direction));
                    }
                }
                break;
        }

        return result;
    }

    static boolean backtracking(int curX, int curY) {

        if (visited[curY][curX]) return false;

        List<Point> uncompleted = new ArrayList<>();
        for (int i = 0; i <= 2; i++) {
            List<Point> validate = validate(new Point(curX, curY, i), i);

            uncompleted.addAll(validate);
        }

        visited[curY][curX] = true;

        for (Point point : uncompleted) {
            backtracking(point.x, point.y);
        }

        for (Point point : uncompleted) {
            completeNumber(point);
        }

        return true;
    }

    static void completeNumber(Point point) {
        if (sudoku[point.y][point.x] != 0) return;

        if (validate(point, point.direction).size() > 1) return;

        boolean[] check = new boolean[10];
        switch (point.direction) {
            case 0:
                int startX = point.x - point.x % 3;
                int startY = point.y - point.y % 3;
                for (int i = startY; i < startY + 3; i++) {
                    for (int j = startX; j < startX + 3; j++) {
                        check[sudoku[i][j]] = true;
                    }
                }
                break;
            case 1:
                for (int i = 0; i < 9; i++) {
                    check[sudoku[i][point.x]] = true;
                }
                break;
            case 2:
                for (int i = 0; i < 9; i++) {
                    check[sudoku[point.y][i]] = true;
                }
                break;
        }
        int number = 0;
        for (int i = 1; i <= 9; i++) {
            if (!check[i]) {
                number = i;
                break;
            }
        }

        sudoku[point.y][point.x] = number;
    }

    static class Point {
        int x;
        int y;
        int direction;

        public Point(int x, int y, int direction) {
            this.x = x;
            this.y = y;
            this.direction = direction;
        }
    }
}
