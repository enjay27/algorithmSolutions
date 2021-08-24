package baekjoon;

import java.util.Scanner;

public class Solution1038 {

    static boolean isEnd = false;
    static int result = -1;

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
                next = nextDecreasingNumberV2(next + 1);
            }
            System.out.println(next);
        }

    }

    static void backtracking(int searchCount, int curCount, Integer curNumber) {
        if (isEnd) return;

        if (curCount == searchCount) {
            isEnd = true;
            result = curNumber;
            return;
        }

        if (curNumber > 1000000) {
            isEnd = true;
            return;
        }

        int nextNumber = nextDecreasingNumber(curNumber + 1, curNumber.toString().length() - 1);
        backtracking(searchCount, curCount + 1, nextNumber);
    }

    static int nextDecreasingNumber(Integer curNum, int curIndex) {
        String s = curNum.toString();
        if (curIndex == 0) return curNum;

        int next = -1;
        if (curIndex <= s.length() - 1) {
            if (s.charAt(curIndex) < s.charAt(curIndex - 1)) {
                next = nextDecreasingNumber(curNum, curIndex - 1);
            } else {
                int pow = (int) Math.pow(10, s.length() - curIndex);
                curNum = curNum / pow * pow;
                curNum += pow;
                next = nextDecreasingNumber(curNum, curNum.toString().length() - 1);
            }
        }

        return next;
    }

    static int backtrackingV2(Integer curNum, int curIndex) {
        String s = curNum.toString();
        if (curIndex == 0) return -1;

        if (curIndex <= s.length() - 1) {
            if (s.charAt(curIndex) >= s.charAt(curIndex - 1)) {
                return curIndex - 1;
            } else {
                return backtrackingV2(curNum, curIndex - 1);
            }
        }

        return -1;
    }

    static int nextDecreasingNumberV2(Integer curNum) {
        String s = curNum.toString();
        int index = backtrackingV2(curNum, s.length() - 1);
        while (index != -1) {
            int pow = (int) Math.pow(10, s.length() - index - 1);
            curNum = curNum / pow * pow;
            curNum += pow;
            s = curNum.toString();
            index = backtrackingV2(curNum, s.length() - 1);
        }
        return curNum;
    }

}
