package 백트레킹;

import java.io.*;
import java.util.HashMap;
import java.util.Map;
import java.util.StringTokenizer;

public class 연산자끼워넣기_14888 {

    static FastReader scan = new FastReader();
    static int N, min, max;
    static int[] arr, op, selected;
    static Map<String, Integer> map;

    static void input(){
        N = scan.nextInt();
        arr = new int[N];
        selected = new int[N-1];
        for(int i = 0; i < N; i++){
            arr[i] = scan.nextInt();
        }
        op = new int[4];
        for(int i = 0; i < 4; i++){
            op[i] = scan.nextInt();
        }
        min = Integer.MAX_VALUE;
        max = Integer.MIN_VALUE;
        map = new HashMap<>();
    }

    static void func(int k){
        if(k == N-1){
            int result = arr[0];
            for(int i = 0; i < N-1; i++){
                if(selected[i] == 0) result = result + arr[i+1];
                if(selected[i] == 1) result = result - arr[i+1];
                if(selected[i] == 2) result = result * arr[i+1];
                if(selected[i] == 3) result = result / arr[i+1];
            }
            max = Integer.max(max, result);
            min = Integer.min(min, result);
        }else{
            for(int i = 0; i < 4; i++){
                if(op[i] == 0) continue;
                selected[k] = i;
                --op[i];
                func(k+1);
                selected[k] = -1;
                ++op[i];
            }
        }
    }

    public static void main(String[] args) {
        input();
        func(0);
        System.out.println(max);
        System.out.println(min);
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
