package Simulation;

import java.io.*;
import java.util.StringTokenizer;

public class 구간합구하기_4_11659 {

    static FastReader scan = new FastReader();
    static int N, M;
    static int[] arr;
    static int[][] quest;

    static void input(){
        N = scan.nextInt();
        M = scan.nextInt();
        arr = new int[N+1];
        for(int i = 1; i < N+1; i++){
            int x = scan.nextInt();
            arr[i] = arr[i-1] + x;
        }
        quest = new int[M][2];
        for(int i = 0; i < M; i++){
            quest[i][0] = scan.nextInt();
            quest[i][1] = scan.nextInt();
        }
    }

    static void pro(){
        StringBuilder sb = new StringBuilder();
        for(int i = 0 ; i < M; i++){
            sb.append(arr[quest[i][1]] - arr[quest[i][0]-1]).append('\n');
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
