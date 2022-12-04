package BFS_DFS;

import java.io.*;
import java.util.ArrayList;
import java.util.StringTokenizer;

public class 연결요소의개수_11724 {

    static FastReader scan = new FastReader();
    static int n, m;
    static ArrayList<Integer>[] A;
    static boolean[] visited;
    static int cnt;

    public static void input(){
        n = scan.nextInt();
        m = scan.nextInt();
        A = new ArrayList[n+1];
        for(int i = 0; i < n+1; i++){
            A[i] = new ArrayList<Integer>();
        }
        for(int i = 0; i < m; i++){
            int x = scan.nextInt();
            int y = scan.nextInt();
            A[x].add(y);
            A[y].add(x);
        }
    }

    public static void dfs(int start){
        visited[start] = true;
        for(int x : A[start]){
            if(visited[x]){
                continue;
            }
            dfs(x);
        }
    }

    public static void pro(){
        visited = new boolean[n+1];
        cnt = 0;
        for(int i = 1; i < n+1; i++){
            if(!visited[i]){
                dfs(i);
                ++cnt;
            }
        }
        System.out.println(cnt);
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
