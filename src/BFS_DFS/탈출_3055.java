package BFS_DFS;

import java.io.*;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class 탈출_3055 {

    static FastReader scan = new FastReader();
    static int r,c, dx, dy, sx, sy;
    static char[][] A;
    static boolean[][] visited;
    static int[][] dir = {{1,0},{-1,0},{0,1},{0,-1}};
    static int[][] distW, distK;

    static void input(){
        r = scan.nextInt();
        c = scan.nextInt();
        A = new char[r+1][c+1];
        distK = new int[r+1][c+1];
        distW = new int[r+1][c+1];
        for(int i = 1; i < r + 1; i++){
            String str = scan.next();
            int idx = 0;
            for(char c : str.toCharArray()){
                A[i][++idx] = c;
                if(c == 'D'){
                    dx = i;
                    dy = idx;
                }
                if(c == 'S'){
                    sx = i;
                    sy = idx;
                }
            }
        }
    }

    static void bfs(int i, int j, char target){
        visited = new boolean[r+1][c+1];
        Queue<Integer> queue = new LinkedList<>();
        if(target == '*'){
            for(int a = 1; a < r+1; a++){
                for(int b = 1; b < c+1; b++){
                    visited[a][b] = false;
                    distW[a][b] = -1;
                    if(A[a][b] == '*'){
                        queue.add(a);
                        queue.add(b);
                        distW[a][b] = 0;
                        visited[a][b] = true;
                    }
                }
            }
        }else{
            queue.add(i);
            queue.add(j);
            visited[i][j] = true;
        }

        while(!queue.isEmpty()){
            int x = queue.poll();
            int y = queue.poll();
            for(int idx = 0; idx < 4; idx++){
                int nx = x + dir[idx][0];
                int ny = y + dir[idx][1];
                if(nx < 0 || ny < 0 || nx > r || ny > c) continue;
                if(visited[nx][ny]) continue;
                if(target == '*' && A[nx][ny] != '.') continue;
                if(target == 'S' && A[nx][ny] != '.' && A[nx][ny] != 'D') continue;
                if(target == 'S' && distW[nx][ny] != -1 && distK[x][y] + 1 >= distW[nx][ny]) continue;
                visited[nx][ny] = true;
                if(target == '*'){
                    distW[nx][ny] = distW[x][y] + 1;
                }else{
                    distK[nx][ny] = distK[x][y] + 1;
                }
                queue.add(nx);
                queue.add(ny);
            }
        }
    }

    static void pro(){
        bfs(0,0, '*');
        bfs(sx,sy, 'S');
        if(distK[dx][dy] == 0){
            System.out.println("KAKTUS");
        }else{
            System.out.println(distK[dx][dy]);
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
