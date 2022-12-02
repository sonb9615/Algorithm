package BFS_DFS;

import java.io.*;
import java.util.ArrayList;
import java.util.Collections;
import java.util.StringTokenizer;

public class 단지번호붙이기_2667 {

    static FastReader scan = new FastReader();
    static StringBuilder sb = new StringBuilder();
    static int n;
    static char[][] A;
    static boolean[][] visited;
    static int houseCnt, allCnt;
    static ArrayList<Integer> ans;

    public static void input(){
        n = scan.nextInt();
        A = new char[n+1][n+1];
        for(int i = 1; i < n+1; i++){
            String str = scan.next();
            int j = 0;
            for(char c : str.toCharArray()){
                A[i][++j] = c;
            }
        }
    }

    public static void dfs(int x, int y){
        ++houseCnt;
        visited[x][y] = true;
        if(y < n && A[x][y+1] == '1' && !visited[x][y+1]){
            dfs(x,y+1);
        }
        if(A[x][y-1] == '1' && !visited[x][y-1]){
            dfs(x,y-1);
        }
        if(x < n && A[x+1][y] == '1' && !visited[x+1][y]){
            dfs(x+1,y);
        }
        if(A[x-1][y] == '1' && !visited[x-1][y]){
            dfs(x-1,y);
        }
    }

    public static void pro(){
        visited = new boolean[n+1][n+1];
        ans = new ArrayList<>();
        for(int i = 1; i < n+1; i++) {
            for (int j = 1; j < n+1; j++) {
                if(A[i][j] == '1' && !visited[i][j]){
                    houseCnt = 0;
                    dfs(i,j);
                    ++allCnt;
                    ans.add(houseCnt);
                }
            }
        }
        Collections.sort(ans);
        sb.append(allCnt).append("\n");
        for(int n : ans){
            sb.append(n).append("\n");
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
