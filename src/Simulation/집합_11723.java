package Simulation;

import java.io.*;
import java.util.Arrays;
import java.util.StringTokenizer;

public class 집합_11723 {

    static FastReader scan = new FastReader();
    static int[] arr;
    static StringBuilder sb = new StringBuilder();
    static void pro(){
        int N = scan.nextInt();
        arr = new int[21];
        for(int i = 0; i < N; i++){
            String str = scan.nextLine();
            String[] opt = str.split(" ");
            switch (opt[0]){
                case "add" :
                    add(Integer.parseInt(opt[1]));
                    break;
                case "remove" :
                    remove(Integer.parseInt(opt[1]));
                    break;
                case "check" :
                    check(Integer.parseInt(opt[1]));
                    break;
                case "toggle" :
                    toggle(Integer.parseInt(opt[1]));
                    break;
                case "all" :
                    all();
                    break;
                case "empty" :
                    empty();
                    break;
            }
        }
        System.out.println(sb);
    }

    static void add(int x){
        if(arr[x] == 0) arr[x] = x;
    }

    static void remove(int x){
        if(arr[x] == x) arr[x] = 0;
    }

    static void check(int x){
        if(arr[x] == x) sb.append(1).append('\n');
        else sb.append(0).append('\n');
    }

    static void toggle(int x){
        if(arr[x] == x) arr[x] = 0;
        else arr[x] = x;
    }

    static void all(){
        for(int i = 1; i < 21; i++){
            arr[i] = i;
        }
    }

    static void empty(){
        arr = new int[20];
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
