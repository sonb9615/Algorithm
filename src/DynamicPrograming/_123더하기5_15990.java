package DynamicPrograming;

import java.io.*;
import java.util.StringTokenizer;

public class _123더하기5_15990 {

    static FastReader scan = new FastReader();
    static int T;
    static int[] arr;
    static long[][] dy;
    static StringBuilder sb = new StringBuilder();

    static void input(){
        T = scan.nextInt();
        arr = new int[T];
        dy = new long[100001][4];
        for(int i = 0; i < T; i++) arr[i] = scan.nextInt();
    }

    static void pro(){

        //마지막 더해진 수에 따라 각각 1,2,3에 저장
        dy[1][1] = 1;
        dy[2][2] = 1;
        dy[3][1] = 1;
        dy[3][2] = 1;
        dy[3][3] = 1;
        int mod = 1000000009;
        for(int i = 4; i < 100001; i++){
            dy[i][1] = (dy[i-1][2] + dy[i-1][3]) % mod;
            dy[i][2] = (dy[i-2][1] + dy[i-2][3]) % mod;
            dy[i][3] = (dy[i-3][1] + dy[i-3][2]) % mod;
        }

        for(int i = 0; i < T; i++){
            long sum = (dy[arr[i]][1] + dy[arr[i]][2] + dy[arr[i]][3]) % mod;
            sb.append(sum).append('\n');
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
