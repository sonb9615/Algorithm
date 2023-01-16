package 최단거리;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.PriorityQueue;

public class 가장먼노드 {

    static int[] indeg, dist;
    static class Edge{
        int to, dist;
        public Edge(int _to, int _dist){
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

    static ArrayList<Edge>[] adj;
    static int maxDist;

    public static int solution(int n, int[][] edge) {
        int answer = 0;
        maxDist = -1;
        adj = new ArrayList[n+1];
        indeg = new int[n+1];
        dist = new int[n+1];
        for(int i = 1; i < n+1; i++) adj[i] = new ArrayList<>();
        for(int i = 0; i < edge.length; i++){
            int x = edge[i][0];
            int y = edge[i][1];
            adj[x].add(new Edge(y,1));
            adj[y].add(new Edge(x,1));
            indeg[x]++;
            indeg[y]++;
        }

        dijkstra(1);
        for(int i = 1; i < n+1; i++){
            if(dist[i] == maxDist) ++answer;
        }

        return answer;
    }

    public static void dijkstra(int start){
        PriorityQueue<Info> pq = new PriorityQueue<>(Comparator.comparingInt(o -> o.weight));
        for(int i = 1; i < dist.length; i++) dist[i] = Integer.MAX_VALUE;
        pq.add(new Info(start,0));
        dist[start] = 0;

        while(!pq.isEmpty()){
            Info info = pq.poll();
            if(dist[info.idx] != info.weight) continue;
            for(Edge e : adj[info.idx]){
                if(dist[e.to] > dist[info.idx] + e.dist){
                    dist[e.to] = dist[info.idx] + e.dist;
                    maxDist = Math.max(maxDist, dist[e.to]);
                    pq.add(new Info(e.to, dist[e.to]));
                }
            }
        }
    }

    public static void main(String[] args) {
        int n = 6;
        int[][] vertex = {{3, 6}, {4, 3}, {3, 2}, {1, 3}, {1, 2}, {2, 4}, {5, 2}};
        System.out.println(solution(n,vertex));
    }
}
