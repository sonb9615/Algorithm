package DynamicPrograming;

import java.io.*;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class _1학년_5557 {

    static FastReader scan = new FastReader();
    static int N;
    static int[] arr;
    static long[][] dy;

    static void input(){
        N = scan.nextInt();
        arr = new int[N];
        dy = new long[N][21];
        for(int i = 0; i < N; i++){
            arr[i] = scan.nextInt();
        }
    }

    static void pro(){
        dy[0][arr[0]] = 1;
        for(int i = 1; i < N-1; i++){
            for(int j = 0; j < 21; j++){
                if(dy[i-1][j] >= 1){
                    if(j + arr[i] <= 20) dy[i][j + arr[i]] += dy[i-1][j];
                    if(j - arr[i] >= 0) dy[i][j - arr[i]] += dy[i-1][j];
                }
            }
        }
        System.out.println(dy[N-2][arr[N-1]]);
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
