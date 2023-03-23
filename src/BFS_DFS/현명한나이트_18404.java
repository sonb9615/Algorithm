package BFS_DFS;

import java.io.*;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class 현명한나이트_18404 {

    static FastReader scan = new FastReader();
    static StringBuilder sb = new StringBuilder();
    static int N, M;
    static int[][] arr;
    static int[] knight;
    static int[][] visited;
    static int[][] dist = {{-2,-1}, {-2,1}, {-1,-2}, {-1,2}, {1,-2}, {1,2}, {2,-1}, {2,1}};

    static void pro(){
        input();
        dfs();
        for(int i = 0; i < M; i++){
            sb.append(visited[arr[i][0]][arr[i][1]]).append(' ');
        }
        System.out.println(sb.toString());
    }

    static void input(){
        N = scan.nextInt();
        M = scan.nextInt();
        arr = new int[M][2];
        knight = new int[2];
        knight[0] = scan.nextInt();
        knight[1] = scan.nextInt();
        for(int i = 0; i < M; i++){
            arr[i][0] = scan.nextInt();
            arr[i][1] = scan.nextInt();
        }
    }

    static void dfs(){
        visited = new int[N+1][N+1];
        for(int i = 0; i < M; i++){
            Queue<Integer> queue = new LinkedList<>();
            queue.add(knight[0]);
            queue.add(knight[1]);
            while(!queue.isEmpty()){
                int x = queue.poll();
                int y = queue.poll();
                for(int j = 0; j < 8; j++){
                    int newX = x + dist[j][0];
                    int newY = y + dist[j][1];
                    if(newX <= 0 || newY <= 0 || newX >= N+1 || newY >= N+1) continue;
                    if(visited[newX][newY] > 0) continue;
                    visited[newX][newY] += visited[x][y] + 1;
                    queue.add(newX);
                    queue.add(newY);
                }
            }
        }
    }

    public static void main(String[] args) {
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
