package swea;

import java.util.Scanner;

public class Solution5550 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        final int test = sc.nextInt();
        for (int tc = 1; tc <= test; tc++) {

            char[] cry = {'c', 'r', 'o', 'a', 'k'};
            int[] frogs = new int[1000];
            int number = 0;
            final char[] chars = sc.next().toCharArray();
            for (char aChar : chars) {
                boolean isFrog = false;
                if (aChar == 'c') {
                    boolean isCounted = false;
                    isFrog = true;
                    for (int i = 0; i < number; i++) {
                        if (frogs[i] % 5 == 0) {
                            frogs[i]++;
                            isCounted = true;
                            break;
                        }
                    }
                    if (!isCounted) {
                        frogs[number]++;
                        number++;
                    }
                } else if (aChar == 'r') {
                    for (int i = 0; i < number; i++) {
                        if (frogs[i] % 5 == 1) {
                            frogs[i]++;
                            isFrog = true;
                            break;
                        }
                    }
                } else if (aChar == 'o') {
                    for (int i = 0; i < number; i++) {
                        if (frogs[i] % 5 == 2) {
                            frogs[i]++;
                            isFrog = true;
                            break;
                        }
                    }
                } else if (aChar == 'a') {
                    for (int i = 0; i < number; i++) {
                        if (frogs[i] % 5 == 3) {
                            frogs[i]++;
                            isFrog = true;
                            break;
                        }
                    }
                } else if (aChar == 'k') {
                    for (int i = 0; i < number; i++) {
                        if (frogs[i] % 5 == 4) {
                            frogs[i]++;
                            isFrog = true;
                            break;
                        }
                    }
                }
                if (!isFrog) {
                    number = -1;
                    break;
                }
            }
            for (int i = 0; i < number; i++) {
                if (frogs[i] % 5 != 0) {
                    number = -1;
                    break;
                }
            }
            System.out.printf("#%d %d\n", tc, number);
        }

    }
}