package BFS_DFS;

import java.io.*;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class 빙산_2573 {

    static FastReader scan = new FastReader();
    static int n,m,ans,cnt;
    static int[][] A, exit;
    static int[][] dir = {{1,0},{-1,0},{0,1},{0,-1}};
    static boolean[][] visited;

    static void input(){
        n = scan.nextInt();
        m = scan.nextInt();
        A = new int[n][m];
        exit = new int[n][m];
        for(int i = 0; i < n; i++){
            for(int j = 0; j < m; j++){
                A[i][j] = scan.nextInt();
            }
        }
    }

    static void bfs(){
        Queue<Integer> queue = new LinkedList<>();
        for(int i = 0; i < n; i++){
            for(int j = 0; j < m; j++){
                exit[i][j] = -1;
                if(A[i][j] != 0){
                    queue.add(i);
                    queue.add(j);
                    exit[i][j] = 0;
                }
            }
        }

        while(!queue.isEmpty()){
            int x = queue.poll();
            int y = queue.poll();
            for(int i = 0; i < 4; i++){
                int nx = x + dir[i][0];
                int ny = y + dir[i][1];
                if(nx < 0 || ny < 0 || nx >= n || ny >= m) continue;
                if(exit[nx][ny] == 0) continue;
                if(A[x][y] - 1 >= 0) --A[x][y];
                exit[nx][ny] = -1;
            }
        }
    }

    static void dfs(int x, int y){
        visited[x][y] = true;
        for(int i = 0; i < 4; i++){
            int nx = x + dir[i][0];
            int ny = y + dir[i][1];
            if(nx < 0 || ny < 0 || nx >= n || ny >= m) continue;
            if(A[nx][ny] == 0) continue;
            if(visited[nx][ny]) continue;
            visited[nx][ny] = true;
            dfs(nx,ny);
        }
    }

    static void pro(){
        out:while(cnt <= 1){
            ++ans;
            cnt = 0;
            bfs();
            visited = new boolean[n][m];
            int zeroCnt = 0;
            for(int i = 1; i < n-1; i++){
                for(int j = 1; j < m-1; j++){
                    if(A[i][j] == 0) ++zeroCnt;
                    if(A[i][j] != 0 && !visited[i][j]){
                        ++cnt;
                        if(cnt > 1) break out;
                        dfs(i,j);
                    }
                }
            }
            if(zeroCnt == (n-2)*(m-2)){
                ans = 0;
                break out;
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
