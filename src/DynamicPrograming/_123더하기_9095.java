package DynamicPrograming;

import java.io.*;
import java.util.StringTokenizer;

public class _123더하기_9095 {

    static int N;
    static int[] arr;
    static int[] dy;
    static FastReader scan = new FastReader();

    static void input(){
        N = scan.nextInt();
        arr = new int[N];
        dy = new int[11];
        for(int i = 0; i < N; i++){
            arr[i] = scan.nextInt();
        }
    }

    static void pro(){
        dy[0] = 0;
        dy[1] = 1;
        dy[2] = 2;
        dy[3] = 4;
        for(int i = 4; i < 11; i++){
            dy[i] = dy[i-1] + dy[i-2] + dy[i-3];
        }
        for(int i = 0; i < arr.length; i++){
            System.out.println(dy[arr[i]]);
        }
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
