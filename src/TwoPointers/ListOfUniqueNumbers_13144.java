package TwoPointers;

import java.io.*;
import java.util.Arrays;
import java.util.StringTokenizer;

public class ListOfUniqueNumbers_13144 {

    static FastReader scan = new FastReader();
    public static int n;
    public static int[] A;

    public static void input(){
        n = scan.nextInt();
        A = new int[n+1];
        for(int i = 1; i < n+1; i++){
            A[i] = scan.nextInt();
        }
    }

    public static void pro(){
        int R = 0;
        long sum = 0;
        int[] num = new int[1000000 + 1];
        for(int L = 1; L <= n; L++){
            while(R + 1 <= n && num[A[R+1]] == 0){
                num[A[++R]] += 1;
            }
            sum += R - L + 1;
            --num[A[L]];
        }
        System.out.println(sum);
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
