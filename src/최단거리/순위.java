package 최단거리;

public class 순위 {

    public int solution(int n, int[][] results) {
        int answer = 0;
        int[][] graph = new int[n+1][n+1];
        for(int i = 0; i < results.length; i++){
            graph[results[i][0]][results[i][1]] = 1;
        }
        //플로이드 와샬 알고리즘
        for(int i = 1; i <= n; i++){
            for(int j = 1; j <= n; j++){
                for(int k = 1; k <= n; k++){
                    if(graph[j][i] == 1 && graph[i][k] == 1){
                        graph[j][k] = 1;
                    }
                }
            }
        }
        for(int i = 0; i <= n; i++){
            int cnt = 0;
            for(int j = 0; j <= n; j++){
                if(graph[i][j] == 1 || graph[j][i] == 1) ++cnt;
            }
            if(cnt == n-1) ++answer;
        }

        return answer;
    }
}
