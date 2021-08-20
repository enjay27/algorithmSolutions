package baekjoon;

import java.awt.*;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Solution2580_backtracking {

    static int[][] sudoku;
    static boolean isPrinted = false;
    static boolean[][] visited = new boolean[9][9];
    static List<Point> uncompleted = new ArrayList<>();

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        sudoku = new int[9][9];

        for (int i = 0; i < 9; i++) {
            for (int j = 0; j < 9; j++) {
                int input = sc.nextInt();
                sudoku[i][j] = input;
                if (input == 0) {
                    uncompleted.add(new Point(j, i));
                }
            }
        }

        backtracking(0);
    }

    static void backtracking(int curIndex) {
        if (isPrinted) return;

        if (curIndex == uncompleted.size()) {
            for (int i = 0; i < 9; i++) {
                for (int j = 0; j < 9; j++) {
                    System.out.print(sudoku[i][j]);
                    if (j != 8) System.out.print(" ");
                }
                System.out.println();
            }
            for (Point point : uncompleted) {
                System.out.print(sudoku[point.y][point.x]);
            }
            System.out.println();
            isPrinted = true;
            return;
        }

        Point curPoint = uncompleted.get(curIndex);
        for (int i = 1; i <= 9; i++) {
            boolean isValidateNumber = true;
            for (int j = 0; j < 3; j++) {
                isValidateNumber = validate(curPoint, i);
                if (!isValidateNumber) break;
            }
            if (!isValidateNumber) continue;
            sudoku[curPoint.y][curPoint.x] = i;
            backtracking(curIndex + 1);
            sudoku[curPoint.y][curPoint.x] = 0;
        }
    }

    static boolean validate(Point point, int number) {

        int startX = point.x - point.x % 3;
        int startY = point.y - point.y % 3;
        for (int i = startY; i < startY + 3; i++) {
            for (int j = startX; j < startX + 3; j++) {
                if (i == point.y && j == point.x) continue;
                if (sudoku[i][j] == number) return false;
            }
        }
        for (int i = 0; i < 9; i++) {
            if (i == point.y) continue;
            if (sudoku[i][point.x] == number) return false;
        }
        for (int i = 0; i < 9; i++) {
            if (i == point.x) continue;
            if (sudoku[point.y][i] == number) return false;
        }

        return true;
    }

}
