package BFS_DFS;

import java.io.*;
import java.util.StringTokenizer;

public class 섬의개수_4963 {

    static FastReader scan = new FastReader();
    static StringBuilder sb = new StringBuilder();
    static int w, h;
    static int[][] A;
    static boolean[][] visited;
    static int[][] dir = {{-1,-1},{-1,0},{-1,1},{0,-1},{0,1},{1,-1},{1,0},{1,1}};
    static boolean status;

    static void input(){
        w = scan.nextInt();
        h = scan.nextInt();
        if(w == 0 && h == 0){
            status = true;
        }else{
            A = new int[h+1][w+1];
            for(int i = 1; i < h+1; i++){
                for(int j = 1; j < w+1; j++){
                    A[i][j] = scan.nextInt();
                }
            }
        }
    }

    static void dfs(int i, int j){
        visited[i][j] = true;
        for(int x = 0; x < 8; x++){
            int nx = dir[x][0] + i;
            int ny = dir[x][1] + j;
            if(nx <= -1 || nx >= h+1 || ny <= -1 || ny >= w+1) continue;
            if(A[nx][ny] == 0) continue;
            if(visited[nx][ny]) continue;
            dfs(nx,ny);
        }
    }

    static void pro(){
        int cnt = 0;
        visited = new boolean[h+1][w+1];
        for(int i = 1; i < h+1; i++){
            for(int j = 1; j < w+1; j++){
                if(A[i][j] == 1 && !visited[i][j]){
                    dfs(i,j);
                    ++cnt;
                }
            }
        }
        sb.append(cnt).append("\n");
    }

    public static void main(String[] args) {
        while(!status){
            input();
            if(!status){
                pro();
            }
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
