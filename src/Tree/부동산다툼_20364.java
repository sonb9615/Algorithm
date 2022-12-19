package Tree;

import java.io.*;
import java.util.StringTokenizer;

public class 부동산다툼_20364 {

    static FastReader scan = new FastReader();
    static StringBuilder sb = new StringBuilder();
    static int n,q,z;
    static boolean[] visited;
    static int[] A;

    static void input(){
        n = scan.nextInt();
        q = scan.nextInt();
        visited = new boolean[n+1];
        A = new int[q];
        for(int i = 0; i < q; i++){
            A[i] = scan.nextInt();
        }
    }

    static void dfs(int x){
        if(visited[x]){
            z = x;
        }
        if(x/2 > 0) dfs(x/2);
    }

    static void pro(){
        for(int i = 0; i < q; i++){
            z = 0;
            dfs(A[i]);
            if(z == 0) visited[A[i]] = true;
            sb.append(z).append('\n');
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
