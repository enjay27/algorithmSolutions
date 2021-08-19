package swea;

import java.awt.Point;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Scanner;

public class Solution1247 {
    static Point[] customers;
    static Point office;
    static Point home;
    static boolean[] visited;
    static int customerNumber;
    static int minDistance;
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int test = sc.nextInt();

        for (int tc = 1; tc <= test; tc++) {
            customerNumber = sc.nextInt();
            minDistance = Integer.MAX_VALUE;
            office = new Point(sc.nextInt(), sc.nextInt());
            home = new Point(sc.nextInt(), sc.nextInt());

            customers = new Point[customerNumber];
            for (int i = 0; i < customerNumber; i++) {
                customers[i] = new Point(sc.nextInt(), sc.nextInt());
            }

            visited = new boolean[customerNumber];

            tracking(0, 0, 0);
            System.out.printf("#%d %d\n", tc, minDistance);
        }
    }

    static void tracking(int select, int index, int curDistance) {
        if (select == customerNumber) {
            curDistance += distance(home, customers[index]);
            minDistance = Math.min(minDistance, curDistance);
            return;
        }

        if (minDistance < curDistance) {
            return;
        }

        for (int i = 0; i < customerNumber; i++) {
            if (visited[i]) continue;

            visited[i] = true;
            int increase;
            if (select == 0) {
                increase = distance(office, customers[i]);
            } else {
                increase = distance(customers[index], customers[i]);
            }
            tracking(select + 1, i, curDistance + increase);
            visited[i] = false;
        }
    }

    static int distance(Point p1, Point p2) {
        return Math.abs(p1.x - p2.x) + Math.abs(p1.y - p2.y);
    }
}
