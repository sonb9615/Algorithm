package Simulation;

import java.io.*;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class 아기상어_16236 {

    static FastReader scan = new FastReader();
    static int N;
    static int[][] map;
    static int[][] dir = {{-1,0},{0,-1},{1,0},{0,1}};
    static class Node{
        public int x, y, dist;
        public Node(int _y, int _x, int _dist){
            this.x = _x;
            this.y = _y;
            this.dist = _dist;
        }
    }
    static int[] start;

    static void input(){
        N = scan.nextInt();
        map = new int[N][N];
        start = new int[2];
        for(int i = 0; i < N; i++){
            for(int j = 0; j < N; j++){
                map[i][j] = scan.nextInt();
                if(map[i][j] == 9){
                    start[0] = i;
                    start[1] = j;
                    map[i][j] = 0;
                }
            }
        }
    }

    static void func(){
        int eat = 0;
        int age = 2;
        int time = 0;
        Queue<Node> queue = new LinkedList<>();
        queue.add(new Node(start[0], start[1], 0));
        while(true){
            int[][] dist = new int[N][N];
            ArrayList<Node> arr = new ArrayList<>();
            while(!queue.isEmpty()){
                Node node = queue.poll();
                for(int i = 0; i < 4; i++){
                    int newY = node.y + dir[i][0];
                    int newX = node.x + dir[i][1];
                    if(newX >= 0 && newY >= 0 && newX < N && newY < N && dist[newY][newX] == 0 && map[newY][newX] <= age){
                        dist[newY][newX] = dist[node.y][node.x] + 1;
                        queue.add(new Node(newY, newX, dist[newY][newX]));
                        if(1 <= map[newY][newX] && map[newY][newX] <= 6 && map[newY][newX] < age){
                            arr.add(new Node(newY, newX, dist[newY][newX]));
                        }
                    }
                }
            }

            if(arr.size() == 0){
                System.out.println(time);
                return;
            }

            Node currentFish = arr.get(0);
            for(int i = 1; i < arr.size(); i++){
                if(currentFish.dist > arr.get(i).dist) currentFish = arr.get(i);
                else if(currentFish.dist == arr.get(i).dist){
                    if(currentFish.y > arr.get(i).y) currentFish = arr.get(i);
                    else if(currentFish.y == arr.get(i).y){
                        if(currentFish.x > arr.get(i).x) currentFish = arr.get(i);
                    }
                }
            }
            time += currentFish.dist;
            ++eat;
            map[currentFish.y][currentFish.x] = 0;
            if(eat == age){
                ++age;
                eat = 0;
            }
            queue.add(currentFish);
        }
    }

    public static void main(String[] args) {
        input();
        func();
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
