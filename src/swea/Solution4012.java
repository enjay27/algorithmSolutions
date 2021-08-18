package swea;

import java.util.*;

public class Solution4012 {
    static int min;
    static int size;
    static boolean[] selected;
    static int[] curDish;
    static int[][] ingredients;

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int test = sc.nextInt();
        for (int tc = 1; tc <= test; tc++) {
            min = Integer.MAX_VALUE;
            size = sc.nextInt();
            selected = new boolean[size];
            curDish = new int[size / 2];
            ingredients = new int[size][size];
            for (int i = 0; i < size; i++) {
                for (int j = 0; j < size; j++) {
                    if (i <= j)
                        ingredients[i][j] += sc.nextInt();
                    else
                        ingredients[j][i] += sc.nextInt();
                }
            }
            combination(0, 0);
            System.out.printf("#%d %d\n", tc, min);
        }
    }

    private static void combination(int curIndex, int select) {
        if (select == size / 2) {

            int dishA = totalSynergy(otherDish());
            int dishB = totalSynergy(curDish);

            min = Math.min(min, Math.abs(dishA - dishB));
            return;
        }

        if (curIndex == size) {
            return;
        }

        combination(curIndex + 1, select);
        curDish[select] = curIndex;
        combination(curIndex + 1, select + 1);
    }

    private static int totalSynergy(int[] dish) {
        int sum = 0;
        for (int i = 0; i < size - 1; i++) {
            boolean isContained = containCheck(dish, i);
            if (isContained) continue;
            for (int j = i + 1; j < size; j++) {
                isContained = false;
                for (int ingredient : dish) {
                    if (ingredient == j) {
                        isContained = true;
                        break;
                    }
                }
                if (isContained) continue;
                sum += ingredients[i][j];
            }
        }
        return sum;
    }

    private static boolean containCheck(int[] otherDish, int i) {
        boolean isContained = false;
        for (int dish : otherDish) {
            if (dish == i) {
                isContained = true;
                break;
            }
        }
        return isContained;
    }

    private static int[] otherDish() {
        int index = 0;
        int[] otherDish = new int[size / 2];
        for (int i = 0; i < size; i++) {
            boolean isContained = false;
            for (int combination : curDish) {
                if (i == combination) {
                    isContained = true;
                    break;
                }
            }
            if (!isContained) {
                otherDish[index] = i;
                index++;
            }
        }
        return otherDish;
    }

}
