package BFS_DFS;

public class 체육대회 {
    public int max;
    public int solution(int[][] ability) {
        int answer = 0;
        boolean[] visited = new boolean[ability[0].length];
        boolean[] attempt = new boolean[ability.length];
        max = Integer.MIN_VALUE;
        dfs(visited, attempt,ability, 0, 0);
        answer = max;
        return answer;
    }

    public void dfs(boolean[] visited, boolean[] attempt,int[][] ability, int score, int n){
        if(n == visited.length) {
            max = Integer.max(max, score);
            return;
        }
        for(int i = 0; i < ability.length; i++){
            if(attempt[i]) continue;
            attempt[i] = true;
            visited[n] = true;
            dfs(visited, attempt,ability, score + ability[i][n], n + 1);
            visited[n] = false;
            attempt[i] = false;
        }
    }
}
