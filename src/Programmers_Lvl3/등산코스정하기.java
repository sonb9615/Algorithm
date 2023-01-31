package Programmers_Lvl3;

import java.util.*;

public class 등산코스정하기 {

    static class Corn{
        int to, dist;
        public Corn(int _to, int _dist){
            this.to = _to;
            this.dist = _dist;
        }
    }

    static class Info{
        int idx, weight;
        public Info(int _idx, int _weight){
            this.idx = _idx;
            this.weight = _weight;
        }
    }

    static ArrayList<Corn>[] adj;
    static int[] dist;
    static boolean[] ends;
    static boolean[] starts;

    public static int[] solution(int n, int[][] paths, int[] gates, int[] summits) {
        int[] answer = new int[2];
        adj = new ArrayList[n+1];
        ends = new boolean[n+1];
        starts = new boolean[n+1];

        for(int i = 0; i < summits.length; i++){
            ends[summits[i]] = true;
        }
        for(int i = 0; i < gates.length; i++){
            starts[gates[i]] = true;
        }

        for(int i = 1; i < n+1; i++) adj[i] = new ArrayList<>();
        for(int i = 0; i < paths.length; i++){
            int x = paths[i][0];
            int y = paths[i][1];
            int dist = paths[i][2];
            if(starts[x] || ends[y]) adj[x].add(new Corn(y, dist));
            else if(starts[y] || ends[x]) adj[y].add(new Corn(x, dist));
            else{
                adj[x].add(new Corn(y, dist));
                adj[y].add(new Corn(x, dist));
            }
        }

        Arrays.sort(summits);
        int min = Integer.MAX_VALUE;
        dijkstra(gates, n);
        for(int j = 0; j < summits.length; j++){
            if(min > dist[summits[j]]){
                min = dist[summits[j]];
                answer[0] = summits[j];
                answer[1] = min;
            }
        }

        return answer;
    }

    public static void dijkstra( int[] gates, int n){

        boolean[] visited = new boolean[n+1];
        dist = new int[n+1];
        for(int i = 1; i < n+1; i++) dist[i] = Integer.MAX_VALUE;
        Queue<Info> queue = new LinkedList<>();
        for(int i = 0; i < gates.length; i++){
            queue.add(new Info(gates[i],0));
            dist[gates[i]] = 0;
            visited[gates[i]] = true;
        }

        while(!queue.isEmpty()){
            Info info = queue.poll();
//            if(info.weight != dist[info.idx]) continue;
            for(Corn corn : adj[info.idx]){
                int x = Math.max(corn.dist, dist[info.idx]);
                if(dist[corn.to] > x){
                    dist[corn.to] = x;
                }
                if(visited[corn.to]) continue;
                visited[corn.to] = true;
                if(ends[corn.to]) continue;
                if(starts[corn.to]) continue;
                queue.add(new Info(corn.to, dist[corn.to]));
            }
        }
    }

    public static void main(String[] args) {
//        int n = 7;
//        int[][] paths = {{1, 4, 4}, {1, 6, 1}, {1, 7, 3}, {2, 5, 2}, {3, 7, 4}, {5, 6, 6}};
//        int[] gates = {1};
//        int[] summits = {2,3,4};

        int n = 6;
        int[][] paths = {{1, 2, 3}, {2, 3, 5}, {2, 4, 2}, {2, 5, 4}, {3, 4, 4}, {4, 5, 3}, {4, 6, 1}, {5, 6, 1}};
        int[] gates = {1,3};
        int[] summits = {5};

//        int n = 2;
//        int[][] paths = {{1, 2, 1}};
//        int[] gates = {1};
//        int[] summits = {2};
        solution(n,paths,gates,summits);
    }
}
