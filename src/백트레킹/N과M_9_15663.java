package 백트레킹;

import java.io.*;
import java.util.*;

public class N과M_9_15663 {

    static FastReader scan = new FastReader();
    static StringBuilder sb = new StringBuilder();
    static int N, M;
    static int[] selected;
    static ArrayList<Integer> arr;

    static Map<String, Integer> map;
    static boolean[] visited;

    static void input(){
        N = scan.nextInt();
        M = scan.nextInt();

        selected = new int[M];
        map = new HashMap<>();
        arr = new ArrayList<>();

        for(int i = 0; i < N; i++){
            arr.add(scan.nextInt());
        }
        Collections.sort(arr);
        visited = new boolean[arr.size()];
    }

    static void ref_func(int k, int start){

        if(k == M){
            StringBuilder temp = new StringBuilder();
            for(int i = 0; i < M; i++){
                temp.append(selected[i]).append(' ');
            }
            if(!map.containsKey(temp.toString())){
                map.put(temp.toString(), 1);
                sb.append(temp).append('\n');
            }
        }else{
            for(int i = 0; i < arr.size(); i++){
                if(!visited[i]){
                    selected[k] = arr.get(i);
                    visited[i] = true;
                    ref_func(k+1, start + 1);
                    visited[i] = false;
                    selected[k] = 0;
                }
            }
        }
    }

    public static void main(String[] args) {
        input();
        ref_func(0, 0);
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
