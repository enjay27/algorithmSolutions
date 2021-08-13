package recursive;

import java.util.Arrays;

/*
 * PowerSet
 */
public class Recursive13 {
	static int[] arr = { 1, 3, 5, 7, 9 };

	public static void main(String[] args) {
		powerSet(0, 0, new boolean[arr.length]);
	}

	private static void powerSet(int idx, int k, boolean[] sel) {
		if (idx == arr.length) {
			// System.out.println(Arrays.toString(sel));
			//if (k == 3) {
				for (int i = 0; i < sel.length; i++) {
					if (sel[i] == true) {
						System.out.print(arr[i] + " ");
					}
				}
				System.out.println();
			//}
			return;
		}
		// 선택했어요
		sel[idx] = true;
		powerSet(idx + 1, k + 1, sel);
		// 선택안했어요
		sel[idx] = false;
		powerSet(idx + 1, k , sel);
	}

}
