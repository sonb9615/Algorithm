package Programmers_Lvl3;

public class 스티커모으기_2 {

    public static int solution(int sticker[]) {
        int answer = 0;
        int n = sticker.length;
        if(n == 1) return sticker[0];
        int[][] dy = new int[n+2][2];
        dy[0][0] = sticker[0];
        if(n > 1) dy[1][1] = sticker[1];
        if(n > 2) {
            dy[2][0] = sticker[0] + sticker[2];
            dy[2][1] = sticker[2];
        }
        for(int i = 3; i < n; i++){
            if(i == n-1) dy[i][0] = Math.max(dy[i-2][0], dy[i-3][0]);
            else dy[i][0] = Math.max(dy[i-2][0], dy[i-3][0]) + sticker[i];
            dy[i][1] = Math.max(dy[i-2][1], dy[i-3][1]) + sticker[i];
        }
        answer = Math.max(Math.max(dy[n-2][0], dy[n-2][1]), Math.max(dy[n-1][0], dy[n-1][1]));
        return answer;
    }

    public static void main(String[] args) {
        int[] stickers = {100, 1, 3, 2};
        System.out.println(solution(stickers));
    }
}
