package BFS_DFS;

import java.io.*;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class 토마토_7569 {

    static FastReader scan = new FastReader();
    static int n,m,h;
    static int[][][] A,dist;
    static int[][] dir = {{1,0,0},{-1,0,0},{0,1,0},{0,-1,0},{0,0,1},{0,0,-1}};

    static void input(){
        m = scan.nextInt();
        n = scan.nextInt();
        h = scan.nextInt();
        A = new int[h][n][m];
        dist = new int[h][n][m];

        for(int k = 0; k < h; k++){
            for(int i = 0; i < n; i++){
                for(int j = 0; j < m; j++){
                    A[k][i][j] = scan.nextInt();
                }
            }
        }
    }

    static void bfs(){
        Queue<Integer> queue = new LinkedList<>();
        for(int k = 0; k < h; k++){
            for(int i = 0; i < n; i++){
                for(int j = 0; j < m; j++){
                    dist[k][i][j] = -1;
                    if(A[k][i][j] == 1){
                        queue.add(i);
                        queue.add(j);
                        queue.add(k);
                        dist[k][i][j] = 0;
                    }
                }
            }
        }

        while(!queue.isEmpty()){
            int x = queue.poll();
            int y = queue.poll();
            int z = queue.poll();
            for(int i = 0; i < 6; i++){
                int nx = x + dir[i][0];
                int ny = y + dir[i][1];
                int nz = z + dir[i][2];
                if(nx < 0 || ny < 0|| nz < 0 || nx >= n || ny >= m || nz >= h) continue;
                if(dist[nz][nx][ny] != -1) continue;
                if(A[nz][nx][ny] == -1) continue;
                queue.add(nx);
                queue.add(ny);
                queue.add(nz);
                dist[nz][nx][ny] = dist[z][x][y] + 1;
            }
        }
    }

    static void pro(){
        bfs();
        int ans = 0;
        for(int k = 0; k < h; k++){
            for(int i = 0; i < n; i++){
                for(int j = 0; j < m; j++){
                    if(A[k][i][j] == -1) continue;
                    if(dist[k][i][j] == -1){
                        System.out.println(-1);
                        return;
                    }
                    ans = Math.max(ans, dist[k][i][j]);
                }
            }
        }
        System.out.println(ans);
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
