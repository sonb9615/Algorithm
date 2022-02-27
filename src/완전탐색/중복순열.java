package 완전탐색;

import java.util.Arrays;

public class 중복순열 {

	private static void makeOverlabPermutation(int r, int[] temp, int current, int[] arr) {
		if (r == current) {
			System.out.println(Arrays.toString(temp));
		} else {
			for (int i = 0; i < arr.length; i++) {
				temp[current] = arr[i];
				makeOverlabPermutation(r, temp, current + 1, arr);
			}
		}
	}

	public static void main(String[] args){
		int[] temp = new int[5];
		int[] arr = {1,2,3,4,5};
		makeOverlabPermutation(5, temp,0,arr);
	}
}
