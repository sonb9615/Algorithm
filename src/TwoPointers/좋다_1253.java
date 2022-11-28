package TwoPointers;

import java.io.*;
import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;
import java.util.StringTokenizer;

public class 좋다_1253 {

    static FastReader scan = new FastReader();
    static int n;
    static int[] A;

    public static void input(){
        n = scan.nextInt();
        A = new int[n + 1];
        for(int i = 1; i < n + 1; i++){
            A[i] = scan.nextInt();
        }
    }

    public static boolean func(int idx){
        int L = 1;
        int R = n;
        int target = A[idx];
        while(L < R){
            if(L == idx){
                ++L;
            }else if(R == idx){
                --R;
            }else{
                if(A[L] + A[R] == target){
                    return true;
                }else if(A[L] + A[R] > target){
                    --R;
                }else{
                    ++L;
                }
            }
        }
        return false;
    }

    public static void pro(){
        Arrays.sort(A, 1, n+1);
        int cnt = 0;
        for(int i = 1; i < n + 1; i++){
            if(func(i)){
                ++cnt;
            }
        }
        System.out.println(cnt);
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
