package BinaraySearch;

import java.io.*;
import java.util.Arrays;
import java.util.StringTokenizer;

public class 나무자르기_2805 {

    static FastReader scan = new FastReader();
    static int N,M;
    static long[] trees;

    static void pro(){
        input();
        binarySearch();
    }

    static void input(){
        N = scan.nextInt();
        M = scan.nextInt();
        trees = new long[N];
        for(int i = 0; i < N; i++){
            trees[i] = scan.nextInt();
        }
        Arrays.sort(trees);
    }

    static void binarySearch(){
        long L = 0;
        long R = 2000000000;
        long ans = 0;
        while(L <= R){
            int mid = (int)(L + R) / 2;
            if(check(mid)){
                ans = mid;
                L = mid + 1;
            }else{
                R = mid - 1;
            }
        }
        System.out.println(ans);
    }

    static boolean check(int H){
        long sum = 0;
        for(int i = 0; i < N; i++){
            if(trees[i] > H){
                sum += trees[i] - H;
            }
        }
        if(sum >= M) return true;
        else return false;
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
