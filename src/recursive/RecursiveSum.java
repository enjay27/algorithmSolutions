package recursive;

public class RecursiveSum {
    static int[] arr = {1, 3, 5};
    static int sum = 0, cross = 1;

    public static void main(String[] args) {
        recursive(0, 1);
    }

    private static void recursive(int i, int val) {
        if (i == arr.length) {
            System.out.printf("%d \n", val);
        }

        recursive(i + 1, val + arr[i]);
        recursive(i + 1, val * arr[i]);
    }
}
