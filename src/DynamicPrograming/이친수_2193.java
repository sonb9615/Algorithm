package DynamicPrograming;

import java.io.*;
import java.util.StringTokenizer;

public class 이친수_2193 {

    static FastReader scan = new FastReader();
    static int N;
    static long[][] dy;

    static void input(){
        N = scan.nextInt();
        dy = new long[N+1][2];
    }

    static void pro(){
        dy[1][1]= 1;
        for(int i = 2; i < N+1; i++){
            dy[i][0] = dy[i-1][0] + dy[i-1][1];
            dy[i][1] = dy[i-1][0];
        }
        System.out.println(dy[N][0] + dy[N][1]);
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
