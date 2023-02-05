package DynamicPrograming;

import java.io.*;
import java.util.StringTokenizer;

public class 스티커_9465 {

    static FastReader scan = new FastReader();
    static int[][] arr;
    static int[][] dy;
    static int n;

    static void input(){
        n = scan.nextInt();
        arr = new int[2][n+1];
        dy = new int[2][n+1];
        for(int i = 0; i < 2; i++){
            for(int j = 1; j < n+1; j++){
                arr[i][j] = scan.nextInt();
            }
        }
    }

    static void pro(){
        dy[0][1] = arr[0][1];
        dy[1][1] = arr[1][1];
        for(int i = 2; i < n+1; i++){
            dy[0][i] = Math.max(dy[1][i-1], dy[1][i-2]) + arr[0][i];
            dy[1][i] = Math.max(dy[0][i-1], dy[0][i-2]) + arr[1][i];
        }
        System.out.println(Math.max(dy[0][n], dy[1][n]));
    }

    public static void main(String[] args) {
        int T = scan.nextInt();
        while(T-- > 0){
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
