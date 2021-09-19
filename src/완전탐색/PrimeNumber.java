package 완전탐색;

import java.util.ArrayList;

public class PrimeNumber {

	private static boolean[] allCaseList = new boolean[10000000];
	private static int answer = 0;
	
	public static int solution(String numbers) {
        
        
        int[] numList = new int[numbers.length()];
        
        
        for(int i = 0; i < numbers.length(); i++) {
        	numList[i] = Integer.parseInt(String.valueOf(numbers.charAt(i)));
        }
        
        for(int i = 1; i < numList.length + 1; i++) {
        	ArrayList<Integer> temp = new ArrayList<Integer>();
        	boolean[] visited = new boolean[numList.length];
        	makePermutation(i, temp, 0, visited, numList);
        }
        
        return answer;
    }
	
	
	private static void makePermutation(int r, ArrayList<Integer> temp, int current, boolean[] visited, int[] arr) {
		if (r == current) {

			String num = "";
			for(int i = 0; i < temp.size(); i++) {
				
				num += temp.get(i);
				
			}
			System.out.println(num);
			System.out.println("=======================");
			
			if(!allCaseList[Integer.parseInt(num)]) {
				allCaseList[Integer.parseInt(num)] = true;
				if(Integer.parseInt(num)>1 && chkPrimeNum(Integer.parseInt(num)) > 0) {
					answer += 1;
				}
			}
			
			
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
	
	
	public static int chkPrimeNum(int num) {
		int rtn = 1;
		
		for(int i = 2; i < num; i++) {
			if(num % i == 0) {
				rtn = 0;
				break;
			}
		}
		
		return rtn;
	}
	public static void main(String[] args) {

		System.out.println(solution("011"));
		
	}

}
