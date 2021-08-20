package baekjoon;

import java.awt.*;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;
import java.util.Stack;

public class Solution15683_withSelection {

    static int[][] office;
    static int[][] selection = {{}, {0}, {0, 2}, {0, 1}, {0, 1, 2}, {0, 1, 2, 3}};
    static int width;
    static int height;
    static List<Camera> cameras = new ArrayList<>();
    static int[] moveX = {0, 1, 0, -1};
    static int[] moveY = {-1, 0, 1, 0};
    static int min = Integer.MAX_VALUE;

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        height = sc.nextInt();
        width = sc.nextInt();

        office = new int[height][width];
        for (int i = 0; i < height; i++) {
            for (int j = 0; j < width; j++) {
                int input = sc.nextInt();
                office[i][j] = input;
                if (input != 0 && input != 6) {
                    cameras.add(new Camera(j, i, input));
                }
            }
        }

        cameras.sort((a, b) -> b.type - a.type);

        dfs(0);

        System.out.println(min);
    }

    static void dfs(int curCamera) {
        if (curCamera == cameras.size()) {
            int areaCount = 0;
            for (int i = 0; i < height; i++) {
                for (int j = 0; j < width; j++) {
                    if (office[i][j] == 0) areaCount++;
                }
            }
            min = Math.min(min, areaCount);
            return;
        }

        Camera camera = cameras.get(curCamera);
        int loop = camera.type == 2 ? 2 : camera.type == 5 ? 1 : 4;

        for (int i = 0; i < loop; i++) {
            camera.direction = i;
            camera.addArea();
            dfs(curCamera + 1);
            camera.removeArea();
        }

    }

    static void writeOneDirection(Stack<Point> dupCheck, int curX, int curY, int direction) {
        direction %= 4;

        curX += moveX[direction];
        curY += moveY[direction];

        if (curX < 0 || curX >= width || curY < 0 || curY >= height) {
            return;
        }
        if (office[curY][curX] == 6) return;

        if (office[curY][curX] == -1) {
            dupCheck.push(new Point(curX, curY));
        } else if (office[curY][curX] == 0) {
            office[curY][curX] = -1;
        }
        writeOneDirection(dupCheck, curX, curY, direction);
    }

    static void removeOneDirection(int curX, int curY, int direction) {
        direction %= 4;

        curX += moveX[direction];
        curY += moveY[direction];

        if (curX < 0 || curX >= width || curY < 0 || curY >= height) {
            return;
        }
        if (office[curY][curX] == 6) return;

        if (office[curY][curX] == -1) {
            office[curY][curX] = 0;
        }

        removeOneDirection(curX, curY, direction);
    }

    static class Camera {
        int x;
        int y;
        int type;
        int direction;
        Stack<Point> dupArea = new Stack<>();

        public Camera(int x, int y, int type) {
            this.x = x;
            this.y = y;
            this.type = type;
        }

        void addArea() {
            for (int increase : selection[type]) {
                writeOneDirection(dupArea, x, y, direction + increase);
            }
        }

        void removeArea() {
            for (int increase : selection[type]) {
                removeOneDirection(x, y, direction + increase);
            }

            while (!dupArea.isEmpty()) {
                Point pop = dupArea.pop();
                office[pop.y][pop.x] = -1;
            }
        }
    }
}
