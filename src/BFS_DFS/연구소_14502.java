package BFS_DFS;

import java.io.*;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

//벽이 3개 모두 세워졌을 때 -> 완전탐색
// 바이러스가 퍼지고 -> dfs
// 이후 방문되지 않고 빈 공간 인 곳의 수가 안전영역의 크기-> bfs

public class 연구소_14502 {

    static FastReader scan = new FastReader();
    static int n,m,b,ans;
    static int[][] A, blanck;
    static boolean[][] visited;
    static int[][] dir = {{1,0},{-1,0},{0,1},{0,-1}};

    static void input(){
        n = scan.nextInt();
        m = scan.nextInt();
        ans = Integer.MIN_VALUE;
        visited = new boolean[n+1][m+1];
        blanck = new int[n*m+1][2];
        A = new int[n+1][m+1];
        for(int i = 1; i < n+1; i++){
            for(int j = 1; j < m+1; j++){
                A[i][j] = scan.nextInt();
            }
        }
    }

    static void bfs(){
        Queue<Integer> queue = new LinkedList<>();
        // 바이러스가 퍼지는 모든 시작 점을 넣고 시작하자
        for(int i = 1; i < n+1; i++){
            for(int j = 1; j < m+1; j++){
                visited[i][j] = false;
                if(A[i][j] == 2){
                    visited[i][j] = true;
                    queue.add(i);
                    queue.add(j);
                }
            }
        }

        while(!queue.isEmpty()){
            int x = queue.poll();
            int y = queue.poll();
            for(int i = 0; i < 4; i++){
                int nx = x + dir[i][0];
                int ny = y + dir[i][1];
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
                }
            }
        }
        ans = Math.max(ans,cnt);
    }

    static void dfs(int idx, int selected_cnt){
        if(selected_cnt == 3){
            bfs();
            return;
        }
        if(idx > b) return;
        //벽을 세우는 경우
        A[blanck[idx][0]][blanck[idx][1]] = 1;
        dfs(idx + 1, selected_cnt + 1);
        //벽을 세우지 않는 경우
        A[blanck[idx][0]][blanck[idx][1]] = 0;
        dfs(idx + 1, selected_cnt);

    }

    static void pro(){
        for(int i = 1; i < n+1; i++){
            for(int j = 1; j < m+1; j++){
                if(A[i][j] == 0){
                    ++b;
                    blanck[b][0] = i;
                    blanck[b][1] = j;
                }
            }
        }
        dfs(1,0);
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
