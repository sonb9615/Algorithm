package Greedy;

import java.io.*;
import java.util.StringTokenizer;

public class 거스름돈_14916 {

    static FastReader scan = new FastReader();

    static int n;

    public static void input(){
        n = scan.nextInt();
    }

    public static void func(){
        int x = n / 5;
        int y = n % 5;
        if(y % 2 == 1 && x > 0){
            x--;
            y += 5;
        }
        int result = x;
        if(y > 0){
            x = y / 2;
            y = y % 2;
            result += x;
        }
        if(y != 0) System.out.println(-1);
        else System.out.println(result);
    }

    public static void main(String[] args) {
        input();
        func();
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
