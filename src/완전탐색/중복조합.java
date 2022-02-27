package 완전탐색;

import java.util.Arrays;

public class 중복조합 {
	
	private static int[] arr = {1,2,3,4,5};

	private static void makeOverlabCombination(int r, int[] temp, int current, int start) {
		if (r == current) {
			System.out.println(Arrays.toString(temp));
		} else {
			for (int i = start; i < arr.length; i++) {
				temp[current] = arr[i];
				makeOverlabCombination(r, temp, current + 1, i);
			}
		}
	}


	public static void main(String[] args){

		int[] temp = new int[5];

		makeOverlabCombination(5, temp,0,0);

	}
}
