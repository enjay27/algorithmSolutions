package recursive;

import java.util.Arrays;
import java.util.Scanner;
/**
 * @author THKim
 */
public class nextpermutation_순열 {

	static int[] arr;
	static int totalCount;
	public static void main(String[] args) {
		// 1 3 5, 1 5 3, 3 1 5, 3 5 1, 5 1 3, 5 3 1 
		arr = new int[] {1, 3, 5};
		
		// 만들수 있는 가장 작은 순열을 만든다
		Arrays.sort(arr);
		
		do {
			System.out.println(Arrays.toString(arr));
		}while(np(arr));
		
		System.out.println("총 경우의 수 : "+totalCount);
	}

	private static boolean np(int arr[]) {
		totalCount++;
		
		int i=arr.length-1;
		while(i>0 && arr[i-1]>=arr[i]) --i;
		// 꼭지점이 없으면 종료
		if(i==0) return false;
		
		// i 는 꼭지점
		// 뒤에서 부터 꼭지점 까지 검색해서 i-1 큰값이 나오면 정지
		int j=arr.length-1;
		while(arr[i-1]>=arr[j])	--j;
		// i-1 이랑 j 값 교환
		
		System.out.println(Arrays.toString(arr));
		swap(arr,i-1,j);
		System.out.println(Arrays.toString(arr));
		// 1, 2, 4, 5, 3
		
		int k = arr.length-1;
		System.out.println("i="+i+","+"k="+k);
		// 꼭지점이 끝이 아니면 꼭지점 기준으로 오름차순 정렬
		while(i<k) {
			swap(arr,i++,k--);			
		}
		return true;
	}
	
	private static void swap(int arr[],int i,int j) {
		int tmp = arr[i];
		arr[i] = arr[j];
		arr[j] = tmp;
	}
}
