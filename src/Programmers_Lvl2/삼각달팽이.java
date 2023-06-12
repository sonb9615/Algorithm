package Programmers_Lvl2;

public class 삼각달팽이 {

    public static int[] solution(int n) {
        int[] answer = new int[n*(n+1)/2];
        int[][] temp = new int[n][n];

        int x = 0;
        int y = -1;
        int val = 0;
        for(int i = 0; i < n; i++){
            for(int j = i; j < n; j++){
                if(i % 3 == 0){
                    ++y;
                }else if(i % 3 == 1){
                    ++x;
                }else{
                    --x;
                    --y;
                }
                temp[y][x] = ++val;
            }
        }

        int idx = -1;
        for(int i = 0; i < answer.length; i++){
            if(idx == answer.length - 1) break;
            for(int j = 0; j < n; j++){
                for(int k = 0; k < n; k++){
                    if(temp[j][k] == 0) break;
                    answer[++idx] = temp[j][k];
                }
            }
        }

        return answer;
    }

    public static void main(String[] args) {
        solution(4);
    }
}
