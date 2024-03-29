package Tree;

import java.io.*;
import java.util.ArrayList;
import java.util.StringTokenizer;

public class 나무탈출_15900 {

    static FastReader scan = new FastReader();
    static ArrayList<Integer>[] A;
    static int n, cnt;

    static void input(){
        n = scan.nextInt();
        A = new ArrayList[n+1];
        for(int i = 1; i < n+1; i++) A[i] = new ArrayList<>();
        for(int i = 0; i < n-1; i++){
            int x = scan.nextInt();
            int y = scan.nextInt();
            A[x].add(y);
            A[y].add(x);
        }
    }

    static void dfs(int x, int par, int depth){
        if(x != 1 && A[x].size() == 1) cnt += depth;
        for(int i : A[x]){
            if(i == par) continue;
            dfs(i, x, depth + 1);
        }
    }

    static void pro(){
        dfs(1, -1, 0);
        if(cnt % 2 == 0) System.out.println("No");
        else System.out.println("Yes");
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
