package Programmers_Lvl2;

import java.util.LinkedList;
import java.util.Queue;

public class 리코쳇로봇 {

    static int[][] dir = {{-1,0},{1,0},{0,-1},{0,1}};
    static int[][] adj;
    static boolean[][] visited;

    static class Node{
        int x, y, cnt;
        public Node(int _x, int _y, int _cnt){
            this.x = _x;
            this.y = _y;
            this.cnt = _cnt;
        }
    }

    public static int solution(String[] board) {
        int answer = 0;
        Node startNode = null;
        Node goalNode = null;
        adj = new int[board.length][board[0].length()];
        visited = new boolean[board.length][board[0].length()];
        for(int i = 0; i < board.length; i++){
            String str = board[i];
            for(int j = 0; j < str.length(); j++){
                if(str.charAt(j) == 'R'){
                    startNode = new Node(j, i, 0);
                }
                if(str.charAt(j) == 'G'){
                    adj[i][j] = -1;
                    goalNode = new Node(j, i, 0);
                }
            }
        }
        return dfs(board, startNode, goalNode);
    }

    public static int dfs(String[] board, Node node, Node goal){

        Queue<Node> queue = new LinkedList<>();
        queue.add(node);
        visited[node.y][node.x] = true;
        while(!queue.isEmpty()){
            Node cur = queue.poll();
            int x = cur.x;
            int y = cur.y;
            int cnt = cur.cnt;
            if(x == goal.x && y == goal.y) return cnt;
            for(int i = 0; i < 4; i++){
                Node next = getNode(i, cur, board);
                if(visited[next.y][next.x]) continue;
                visited[next.y][next.x] = true;
                next.cnt = cnt + 1;
                queue.add(next);
            }
        }
        return -1;
    }

    public static Node getNode(int idx, Node node, String[] board){
        int x = node.x;
        int y = node.y;
        int xVal = dir[idx][0];
        int yVal = dir[idx][1];
        while(x + xVal >= 0 && x + xVal < board[0].length()
                && y +yVal >= 0 && y + yVal < board.length
                && board[y + yVal].charAt(x + xVal) != 'D'){
            x += xVal;
            y += yVal;
        }
        Node newNode = new Node(x,y,0);
        return newNode;
    }


    public static void main(String[] args) {
        String[] board = {"...D..R", ".D.G...", "....D.D", "D....D.", "..D...."};
        solution(board);
    }
}
