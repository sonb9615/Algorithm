package Simulation;

public class 기둥과보설치 {

    static boolean[][] wall;
    static boolean[][] pillar;
    static int cnt;

    public static int[][] solution(int n, int[][] build_frame) {
        cnt = 0;
        wall = new boolean[n+1][n+1];
        pillar = new boolean[n+1][n+1];

        for(int i = 0; i < build_frame.length; i++){
            int x = build_frame[i][0];
            int y = build_frame[i][1];
            int a = build_frame[i][2];
            int b = build_frame[i][3];
            if(a == 0) buildPillar(x,y,b,n);
            if(a == 1) buildWall(x,y,b,n);
        }

        int[][] answer = new int[cnt][3];
        int idx = -1;
        for(int i = 0; i < n+1; i++){
            if(idx == cnt) break;
            for(int j = 0; j < n+1; j++){
                if(idx == cnt) break;
                if(pillar[i][j]){
                    answer[++idx][0] = i;
                    answer[idx][1] = j;
                    answer[idx][2] = 0;
                };
                if(wall[i][j]){
                    answer[++idx][0] = i;
                    answer[idx][1] = j;
                    answer[idx][2] = 1;
                }
            }
        }

        return answer;
    }

    public static void buildPillar(int x, int y, int b, int n){
        if(b == 1) {
            if(pillarCheck(x, y)){
                ++cnt;
                pillar[x][y] = true;
            }
        }
        if(b == 0){
            pillar[x][y] = false;
            if(!cancleCheck(n)) pillar[x][y] = true;
            else --cnt;
        }
    }

    public static void buildWall(int x, int y, int b, int n){
        if(y == 0 || x == n) return;
        if(b == 1){
            if(wallCheck(x, y)){
                ++cnt;
                wall[x][y] = true;
            }
        }
        if(b == 0){
            wall[x][y] = false;
            if(!cancleCheck(n)) wall[x][y] = true;
            else --cnt;
        }
    }

    public static boolean cancleCheck(int n){
        for(int i = 0; i < n+1; i++) {
            for (int j = 0; j < n + 1; j++) {
                if(pillar[i][j] && !pillarCheck(i,j)) return false;
                else if(wall[i][j] && !wallCheck(i, j)) return false;
            }
        }
        return true;
    }

    public static boolean wallCheck(int x, int y){
        if(y > 0 && pillar[x][y-1]) return true;
        if(y > 0 && pillar[x+1][y-1]) return true;
        if(x > 0 && wall[x-1][y] && wall[x+1][y]) return true;
        return false;
    }

    public static boolean pillarCheck(int x, int y){
        if(y == 0) return true;
        if(y > 0 && pillar[x][y-1]) return true;
        if(x > 0 && wall[x-1][y] || wall[x][y]) return true;
        return false;
    }

    public static void main(String[] args) {
        int n = 5;
//        int[][] frame = {{1,0,0,1},{1,1,1,1},{2,1,0,1},{2,2,1,1},{5,0,0,1}
//                ,{5,1,0,1},{4,2,1,1},{3,2,1,1}};
        int[][] frame = {{0,0,0,1},{2,0,0,1},{4,0,0,1},{0,1,1,1},{1,1,1,1}
        ,{2,1,1,1},{3,1,1,1},{2,0,0,0},{1,1,1,0},{2,2,0,1}};
        solution(n, frame);
    }
}
