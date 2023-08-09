package Heap;

import java.io.*;
import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;
import java.util.StringTokenizer;

public class 좌표압축_18870 {

    static FastReader scan = new FastReader();
    static int N;
    static int[] sorted, origin;
    static Map<Integer, Integer> map;
    static void input(){
        N = scan.nextInt();
        map = new HashMap<>();
        sorted = new int[N];
        origin = new int[N];
        for(int i = 0; i < N; i++){
            int x = scan.nextInt();
            sorted[i] = x;
            origin[i] = x;
        }
        Arrays.sort(sorted);
    }

    static void pro(){
        int rank = -1;
        for(int i = 0; i < N; i++){
            if(!map.containsKey(sorted[i])){
                map.put(sorted[i], ++rank);
            }
        }
        StringBuilder sb = new StringBuilder();
        for(int key : origin){
            sb.append(map.get(key)).append(" ");
        }
        System.out.println(sb);
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
