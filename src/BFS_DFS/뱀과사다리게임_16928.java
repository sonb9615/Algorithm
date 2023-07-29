package BFS_DFS;

import java.io.*;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class 뱀과사다리게임_16928 {

    static FastReader scan = new FastReader();
    static int N, M;
    static int[] arr, dist;

    static void input(){
        N = scan.nextInt();
        M = scan.nextInt();
        arr = new int[101];
        dist = new int[101];
        for(int i = 0; i < N + M; i++){
            arr[scan.nextInt()] = scan.nextInt();
        }
        Arrays.fill(dist, Integer.MAX_VALUE);
    }

    static void pro(){
        Queue<Integer> queue = new LinkedList<>();
        queue.add(1);
        dist[1] = 0;
        while (!queue.isEmpty()){
            int node = queue.poll();
            for(int i = 1; i < 7; i++){
                int nn = node + i;
                if(nn < 1 || nn > 100) continue;
                if(arr[nn] != 0) nn = arr[nn];
                if(dist[nn] > dist[node] + 1){
                    dist[nn] = dist[node] + 1;
                    queue.add(nn);
                }
            }
        }
        System.out.println(dist[100]);
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
