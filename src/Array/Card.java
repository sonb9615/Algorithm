package Array;

import java.io.*;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Card {

    static FastReader scan = new FastReader();
    static StringBuilder sb = new StringBuilder();

    static class Elem implements Comparable<Elem>{

        public long num;

        @Override
        public int compareTo(Elem other){
            return Long.valueOf(num - other.num).intValue();
        }
    }

    static int N;
    static Elem[] elem;

    static void input(){
        N = scan.nextInt();
        elem = new Elem[N];

        for(int i = 0; i < N; i++){
            elem[i] = new Elem();
            elem[i].num = scan.nextInt();
        }

    }

    static void fn(){
        Arrays.sort(elem);
        int[] modCnt = new int[N];
        modCnt[0] = 1;
        long mod = elem[0].num;
        int cnt = 0;
        for(int i = 1; i < N; i++){
            if(mod == elem[i].num){
                modCnt[i] = modCnt[i-1] + 1;
            }else{
                if(cnt > modCnt[i-1]){
                    modCnt[i] = cnt;
                    mod = elem[i].num;
                    cnt = 0;
                }else{
                    modCnt[i] = modCnt[i-1];
                    ++cnt;
                }
            }
        }
        System.out.println(mod);
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
