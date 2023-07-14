package Tree;

import java.io.*;
import java.util.ArrayList;
import java.util.StringTokenizer;

public class 단절점과단절선_14675 {

    static FastReader scan = new FastReader();
    static int N, q;
    static ArrayList<Integer>[] tree;
    static int[][] Q;
    static void input(){
        N = scan.nextInt();
        tree = new ArrayList[N+1];
        for(int i = 1; i < N+1; i++){
            tree[i] = new ArrayList<>();
        }
        for(int i = 0; i < N-1; i++){
            int x = scan.nextInt();
            int y = scan.nextInt();
            tree[x].add(y);
            tree[y].add(x);
        }
        q = scan.nextInt();
        Q = new int[q][2];
        for(int i = 0; i < q; i++){
            Q[i][0] = scan.nextInt();
            Q[i][1] = scan.nextInt();
        }
    }

    static void func(){
        boolean[] cutVertex = new boolean[N+1];
        for(int i = 1; i < N+1; i++){
            if(tree[i].size() == 1) cutVertex[i] = true;
        }
        for(int i = 0; i < q; i++){
            if(Q[i][0] == 1 && cutVertex[Q[i][1]]) System.out.println("no");
            else System.out.println("yes");
        }
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
