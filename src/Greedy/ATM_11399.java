package Greedy;

import java.io.*;
import java.util.Arrays;
import java.util.StringTokenizer;

public class ATM_11399 {

    static FastReader scan = new FastReader();
    static int n;
    static int[] arr;

    static void input(){
        n = scan.nextInt();
        arr = new int[n];
        for(int i = 0; i < n; i++){
            arr[i] = scan.nextInt();
        }
    }

    static void func(){
        Arrays.sort(arr);
        int sum = 0;
        int result = 0;
        for(int num : arr){
            sum += num;
            result += sum;
        }
        System.out.println(result);
    }

    public static void main(String[] args) {
        input();
        func();
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
