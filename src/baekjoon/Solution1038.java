package baekjoon;

import java.util.Scanner;

public class Solution1038 {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int number = sc.nextInt();

        //1021 : 987654321
        //1022 : 9876543210
        int next = 0;
        if (number == 1022) {
            System.out.println("9876543210");
        } else if (number > 1022) {
            System.out.println(-1);
        } else {
            for (int i = 0; i < number; i++) {
                next = nextDecreasingNumber(next + 1);
            }
            System.out.println(next);
        }

    }

    static int backtracking(Integer curNum, int curIndex) {
        if (curIndex == 0) return -1;

        String s = curNum.toString();

        if (curIndex <= s.length() - 1) {
            if (s.charAt(curIndex) >= s.charAt(curIndex - 1)) {
                return curIndex - 1;
            } else {
                return backtracking(curNum, curIndex - 1);
            }
        }

        return -1;
    }

    static int nextDecreasingNumber(Integer curNum) {
        String s = curNum.toString();

        int index = backtracking(curNum, s.length() - 1);

        while (index != -1) {
            int pow = (int) Math.pow(10, s.length() - index - 1);
            curNum = curNum / pow * pow;
            curNum += pow;
            s = curNum.toString();
            index = backtracking(curNum, s.length() - 1);
        }
        return curNum;
    }

}
