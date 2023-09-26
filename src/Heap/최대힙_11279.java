package Heap;

import java.io.*;
import java.util.PriorityQueue;
import java.util.StringTokenizer;

public class 최대힙_11279 {

    static FastReader scan = new FastReader();
    static StringBuilder sb = new StringBuilder();

    static void pro(){
        PriorityQueue<Integer> pq = new PriorityQueue<>((o1, o2) -> o2-o1);
        int N = scan.nextInt();
        for(int i = 0; i < N; i++){
            int x = scan.nextInt();
            pq.add(x);
            if(x == 0){
                if(pq.isEmpty()) sb.append(0);
                else sb.append(pq.poll());
                sb.append('\n');
            }
        }
        System.out.println(sb.toString());
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
