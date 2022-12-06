package BFS_DFS;

import java.io.*;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class 숨바꼭질_1697 {

    static FastReader scan = new FastReader();
    static int n,k;
    static boolean[] visited;
    static int[] dist;

    static void input(){
        n = scan.nextInt();
        k = scan.nextInt();
        visited = new boolean[100000 + 1];
        dist = new int[100000 + 1];
    }

    static void bfs(int start){
        Queue<Integer> queue = new LinkedList<>();
        queue.add(start);
        visited[start] = true;
        while(!queue.isEmpty()){
            int idx = queue.poll();
            int[] dir = {-1, 1, idx};
            for(int i = 0; i < 3; i++){
                int nIdx = idx + dir[i];
                if(nIdx < 0 || nIdx > 100000) continue;
                if(visited[nIdx]) continue;
                visited[nIdx] = true;
                queue.add(nIdx);
                dist[nIdx] = dist[idx] + 1;
            }
        }
    }

    static void pro(){
        bfs(n);
        System.out.println(dist[k]);
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
