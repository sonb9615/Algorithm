package Tree;

import java.io.*;
import java.util.ArrayList;
import java.util.StringTokenizer;

public class 노드사이의거리_1240 {

    static FastReader scan = new FastReader();
    static StringBuilder sb = new StringBuilder();
    static int n,m,sum;
    static int[][] dist;
    static ArrayList<Integer>[] A;
    static int[] node;

    static void input(){
        n = scan.nextInt();
        m = scan.nextInt();
        A = new ArrayList[n+1];
        dist = new int[n+1][n+1];
        for(int i = 1; i < n+1; i++) A[i] = new ArrayList<>();
        for(int i = 1; i < n; i++){
            int x = scan.nextInt();
            int y = scan.nextInt();
            int z = scan.nextInt();
            dist[x][y] = z;
            dist[y][x] = z;
            A[x].add(y);
            A[y].add(x);
        }
        node = new int[m*2];
        for(int i = 0; i < m*2; i++){
            node[i] = scan.nextInt();
        }
    }

    static void dfs(int x, int par, int target, int len){
        if(x == target){
            sum = len;
            return;
        }
        for(int i : A[x]){
            if(i == par) continue;
            dfs(i,x,target,len + dist[i][x]);
        }
    }

    static void pro(){
        for(int i = 0; i < m*2; i++){
            int x = node[i];
            int y = node[++i];
            sum = 0;
            dfs(x,-1, y, 0);
            sb.append(sum).append('\n');
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
