package BinaraySearch;

import java.io.*;
import java.util.Arrays;
import java.util.StringTokenizer;

public class TwoSolutions {

    static FastReader scan = new FastReader();
    static StringBuilder sb = new StringBuilder();

    static int N;
    static int[] A;

    static void input(){
        N = scan.nextInt();
        A = new int[N + 1];
        for(int i = 1; i <= N; i++){
            A[i] = scan.nextInt();
        }
    }

    public static int bs(int[] A, int L, int R, int x){

        int rtn = R + 1;
        while(L <= R){
            int mid = (L + R) / 2;
            if(A[mid] >= x){
                rtn = mid;
                R = mid - 1;
            }else{
                L = mid + 1;
            }
        }

        return rtn;
    }

    static void fn(){

        //오름차순으로 정렬
        Arrays.sort(A, 1, N + 1);

        int val1 = 0;
        int val2 = 0;
        int absolute = Integer.MAX_VALUE;
        //임시 값을 뽑기(index)
        for(int i = 1; i <= N - 1; i++){

            int tmp = bs(A, i + 1, N, -A[i]);

            // 1. A[left] + A[candidate - 1]
            if (i < tmp - 1 && Math.abs(A[i] + A[tmp - 1]) < absolute) {
                absolute = Math.abs(A[i] + A[tmp - 1]);
                val1 = A[i];
                val2 = A[tmp - 1];
            }

            // 2. A[left] + A[candidate]
            if (tmp <= N && Math.abs(A[i] + A[tmp]) < absolute) {
                absolute = Math.abs(A[i] + A[tmp]);
                val1 = A[i];
                val2 = A[tmp];
            }
        }
        sb.append(val1).append(' ').append(val2);
        System.out.println(sb);
    }


    public static void main(String[] args) {

        input();
        fn();
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
