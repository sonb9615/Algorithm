package 위상정렬;

import java.io.*;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class ACM_Craft_1005 {

    static FastReader scan = new FastReader();
    static StringBuilder sb = new StringBuilder();
    static int n,k,w;
    static int[] indeg, time, t_done;
    static ArrayList<Integer>[] adj;

    static void input(){
        n = scan.nextInt();
        k = scan.nextInt();
        time = new int[n+1];
        indeg = new int[n+1];
        t_done = new int[n+1];
        adj = new ArrayList[n+1];
        for(int i = 1; i < n+1; i++){
            time[i] = scan.nextInt();
            adj[i] = new ArrayList<>();
        }
        for(int i = 0; i < k; i++){
            int x = scan.nextInt();
            int y = scan.nextInt();
            adj[x].add(y);
            indeg[y]++;
        }
        w = scan.nextInt();
    }

    static void pro(){
        Queue<Integer> queue = new LinkedList<>();
        for(int i = 1; i < n+1; i++){
            if(indeg[i] == 0){
                queue.add(i);
                t_done[i] = time[i];
            }
        }

        while(!queue.isEmpty()){
            int x = queue.poll();
            for(int num : adj[x]){
                --indeg[num];
                if(indeg[num] == 0) queue.add(num);
                t_done[num] = Math.max(t_done[num],t_done[x] + time[num]);
            }
        }
        System.out.println(t_done[w]);
    }

    public static void main(String[] args) {
        int t = scan.nextInt();
        while(t > 0){
            --t;
            input();
            pro();
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
