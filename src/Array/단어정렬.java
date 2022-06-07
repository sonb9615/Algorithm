package Array;

import java.io.*;
import java.util.Arrays;
import java.util.StringTokenizer;

public class 단어정렬 {

    static FastReader scan = new FastReader();
    static StringBuilder sb = new StringBuilder();

    static class Elem implements Comparable<Elem>{

        public int len;
        public String word;

        @Override
        public int compareTo(Elem other) {
            if(len != other.len){
                return len - other.len;
            }
            return word.compareTo(other.word);
        }
    }

    static int N;
    static String w;
    static Elem[] elem;

    static void input(){
        N = scan.nextInt();
        elem = new Elem[N];

        for (int i = 0; i < N; i++){
            elem[i] = new Elem();
            String a = scan.next();
            elem[i].word = a;
            elem[i].len = a.length();
        }
    }

    static void fn(){
        Arrays.sort(elem);
        String old = "";
        for(int i = 0; i < N; i++){
            if(!old.equals(elem[i].word)){
                sb.append(elem[i].word).append('\n');
                old = elem[i].word;
            }
        }
        System.out.println(sb.toString());
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
