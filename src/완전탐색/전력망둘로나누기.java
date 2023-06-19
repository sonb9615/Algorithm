package 완전탐색;

import java.util.LinkedList;
import java.util.Queue;

public class 전력망둘로나누기 {

    static int[][] arr;

    public static int solution(int n, int[][] wires) {
        int answer = Integer.MAX_VALUE;
        arr = new int[n+1][n+1];
        for(int[] wire : wires){
            arr[wire[0]][wire[1]] = 1;
            arr[wire[1]][wire[0]] = 1;
        }

        int idx = 0;
        for(int[] wire : wires){
            arr[wire[0]][wire[1]] = 0;
            arr[wire[1]][wire[0]] = 0;
            answer = Math.min(answer, dfs(++idx, n));
            arr[wire[0]][wire[1]] = 1;
            arr[wire[1]][wire[0]] = 1;
        }

        return answer;
    }

    public static int dfs(int start, int n){
        Queue<Integer> queue = new LinkedList<>();
        queue.offer(start);
        boolean[] visit = new boolean[n+1];
        int cnt = 1;
        while (!queue.isEmpty()){
            int par = queue.poll();
            visit[par] = true;
            for(int i = 1; i < n+1; i++){
                if(visit[i]) continue;
                if(arr[par][i] != 1) continue;
                queue.add(i);
                ++cnt;
            }
        }
        return Math.abs(n - cnt*2);
    }
}
