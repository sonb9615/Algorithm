package TwoPointers;

import java.io.*;
import java.util.StringTokenizer;

public class 배열합치기 {

    static FastReader scan = new FastReader();
    static StringBuilder sb = new StringBuilder();

    static int n, m;
    static int[] A, B;
    public static void input(){
        n = scan.nextInt();
        m = scan.nextInt();
        A = new int[n + 1];
        for(int i = 1; i < n + 1; i++){
            A[i] = scan.nextInt();
        }
        B = new int[m + 1];
        for(int i = 1; i < m + 1; i++){
            B[i] = scan.nextInt();
        }
    }

    public static void pro(){
        int R = 0;
        for(int L = 1; L < n + 1; L++){
            while(R < m && B[R + 1] < A[L]){
                ++R;
                sb.append(B[R]).append(" ");
            }
            sb.append(A[L]).append(" ");
        }
        while(R < m){
            sb.append(B[++R]).append(" ");
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
