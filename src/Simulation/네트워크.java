package Simulation;

public class 네트워크 {

    private static boolean[] visited;

    public static int solution(int n, int[][] computers) {
        int answer = 0;
        visited = new boolean[n];

        for(int i = 0; i < n; i++){
            if(!visited[i]){
                visited[i] = true;
                dfs(i, n, computers);
                ++answer;
            }
        }

        return answer;
    }

    public static void dfs(int start, int n, int[][] computers){
        for(int i = 0; i < n; i++){
            if(i == start) continue;
            if(computers[start][i] == 0) continue;
            if(visited[i]) continue;
            visited[i] = true;
            dfs(i, n, computers);
        }
    }

    public static void main(String[] args) {
        int n = 3;
        int[][] computers = {{1, 1, 0}, {1, 1, 0}, {0, 0, 1}};
        solution(n, computers);
    }

}
