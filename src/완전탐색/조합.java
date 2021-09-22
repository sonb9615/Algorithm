package 완전탐색;

import java.util.Arrays;

public class 조합 {

	private static int[] arr = {1,2,3,4,5};
	
	private static void makeCombination(int r, int[] temp, int current, int start) {
		if (r == current) {
			System.out.println(Arrays.toString(temp));
		} else {
			for (int i = start; i < arr.length; i++) {
				temp[current] = arr[i];
				makeCombination(r, temp, current + 1, i + 1);
			}
		}
	}
}
