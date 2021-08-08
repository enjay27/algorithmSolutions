package recursive;

import java.util.Arrays;

/*
 * 순열
 */
public class Recursive10 {
    static int cnt;
    public static void main(String[] args) {
        int[] arr = {1,3,5};
        boolean[] visited= new boolean[arr.length];
        permutation(arr,new int[2],0,visited);
        System.out.println(cnt);
    }

    private static void permutation(int[] arr, int[] sel, int k, boolean[] visited) {
        System.out.print("k : " + k);
        System.out.println(" visited = " + Arrays.toString(visited));
        if(k==sel.length) {
            cnt++;
            // 다골랐어요
            System.out.println(Arrays.toString(sel));
            return;
        }

        for (int i = 0; i < arr.length; i++) {
            // 이미고린것은 pass
            if(!visited[i]) {
                // 고른숫자의 인덱스를 체크
                visited[i]=true;
                // 고른값을 sel 배열에 넣고 다음 인덱스 제귀호출
                sel[k]=arr[i];
                permutation(arr,sel,k+1,visited);
                // 되돌아 가면서 방문배열 원복
                visited[i]=false;
            }
        }
    }
}