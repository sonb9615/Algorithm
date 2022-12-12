package BFS_DFS;

import java.io.*;
import java.math.BigInteger;
import java.util.*;

public class 샘터_18513 {

    static FastReader scan = new FastReader();
    static int n, k, cnt;
    static long ans;
    static Map<Integer,Integer> map;
    static int[] dir = {1,-1};

    static void input(){
        n = scan.nextInt();
        k = scan.nextInt();
        map = new HashMap<>();
        for(int i = 0; i < n; i++){
            map.put(scan.nextInt(), 0);
        }
    }

    static void pro(){
        Queue<Integer> queue = new LinkedList<>(map.keySet());
        ans = 0;
        out:while(!queue.isEmpty()){
            int idx = queue.poll();
            for(int i = 0; i < 2; i++){
                int nIdx = idx + dir[i];
                if(map.containsKey(nIdx)) continue;
                ++cnt;
                map.put(nIdx, map.get(idx) + 1);
                ans += map.get(nIdx);
                if(cnt == k) break out;
                queue.add(nIdx);
            }
        }
        System.out.println(ans);
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
