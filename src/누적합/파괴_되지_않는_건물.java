package 누적합;

public class 파괴_되지_않는_건물 {

    public static int solution(int[][] board, int[][] skill) {
        int answer = 0;
        int[][] degree = new int[board.length+1][board[0].length+1];
        for(int i = 0; i < skill.length; i++){
            int num = skill[i][0] == 1 ? skill[i][5] * -1 : skill[i][5];
            int r1 = skill[i][1];
            int c1 = skill[i][2];
            int r2 = skill[i][3];
            int c2 = skill[i][4];
            degree[r1][c1] += num;
            degree[r1][c2+1] += num * -1;
            degree[r2+1][c2+1] += num;
            degree[r2+1][c1] += num * -1;
        }
        for(int i = 0; i < degree.length; i++){
            for(int j = 1; j < degree[i].length; j++){
                degree[i][j] += degree[i][j-1];
            }
        }

        for(int i = 0; i < degree[0].length; i++){
            for(int j = 1; j < degree.length; j++){
                degree[j][i] += degree[j-1][i];
            }
        }

        for(int i = 0; i < board.length; i++){
            for(int j = 0; j < board[i].length; j++){
                board[i][j] += degree[i][j];
                if(board[i][j] > 0) ++answer;
            }
        }
        return answer;
    }

    public static void main(String[] args) {
        int[][] board = {{5,5,5,5,5},{5,5,5,5,5},{5,5,5,5,5},{5,5,5,5,5}};
        int[][] skills = {{1,0,0,3,4,4},{1,2,0,2,3,2},{2,1,0,3,1,2},{1,0,1,3,3,1}};
        solution(board, skills);
    }
}
