package 분할정복;

import java.io.*;
import java.util.StringTokenizer;

public class 색종이만들기_2630 {

    static FastReader scan = new FastReader();
    static int N, white, blue;
    static int[][] arr;

    static void input(){
        N = scan.nextInt();
        arr = new int[N][N];
        for(int i = 0; i < N; i++){
            for(int j = 0; j < N; j++){
                arr[i][j] = scan.nextInt();
            }
        }
    }

    static void pro(int r, int c, int len){
        if(check(r, c, len)){
            if(arr[r][c] == 1) ++blue;
            else ++white;
        }else{
            pro(r, c, len/2);
            pro(r, c + len/2, len/2);
            pro(r + len/2, c, len/2);
            pro(r + len/2, c + len/2, len/2);
        }
    }

    static boolean check(int r, int c, int len){
        int color = arr[r][c];
        for(int i = r; i < r + len; i++){
            for(int j = c; j < c + len; j++){
                if(color != arr[i][j]) return false;
            }
        }
        return true;
    }

    public static void main(String[] args) {
        input();
        pro(0,0, N);
        System.out.println(white);
        System.out.println(blue);
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
