package Tree;

import java.io.*;
import java.util.StringTokenizer;

public class 트리순회_1991 {

    static FastReader scan = new FastReader();
    static StringBuilder sb = new StringBuilder();
    static int n;
    static int[][] childes;

    static void input(){
        n = scan.nextInt();
        childes = new int[30][2];
        for(int i = 0; i < n; i++){
            char c = scan.next().charAt(0);
            int cIdx = (int)(c - 'A');
            for(int j = 0; j < 2; j++){
                char ch = scan.next().charAt(0);
                if(ch != '.') childes[cIdx][j] = (int)(ch - 'A');
                else childes[cIdx][j] = -1;
            }
        }
    }

    static void pre_order(int x){
        if(x == -1) return;
        sb.append((char)(x + 'A'));
        pre_order(childes[x][0]);
        pre_order(childes[x][1]);
    }

    static void mid_order(int x){
        if(x == -1) return;
        mid_order(childes[x][0]);
        sb.append((char)(x + 'A'));
        mid_order(childes[x][1]);
    }

    static void fin_order(int x){
        if(x == -1) return;
        fin_order(childes[x][0]);
        fin_order(childes[x][1]);
        sb.append((char)(x + 'A'));
    }

    static void pro(){
        pre_order(0);
        sb.append('\n');
        mid_order(0);
        sb.append('\n');
        fin_order(0);
        sb.append('\n');
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
