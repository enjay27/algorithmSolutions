package recursive;


import java.util.Arrays;
import java.util.Scanner;

public class nextpermutation_조합 {

	
	static int[] arr,sel;
	static int K = 3;
	public static void main(String[] args) {
		arr = new int[] {1,3,5};
		sel = new int[arr.length];
		// 선택배열 뒤 부터 뽑을 갯수만큼 1로 채운다
		for (int i = 0; i < K; i++) {
			sel[sel.length-1-i]=1;
		}
		
		System.out.println(Arrays.toString(sel));
		do {
			for(int i=0; i<sel.length; ++i) {
				if(sel[i]==1) System.out.print(arr[i]+" ");
			}
			System.out.println();
		}while(np(sel));
	}
	
	private static boolean np(int sel[]) {
		int i=sel.length-1;
		while(i>0 && sel[i-1]>=sel[i]) { 
			--i;
		}
		if(i==0) return false;
		
		int j=sel.length-1;
		
		while(sel[i-1]>=sel[j])	--j;
		swap(sel,i-1,j);
		
		int k=sel.length-1;
		while(i<k) {
			swap(sel,i++,k--);			
		}
		return true;
		
	}
	
	private static void swap(int arr[],int i,int j) {
		int tmp = arr[i];
		arr[i] = arr[j];
		arr[j] = tmp;
	}
}
