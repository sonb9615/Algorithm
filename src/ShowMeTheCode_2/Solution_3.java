package ShowMeTheCode_2;

import java.io.*;
import java.util.StringTokenizer;

public class Solution_3 {

    static FastReader scan = new FastReader();
    static StringBuilder sb = new StringBuilder();

    static int N;
    static int[] A;
    static int[] B;

    public static void main(String[] args) {

        input();
        fn();
    }

    static void input(){

        N = scan.nextInt();
        A = new int[N];
        B = new int[N];
        for(int i = 0; i < N; i++){
            A[i] = scan.nextInt();
        }
        for(int i = 0; i < N; i++){
            B[i] = scan.nextInt();
        }
    }

    static void fn(){

        int cnt = 0;
        for(int i = 0; i < N; i++){
            int idx = i;
            int aSum = 0;
            int bSum = 0;
            while(idx < N){
                if(aSum + A[idx] == bSum + B[idx]){
                    ++cnt;
                }
                ++idx;
            }
        }

        System.out.println(cnt);
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
