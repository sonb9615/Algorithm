package DynamicPrograming;

import java.io.*;
import java.util.StringTokenizer;

public class 기타리스트_1495 {

    static FastReader scan = new FastReader();
    static int n,s,m;
    static int[] arr;
    static boolean[][] dy;

    static void input(){
        n = scan.nextInt();
        s = scan.nextInt();
        m = scan.nextInt();
        arr = new int[n+1];
        dy = new boolean[n+1][m+1];
        for(int i = 1; i < n+1; i++){
            arr[i] = scan.nextInt();
        }
    }

    static void pro(){
        dy[0][s] = true;
        int ans = 0;
        for(int i = 1; i < n+1; i++){
            boolean chk = false;
            ans = 0;
            for(int j = 0; j < m+1; j++){
                if(!dy[i-1][j]) continue;
                for(int x : new int[]{j + arr[i], j - arr[i]}){
                    if(x > m || x < 0) continue;
                    ans = Math.max(ans, x);
                    dy[i][x] = true;
                    chk = true;
                }
            }
            if(!chk){
                System.out.println(-1);
                return;
            }
        }

        System.out.println(ans);
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
