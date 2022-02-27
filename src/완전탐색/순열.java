package 완전탐색;

import java.util.ArrayList;

public class 순열 {
	
	private static void makePermutation(int r, ArrayList<Integer> temp, int current, boolean[] visited, int[] arr) {
		if (r == current) {

			String num = "";
			for(int i = 0; i < temp.size(); i++) {

				num += temp.get(i);

			}
			System.out.println(num);
			System.out.println("=======================");
			
			
		} else {
 			for (int i = 0; i < arr.length; i++) {
				if (!visited[i]) {
					visited[i] = true;
					temp.add(arr[i]);
					makePermutation(r, temp, current +1, visited, arr);
					temp.remove(temp.size()-1);
					visited[i] = false;
				}
			}
		}
	}

	public static void main(String[] args){

		ArrayList<Integer> temp = new ArrayList<>();
		boolean[] visited = new boolean[3];
		int[] arr = {1,2,3};

		makePermutation(3, temp, 0, visited, arr);
	}
	
}
