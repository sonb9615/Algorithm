package Programmers_Lvl2;

public class 리코쳇로봇 {

    static int[][] dir = {{-1,0},{1,0},{0,-1},{0,1}};
    static boolean[][] visited;

    public int solution(String[] board) {
        int answer = 0;
        return answer;
    }

    public static void dfs(int i, int j, String[] board){
        if(visited[i][j]) return;
        if(i == 0 || j == 0 || i == board.length - 1 || j == board[i].length() - 1){
            visited[i][j] = true;
        }
    }
}
