package baekjoon;

import java.util.LinkedList;
import java.util.List;
import java.util.Scanner;
import java.util.Stack;

public class Solution17143 {
    static int[] moveX = {0, 0, 0, 1, -1};
    static int[] moveY = {0, -1, 1, 0, 0};
    static int height;
    static int width;
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        height = sc.nextInt();
        width = sc.nextInt();
        int sharkNumber = sc.nextInt();

        List<Shark> sharks = new LinkedList<>();
        for (int i = 0; i < sharkNumber; i++) {
            int y = sc.nextInt() - 1;
            int x = sc.nextInt() - 1;
            int speed = sc.nextInt();
            int direction = sc.nextInt();
            int size = sc.nextInt();
            sharks.add(new Shark(x, y, speed, direction, size));
        }
        Shark[][] sharkArray = new Shark[height][width];

        int sizeSum = 0;
        for (int i = 0; i < width; i++) {
            Stack<Shark> needToRemove = new Stack<>();
            for (Shark shark : sharks) {
                if (sharkArray[shark.y][shark.x] == null) {
                    shark.saveToArray(sharkArray);
                } else {
                    if (sharkArray[shark.y][shark.x].size < shark.size) {
                        needToRemove.add(sharkArray[shark.y][shark.x]);
//                        sharks.remove(sharkArray[shark.y][shark.x]);
                        shark.saveToArray(sharkArray);
                    } else {
                        needToRemove.add(shark);
//                        sharks.remove(shark);
                    }
                }
            }
            while (!needToRemove.isEmpty()) {
                Shark pop = needToRemove.pop();
                sharks.remove(pop);
            }
            for (int j = 0; j < height; j++) {
                if (sharkArray[j][i] != null) {
                    sizeSum += sharkArray[j][i].size;
                    sharks.remove(sharkArray[j][i]);
                    sharkArray[j][i] = null;
                    break;
                }
            }
            for (Shark shark : sharks) {
                shark.deleteFromArray(sharkArray);
                shark.move();
            }
        }
        System.out.println(sizeSum);
    }

    static class Shark {
        int x;
        int y;
        int speed;
        int direction;
        int size;

        public Shark(int x, int y, int speed, int direction, int size) {
            this.x = x;
            this.y = y;
            this.speed = speed;
            this.direction = direction;
            this.size = size;
        }

        public void deleteFromArray(Shark[][] sharkArray) {
            sharkArray[y][x] = null;
        }

        public void saveToArray(Shark[][] sharkArray) {
            sharkArray[y][x] = this;
        }

        void move() {
            int movementX = (moveX[direction] * speed) % (2 * width - 2);
            int movementY = (moveY[direction] * speed) % (2 * height - 2);
            x += movementX;
            y += movementY;
            while (x < 0 || x >= width) {
                speed = -speed;
                if (x < 0) {
                    x = -x;
                } else {
                    x = 2 * width - x - 2;
                }
            }
            while (y < 0 || y >= height) {
                speed = -speed;
                if (y < 0) {
                    y = -y;
                } else {
                    y = 2 * height - y - 2;
                }
            }
        }

        @Override
        public String toString() {
            return "Shark{" +
                    "x=" + x +
                    ", y=" + y +
                    ", speed=" + speed +
                    ", direction=" + direction +
                    ", size=" + size +
                    '}';
        }
    }
}
