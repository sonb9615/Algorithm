package 최단거리;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class 플로이드_11404 {

    static int N,M;
    static int[][] dist;

    static void input() throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        N = Integer.parseInt(br.readLine());
        M = Integer.parseInt(br.readLine());
        dist = new int[N+1][N+1];
        for(int i = 1; i <= N; i++){
            Arrays.fill(dist[i], Integer.MAX_VALUE);
            dist[i][i] = 0;
        }
        for(int i = 0; i < M; i++){
            StringTokenizer st = new StringTokenizer(br.readLine());
            int from = Integer.parseInt(st.nextToken());
            int to = Integer.parseInt(st.nextToken());
            int val = Integer.parseInt(st.nextToken());
            if(dist[from][to] > val){
                dist[from][to] = val;
            }
        }
    }

    static void pro(){
        StringBuilder sb = new StringBuilder();

        for(int k = 1; k <= N; k++){
            for(int i = 1; i <= N; i++){
                if(dist[i][k] == Integer.MAX_VALUE) continue;
                for(int j = 1; j <= N; j++){
                    if(dist[k][j] == Integer.MAX_VALUE) continue;
                    if(dist[i][j] > dist[i][k] + dist[k][j]){
                        dist[i][j] = dist[i][k] + dist[k][j];
                    }
                }
            }
        }

        for(int i = 1; i <= N; i++){
            for(int j = 1; j <= N; j++){
                if(dist[i][j] == Integer.MAX_VALUE) sb.append(0).append(' ');
                else sb.append(dist[i][j]).append(' ');
            }
            sb.append('\n');
        }

        System.out.println(sb);
    }

    public static void main(String[] args) throws IOException {
        input();
        pro();
    }
}
