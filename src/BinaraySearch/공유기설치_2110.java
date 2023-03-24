package BinaraySearch;

import java.io.*;
import java.util.Arrays;
import java.util.StringTokenizer;

public class 공유기설치_2110 {

    static FastReader scan = new FastReader();
    static int N,C;
    static int[] A;

    static void pro(){
        input();
        Arrays.sort(A);
        int L = 1;
        int R = 1000000000;
        int ans = 0;
        while(L <= R){
            int mid = (L+R)/2;
            if(determine(mid)){
                ans = mid;
                L = mid + 1;
            }else {
                R = mid - 1;
            }
        }
        System.out.println(ans);
    }

    static boolean determine(int dist){
        int cnt = 1;
        int last = A[0];
        for(int i = 1; i < N; i++){
            if(A[i] - last < dist) continue;
            last = A[i];
            ++cnt;
        }
        return cnt >= C;
    }

    static void input(){
        N = scan.nextInt();
        C = scan.nextInt();
        A = new int[N];
        for(int i = 0; i < N; i++){
            A[i] = scan.nextInt();
        }
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
