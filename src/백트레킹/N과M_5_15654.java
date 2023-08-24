package 백트레킹;

import java.io.*;
import java.util.*;

public class N과M_5_15654 {

    static FastReader scan = new FastReader();
    static StringBuilder sb = new StringBuilder();
    static StringBuilder answer = new StringBuilder();
    static int N,M;
    static int[] arr;
    static boolean[] visited;

    public static void input(){
        N = scan.nextInt();
        M = scan.nextInt();
        arr = new int[N];
        visited = new boolean[N];
        for(int i = 0; i < N; i++){
            arr[i] = scan.nextInt();
        }
        Arrays.sort(arr);
    }

    public static void reFunc(int k){
        if(k == M){
            answer.append(sb).append('\n');
            return;
        }
        for(int i = 0; i < N; i++){
            if(visited[i]) continue;
            sb.append(arr[i]).append(' ');
            visited[i] = true;
            reFunc(k+1);
            sb.delete(sb.length()-String.valueOf(arr[i]).length()-1, sb.length());
            visited[i] = false;
        }
    }

    public static void main(String[] args) {
        input();
        reFunc(0);
        System.out.println(answer.toString());
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
