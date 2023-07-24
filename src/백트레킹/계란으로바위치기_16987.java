package 백트레킹;

import java.io.*;
import java.util.StringTokenizer;

public class 계란으로바위치기_16987 {

    static FastReader scan = new FastReader();
    static int N, max;
    static int[][] arr;

    static void input(){
        N = scan.nextInt();
        arr = new int[N][2];
        for(int i = 0; i < N; i++){
            arr[i][0] = scan.nextInt();
            arr[i][1] = scan.nextInt();
        }
        max = 0;
    }

    static void pro(int k, int cnt){
        if(k == N){
            max = Integer.max(max, cnt);
            return;
        }
        if(arr[k][0] <= 0 || cnt == N - 1){
            pro(k+1, cnt);
            return;
        }
        int temp = cnt;
        for(int i = 0; i < N; i++){
            if(i == k) continue;
            if(arr[i][0] <= 0) continue;
            arr[k][0] -= arr[i][1];
            if(arr[k][0] <= 0) ++cnt;
            arr[i][0] -= arr[k][1];
            if(arr[i][0] <= 0) ++cnt;
            pro(k+1, cnt);
            arr[k][0] += arr[i][1];
            arr[i][0] += arr[k][1];
            cnt = temp;
        }
    }

    public static void main(String[] args) {
        input();
        pro(0,0);
        System.out.println(max);
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
