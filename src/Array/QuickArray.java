package Array;

import java.util.Arrays;

public class QuickArray {

	public static void main(String[] args) {

		int[] arr = { 5, 2, 6, 8, 9, 4, 3, 7, 1 };
		System.out.println("---- 정렬전 -----");
		System.out.println(Arrays.toString(arr));
		System.out.println("---- 정렬후 -----");
		quickSort(arr, 0, arr.length - 1);
		System.out.println(Arrays.toString(arr));
		// console
		// ---- 정렬전 -----
		// [5, 2, 6, 8, 9, 4, 3, 7, 1]
		// ---- 정렬후 -----
		// [1, 2, 3, 4, 5, 6, 7, 8, 9]

	}

	public static void quickSort(int[] arr, int s, int e) {
		int start = s; // 시작점 임시변수
		int end = e; // 끝점 임시변수
		int pivot = arr[(s + e) / 2]; // 피벗 변수
		int cnt = 0;
		System.out.println("start : "+s+"/ end : "+e + "/ pivot : " + pivot);

		while (start <= end) { // 시작점이 끝점보다 작거나 같을때까지 반복
			while (arr[start] < pivot) // 앞쪽 배열값이 피벗보다 작으면 뒤로 인덱스 이동
				start++;
			while (arr[end] > pivot) // 뒤쪽 배열값이 피벗보다 크면 앞으로 인덱스 이동
				end--;

			if (start <= end) { // 예외로 한번 확인
				int temp = arr[start]; // 시작점, 끝점 값 swap해주기
				arr[start] = arr[end];
				arr[end] = temp;

				start++; //
				end--;
			}
			System.out.printf(cnt++ + "번 :");
			for(int i : arr) {
				System.out.printf(i + " ");
			}
			System.out.println("");
		}

		// while문이 다돌면 피벗위치가 남는다.

		if (s < start - 1) { // 피벗위치 앞부분 정렬
			quickSort(arr, s, start - 1);
		}
		if (start < e) { // 피벗위치포함 뒷부분 다시 정렬
			quickSort(arr, start, e);
		}
	}
}
