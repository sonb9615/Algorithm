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
    static int[][] child;
    static Edge[] edges;
    static int[][] answer;
    static ArrayList<Integer> arr;

    public static int[][] solution(int[][] nodeinfo) {
        child = new int[nodeinfo.length+1][2];
        int nodeCnt = nodeinfo.length;
        edges = new Edge[nodeinfo.length];
        answer = new int[2][nodeCnt];
        arr = new ArrayList<>();
        for(int i = 1; i < nodeCnt + 1; i++){
            edges[i-1] = new Edge(i, nodeinfo[i-1][0], nodeinfo[i-1][1]);
        }

        Arrays.sort(edges, new Comparator<Edge>(){
            public int compare(Edge n1, Edge n2){
                if(n1.y == n2.y) return n1.x - n2.x;
                else return n2.y - n1.y;
            }
        });

        Edge root = edges[0];
        for(int i = 1; i < nodeCnt; i++){
            makeTree(root, edges[i], nodeinfo);
        }

        preorder(root.idx);
        for(int i = 0; i < nodeCnt; i++){
            answer[0][i] = arr.get(i);
        }
        arr = new ArrayList<>();
        postOrder(root.idx);
        for(int i = 0; i < nodeCnt; i++){
            answer[1][i] = arr.get(i);
        }
        return answer;
    }

    public static void makeTree(Edge parentE, Edge childE, int[][] nodeInfo){
        if(parentE.x > childE.x){
            if(child[parentE.idx][0] == 0) child[parentE.idx][0] = childE.idx;
            else makeTree(new Edge(child[parentE.idx][0]
                    ,nodeInfo[child[parentE.idx][0]-1][0], nodeInfo[child[parentE.idx][0]-1][1]), childE, nodeInfo);
        }else{
            if(child[parentE.idx][1] == 0) child[parentE.idx][1] = childE.idx;
            else makeTree(new Edge(child[parentE.idx][1]
                    ,nodeInfo[child[parentE.idx][1]-1][0], nodeInfo[child[parentE.idx][1]-1][1]), childE, nodeInfo);
        }
    }

    public static void preorder(int parentIdx){
        arr.add(parentIdx);
        for(int i = 0; i < 2; i++){
            if(child[parentIdx][i] == 0) continue;
            preorder(child[parentIdx][i]);
        }
    }

    public static void postOrder(int parentIdx){
        for(int i = 0; i < 2; i++){
            if(child[parentIdx][i] == 0) continue;
            postOrder(child[parentIdx][i]);
        }
        arr.add(parentIdx);
    }

    public static void main(String[] args) {
        int[][] nodeInfo = {{5,3},{11,5},{13,3},{3,5},{6,1},{1,3},{8,6},{7,2},{2,2}};
        solution(nodeInfo);
    }
}
