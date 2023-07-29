package 분할정복;

import java.io.*;
import java.util.StringTokenizer;

public class Z_1074 {

    static FastReader scan = new FastReader();
    static int N, R, C, count;
    static int[][] arr;

    static void input(){
        N = scan.nextInt();
        R = scan.nextInt();
        C = scan.nextInt();
        arr = new int[N][N];
        count = 0;
    }

    static void pro(int r, int c, int size){
        if(size == 1) return;
        if(r < size / 2 && c < size / 2){
            pro(r, c, size / 2);
        }else if(r < size / 2 && c >= size / 2){
            count += size * size / 4;
            pro(r, c - size / 2, size / 2);
        }else if(r >= size / 2 && c < size / 2){
            count += size * size / 4 * 2;
            pro(r - size / 2, c, size / 2);
        }else{
            count += size * size / 4 * 3;
            pro(r - size / 2, c - size / 2, size / 2);
        }
    }

    public static void main(String[] args) {
        input();
        pro(R, C, (int) Math.pow(2,N));
        System.out.println(count);
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
