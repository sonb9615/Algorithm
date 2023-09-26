package Greedy;

import java.io.*;
import java.util.Stack;
import java.util.StringTokenizer;

public class 동전0_11047 {

    static FastReader scan = new FastReader();
    static int N, K;
    static Stack<Integer> st;

    public static void input(){
        N = scan.nextInt();
        K = scan.nextInt();
        st = new Stack<>();
        for(int i = 0; i < N; i++){
            st.push(scan.nextInt());
        }
    }

    public static void pro(){
        int cnt = 0;
        while(!st.isEmpty()){
            int x = st.pop();
            cnt += K / x;
            K %= x;
        }
        System.out.println(cnt);
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
