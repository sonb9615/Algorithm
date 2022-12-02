package BFS_DFS;

import java.io.*;
import java.util.*;

public class DFS와BFS_1260 {

    static FastReader scan = new FastReader();
    static StringBuilder sb = new StringBuilder();
    static int n,m,v;
    static ArrayList<Integer>[] A;
    static boolean[] visited;

    public static void input(){
        n = scan.nextInt();
        m = scan.nextInt();
        v = scan.nextInt();
        A = new ArrayList[n+1];
        for(int i = 1; i < n+1; i++){
            A[i] = new ArrayList<Integer>();
        }
        for(int i = 1; i < m + 1; i++){
            int x = scan.nextInt();
            int y = scan.nextInt();
            A[x].add(y);
            A[y].add(x);
        }
        for(int i = 1; i <n+1; i++){
            Collections.sort(A[i]);
        }
    }

    public static void dfs(int start){
        visited[start] = true;
        sb.append(start).append(" ");
        for(int idx : A[start]){
            if(visited[idx]){
                continue;
            }
            dfs(idx);
        }
    }

    public static void bfs(int start){
        Queue<Integer> queue = new LinkedList<>();
        queue.add(start);
        visited[start] = true;
        sb.append(start).append(" ");
        while(!queue.isEmpty()){
            for(int idx : A[queue.peek()]){
                if(visited[idx]){
                    continue;
                }
                queue.add(idx);
                visited[idx] = true;
                sb.append(idx).append(" ");
            }
            queue.poll();
        }
    }

    public static void pro(){
        visited = new boolean[n + 1];
        dfs(v);
        sb.append("\n");
        visited = new boolean[n + 1];
        bfs(v);
        System.out.println(sb);
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
