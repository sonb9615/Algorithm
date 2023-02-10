package DynamicPrograming;

import java.io.*;
import java.util.StringTokenizer;

public class 내려가기_2096 {

    static FastReader scan = new FastReader();
    static int N;
    static int[][] adj;
    static int[][] dy;

    static void input(){
        N = scan.nextInt();
        adj = new int[N][3];
        dy = new int[N][6];
        for(int i = 0; i < N; i++){
            int x = scan.nextInt();
            int y = scan.nextInt();
            int z = scan.nextInt();
            adj[i][0] = x;
            adj[i][1] = y;
            adj[i][2] = z;
        }
    }

    static void pro(){
        dy[0][0] = adj[0][0];
        dy[0][1] = adj[0][1];
        dy[0][2] = adj[0][2];
        dy[0][3] = adj[0][0];
        dy[0][4] = adj[0][1];
        dy[0][5] = adj[0][2];
        for(int i = 1; i < N; i++){
            dy[i][0] = Math.max(dy[i-1][0], dy[i-1][1]) + adj[i][0];
            dy[i][1] = Math.max(Math.max(dy[i-1][0], dy[i-1][1]), dy[i-1][2]) + adj[i][1];
            dy[i][2] = Math.max(dy[i-1][1], dy[i-1][2]) + adj[i][2];
            dy[i][3] = Math.min(dy[i-1][3], dy[i-1][4]) + adj[i][0];
            dy[i][4] = Math.min(Math.min(dy[i-1][3], dy[i-1][4]), dy[i-1][5]) + adj[i][1];
            dy[i][5] = Math.min(dy[i-1][4], dy[i-1][5]) + adj[i][2];
        }
        StringBuilder sb = new StringBuilder();
        sb.append(Math.max(Math.max(dy[N-1][0], dy[N-1][1]), dy[N-1][2])).append(' ');
        sb.append(Math.min(Math.min(dy[N-1][3], dy[N-1][4]), dy[N-1][5]));
        System.out.println(sb.toString());
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
