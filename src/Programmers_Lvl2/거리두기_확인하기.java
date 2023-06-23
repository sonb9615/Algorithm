package Programmers_Lvl2;

import java.util.LinkedList;
import java.util.Queue;

public class 거리두기_확인하기 {

    public static int[] solution(String[][] places) {
        int[] answer = new int[places.length];
        for(int i = 0; i < 5; i++){
            boolean chk = true;
            for(int j = 0; j < 5 && chk; j++){
                for(int k = 0; k < 5 && chk; k++){
                    if(places[i][j].charAt(k) == 'P'
                            && !dfs(j, k, places[i])) chk = false;
                }
            }
            if(chk) answer[i] = 1;
        }
        return answer;
    }

    public static boolean dfs(int r1, int c1, String[] place){
        Queue<Integer> queue = new LinkedList<>();
        queue.offer(r1);
        queue.offer(c1);
        boolean[][] visited = new boolean[5][5];
        visited[r1][c1] = true;
        int[][] dir = {{1,0},{-1,0},{0,1},{0,-1}};
        while(!queue.isEmpty()){
            int r = queue.poll();
            int c = queue.poll();
            for(int i = 0 ; i < 4; i++){
                int r2 = r + dir[i][0];
                int c2 = c + dir[i][1];
                if(r2 < 0 || c2 < 0 || r2 >= 5 || c2 >= 5) continue;
                if(visited[r2][c2]) continue;
                if(Math.abs(r1-r2) + Math.abs(c1-c2) > 2) continue;
                if(place[r2].charAt(c2) == 'P') return false;
                else if(place[r2].charAt(c2) == 'O'){
                    queue.offer(r2);
                    queue.offer(c2);
                    visited[r2][c2] = true;
                }
            }
        }
        return true;
    }



    public static void main(String[] args) {
        String[][] places = {{"POOOP", "OXXOX", "OPXPX", "OOXOX", "POXXP"}
                , {"POOPX", "OXPXP", "PXXXO", "OXXXO", "OOOPP"}
                , {"PXOPX", "OXOXP", "OXPOX", "OXXOP", "PXPOX"}
                , {"OOOXX", "XOOOX", "OOOXX", "OXOOX", "OOOOO"}
                , {"PXPXP", "XPXPX", "PXPXP", "XPXPX", "PXPXP"}};
        solution(places);
    }
}
