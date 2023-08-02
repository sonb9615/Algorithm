package Simulation;

import java.io.*;
import java.util.*;

public class 치즈_2638 {

    static FastReader scan = new FastReader();
    static int N, M, cnt;
    static int[][] arr;
    static int[][] dir = {{-1,0}, {0,1}, {1,0}, {0,-1}};
    static ArrayList<Cheese> cheeses;
    static boolean[][] visited;

    static class Cheese{
        int r,c;
        public Cheese(int _r, int _c){
            this.r = _r;
            this.c = _c;
        }
    }

    static void input(){
        N = scan.nextInt();
        M = scan.nextInt();
        arr = new int[N][M];
        cheeses = new ArrayList<>();
        for(int i = 0; i < N; i++){
            for(int j = 0; j < M; j++){
                arr[i][j] = scan.nextInt();
                if(arr[i][j] == 1){
                    ++cnt;
                    cheeses.add(new Cheese(i,j));
                }
            }
        }
    }

    static void pro(){
        int answer = 0;
        while(cnt > 0){
            outAir();
            melting();
            ++answer;
        }
        System.out.println(answer);
    }

    static void outAir(){
        visited = new boolean[N][M];
        Queue<Integer> queue = new LinkedList<>();
        queue.add(0);
        queue.add(0);
        visited[0][0] = true;
        arr[0][0] = 2;
        while(!queue.isEmpty()){
            int r = queue.poll();
            int c = queue.poll();
            for(int i = 0; i < 4; i++){
                int nr = r + dir[i][0];
                int nc = c + dir[i][1];
                if(nr < 0 || nc < 0 || nr >= N || nc >= M) continue;
                if(visited[nr][nc]) continue;
                if(arr[nr][nc] == 1) continue;
                arr[nr][nc] = 2;
                queue.add(nr);
                queue.add(nc);
                visited[nr][nc] = true;
            }
        }
    }

    static void melting(){
        for(int i = 0; i < cheeses.size(); i++){
            int count = 0;
            Cheese c = cheeses.get(i);
            for(int k = 0; k < 4; k++){
                int ni = c.r + dir[k][0];
                int nj = c.c + dir[k][1];
                if(ni < 0 || nj < 0 || ni >= N || nj >= M) continue;
                if(arr[ni][nj] == 2) count++;
            }
            if(count >= 2){
                --cnt;
                arr[c.r][c.c] = 0;
                cheeses.remove(i);
                --i;
            }
        }
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
