package Simulation;

import java.io.*;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class 거짓말_1043 {

    static FastReader scan = new FastReader();
    static int N, M;
    static ArrayList<Integer> knownP;
    static ArrayList<Integer>[] parties, per;
    static boolean[] visited,meet;

    public static void input(){
        N = scan.nextInt();
        M = scan.nextInt();
        per = new ArrayList[N+1];
        meet = new boolean[N+1];
        for(int i = 0; i < N+1; i++){
            per[i] = new ArrayList<>();
        }
        knownP = new ArrayList<>();
        int cnt = scan.nextInt();
        for(int i = 0; i < cnt; i++){
            knownP.add(scan.nextInt());
        }
        parties = new ArrayList[M];
        visited = new boolean[M];
        for(int i = 0; i < M; i++){
            parties[i] = new ArrayList<>();
            int x = scan.nextInt();
            for(int j = 0; j < x; j++){
                int person = scan.nextInt();
                parties[i].add(person);
                per[person].add(i);
            }
        }
    }

    public static void pro(){
        Queue<Integer> queue = new LinkedList<>();
        for(int i = 0; i < knownP.size(); i++){
            queue.add(knownP.get(i));
            meet[knownP.get(i)] = true;
        }
        while(!queue.isEmpty()){
            int x = queue.poll();
            for (int party : per[x]){
                if(visited[party]) continue;
                visited[party] = true;
                for(int person : parties[party]){
                    if(meet[person]) continue;
                    meet[person] = true;
                    queue.add(person);
                }
            }
        }
        int answer = 0;
        for(int i = 0; i < visited.length; i++){
            if(!visited[i]) ++answer;
        }
        System.out.println(answer);
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
