package BFS_DFS;

import java.io.*;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class 연구소_14502 {

    static FastReader scan = new FastReader();
    static int n,m,b,ans;
    static boolean[][] visited;
    static int[][] A, blank;
    static int[][] dir = {{1,0},{-1,0},{0,1},{0,-1}};

    static void input(){
        n = scan.nextInt();
        m = scan.nextInt();
        A = new int[n+1][m+1];
        blank = new int[n*m+1][2];
        visited = new boolean[n+1][m+1];
        ans = Integer.MIN_VALUE;
        for(int i = 1; i < n+1; i++){
            for(int j = 1; j < m+1; j++){
                A[i][j] = scan.nextInt();
            }
        }
    }

    static void bfs(){
        Queue<Integer> queue = new LinkedList<>();

        for(int i = 1; i < n+1; i++){
            for(int j = 1; j < m+1; j++){
                visited[i][j] = false;
                if(A[i][j] == 2){
                    queue.add(i);
                    queue.add(j);
                    visited[i][j] = true;
                }
            }
        }

        while(!queue.isEmpty()){
            int x = queue.poll();
            int y = queue.poll();
            for(int k = 0; k < 4; k++){
                int nx = x + dir[k][0];
                int ny = y + dir[k][1];
                if(nx < 0 || ny < 0 || nx > n || ny > m) continue;
                if(A[nx][ny] != 0) continue;
                if(visited[nx][ny]) continue;
                visited[nx][ny] = true;
                queue.add(nx);
                queue.add(ny);
            }
        }

        int cnt = 0;
        for(int i = 1; i < n+1; i++){
            for(int j = 1; j < m+1; j++){
                if(A[i][j] == 0 && !visited[i][j]){
                    ++cnt;
                    ans = Math.max(ans,cnt);
                }
            }
        }
    }

    // 3개의 벽을 모두 세우는 경우
    static void dfs(int idx, int selected_cnt){
        if(selected_cnt == 3){
            bfs();
            return;
        }
        if(idx > b) return;

        //벽을 세우는 경우
       A[blank[idx][0]][blank[idx][1]] = 1;
        dfs(idx + 1, selected_cnt + 1);

        //벽을 세우지 않는 경우
        A[blank[idx][0]][blank[idx][1]] = 0;
        dfs(idx + 1, selected_cnt);
    }

    static void pro(){
        for(int i = 1; i < n+1; i++){
            for(int j = 1; j < m+1; j++){
                // 빈 공간에 벽을 세울 수 있습니다.
                if(A[i][j] == 0){
                    b++;
                    blank[b][0] = i;
                    blank[b][1] = j;
                }
            }
        }
        dfs(1,0);
    }

    public static void main(String[] args) {
        input();
        pro();
        System.out.println(ans);
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
