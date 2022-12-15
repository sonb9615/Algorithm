package BFS_DFS;

import java.io.*;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class 움직이는미로탈출_16954 {

    static FastReader scan = new FastReader();
    static char[][] maze;
    static int[][] dir = {{-1,-1},{-1,0},{-1,1},{0,-1},{0,1},{1,-1},{1,0},{1,1},{0,0}};
    static int[][] dist;
    static boolean[][] visited;
    static int bCnt;

    static void input(){
        dist = new int[8][8];
        maze = new char[8][8];
        visited = new boolean[8][8];
        bCnt = 0;
        for(int i = 0; i < 8; i++){
            String str = scan.nextLine();
            int idx = -1;
            for(char c : str.toCharArray()){
                maze[i][++idx] = c;
                if(c == '#') ++bCnt;
            }
        }
    }

    static void blockMove(){
        char[][] newMaze = new char[8][8];
        bCnt = 0;
        for(int i = 0; i < 8; i++){
            for(int j = 0; j < 8; j++){
                if(newMaze[i][j] != '#') newMaze[i][j] = '.';
                if(i+1 < 8 && maze[i][j] == '#'){
                    newMaze[i+1][j] = '#';
                    bCnt++;
                }
            }
        }
        maze = newMaze;
    }

    static boolean bfs(int i, int j){
        Queue<Integer> queue = new LinkedList<>();
        queue.add(i);
        queue.add(j);

        while(!queue.isEmpty()){
            int cicle = queue.size() / 2;

            for(int cnt = 0; cnt < cicle; cnt++){
                int x = queue.poll();
                int y = queue.poll();
                if(maze[x][y] == '#') continue;
                if(x == 0 && y == 7 || bCnt == 0) return true;
                for(int z = 0; z < 9; z++){
                    int nx = x + dir[z][0];
                    int ny = y + dir[z][1];
                    if(nx < 0 || ny < 0 || nx >= 8 || ny >= 8) continue;
                    if(maze[nx][ny] == '#') continue;
                    if(visited[nx][ny]) continue;
                    queue.add(nx);
                    queue.add(ny);
                    visited[nx][ny] = true;
                    dist[nx][ny] = dist[x][y] + 1;
                }
            }

            if(bCnt > 0) blockMove();

            for(int k = 0; k < 8; k++){
                Arrays.fill(visited[k], false);
            }
        }
        return false;
    }

    static void pro(){
        if(bfs(7,0)) System.out.println(1);
        else System.out.println(0);
    }

    public static void main(String[] args) {
        input();
        pro();
    }

    static class FastReader {
        BufferedReader br;
        StringTokenizer st;

        public FastReader() {
            br = new BufferedReader(new InputStreamReader(System.in));
        }

        public FastReader(String s) throws FileNotFoundException {
            br = new BufferedReader(new FileReader(new File(s)));
        }

        String next() {
            while (st == null || !st.hasMoreElements()) {
                try {
                    st = new StringTokenizer(br.readLine());
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
            return st.nextToken();
        }

        int nextInt() {
            return Integer.parseInt(next());
        }

        long nextLong() {
            return Long.parseLong(next());
        }

        double nextDouble() {
            return Double.parseDouble(next());
        }

        String nextLine() {
            String str = "";
            try {
                str = br.readLine();
            } catch (IOException e) {
                e.printStackTrace();
            }
            return str;
        }
    }
}
