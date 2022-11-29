package TwoPointers;

import java.io.*;
import java.util.HashMap;
import java.util.Map;
import java.util.StringTokenizer;

public class 고냥이_16472 {

    static FastReader scan = new FastReader();
    static int n;
    static char[] A;

    public static void input(){
        n = scan.nextInt();
        A = scan.next().toCharArray();
    }

    public static void pro(){

        int R = 0;
        int max = Integer.MIN_VALUE;
        Map<Character, Integer> map = new HashMap<>();

        for(int L = 0; L < A.length - 1; L++){
            if(!map.containsKey(A[L])){
                map.put(A[L], 1);
            }
            while(R + 1 < A.length && map.size() <= n){
                if(map.containsKey(A[++R])){
                    map.put(A[R],map.get(A[R]) + 1);
                }else{
                    map.put(A[R], 1);
                }
            }
            int len = map.size() > n ? R - L : R - L + 1;
            max = Integer.max(max,len);
            if(map.get(A[L]) > 1){
                map.put(A[L],map.get(A[L]) - 1);
            }else{
                map.remove(A[L]);
            }
        }
        System.out.println(max);
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
