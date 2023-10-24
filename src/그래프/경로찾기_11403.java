package 그래프;

import java.io.*;
import java.util.StringTokenizer;

public class 경로찾기_11403 {

    static FastReader scan = new FastReader();
    static int N;
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

    static void pro(){
        StringBuilder sb = new StringBuilder();
        for(int k = 0; k < N; k++){
            for(int i = 0; i < N; i++){
                for(int j = 0; j < N; j++){
                    if(arr[i][k] == 1 && arr[k][j] == 1){
                        arr[i][j] = 1;
                    }
                }
            }
        }

        for(int i = 0; i < N; i++){
            for(int j = 0; j < N; j++){
                sb.append(arr[i][j]).append(' ');
            }
            sb.append('\n');
        }
        System.out.println(sb);
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
