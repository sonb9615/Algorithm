package Tree;

import java.io.*;
import java.util.ArrayList;
import java.util.StringTokenizer;

public class 트리와쿼리_15681 {

    static FastReader scan = new FastReader();
    static StringBuilder sb = new StringBuilder();
    static int n,r,q;
    static ArrayList<Integer>[] A;
    static int[] U;

    static void input(){
        n = scan.nextInt();
        r = scan.nextInt();
        q = scan.nextInt();
        A = new ArrayList[n+1];
        U = new int[n+1];
        for(int i = 1; i < n+1; i++) A[i] = new ArrayList<>();
        for(int i = 1; i < n; i++){
            int x = scan.nextInt();
            int y = scan.nextInt();
            A[x].add(y);
            A[y].add(x);
        }
    }

    static void dfs(int x, int par){
        for(int i : A[x]){
            if(i == par) continue;
            if(U[i] > 1) continue;
            dfs(i,x);
            U[x] += U[i];
        }
        ++U[x];
    }

    static void pro(){
        dfs(r, -1);
        for(int i = 0; i < q; i++){
            int x = scan.nextInt();
            sb.append(U[x]).append('\n');
        }
    }

    public static void main(String[] args) {
        input();
        pro();
        System.out.println(sb);
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
