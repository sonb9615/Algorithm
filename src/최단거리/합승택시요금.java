package 최단거리;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Comparator;
import java.util.PriorityQueue;

public class 합승택시요금 {

    static class Node{
        int to, cost;
        public Node(int _to, int _cost){
            this.to = _to;
            this.cost = _cost;
        }
    }

    static ArrayList<Node>[] arr;

    public static int solution(int n, int s, int a, int b, int[][] fareList) {
        int answer = Integer.MAX_VALUE;

        arr = new ArrayList[n+1];
        for(int i = 1; i < n+1; i++) arr[i] = new ArrayList<>();
        for(int i = 0; i < fareList.length; i++){
            int x = fareList[i][0];
            int y = fareList[i][1];
            arr[x].add(new Node(y, fareList[i][2]));
            arr[y].add(new Node(x, fareList[i][2]));
        }

        int[] startA = new int[n+1];
        int[] startB = new int[n+1];
        int[] start = new int[n+1];

        Arrays.fill(startA, Integer.MAX_VALUE);
        Arrays.fill(startB, Integer.MAX_VALUE);
        Arrays.fill(start, Integer.MAX_VALUE);

        dijkstra(a, startA);
        dijkstra(b, startB);
        dijkstra(s, start);

        for(int i = 1; i < n+1; i++){
            answer = Integer.min(answer, startA[i] + startB[i] + start[i]);
        }

        return answer;
    }

    public static int[] dijkstra(int start, int[] startArr){
        PriorityQueue<Node> pq = new PriorityQueue<>(Comparator.comparingInt(o -> o.cost));
        pq.offer(new Node(start, 0));
        startArr[start] = 0;
        while(!pq.isEmpty()){
            Node info = pq.poll();
            for(Node node : arr[info.to]){
                if(startArr[node.to] > startArr[info.to] + node.cost){
                    startArr[node.to] = startArr[info.to] + node.cost;
                    pq.offer(new Node(node.to, startArr[node.to]));
                }
            }
        }
        return startArr;
    }

    public static void main(String[] args) {
        int[][] fareList = {{4, 1, 10}, {3, 5, 24}, {5, 6, 2}, {3, 1, 41}, {5, 1, 24}, {4, 6, 50}, {2, 4, 66}, {2, 3, 22}, {1, 6, 25}};
        solution(6, 4, 6, 2, fareList);
    }
}
