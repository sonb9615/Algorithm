package TwoPointers;

import BinaraySearch.TwoSolutions;

import java.io.*;
import java.util.StringTokenizer;

public class 부분합 {

    static FastReader scan = new FastReader();
    static StringBuilder sb = new StringBuilder();

    static int n, s;
    static int[] a;

    public static void input(){
        n = scan.nextInt();
        s = scan.nextInt();
        a = new int[n + 1];
        for(int i = 1; i <= n; i++){
            a[i] = scan.nextInt();
        }
    }

    public static void pro(){
        int sum = 0;
        int R = 0;
        int minLen = n + 1;

        for(int L = 1; L <= n; L++){
            sum -= a[L - 1];
            while(R + 1 <= n && sum < s){
                sum += a[++R];
            }
            if(sum >= s){
                minLen = Math.min(minLen, R - L + 1);
            }
        }

        if(minLen == n + 1){
            minLen = 0;
        }
        System.out.println(minLen);
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
