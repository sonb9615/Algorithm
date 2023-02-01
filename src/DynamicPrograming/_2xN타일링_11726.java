package DynamicPrograming;

import java.io.*;
import java.util.StringTokenizer;

public class _2xN타일링_11726 {

    static FastReader scan = new FastReader();

    static void pro(){
        int n = scan.nextInt();
        int[] dy = new int[1005];
        dy[1] = 1;
        dy[2] = 2;
        for(int i = 3; i < n+1; i++){
            dy[i] = (dy[i-1] + dy[i-2]) % 10007;
        }
        System.out.println(dy[n]);
    }

    public static void main(String[] args) {
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
