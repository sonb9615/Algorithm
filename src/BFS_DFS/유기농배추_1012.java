package BFS_DFS;

import java.io.*;
import java.util.StringTokenizer;

public class 유기농배추_1012 {

    static FastReader scan = new FastReader();
    static StringBuilder sb = new StringBuilder();
    static int t, m, n, k;
    static int[][] A;
    static boolean[][] visited;
    static int cnt;
    static int[][] dir = {{1,0},{-1,0},{0,1},{0,-1}};

    public static void input(){
        m = scan.nextInt();
        n = scan.nextInt();
        k = scan.nextInt();
        A = new int[m][n];
        for(int i = 0; i < k; i++){
            int y = scan.nextInt();
            int x = scan.nextInt();
            A[y][x] = 1;
        }
    }

    public static void dfs(int i, int j){
        visited[i][j] = true;
        for(int x = 0; x < 4; x++){
            int nx = i + dir[x][0];
            int ny = j + dir[x][1];
            if(nx > -1 && nx < m && ny > -1 && ny < n){
                if(visited[nx][ny]){
                    continue;
                }
                if(A[nx][ny] == 0){
                    continue;
                }
                dfs(nx,ny);
            }
        }
    }

    public static void pro(){
        visited = new boolean[m][n];
        for(int i = 0; i < m; i++){
            for(int j = 0; j < n; j++){
                if(A[i][j] == 1 && !visited[i][j]){
                    dfs(i,j);
                    ++cnt;
                }
            }
        }
        sb.append(cnt).append("\n");
        cnt = 0;
    }

    public static void main(String[] args) {
        t = scan.nextInt();
        for(int i = 0; i < t; i++){
            input();
            pro();
        }
        System.out.println(sb);
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
