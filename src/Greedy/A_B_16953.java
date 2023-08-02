package Greedy;

import java.io.*;
import java.util.*;

public class A_B_16953 {

    static FastReader scan = new FastReader();
    static Long N, M;
    static Map<Long, Long> map;

    static void input(){
        N = scan.nextLong();
        M = scan.nextLong();
        map = new HashMap<>();
    }

    static void pro(){
        Queue<Long> queue = new LinkedList<>();
        queue.add(N);
        map.put(N, 1L);
        while (!queue.isEmpty()){
            Long x = queue.poll();
            Long nx1 = x * 2;
            check(nx1, x, queue);
            StringBuilder sb = new StringBuilder();
            Long nx2 = Long.parseLong(sb.append(x).append(1).toString());
            check(nx2, x, queue);
        }
        if(!map.containsKey(M)) System.out.println(-1);
        else System.out.println(map.get(M));
    }

    static void check(Long nx, Long x, Queue<Long> queue){
        if(nx >= N && nx <= M){
            if(map.containsKey(nx)){
                if(map.get(nx) < map.get(x) + 1){
                    map.put(nx, map.get(x) + 1);
                    queue.add(nx);
                }
            }else{
                map.put(nx, map.get(x) + 1);
                queue.add(nx);
            }
        }
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
