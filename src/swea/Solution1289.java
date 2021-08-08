package swea;

import java.util.Scanner;

public class Solution1289 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int T;
        T=sc.nextInt();

        for(int test_case = 1; test_case <= T; test_case++)
        {
            String num = sc.next();
            char[] chars = num.toCharArray();
            char curNum = '0';
            int count = 0;
            for (char aChar : chars) {
                if (aChar != curNum) {
                    count++;
                    curNum = aChar;
                }
            }

            System.out.println(count);
        }
    }
}
