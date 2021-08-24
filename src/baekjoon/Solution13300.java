package baekjoon;

import java.util.Scanner;

public class Solution13300 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int numberOfPeople = sc.nextInt();
        int limitPerOneRoom = sc.nextInt();

        int[][] students = new int[6][2];

        for (int i = 0; i < numberOfPeople; i++) {
            int gender = sc.nextInt();
            int grade = sc.nextInt();
            students[grade - 1][gender]++;
        }

        int rooms = 0;
        for (int[] student : students) {
            for (int i : student) {
                rooms += i / limitPerOneRoom;
                if (i % limitPerOneRoom > 0) rooms++;
            }
        }

        System.out.println(rooms);
    }
}
