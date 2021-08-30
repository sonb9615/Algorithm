package BFS_DFS;

import java.util.LinkedList;
import java.util.Queue;

public class BFS {

	public static String bfs(int start, int[][] graph, boolean[] visited){
		StringBuilder sb = new StringBuilder();
		Queue<Integer> que = new LinkedList<Integer>();

		que.offer(start);
		visited[start] = true;

		while (!que.isEmpty()){
			int nodeIdx = que.poll();
			sb.append(nodeIdx + "->");

			for(int i=0; i < graph[nodeIdx].length; i++){
				int tmp = graph[nodeIdx][i];
				if(!visited[tmp]){
					visited[tmp] = true;
					que.offer(tmp);
				}
			}
		}

		return sb.toString();
	}

	public static void main(String[] args){

		int[][] graph = {{}, {2,3,8}, {1,6,8}, {1,5}, {5,7}, {3,4,7}, {2}, {4,5}, {1,2}};
		// 방문처리를 위한 boolean배열 선언
		boolean[] visited = new boolean[9];
		System.out.println(bfs(1, graph, visited));

	}
}
