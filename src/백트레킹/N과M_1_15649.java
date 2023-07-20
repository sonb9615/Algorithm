package 백트레킹;

import java.io.*;
import java.util.StringTokenizer;

public class N과M_1_15649 {

    static StringBuilder sb = new StringBuilder();

    static int N,M;
    static int[] selected;

    public static void input(){
        FastReader scan = new FastReader();
        N = scan.nextInt();
        M = scan.nextInt();
        selected = new int[M+1];
    }

    public static void ref_func(int k){
        if(k == M + 1){
            for(int i = 1; i <= M ; i++){
                sb.append(selected[i]).append(' ');
            }
            sb.append('\n');
        }else{
            for(int cand = 1; cand <= N; cand++){
                boolean isUsed = false;
                for(int j = 1; j <= k; j++){
                    if(cand == selected[j]){
                        isUsed = true;
                        break;
                    }
                }
                if(!isUsed){
                    selected[k] = cand;
                    ref_func(k+1);
                    selected[k] = 0;
                }
            }
        }
    }

    public static void main(String[] args) {
        input();
        ref_func(1);
        System.out.println(sb.toString());
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
