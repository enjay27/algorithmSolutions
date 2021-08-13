package recursive;
// 중복조합
import java.util.Arrays;

public class Recursive12 {

	public static void main(String[] args) {
		int[] arr = {1,3,5,7,9};
		
		combination(arr,new int[3],0,0);

	}

	private static void combination(int[] arr, int[] sel, int idx, int k) {
		if(k==sel.length) {
			// 다골랐어용
			System.out.println(Arrays.toString(sel));
			return;
		}
		
		for (int i = idx; i < arr.length; i++) {
			sel[k]=arr[i];
			combination(arr, sel, i, k+1);
		}
	}

}
