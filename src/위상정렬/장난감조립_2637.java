package 위상정렬;

import java.io.*;
import java.util.*;

public class 장난감조립_2637 {

    static FastReader scan = new FastReader();
    static int n,m;
    static HashMap<Integer, Integer>[] parts;
    static int[] indeg;
    static int[][] item_cnt;

    static void input(){
        n = scan.nextInt();
        m = scan.nextInt();
        parts = new HashMap[n+1];
        indeg = new int[n+1];
        item_cnt = new int[n+1][n+1];
        for(int i = 1; i < n+1; i++) {
            parts[i] = new HashMap<>();
        }
        for(int i = 0; i < m; i++){
            int x = scan.nextInt();
            int y = scan.nextInt();
            int k = scan.nextInt();
            ++indeg[x];
            parts[y].put(x,k);
        }
    }

    static void pro(){
        Queue<Integer> queue = new LinkedList<>();
        for(int i = 1; i < n+1; i++){
            if(indeg[i] == 0){
                queue.add(i);
                item_cnt[i][i] = 1;
            }
        }

        while(!queue.isEmpty()){
            int x = queue.poll();
            for(int key : parts[x].keySet()){
                int y = parts[x].get(key);
                --indeg[key];
                for(int i = 1; i < n+1; i++){
                    item_cnt[key][i] += item_cnt[x][i] * y;
                }
                if(indeg[key] == 0) queue.add(key);
            }
        }

        for(int i = 1; i < n+1; i++){
            if(item_cnt[n][i] != 0)
                System.out.println(i + " " + item_cnt[n][i]);
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
