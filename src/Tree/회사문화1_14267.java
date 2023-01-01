package Tree;

import java.io.*;
import java.util.ArrayList;
import java.util.StringTokenizer;

public class 회사문화1_14267 {

    static FastReader scan = new FastReader();
    static int n,m;
    static ArrayList<Integer>[] child;
    static int[] comp;
    static StringBuilder sb = new StringBuilder();

    static void input(){
        n = scan.nextInt();
        m = scan.nextInt();
        child = new ArrayList[n+1];
        comp = new int[n+1];
        for(int i = 1; i < n+1; i++) child[i] = new ArrayList<>();
        for(int i = 1; i < n+1; i++){
            int x = scan.nextInt();
            if(x == -1) continue;
            child[x].add(i);
        }
        for(int i = 0; i < m; i++){
            int x = scan.nextInt();
            int y = scan.nextInt();
            comp[x] += y;
        }
    }

    static void dfs(int idx){
        for(int x : child[idx]){
            comp[x] += comp[idx];
            dfs(x);
        }
    }

    static void pro(){
        dfs(1);
        for(int i = 1; i < n+1; i++){
            sb.append(comp[i]).append(' ');
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
