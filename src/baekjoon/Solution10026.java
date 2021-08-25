package baekjoon;

import java.util.*;

public class Solution10026 {
    static char[][] img;
    static int size;
    static boolean[][] normalVisited;
    static boolean[][] blindVisited;
    static int normalCount = 0;
    static int blindCount = 0;
    static int[] moveX = {0, 1, 0, -1};
    static int[] moveY = {-1, 0, 1, 0};

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        size = sc.nextInt();

        normalVisited = new boolean[size][size];
        blindVisited = new boolean[size][size];

        img = new char[size][];

        for (int i = 0; i < size; i++) {
            img[i] = sc.next().toCharArray();
        }

        for (int i = 0; i < size; i++) {
            for (int j = 0; j < size; j++) {
                if (!normalVisited[i][j]) {
                    normalCount++;
                    ArrayList<Character> discriminable = new ArrayList<>();
                    discriminable.add(img[i][j]);
                    tracking(normalVisited, j, i, discriminable);
                }
                if (!blindVisited[i][j]) {
                    blindCount++;
                    List<Character> discriminable;
                    if (img[i][j] == 'R' || img[i][j] == 'G') {
                        discriminable = new ArrayList<>(Arrays.asList('R', 'G'));
                    } else {
                        discriminable = new ArrayList<>(Collections.singletonList(img[i][j]));
                    }
                    tracking(blindVisited, j, i, discriminable);

                }

            }
        }

        System.out.print(normalCount + " " + blindCount);

    }

    static void tracking(boolean[][] visited, int curX, int curY, List<Character> discriminable) {
        if (curX < 0 || curX >= size || curY < 0 || curY >= size) return;

        if (visited[curY][curX]) return;

        if (!discriminable.contains(img[curY][curX])) return;

        visited[curY][curX] = true;

        for (int i = 0; i < 4; i++) {
            tracking(visited, curX + moveX[i], curY + moveY[i], discriminable);
        }

    }
}
