package programmers_0910;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

//백준
public class 빗물_14719 {

	static int[] map;
	static int ret, left, right;
	
	public static void main(String[] args) throws IOException {

//		int[] walls = {3, 0, 1, 4};
//		solution(4, 4, walls);
		/*5*/
		
//		int[] walls = {3, 1, 2, 3, 4, 1, 1, 2};
//		solution(4, 8, walls);
		/* 5 */
		
//		int[] walls = {0, 0, 0, 2, 0};
//		solution(3, 5, walls);
		/* 0 */
		
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		int H = Integer.parseInt(st.nextToken());
		int W = Integer.parseInt(st.nextToken());
		map = new int[W];
		ret = left = right = 0;

		st = new StringTokenizer(br.readLine());
		for (int i = 0; i < W; i++) {
			int N = Integer.parseInt(st.nextToken());
			map[i] = N;
		}
		solution(H,W,map);
		

	}

	
	public static void solution(int y, int x, int[] walls) {
		
		int[] amount = new int[walls.length];
		int sum = 0;
		
		for(int i = 0; i < walls.length; i++) {
			amount[i] = y - walls[i];
			sum = sum + amount[i];
		}
		
		
		int cnt = 0;
		int min = y;
		int over = 0;
		for(int i = 0; i < amount.length; i++) {
			
			if(amount[i] < min) {
				over = (cnt * min) + over;
				min = amount[i];
				if(min == 0) {
					cnt = 0;
					min = y;
				}else {
					cnt = 1;
					min = amount[i];
				}
				
			}else {
				cnt++;
				if(i == amount.length-1) {
					over = over + (amount[i]-min)+(cnt*min);
				}
			}
			
		}
		
		System.out.println(sum - over);
		
	}
}
