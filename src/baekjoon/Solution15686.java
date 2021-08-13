package baekjoon;

import java.awt.Point;
import java.util.*;
import java.util.List;

public class Solution15686 {
    static int number;
    static int size;
    static int minDistance = Integer.MAX_VALUE;
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        size = sc.nextInt();
        number = sc.nextInt();
        List<Point> houses = new ArrayList<>();
        List<Point> stores = new ArrayList<>();

        Map<Point, List<Integer>> distances = new HashMap<>();

        for (int i = 0; i < size; i++) {
            for (int j = 0; j < size; j++) {
                int input = sc.nextInt();
                if (input == 1) {
                    houses.add(new Point(j, i));
                } else if (input == 2) {
                    stores.add(new Point(j, i));
                }
            }
        }

        for (Point store : stores) {
            distances.put(store, new ArrayList<>());
            for (Point house : houses) {
                distances.get(store).add(Math.abs(store.x - house.x) + Math.abs(store.y - house.y));
            }
        }
        int[] ints = new int[houses.size()];
        Arrays.fill(ints, Integer.MAX_VALUE);

        recursive(distances, stores, ints, 0, 0);

        System.out.println(distances);
        System.out.println("minDistance = " + minDistance);
    }

    static void recursive(Map<Point, List<Integer>> distances, List<Point> stores, int[] curDistances, int index, int select) {
        if (select == number) {
            int sum = 0;
            for (int distance : curDistances) {
                sum += distance;
            }
            minDistance = Math.min(sum, minDistance);
            return;
        }

        if (index == distances.size()) {
            return;
        }

        if (index - select > distances.size() - number) {
            return;
        }


        recursive(distances, stores, curDistances, index + 1, select);

        Map<Integer, Integer> restoreValue = new HashMap<>();
        for (int i = 0; i < distances.get(stores.get(index)).size(); i++) {
            if (curDistances[i] > distances.get(stores.get(index)).get(i)) {
                restoreValue.put(i, curDistances[i]);
                curDistances[i] = distances.get(stores.get(index)).get(i);
            }
        }

        recursive(distances, stores, curDistances, index + 1, select + 1);

        for (Integer integer : restoreValue.keySet()) {
            curDistances[integer] = restoreValue.get(integer);
        }
    }

}
