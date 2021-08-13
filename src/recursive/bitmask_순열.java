package recursive;

import java.util.Arrays;
import java.util.Scanner;
// bitmask 를 이용한 순열
public class bitmask_순열 {

	
	static int[] arr, sel;
	static int cnt;
	public static void main(String[] args) {
		
		arr = new int[] {1,3,5};
		sel = new int[arr.length];
		
		
		permutation(0,0);
		
		System.out.println("총 경우의 수 : "+cnt);
	}

	private static void permutation(int idx, int bit) {
		if(idx == arr.length) {
			cnt++;
			System.out.println(Arrays.toString(sel));
			return;
		}
				
		for(int i=0; i<arr.length; ++i) {
			
			if((bit&1<<i) != 0) continue;
			
			sel[idx] = arr[i];
			permutation(idx+1, bit|1<<i);
		}
	}
}
