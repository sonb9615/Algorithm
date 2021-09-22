package BFS_DFS;

import java.util.ArrayList;
import java.util.Collections;

public class MakeARoute {

	static boolean[] isVisited;
	static ArrayList<String> route;
	
	public static String[] solution(String[][] tickets) {

		
		isVisited = new boolean[tickets.length];
		int cnt = 0;
		route = new ArrayList<String>();
		dfs("ICN","ICN",tickets,cnt);
		Collections.sort(route);
		String[] answer = route.get(0).split("_");
		return answer;
	}
	
	public static void dfs(String start, String next, String[][] tickets, int cnt) {
		if(cnt == tickets.length) {
			route.add(next);
			return;
		}
		
		for(int i = 0; i < tickets.length; i++) {
			if(!isVisited[i] && tickets[i][0].equals(start)) {
				isVisited[i] = true;
				dfs(tickets[i][1], next + "_" + tickets[i][1], tickets, cnt+1);
				isVisited[i] = false;
			}
		}
		
		
		return;
	}
	
	public static void main(String[] args) {

		String[][] tickets = {{"ICN", "SFO"}, {"ICN", "ATL"}, {"SFO", "ATL"}, {"ATL", "ICN"}, {"ATL", "SFO"}};
		String[] result = solution(tickets); 
		for(String str : result) {
			System.out.println(str);
		}
	}

}
