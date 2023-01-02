package 위상정렬;

import java.io.*;
import java.util.*;

public class Strahler순서_9470 {

    static FastReader scan = new FastReader();
    static StringBuilder sb = new StringBuilder();
    static int k,m,p;
    static ArrayList<Integer>[] adj;
    static int[] indeg,ord,maxCnt;

    static void input(){
        k = scan.nextInt();
        m = scan.nextInt();
        p = scan.nextInt();
        adj = new ArrayList[m+1];
        indeg = new int[m+1];
        ord = new int[m+1];
        maxCnt = new int[m+1];
        for(int i = 1; i < m+1; i++) adj[i] = new ArrayList<>();
        for(int i = 0; i < p; i++){
            int x = scan.nextInt();
            int y = scan.nextInt();
            adj[x].add(y);
            ++indeg[y];
        }
    }

    static void pro(){
        Queue<Integer> queue = new LinkedList<>();
        for(int i = 1; i < m+1; i++){
            if(indeg[i] == 0){
                queue.add(i);
                ++ord[i];
            }
        }
        int ans = 0;
        while(!queue.isEmpty()){
            int x = queue.poll();
            if(maxCnt[x] >= 2) ++ord[x];
            ans = Math.max(ord[x], ans);
            for(int idx : adj[x]){
                --indeg[idx];
                if(indeg[idx] == 0){
                    queue.add(idx);
                }
                if(ord[x] == ord[idx]) ++maxCnt[idx];
                if(ord[x] > ord[idx]){
                    ord[idx] = ord[x];
                    maxCnt[idx] = 1;
                }
            }
        }
        sb.append(k).append(' ').append(ans);
    }

    public static void main(String[] args) {
        int t = scan.nextInt();
        while(t > 0){
            --t;
            input();
            pro();
            sb.append('\n');
        }
        System.out.println(sb);
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
