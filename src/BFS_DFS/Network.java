package BFS_DFS;

import java.util.LinkedList;
import java.util.Queue;

public class Network {

	public static int solution(int n, int[][] computers) {
        boolean[] visited = new boolean[n];
        int cnt = 1;
        cnt = bfs(0, computers, visited,cnt);

        return cnt;
    }

	public static int bfs(int start, int[][] graph, boolean[] visited, int cnt){
		StringBuilder sb = new StringBuilder();
		Queue<Integer> que = new LinkedList<Integer>();

		que.offer(start);
		visited[start] = true;

		while (!que.isEmpty()){
			int nodeIdx = que.poll();
			sb.append(nodeIdx + "->");

			for(int i=0; i < graph[nodeIdx].length; i++){
				int tmp = graph[nodeIdx][i];
				if(i != nodeIdx && tmp == 1){
					if(!visited[i]){
						visited[i] = true;
						que.offer(i);
					}
				}
			}
		}

		for(int i = 0; i < visited.length; i++){
			if(!visited[i]){
				cnt++;
				cnt = bfs(i, graph, visited,cnt);
			}
		}
		return cnt;
	}
}
