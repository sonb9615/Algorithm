package Tree;

import java.io.*;
import java.util.ArrayList;
import java.util.StringTokenizer;

public class 트리_1068 {

    static FastReader scan = new FastReader();
    static int erased,n,root;
    static ArrayList<Integer>[] child;
    static int[] leaf;

    static void input(){
        n = scan.nextInt();
        leaf = new int[n];
        child = new ArrayList[n];
        for(int i = 0; i < n; i++) child[i] = new ArrayList<>();
        for(int i = 0; i < n; i++){
            int x = scan.nextInt();
            if(x == -1){
                root = i;
                continue;
            }
            child[x].add(i);
        }
        erased = scan.nextInt();
    }

    static void dfs(int x){
        if(child[x].isEmpty()){
            leaf[x] = 1;
        }
        for(int i : child[x]){
            dfs(i);
            leaf[x] += leaf[i];
        }
    }

    static void pro(){
        for(int i = 0; i < n; i++){
            if(child[i].contains(erased)){
                child[i].remove(child[i].indexOf(erased));
            }
        }
        if(root != erased) dfs(root);
        System.out.println(leaf[root]);
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
