package Programmers_Lvl2;

public class N_Queen {

    static int[] queens;
    static int answer;
    public static int solution(int n) {
        answer = 0;
        queens = new int[n];
        locateQueen(n, 0);
        return answer;
    }

    public static void locateQueen(int n, int depth){
        if(depth == n){
            ++answer;
            return;
        }
        for(int i = 0; i < n; i++){
            queens[depth] = i;
            if(check(depth)) locateQueen(n, depth+1);
        }
    }

    public static boolean check(int depth){
        for(int i = 0; i < depth; i++){
            if(queens[i] == queens[depth]) return false;
            if(Math.abs(i-depth) == Math.abs(queens[i] - queens[depth])) return false;
        }
        return true;
    }
}
