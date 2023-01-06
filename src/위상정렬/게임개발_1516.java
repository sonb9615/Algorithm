package 위상정렬;

import java.io.*;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class 게임개발_1516 {

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
            int x = scan.nextInt();
            time[i] = x;
            while(x > 0){
                x = scan.nextInt();
                if(x > 0){
                    adj[x].add(i);
                    indeg[i]++;
                }
            }
        }
    }

    static void pro(){
        Queue<Integer> queue = new LinkedList<>();
        for(int i = 1; i < n+1; i++){
            if(indeg[i] == 0) queue.add(i);
            time_done[i] = time[i];
        }
        while(!queue.isEmpty()){
            int x = queue.poll();
            for(int y : adj[x]){
                indeg[y]--;
                if(indeg[y] == 0) queue.add(y);
                time_done[y] = Math.max(time[y] + time_done[x],time_done[y]);
            }
        }
    }

    public static void main(String[] args) {
        input();
        pro();
        for(int i = 1; i < n+1; i++){
            System.out.println(time_done[i]);
        }
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
