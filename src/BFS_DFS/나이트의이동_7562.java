package BFS_DFS;

import java.io.*;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class 나이트의이동_7562 {

    static FastReader scan = new FastReader();
    static StringBuilder sb = new StringBuilder();
    static int l, startX, startY, arriveX, arriveY;
    static boolean[][] visited;
    static int[][] dist;
    static int[][] dir = {{-2,-1},{-2,1},{-1,2},{1,2},{2,1},{2,-1},{1,-2},{-1,-2}};

    static void input(){
        l = scan.nextInt();
        startX = scan.nextInt();
        startY = scan.nextInt();
        arriveX = scan.nextInt();
        arriveY = scan.nextInt();
        visited = new boolean[l][l];
        dist = new int[l][l];
    }

    static void dfs(int i, int j){
        Queue<Integer> queue = new LinkedList<>();
        queue.add(i);
        queue.add(j);
        visited[i][j] = true;
        while (!queue.isEmpty()){
            int x = queue.poll();
            int y = queue.poll();
            for(int idx = 0; idx < 8; idx++){
                int nx = x + dir[idx][0];
                int ny = y + dir[idx][1];
                if(nx < 0 || ny < 0 || nx+1 > l || ny+1 > l) continue;
                if(visited[nx][ny]) continue;
                visited[nx][ny] = true;
                queue.add(nx);
                queue.add(ny);
                dist[nx][ny] = dist[x][y] + 1;
            }
        }
    }

    static void pro(){
        dfs(startX,startY);
    }

    public static void main(String[] args) {
        int T = scan.nextInt();
        for(int i = 0; i < T; i++){
            input();
            pro();
            sb.append(dist[arriveX][arriveY]).append('\n');
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
