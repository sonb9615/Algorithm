package TwoPointers;

import java.io.*;
import java.util.Arrays;
import java.util.StringTokenizer;

public class 수_고르기_2230 {

    static FastReader scan = new FastReader();
    static int n,m;
    static int[] A;

    public static void input(){
        n = scan.nextInt();
        m = scan.nextInt();
        A = new int[n + 1];
        for(int i = 1; i < n + 1; i++){
            A[i] = scan.nextInt();
        }
    }

    public static void pro(){
        Arrays.sort(A, 1, n+1);
        int R = 2;
        int min = Integer.MAX_VALUE;
        for(int L = 1; L < n; L++){
            while(R < n && A[R] - A[L] < m){
                ++R;
            }
            if(A[R] - A[L] >= m){
                min = Math.min(min, A[R] - A[L]);
            }
        }
        System.out.println(min);
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
