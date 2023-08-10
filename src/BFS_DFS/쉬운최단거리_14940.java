package BFS_DFS;

import java.io.*;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class 쉬운최단거리_14940 {

    static FastReader scan = new FastReader();
    static int N, M;
    static int[][] arr, dir;
    static int[] start;
    static int[][] dist = {{-1,0}, {0,1}, {1,0}, {0,-1}};

    static void input(){
        N = scan.nextInt();
        M = scan.nextInt();
        arr = new int[N][M];
        dir = new int[N][M];
        start = new int[2];
        for(int i = 0; i < N; i++){
            Arrays.fill(dir[i], -1);
            for(int j = 0; j < M; j++){
                int x = scan.nextInt();
                if(x == 2){
                    start[0] = i;
                    start[1] = j;
                }else if(x == 0){
                    dir[i][j] = 0;
                }
                arr[i][j] = x;
            }
        }
    }

    static void pro(){
        Queue<Integer> queue = new LinkedList<>();
        queue.add(start[0]);
        queue.add(start[1]);
        dir[start[0]][start[1]] = 0;
        while (!queue.isEmpty()){
            int x = queue.poll();
            int y = queue.poll();
            for(int i = 0; i < 4; i++){
                int nx = x + dist[i][0];
                int ny = y + dist[i][1];
                if(nx < 0 || ny < 0 || nx >= N || ny >= M) continue;
                if(arr[nx][ny] == 0) continue;
                if(dir[nx][ny] == -1 || dir[nx][ny] > dir[x][y] + 1){
                    dir[nx][ny] = dir[x][y] + 1;
                    queue.add(nx);
                    queue.add(ny);
                }
            }
        }
        StringBuilder sb = new StringBuilder();
        for(int i = 0; i < N; i++){
            for(int j = 0; j < M; j++){
                sb.append(dir[i][j]).append(" ");
            }
            sb.append('\n');
        }
        System.out.println(sb);
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
