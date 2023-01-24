package Programmers_Lvl3;

import java.util.*;

public class 길찾기게임 {

    public static class Edge{
        int idx,x,y;
        public Edge(int _idx, int _x, int _y){
            this.idx = _idx;
            this.x = _x;
            this.y = _y;
        }
    }

    public static int[][] solution(int[][] nodeinfo) {
        int[][] answer = {};
        int[][] child = new int[nodeinfo.length+1][2];
        int nodeCnt = nodeinfo.length;
        PriorityQueue<Edge> pq = new PriorityQueue<>(new Comparator<Edge>() {
            @Override
            public int compare(Edge n1, Edge n2) {
                if(n1.y == n2.y) return n1.x - n2.x;
                else return n2.y - n1.y;
            }
        });

        for(int i = 1; i < nodeCnt + 1; i++){
            pq.add(new Edge(i, nodeinfo[i-1][0], nodeinfo[i-1][1]));
        }

        Queue<Edge> queue = new LinkedList<>();
        Edge parE = pq.poll();
        while(!pq.isEmpty()){
            Edge e = pq.poll();
            if(child[parE.idx][1] > 0) parE = queue.poll();
            if(e.x < parE.x) child[parE.idx][0] = e.idx;
            else child[parE.idx][1] = e.idx;
            queue.add(e);
        }


        return answer;
    }

    public static void main(String[] args) {
        int[][] nodeInfo = {{5,3},{11,5},{13,3},{3,5},{6,1},{1,3},{8,6},{7,2},{2,2}};
        solution(nodeInfo);
    }
}
