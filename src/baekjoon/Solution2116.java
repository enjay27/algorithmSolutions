package baekjoon;

import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

public class Solution2116 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int numberOfDice = sc.nextInt();
        /*
            A - F
            B - D
            C - E
         */
        Map<Integer, Integer> position = new HashMap<>();
        position.put(0, 5);
        position.put(5, 0);
        position.put(1, 3);
        position.put(3, 1);
        position.put(2, 4);
        position.put(4, 2);


    }
}
