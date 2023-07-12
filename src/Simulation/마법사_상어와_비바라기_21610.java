package Simulation;

import java.io.*;
import java.util.ArrayList;
import java.util.StringTokenizer;

public class 마법사_상어와_비바라기_21610 {

    static FastReader scan = new FastReader();
    static int[][] dist = {{0,0},{0,-1},{-1,-1},{-1,0},{-1,1},{0,1},{1,1},{1,0},{1,-1}};
    static int N,M;
    static int[][] arr, process, cloud;
    static boolean[][] visited;

    static void input(){
        N = scan.nextInt();
        M = scan.nextInt();
        arr = new int[N+1][N+1];
        for(int i = 1; i < N+1; i++){
            for(int j = 1; j < N+1; j++){
                arr[i][j] = scan.nextInt();
            }
        }
        process = new int[M][2];
        for(int i = 0; i < M; i++){
            process[i][0] = scan.nextInt();
            process[i][1] = scan.nextInt();
        }
        cloud = new int[][]{{N-1,1},{N-1,2},{N,1},{N,2}};
    }

    static void func(int num, int count){
        int cnt = count % N;
        visited = new boolean[N+1][N+1];
        int plusY = dist[num][0] * cnt;
        int plusX = dist[num][1] * cnt;
        for(int i = 0; i < cloud.length; i++){
            cloud[i][0] = moveCloud(cloud[i][0] + plusY, N);
            cloud[i][1] = moveCloud(cloud[i][1] + plusX, N);
            visited[cloud[i][0]][cloud[i][1]] = true;
            arr[cloud[i][0]][cloud[i][1]]++;
        }
        for (int[] ints : cloud) {
            arr[ints[0]][ints[1]] += checkBasket(ints[0], ints[1]);
        }
        ArrayList<int[]> tempCloud = new ArrayList<>();
        for(int i = 1; i < N+1; i++){
            for(int j = 1; j < N+1; j++){
                if(visited[i][j]) continue;
                if(arr[i][j] < 2) continue;
                arr[i][j] -= 2;
                tempCloud.add(new int[]{i, j});
            }
        }
        cloud = new int[tempCloud.size()][2];
        for(int i = 0 ; i < tempCloud.size(); i++){
            cloud[i][0] = tempCloud.get(i)[0];
            cloud[i][1] = tempCloud.get(i)[1];
        }
    }

    static int moveCloud(int x, int n){
        if(x > n) x -= n;
        if(x < 1) x += n;
        return x;
    }

    static int checkBasket(int y, int x){
        int cnt = 0;
        for(int i = 1; i < 5; i++){
            int checkBasketY = y + dist[i*2][0];
            int checkBasketX = x + dist[i*2][1];
            if(checkBasketX > N || checkBasketY > N || checkBasketX < 1 || checkBasketY < 1) continue;
            if(arr[checkBasketY][checkBasketX] < 1) continue;
            ++cnt;
        }
        return cnt;
    }


    public static void main(String[] args) {
        input();
        for(int i = 0 ; i < M; i++){
            func(process[i][0], process[i][1]);
        }
        int result = 0;
        for(int i = 1; i < N+1; i++){
            for(int j = 1; j < N+1; j++){
                result += arr[i][j];
            }
        }
        System.out.println(result);
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
