package BFS_DFS;

import java.io.*;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class 미로탐색_2178 {

    static FastReader scan = new FastReader();
    static int n,m;
    static char[][] A;
    static boolean[][] visited;
    static int[][] dir = {{1,0},{-1,0},{0,1},{0,-1}};
    static int[][] dist;

    static void input(){
        n = scan.nextInt();
        m = scan.nextInt();
        visited = new boolean[n+1][m+1];
        dist = new int[n+1][m+1];
        A = new char[n+1][m+1];
        for(int i = 1; i < n+1; i++){
            String str = scan.next();
            int idx = 0;
            for(char c : str.toCharArray()){
                A[i][++idx] = c;
            }
        }
    }

    static void bfs(int i, int j){
        Queue<Integer> queue = new LinkedList<>();
        queue.add(i);
        queue.add(j);
        visited[i][j] = true;
        dist[i][j] = 1;
        while(!queue.isEmpty()){
            int x = queue.poll();
            int y = queue.poll();
            for(int z = 0; z < 4; z++){
                int nx = x + dir[z][0];
                int ny = y + dir[z][1];
                if(nx < 0 || ny < 0 || nx > n || ny > m) continue;
                if(A[nx][ny] != '1') continue;
                if(visited[nx][ny]) continue;
                visited[nx][ny] = true;
                queue.add(nx);
                queue.add(ny);
                dist[nx][ny] = dist[x][y] + 1;
            }
        }
    }

    static void pro(){
        bfs(1,1);
        System.out.println(dist[n][m]);
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
