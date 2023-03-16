package Programmers_Lvl2;

public class 양궁대회 {

    static int[] lion;
    static int[] res = {-1};
    static int max = Integer.MIN_VALUE;

    public static int[] solution(int n, int[] info) {
        lion = new int[11];
        dfs(info, n, 1);
        return res;
    }

    public static void dfs(int[] info, int n, int cnt){
        int lionPoint = 0;
        int apeachPoint = 0;
        if(cnt == n +1){
            for(int i = 0; i < 11; i++){
                if(lion[i] > info[i]) lionPoint += 10 - i;
                else if (info[i] != 0) apeachPoint += 10 - i;
            }
            if(lionPoint > apeachPoint){
                if(max <= lionPoint - apeachPoint){
                    max = lionPoint - apeachPoint;
                    res = lion.clone();
                }
            }
            return;
        }

        // 라이언은 어피치가 쏜 곳의 +1 만큼의 개수만큼만 쏘면 점수를 갖으므로 굳이 더 많은 화살을 낭비할 필요가 없다.
        for(int i = 0; i < 11 && lion[i] < info[i] + 1; i++){
            ++lion[i];
            dfs(info, n, cnt +1);
            --lion[i];
        }
    }

    public static void main(String[] args) {
        int n = 9;
        int[] info = {0,0,1,2,0,1,1,1,1,1,1};
        solution(n,info);
    }
}
