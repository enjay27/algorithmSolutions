package recursive;
// 조합
import java.util.Arrays;

public class Recursive11 {
    static int count = 1;
    public static void main(String[] args) {
        int[] arr = {1,3,5};

        combination(arr,new int[2],0,0);

    }

    private static void combination(int[] arr, int[] sel, int idx, int k) {
        System.out.println("idx = " + idx + " k : " + k);
        count++;
        if(k==sel.length) {
            // 다골랐어용
            System.out.println(Arrays.toString(sel));
            return;
        }

        for (int i = idx; i < arr.length; i++) {
            sel[k]=arr[i];
            combination(arr, sel, i+1, k+1);
        }
    }

}