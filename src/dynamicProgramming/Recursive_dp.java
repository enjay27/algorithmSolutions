package dynamicProgramming;

public class Recursive_dp {

    static int[] memo;

    public static void main(String[] args) {
        add(1, 0);
        System.out.println(addReturn(1));
        memo = new int[11];

        System.out.println(addMemo(1));
    }

    private static int addMemo(int curNum) {
        if (curNum > 10) {
            return 0;
        }
        if (memo[curNum] != 0) {
            return memo[curNum];
        }
        memo[curNum] = curNum + addMemo(curNum + 1);
        return memo[curNum];
    }

    private static int addReturn(int curNum) {
        if (curNum > 10) {
            return 0;
        }

        return curNum + addReturn(curNum + 1);
    }

    private static void add(int curNum, int sum) {
        if (curNum > 10) {
            System.out.println(sum);
            return;
        }

        add(curNum + 1, sum + curNum);
    }

}
