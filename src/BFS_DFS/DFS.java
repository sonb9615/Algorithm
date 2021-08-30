package BFS_DFS;

public class DFS {

	// 방문처리에 사용 할 배열선언
	static boolean[] vistied = new boolean[9];
	// 그림예시 그래프의 연결상태를 2차원 배열로 표현
	// 인덱스가 각각의 노드번호가 될 수 있게 0번인덱스는 아무것도 없는 상태라고 생각하시면됩니다.
	static int[][] graph = {{}, {2,3,8}, {1,6,8}, {1,5}, {5,7}, {3,4,7}, {2}, {4,5}, {1,2}};


	static void dfs(int nodeIdx) {
		vistied[nodeIdx] = true;
		
		System.out.println(nodeIdx + "->");
		
		for(int node : graph[nodeIdx]) {
			if(!vistied[node]) {
				dfs(node);
			}
		}
	}
	
	public static void main(String[] args) {
		dfs(1);
	}
}
