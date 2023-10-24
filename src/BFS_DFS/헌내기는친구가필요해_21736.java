package BFS_DFS;

import java.io.*;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class 헌내기는친구가필요해_21736 {

    static FastReader scan = new FastReader();
    static int N,M, startX, startY;
    static String[][] map;
    static Queue<Integer> queue;
    static boolean[][] visited;
    static int[][] dir = {{0,1},{1,0},{-1,0},{0,-1}};

    static void input(){
        N = scan.nextInt();
        M = scan.nextInt();
        map = new String[N][M];
        queue = new LinkedList<>();
        visited = new boolean[N][M];
        for(int i = 0; i < N; i++){
            String str = scan.nextLine();
            int j = -1;
            for(char c : str.toCharArray()){
                map[i][++j] = String.valueOf(c);
                if(c == 'I'){
                    queue.add(i);
                    queue.add(j);
                    visited[i][j] = true;
                }
            }
        }
    }

    static void pro(){
        int ans = 0;
        while(!queue.isEmpty()){
            int x = queue.poll();
            int y = queue.poll();
            for(int i = 0; i < 4; i++){
                int newX = x + dir[i][0];
                int newY = y + dir[i][1];
                if(newX < 0 || newY < 0 || newX >= N || newY >= M) continue;
                if(visited[newX][newY]) continue;
                if("X".equals(map[newX][newY])) continue;
                if("P".equals(map[newX][newY])) ++ans;
                visited[newX][newY] = true;
                queue.add(newX);
                queue.add(newY);
            }
        }
        if(ans == 0) System.out.println("TT");
        else System.out.println(ans);
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
