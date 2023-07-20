package 백트레킹;

import java.io.*;
import java.util.StringTokenizer;

public class N과M_2_15650 {

    static FastReader scan = new FastReader();
    static int N,M;
    static StringBuilder sb = new StringBuilder();
    static int[] selected;

    static void input(){
        N = scan.nextInt();
        M = scan.nextInt();
        selected = new int[M+1];
    }

    static void re_func(int k, int start){

        if(k == M+1){
            for(int i = 1; i <= M; i++){
                sb.append(selected[i]).append(' ');
            }
            sb.append('\n');
        }else{
            for(int i = start; i <= N; i++){
                selected[k] = i;
                re_func(k+1, start + 1);
                start++;
                selected[k] = 0;
            }
        }
    }

    public static void main(String[] args) {
        input();
        re_func(1, 1);
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
