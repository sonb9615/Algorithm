package Programmers_Lvl2;

public class 게임맵최단거리 {

    public static int[][] dist = {{-1,0}, {1,0}, {0,-1}, {0,1}};
    public static int min = Integer.MAX_VALUE;

    public static int solution(int[][] maps) {
        int answer = 0;
        boolean[][] visited = new boolean[maps.length][maps[0].length];
        visited[0][0] = true;
        dfs(0,0, maps, 1, visited);
        if(min == Integer.MAX_VALUE) min = -1;
        return min;
    }

    public static void dfs(int x, int y, int[][] maps, int sum, boolean[][] visited){
        int n = maps.length;
        int m = maps[0].length;
        if(x == n-1 && y == m-1){
            min = Integer.min(min, sum);
            return;
        }
        for(int i = 0; i < 4; i++){
            int newX = x + dist[i][0];
            int newY = y + dist[i][1];
            if(newX < 0 || newY < 0 || newX >= n || newY >= m) continue;
            if(maps[newX][newY] == 0) continue;
            if(visited[newX][newY]) continue;
            visited[newX][newY] = true;
            dfs(newX, newY, maps,sum+1, visited);
            visited[newX][newY] = false;
        }
    }

    public static void main(String[] args) {
        int[][] maps = {{1, 0, 1, 1, 1}, {1, 0, 1, 0, 1}, {1, 0, 1, 1, 1}, {1, 1, 1, 0, 1}, {0, 0, 0, 0, 1}};
        solution(maps);
    }
}
