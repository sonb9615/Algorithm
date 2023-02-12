package DynamicPrograming;

import java.io.*;
import java.util.StringTokenizer;

public class _1학년_5557 {

    static FastReader scan = new FastReader();
    static int N;
    static int[] arr;
    static int[][] dy;

    static void input(){
        N = scan.nextInt();
        arr = new int[N];
        dy = new int[N][2];
        for(int i = 0; i < N; i++){
            arr[i] = scan.nextInt();
        }
    }

    static void pro(){

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
