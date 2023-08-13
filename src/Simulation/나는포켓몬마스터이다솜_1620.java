package Simulation;

import java.io.*;
import java.util.HashMap;
import java.util.Map;
import java.util.StringTokenizer;

public class 나는포켓몬마스터이다솜_1620 {

    static FastReader scan = new FastReader();
    static Map<String, Integer> map;
    static String[] arr;
    static int N, M;

    static void input(){
        N = scan.nextInt();
        M = scan.nextInt();
        map = new HashMap<>();
        arr = new String[N+1];
        int idx = 0;
        for(int i = 0; i < N; i++){
            String str = scan.nextLine();
            String name = str.toUpperCase();
            if(!map.containsKey(name)){
                map.put(name, ++idx);
                arr[idx] = str;
            }
        }
    }

    static void pro(){
        StringBuilder sb = new StringBuilder();
        for(int i = 0; i < M; i++){
            String key = scan.nextLine().toUpperCase();
            if(map.containsKey(key)){
                sb.append(map.get(key)).append('\n');
            }else{
                sb.append(arr[Integer.parseInt(key)]).append('\n');
            }
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
