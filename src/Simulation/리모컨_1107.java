package Simulation;

import java.io.*;
import java.util.StringTokenizer;

public class 리모컨_1107 {

    static FastReader scan = new FastReader();
    static StringBuilder sb = new StringBuilder();
    static int M;
    static String N;
    static boolean[] brokenBtn;

    static void input(){
        N = scan.nextLine();
        M = scan.nextInt();
        brokenBtn = new boolean[10];
        for(int i = 0; i < M; i++){
            brokenBtn[scan.nextInt()] = true;
        }
    }

    static void pro(){
        int answer = Math.abs(Integer.parseInt(N) - 100);
        for(int i = 0; i < 999999; i++){
            String str = String.valueOf(i);
            boolean chk = false;
            for(char c : str.toCharArray()){
                if(brokenBtn[Integer.parseInt(String.valueOf(c))]){
                    chk = true;
                    break;
                }
            }
            if(chk) continue;
            int cnt = str.length() + Math.abs(i-Integer.parseInt(N));
            answer = Math.min(answer, cnt);
        }
        System.out.println(answer);
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
