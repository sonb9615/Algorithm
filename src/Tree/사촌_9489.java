package Tree;

import java.io.*;
import java.util.*;

public class 사촌_9489 {

    static FastReader scan = new FastReader();
    static StringBuilder sb = new StringBuilder();
    static int[] A;
    static int[] par;
    static int n,k;

    static boolean input(){
        n = scan.nextInt();
        k = scan.nextInt();
        if(n == 0 && k == 0) return false;
        A = new int[n+1];
        par = new int[n+1];
        for(int i = 1; i < n+1; i++){
            A[i] = scan.nextInt();
        }
        return true;
    }

    static void pro(){
        par[0] = -1;
        par[1] = 0;
        int last = 1;
        for(int i = 2; i < n+1; i++,last++){
            for(; i < n+1; i++){
                par[i] = last;
                if(i < n && A[i] + 1 != A[i+1]) break;
            }
        }

        int kIdx = 0;
        for(int i = 1; i < n+1; i++){
            if(A[i] == k){
                kIdx = i;
                break;
            }
        }
        int cnt = 0;
        for(int i = 1; i < n+1; i++){
            if(par[par[i]] == par[par[kIdx]] && par[i] != par[kIdx]) ++cnt;
        }
        sb.append(cnt);
    }

    public static void main(String[] args) {
        while(input()){
            pro();
            sb.append('\n');
        }
        System.out.println(sb);
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
