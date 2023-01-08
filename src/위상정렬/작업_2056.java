package 위상정렬;

import java.io.*;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class 작업_2056 {

    static FastReader scan = new FastReader();
    static int n;
    static ArrayList<Integer>[] adj;
    static int[] indeg, time, time_done;

    static void input(){
        n = scan.nextInt();
        adj = new ArrayList[n+1];
        indeg = new int[n+1];
        time = new int[n+1];
        time_done = new int[n+1];
        for(int i = 1; i < n+1; i++) adj[i] = new ArrayList<>();
        for(int i = 1; i < n+1; i++){
            int t = scan.nextInt();
            time[i] = t;
            int cnt = scan.nextInt();
            while(cnt > 0){
                --cnt;
                int w = scan.nextInt();
                adj[w].add(i);
                indeg[i]++;
            }
        }
    }

    static void pro(){
        int min_time = 0;
        Queue<Integer> queue = new LinkedList<>();
        for(int i = 1; i < n+1; i++){
            if(indeg[i] == 0){
                queue.add(i);
                time_done[i] = time[i];
            }
        }
        while(!queue.isEmpty()){
            int x = queue.poll();
            for(int y : adj[x]){
                indeg[y]--;
                if(indeg[y] == 0) queue.add(y);
                time_done[y] = Math.max(time_done[y], time_done[x] + time[y]);

            }
        }
        for(int i = 1; i < n+1; i++){
            min_time = Math.max(min_time, time_done[i]);
        }
        System.out.println(min_time);
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
