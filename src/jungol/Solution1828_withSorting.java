package jungol;

import java.util.Arrays;
import java.util.Scanner;

class Chemical implements Comparable<Chemical> {
    int low;
    int high;

    public Chemical(int low, int high) {
        this.low = low;
        this.high = high;
    }

    @Override
    public int compareTo(Chemical o) {
        return Integer.compare(this.high, o.high);
    }

    @Override
    public String toString() {
        return "Chemical{" +
                "low=" + low +
                ", high=" + high +
                '}';
    }
}

public class Solution1828_withSorting {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int number = sc.nextInt();

        Chemical[] chemicals = new Chemical[number];
        for (int i = 0; i < number; i++) {
            chemicals[i] = new Chemical(sc.nextInt(), sc.nextInt());
        }
        Arrays.sort(chemicals);

        int cnt = 1;
        int tmp = chemicals[0].high;
        for (int i = 0; i < number; i++) {
            if (tmp < chemicals[i].low) {
                cnt++;
                tmp = chemicals[i].high;
            }
        }
        System.out.println(cnt);
    }
}
