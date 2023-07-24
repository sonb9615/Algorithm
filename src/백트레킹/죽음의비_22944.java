package 백트레킹;

import java.io.*;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class 죽음의비_22944 {

    static FastReader scan = new FastReader();
    static int N, H, D, min;
    static String[][] arr;
    static int[] start;
    static int[][] dir = {{0,-1},{1,0},{0,1},{-1,0}};
    static int[][] dist;

    static class Ele{
        int x, y, hp, uhp, len;
        public Ele(int _x, int _y, int _hp, int _uhp, int _len){
            this.x = _x;
            this.y = _y;
            this.hp = _hp;
            this.uhp = _uhp;
            this.len = _len;
        }
    }

    static void input(){
        N = scan.nextInt();
        H = scan.nextInt();
        D = scan.nextInt();
        arr = new String[N][N];
        dist = new int[N][N];
        start = new int[2];
        for(int i = 0; i < N; i++){
            String str = scan.next();
            for(int j = 0; j < N; j++){
                arr[i][j] = String.valueOf(str.charAt(j));
                if("S".equals(arr[i][j])){
                    start[0] = i;
                    start[1] = j;
                }
            }
        }
        min = Integer.MAX_VALUE;
    }

    static void pro(){
        dist[start[0]][start[1]] = H;
        Ele ele = new Ele(start[1], start[0], H, 0, 0);
        bfs(ele);
    }

    static void bfs(Ele ele){
        Queue<Ele> queue = new LinkedList<>();
        queue.add(ele);
        while(!queue.isEmpty()){
            Ele currEle = queue.poll();
            for(int i = 0; i < 4; i++){
                int nx = currEle.x + dir[i][1];
                int ny = currEle.y + dir[i][0];
                int hp = currEle.hp;
                int uhp = currEle.uhp;
                if(ny < 0 || nx < 0 || ny >= N || nx >= N) continue;
                if("E".equals(arr[ny][nx])){
                    min = Integer.min(min, currEle.len + 1);
                    continue;
                }
                if(currEle.uhp > 0) --uhp;
                else --hp;
                if("U".equals(arr[ny][nx])) uhp = D;
                if(dist[ny][nx] < hp + uhp){
                    dist[ny][nx] = hp + uhp;
                    queue.add(new Ele(nx,ny, hp, uhp, currEle.len+1));
                }
            }
        }
    }

    public static void main(String[] args) {
        input();
        pro();
        if(min == Integer.MAX_VALUE) min = -1;
        System.out.println(min);
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
