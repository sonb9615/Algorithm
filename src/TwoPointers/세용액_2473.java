package TwoPointers;

import java.io.*;
import java.util.*;

public class 세용액_2473 {

    static FastReader scan = new FastReader();
    static StringBuilder sb = new StringBuilder();
    static int n;
    static int[] A;

    public static void input(){
        n = scan.nextInt();
        A = new int[n+1];
        for(int i = 1; i < n+1; i++){
            A[i] = scan.nextInt();
        }
    }

    public static void pro(){

        Arrays.sort(A, 1, n+1);
        int[] ele = new int[3];
        long absMin = Long.MAX_VALUE;
        for(int i = 1; i < n-1; i++){
            int R = n;
            int L = i+1;
             while(L < R){
                 if(absMin > Math.abs((long)A[i] + A[L] + A[R])){
                     ele[0] = A[i];
                     ele[1] = A[L];
                     ele[2] = A[R];
                     absMin = Math.abs((long)A[i] + A[L] + A[R]);
                 }
                 if((long)A[i] + A[L] + A[R] < 0){
                    ++L;
                }else{
                     --R;
                 }
             }
        }
        sb.append(ele[0]).append(" ").append(ele[1]).append(" ").append(ele[2]).append(" ");
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
