package Tree;

import java.io.*;
import java.util.ArrayList;
import java.util.StringTokenizer;

public class 가장가까운공통조상_3584 {

    static FastReader scan = new FastReader();
    static StringBuilder sb = new StringBuilder();
    static int t,n,a,b,z;
    static int[] par;
    static boolean[] visited;

    static void input(){
        n = scan.nextInt();
        par = new int[n+1];
        visited = new boolean[n+1];
        for(int i = 1; i < n; i++){
            int x = scan.nextInt();
            int y = scan.nextInt();
            par[y] = x;
        }
        a = scan.nextInt();
        b = scan.nextInt();
    }

    static void pro(){
        while(a > 0){
            visited[a] = true;
            a = par[a];
        }

        while(b > 0 && !visited[b]){
            b = par[b];
        }
        System.out.println(b);
    }

    public static void main(String[] args) {
        t = scan.nextInt();
        for(int i = 0; i < t; i++){
            input();
            pro();
        }
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
