package Simulation;

import java.io.*;
import java.util.StringTokenizer;

public class 곱셈_1629 {

    static FastReader scan = new FastReader();
    static int A, B, C;

    static void input(){
        A = scan.nextInt();
        B = scan.nextInt();
        C = scan.nextInt();
    }

    static void pro(){
        System.out.println(pow(A,B));
    }

    static long pow(int a, int b){
        if(b == 0) return 1;
        long temp = pow(a, b / 2);
        if(b % 2 == 0) return (temp * temp) % C;
        else return (temp * temp % C) * A % C;
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
