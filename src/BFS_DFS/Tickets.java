package BFS_DFS;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.PriorityQueue;

public class Tickets {

	public static String[] solution(String[][] tickets) {

		String[] answer = {};
		ArrayList<String> route = new ArrayList<String>();
		String start = "ICN";
		route.add(start);
		boolean[] isVisited = new boolean[tickets.length];

		while(!start.isEmpty()){
			start = nextDes(start, isVisited, tickets, route.size());
			if(!start.isEmpty()) {
				route.add(start);
			}
		}
		
		answer = route.toArray(new String[route.size()]);
		return answer;
	}

	
	public static String nextDes(String start, boolean[] isVisited, String[][] tickets, int cnt){

		class obj{
			String ticket;
			int idx;
			
			public obj(String ticket, int idx) {
				this.ticket = ticket;
				this.idx = idx;
			}
		}
		
		PriorityQueue<obj> pq = new PriorityQueue<obj>(new Comparator<obj>() {

			@Override
			public int compare(obj o1, obj o2) {
				int result = -1;
				
				for(int i = 0 ; i < o1.ticket.length(); i++) {
					if(o1.ticket.charAt(i) < o2.ticket.charAt(i)) {
						result = -1;
						break;
					}else if(o1.ticket.charAt(i) > o2.ticket.charAt(i)) {
						result = 0;
						break;
					}else {
						continue;
					}
				}
				return result;
			}
			
		});
		
		
		for(int i = 0; i < tickets.length; i++){
			if(!isVisited[i] && tickets[i][0].equals(start)){
				// 알파벳 내림차순
				pq.offer(new obj(tickets[i][1],i));
			}
		}
		
		if(pq.size() > 1) {
			// 알파벳 내림차순
			// 스택이 1보다 클때 해당 값으로 dfs하자
			
			String pqs = "";
			while(!pq.isEmpty()) {
				pqs = dfs(pq.peek().ticket, isVisited, tickets);
				if(!pqs.isEmpty()) {
					isVisited[pq.poll().idx] = true;
					break;
				}else {
					pq.poll();
				}
			}
			
			return pqs;
			
		}else if(pq.size() == 1) {
			isVisited[pq.peek().idx] = true;
			return pq.poll().ticket;
		}else {
			return "";
		}
		
	}
	
	//한번이 아니라 진짜 dfs입니다.....
	public static String dfs(String str, boolean[] isVisited, String[][] tickets) {
		
		String result = "";
		
		for(int i = 0; i < tickets.length; i++) {
			if(str.equals(tickets[i][0])) {
				if(!isVisited[i]) {
					result = str;
					break;
				}
			}
		}
		
		return result;
	}
	

	public static void main(String[] args){

//		String[][] tickets = {{"ICN","SFO"},{"ICN","ATL"},{"SFO","ATL"},{"ATL","ICN"},{"ATL","SFO"}};
//		String[][] tickets = {{"ICN","AAA"},{"ICN","AAA"},{"ICN","AAA"},{"AAA","ICN"},{"AAA","ICN"}};
//		String[][] tickets = {{"ICN", "AOO"}, {"AOO", "BOO"}, {"AOO", "BOO"}, {"BOO", "AOO"}, {"BOO", "FOO"}, {"FOO", "COO"}, {"COO", "ZOO"}};
//		String[][] tickets = {{"ICN", "BBB"},{"ICN", "CCC"},{"BBB", "CCC"},{"CCC", "BBB"},{"CCC", "ICN"}};
//		String[][] tickets = {{"ICN", "A"}, {"A", "C"}, {"A", "D"}, {"D", "B"}, {"B", "A"}};
//		String[][] tickets = {{"ICN", "SFO"}, {"ICN", "ATL"}, {"SFO", "ATL"}, {"ATL", "ICN"}, {"ATL", "SFO"}};
		String[][] tickets = {{"ICN", "AOO"}, {"AOO", "BOO"}, {"BOO", "COO"}, {"COO", "DOO"}, {"DOO", "EOO"}, {"EOO", "DOO"}, {"DOO", "COO"}, {"COO", "BOO"}, {"BOO", "AOO"}};
		//"ICN", "ATL", "ICN", "SFO", "ATL", "SFO"
		//["ICN", "SFO"], ["ICN", "ATL"], ["SFO", "ATL"], ["ATL", "ICN"], ["ATL", "SFO"]
		//"ICN", "AOO", "BOO", "AOO", "BOO", "FOO", "COO", "ZOO"
		//['ICN','AAA'],['ICN','AAA'],['ICN','AAA'],['AAA','ICN'],['AAA','ICN']
		//["ICN", "AOO"], ["AOO", "BOO"], ["AOO", "BOO"], ["BOO", "AOO"], ["BOO", "FOO"], ["FOO", "COO"], ["COO", "ZOO"]
		//["ICN", "BBB"],["ICN", "CCC"],["BBB", "CCC"],["CCC", "BBB"],["CCC", "ICN"]
		//"ICN", "BBB", "CCC", "ICN", "CCC", "BBB"
		//["ICN", "A"], ["A", "C"], ["A", "D"], ["D", "B"], ["B", "A"]
		//["ICN", "AOO"], ["AOO", "BOO"], ["BOO", "COO"], ["COO", "DOO"], ["DOO", "EOO"], ["EOO", "DOO"], ["DOO", "COO"], ["COO", "BOO"], ["BOO", "AOO"]
		//["ICN", "AOO", "BOO", "COO", "DOO", "EOO", "DOO", "COO", "BOO", "AOO"]
		String[] result = solution(tickets); 
		for(String str : result) {
			System.out.println(str);
		}

	}

}
