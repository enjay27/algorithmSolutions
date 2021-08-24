package baekjoon;

import java.util.Scanner;

public class Solution1038 {

    static boolean isEnd = false;
    static int result = -1;

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int number = sc.nextInt();

//        backtracking(number, 0, 0);
        int next = 0;
        if (number > 1038) {
            next = -1;
        } else {
            for (int i = 0; i < number; i++) {
                next = nextDecreasingNumber(next + 1, Integer.toString(next).length() - 1);
            }
        }

        System.out.println(next);
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

}
