package BFS_DFS;

import java.io.*;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

// 물통의 현재 상태와 물을 붓는 행위를 관리하는 구조체
class State{
    int[] X;
    State(int[] _X){
        X = new int[3];
        for(int i = 0; i < 3; i++){
            X[i] = _X[i];
        }
    }

    State move(int from, int to, int[] Limit){
        int[] nX = new int[]{X[0],X[1],X[2]};
        if(X[from] + X[to] >= Limit[to]){
            nX[from] -= Limit[to] - X[to];
            nX[to] = Limit[to];
        }else{
            nX[to] = X[from] + X[to];
            nX[from] = 0;
        }
        return new State(nX);
    }
};

public class 물통_2251 {

    static FastReader scan = new FastReader();
    static StringBuilder sb = new StringBuilder();
    static int[] Limit;
    static boolean[][][] visited;
    static boolean[] possible;

    static void input(){
        Limit = new int[3];
        for(int i = 0; i < 3; i++){
            Limit[i] = scan.nextInt();
        }
        visited = new boolean[201][201][201];
        possible = new boolean[201];
    }

    static void bfs(int x1, int x2, int x3){
        Queue<State> queue = new LinkedList<>();
        visited[x1][x2][x3] = true;
        queue.add(new State(new int[]{x1,x2,x3}));
        while(!queue.isEmpty()){
            State st = queue.poll();
            if(st.X[0] == 0) possible[st.X[2]] = true;
            for(int from = 0; from < 3; from++){
                for(int to = 0; to < 3; to++){
                    if(from == to) continue;
                    State nxt = st.move(from, to, Limit);
                    if(!visited[nxt.X[0]][nxt.X[1]][nxt.X[2]]){
                        visited[nxt.X[0]][nxt.X[1]][nxt.X[2]] = true;
                        queue.add(nxt);
                    }
                }
            }
        }
    }

    static void pro(){
        bfs(0,0,Limit[2]);
        for(int i = 0; i < 201; i++){
            if(possible[i]){
                sb.append(i).append(' ');
            }
        }
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
