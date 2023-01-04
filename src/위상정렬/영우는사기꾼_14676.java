package 위상정렬;

import java.io.*;
import java.util.ArrayList;
import java.util.StringTokenizer;

public class 영우는사기꾼_14676 {

    static FastReader scan = new FastReader();
    static int n,m,k;
    static ArrayList<Integer>[] adj;
    static int[] maxCnt, indeg, stable;
    static ArrayList<Integer> cmd;
    static boolean chk;

    static void input(){
        n = scan.nextInt();
        m = scan.nextInt();
        k = scan.nextInt();
        adj = new ArrayList[n+1];
        maxCnt = new int[n+1];
        indeg = new int[n+1];
        stable = new int[n+1];
        chk = true;
        for(int i = 1; i < n+1; i++) adj[i] = new ArrayList<>();
        for(int i = 0; i < m; i++){
            int x = scan.nextInt();
            int y = scan.nextInt();
            adj[x].add(y);
            ++indeg[y];
        }
    }

    static void construct(int x){
        if(indeg[x] > stable[x]) chk = false;
        ++maxCnt[x];
        if(maxCnt[x] == 1){
            for(int num : adj[x]){
                ++stable[num];
            }
        }
    }

    static void destroy(int x){
        if(maxCnt[x] == 0) chk = false;
        --maxCnt[x];
        if(maxCnt[x] == 0){
            for(int num : adj[x]){
                --stable[num];
            }
        }
    }

    static void pro(){
        while(k-- > 0){
            int x = scan.nextInt();
            int y = scan.nextInt();
            if(x == 1) construct(y);
            if(x == 2) destroy(y);
        }
        if(chk) System.out.println("King-God-Emperor");
        else System.out.println("Lier!");
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
