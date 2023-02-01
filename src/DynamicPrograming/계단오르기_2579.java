package DynamicPrograming;

import java.io.*;
import java.util.StringTokenizer;

public class 계단오르기_2579 {

    static FastReader scan = new FastReader();
    static int n;
    static int[] arr;
    static int[][] dy;

    static void input(){
        n = scan.nextInt();
        arr = new int[n+1];
        dy = new int[n+1][2];
        for(int i = 1; i < n+1; i++){
            arr[i] = scan.nextInt();
        }
    }

    static void pro(){
        dy[1][0] = arr[1];
        for(int i = 2; i < n+1; i++){
            dy[i][0] = Math.max(dy[i-2][0], dy[i-2][1]) + arr[i];
            dy[i][1] = dy[i-1][0] + arr[i];
        }
        System.out.println(Math.max(dy[n][0], dy[n][1]));
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
