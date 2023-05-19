package BFS_DFS;

import java.util.Arrays;
import java.util.LinkedList;
import java.util.Queue;

public class 게임맵최단거리 {

    static int[][] dir = {{1,0},{-1,0},{0,1},{0,-1}};
    static boolean[][] visited;
    static int[][] dist;

    public static int solution(int[][] maps) {
        visited = new boolean[maps.length][maps[0].length];
        dist = new int[maps.length][maps[0].length];
        for(int i = 0; i < maps.length; i++){
            Arrays.fill(dist[i], Integer.MAX_VALUE);
        }
        dfs(maps);
        if(dist[maps.length - 1][maps[0].length -1] == Integer.MAX_VALUE) return -1;
        return dist[maps.length - 1][maps[0].length -1];
    }

    public static void dfs(int[][] maps){
        Queue<Integer> queue = new LinkedList<>();
        queue.offer(0);
        queue.offer(0);
        visited[0][0] = true;
        dist[0][0] = 1;

        while(!queue.isEmpty()){
            int startX = queue.poll();
            int startY = queue.poll();
            for(int i = 0; i < 4; i++){
                int newX = startX + dir[i][0];
                int newY = startY + dir[i][1];
                if(newX >= maps[0].length || newY >= maps.length || newX < 0 || newY < 0) continue;
                if(maps[newY][newX] == 0) continue;
                if(visited[newY][newX]) continue;
                dist[newY][newX] = dist[startY][startX] + 1;
                visited[newY][newX] = true;
                queue.offer(newX);
                queue.offer(newY);
            }
        }
    }

    public static void main(String[] args) {
        int[][] maps = {{1,0,1,1,1},{1,0,1,0,1},{1,0,1,1,1},{1,1,1,0,1},{0,0,0,0,1}};
        solution(maps);
    }

}
