package Programmers_Lvl2;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class 무인도여행 {

    static int[][] adj;
    static boolean[][] visited;
    static List<Integer> ans;
    static int[] dir = {-1, 1};
    static int len, depth, sum;

    public static int[] solution(String[] maps) {

        len = maps[0].length();
        depth = maps.length;
        adj = new int[depth][len];
        visited = new boolean[depth][len];
        ans = new ArrayList<>();
        sum = 0;
        for(int i = 0; i < depth; i++){
            for(int j = 0; j < len; j++){
                if(visited[i][j]) continue;
                dfs(i, j, maps);
                if(sum > 0){
                    ans.add(sum);
                    sum = 0;
                }
            }
        }
        if(ans.size() == 0) ans.add(-1);
        Collections.sort(ans);
        int[] answer = new int[ans.size()];
        for(int i = 0; i < ans.size(); i++){
            answer[i] = ans.get(i);
        }
        return answer;
    }

    public static void dfs(int i, int j, String[] maps){
        visited[i][j] = true;
        char c = maps[i].charAt(j);
        if(c == 'X') return;
        sum += c - '0';
        for(int x = 0; x < 2; x++){
            int nexti = dir[x] + i;
            int nextj = dir[x] + j;
            if(nexti >= 0 && nexti < depth && !visited[nexti][j]) dfs(nexti, j, maps);
            if(nextj >= 0 && nextj < len && !visited[i][nextj]) dfs(i, nextj, maps);
        }
    }

    public static void main(String[] args) {
        String[] maps = {"X591X","X1X5X","X231X", "1XXX1"};
        solution(maps);
    }

}
