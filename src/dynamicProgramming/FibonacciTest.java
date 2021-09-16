package dynamicProgramming;

import java.util.Scanner;

public class FibonacciTest {
    static long totalCount1, totalCount2;
    static long[] call1, call2, memo;

    private static long fibonacci1(int n) {
        totalCount1++;
        call1[n]++;
        if (n < 2) return n;
        return fibonacci1(n-1) + fibonacci1(n - 2);
    }

    private static long fibonacci2(int n) {
        totalCount2++;
        call2[n]++;
        if (n >= 2 && memo[n] == 0) {
            memo[n] = fibonacci2(n - 1) + fibonacci2(n - 2);
        }
        return memo[n];
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int N = sc.nextInt();

        call1 = new long[N + 1];
        call2 = new long[N + 1];
        memo = new long[N + 1];

        memo[0] = 0;
        memo[1] = 1;

        System.out.println(fibonacci2(N));
        for (int i = 0; i <= N; i++) {
            System.out.println("fibo2(" + i + ") : " + call2[i]);
        }
        System.out.println("fibo2 callcount : " + totalCount2);

        System.out.println(fibonacci1(N));
        for (int i = 0; i <= N; i++) {
            System.out.println("fibo1(" + i + ") : " + call1[i]);
        }
        System.out.println("fibo1 callcount : " + totalCount1);


    }
}
