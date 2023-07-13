package Simulation;

import java.io.*;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class 마법사_상어와_파이어스톰_20058 {

    static FastReader scan = new FastReader();
    static int N, Q, n;
    static int[][] map, temp;
    static int[] level;
    static int[][] dir = {{0,1},{1,0},{0,-1},{-1,0}};
    static boolean[][] visited;

    static void input(){
        N = scan.nextInt();
        Q = scan.nextInt();
        n = (int) Math.pow(2,N);
        map = new int[n][n];
        level = new int[Q];
        visited = new boolean[n][n];
        for(int i = 0; i < n; i++){
            for(int j = 0; j < n; j++){
                map[i][j] = scan.nextInt();
            }
        }
        for(int i = 0; i < Q; i++) {
            level[i] = scan.nextInt();
        }
    }

    static void func(){
        temp = new int[n][n];
        for(int i = 0; i < level.length; i++){
            int L = (int) Math.pow(2, level[i]);
            for(int j = 0; j < n; j += L){
                for(int k = 0; k < n; k += L){
                    rotate(L, j, k);
                }
            }
            for(int j = 0; j < n; j++){
                System.arraycopy(temp[j],0, map[j], 0, n);
            }
            decreaseIce();
        }
        int totalIceCnt = 0;
        int maxLandCnt = 0;
        for(int i = 0; i < n; i++){
            for(int j = 0; j < n; j++){
                if(map[i][j] == 0) continue;
                totalIceCnt += map[i][j];
                if(visited[i][j]) continue;
                maxLandCnt = Math.max(maxLandCnt, findLand(i,j));
            }
        }
        System.out.println(totalIceCnt);
        System.out.println(maxLandCnt);
    }

    static void rotate(int L, int r, int c){
        for(int i = 0; i < L; i++){
            for(int j = 0; j < L; j++){
                temp[r + j][c + L - i -1] = map[r + i][c + j];
            }
        }
    }

    public static void decreaseIce(){
        for(int i = 0; i < n; i++){
            for(int j = 0; j < n; j++){
                int iceCnt = 0;
                if(map[i][j] == 0) continue;
                for(int k = 0; k < 4; k++){
                    int ny = i + dir[k][0];
                    int nx = j + dir[k][1];
                    if(ny >= 0 && nx >= 0 && ny < n && nx < n && temp[ny][nx] > 0){
                        ++iceCnt;
                    }
                }
                if(iceCnt < 3) --map[i][j];
            }
        }
    }

    static int findLand(int startR, int startC){
        Queue<Integer> queue = new LinkedList<>();
        queue.add(startR);
        queue.add(startC);
        visited[startR][startC] = true;
        int cnt = 1;
        while (!queue.isEmpty()){
            int r = queue.poll();
            int c = queue.poll();
            for(int i = 0; i < 4; i++){
                int nr = r + dir[i][0];
                int nc = c + dir[i][1];
                if(nr >= 0 && nc >= 0 && nr < n && nc < n
                        && !visited[nr][nc] && map[nr][nc] > 0){
                    visited[nr][nc] = true;
                    queue.add(nr);
                    queue.add(nc);
                    ++cnt;
                }
            }
        }
        return cnt;
    }


    public static void main(String[] args) {
        input();
        func();
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
