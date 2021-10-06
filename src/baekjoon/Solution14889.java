package baekjoon;

import java.util.Arrays;
import java.util.Scanner;

public class Solution14889 {

    static int size;
    static int[][] map;
    static boolean[] visited;
    static int[] selected;
    static int[] subSelected;
    static int min = Integer.MAX_VALUE;

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        size = sc.nextInt();

        map = new int[size][size];
        for (int i = 0; i < size; i++) {
            for (int j = 0; j < size; j++) {
                 map[i][j] = sc.nextInt();
            }
        }

        visited = new boolean[size];
        selected = new int[size / 2];
        subSelected = new int[2];

        combination(0, 0, size, size / 2);
        System.out.println(min);
    }

    static void combination(int curIndex, int select, int totalSize, int selectSize) {
        if (select == selectSize) {
            int selectedTeamTotal = subCombination(0, 0, size / 2, selected);
            int[] ints = new int[size / 2];
            int index = 0;
            for (int i = 0; i < size; i++) {
                if (visited[i]) continue;
                ints[index] = i;
                index++;
            }
            int otherTeamTotal = subCombination(0, 0, size / 2, ints);
            min = Math.min(Math.abs(selectedTeamTotal - otherTeamTotal), min);
            return;
        }
        if (curIndex == totalSize) {
            return;
        }

        combination(curIndex + 1, select, totalSize, selectSize);
        selected[select] = curIndex;
        visited[curIndex] = true;
        combination(curIndex + 1, select + 1, totalSize, selectSize);
        visited[curIndex] = false;
    }

    static int subCombination(int curIndex, int select, int totalSize, int[] selected) {
        if (select == 2) {
            return map[subSelected[0]][subSelected[1]] + map[subSelected[1]][subSelected[0]];
        }
        if (curIndex == totalSize) {
            return 0;
        }
        int sub1 = subCombination(curIndex + 1, select, totalSize, selected);
        subSelected[select] = selected[curIndex];
        int sub2 = subCombination(curIndex + 1, select + 1, totalSize, selected);
        return sub1 + sub2;
    }

}
