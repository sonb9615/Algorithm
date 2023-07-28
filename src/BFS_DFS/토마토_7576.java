package BFS_DFS;

import java.io.*;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class 토마토_7576 {

    static FastReader scan = new FastReader();
    static int N, M, cnt, zeroCnt;
    static int[][] arr, dist;
    static int[][] dir = {{-1,0}, {0,1}, {1,0}, {0,-1}};
    static ArrayList<Box> start;

    static class Box{
        int x, y, dist;
        public Box(int _x, int _y, int _dist){
            this.x = _x;
            this.y = _y;
            this.dist = _dist;
        }
    }

    static void input(){
        M = scan.nextInt();
        N = scan.nextInt();
        cnt = 0;
        arr = new int[N][M];
        dist = new int[N][M];
        start = new ArrayList<>();
        for(int i = 0; i < N; i++){
            for(int j = 0; j < M; j++){
                dist[i][j] = Integer.MAX_VALUE;
                arr[i][j] = scan.nextInt();
                if(arr[i][j] == 1){
                    ++cnt;
                    start.add(new Box(j,i,0));
                    dist[i][j] = 0;
                }
                if(arr[i][j] == -1) ++cnt;
                if(arr[i][j] == 0) ++zeroCnt;
            }
        }
    }

    static void pro(){
        int day = 0;
        Queue<Box> queue = new LinkedList<>();
        for(int i = 0; i < start.size(); i++){
            queue.add(start.get(i));
        }
        while(!queue.isEmpty()){
            Box currBox = queue.poll();
            for(int i = 0; i < 4; i++){
                int ny = currBox.y + dir[i][0];
                int nx = currBox.x + dir[i][1];
                if(ny < 0 || nx < 0 || ny >= N || nx >= M) continue;
                if(arr[ny][nx] == -1) continue;
                if(dist[ny][nx] > currBox.dist + 1){
                    dist[ny][nx] = currBox.dist + 1;
                    --zeroCnt;
                    day = Math.max(day, dist[ny][nx]);
                    queue.add(new Box(nx, ny, dist[ny][nx]));
                }
            }
        }
        if(zeroCnt != 0) System.out.println(-1);
        else System.out.println(day);
    }

    public static void main(String[] args) {
        input();
        if(start.size() == 0) System.out.println(-1);
        else if(cnt == N*M) System.out.println(0);
        else pro();
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
