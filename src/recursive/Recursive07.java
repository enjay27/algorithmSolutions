package recursive;

import java.util.Arrays;

public class Recursive07 {
    static int cnt=0;
    // 원본배열
    static int[] arr = {1,3,5};
    // 1,3  : 1,5 : 3,5
    // 담을배열
    static int[] sel = new int[2];
    public static void main(String[] args) {

        combination(0,0);
        //System.out.println(cnt);
    }
    private static void combination(int idx, int k) {
        System.out.println("idx = " + idx);
        System.out.println("k = " + k);
        // base part
        // 담을배열이 다 차면
        if(k==sel.length) {
            System.out.println(Arrays.toString(sel));
            return;
        }
        // 원본배열을 다 봤으면
        if(idx==arr.length) {
            //cnt++;
            //System.out.println(Arrays.toString(sel));
            return;
        }
        // 담는경우
        sel[k]=arr[idx];
        combination(idx+1,k+1);
        // 안담는경우
        combination(idx+1,k);
    }

}