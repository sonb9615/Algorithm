package Hash;

import java.io.*;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;
import java.util.StringTokenizer;

public class 패션왕_신혜빈_9375 {

    static FastReader scan = new FastReader();
    static StringBuilder sb = new StringBuilder();

    static void pro(){
        int t = scan.nextInt();
        for(int i = 0; i < t; i++){
            int n = scan.nextInt();
            Map<String, Integer> map = new HashMap<>();
            for(int j = 0; j < n; j++){
                String str = scan.nextLine();
                String[] sp = str.split(" ");
                if(map.containsKey(sp[1])){
                    map.put(sp[1], map.get(sp[1]) + 1);
                }else{
                    map.put(sp[1], 1);
                }
            }

            int cnt = 1;
            for(String key : map.keySet()){
                cnt *= map.get(key) + 1;
            }
            sb.append(cnt - 1).append('\n');
        }
    }

    public static void main(String[] args) {
        pro();
        System.out.println(sb.toString());
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
