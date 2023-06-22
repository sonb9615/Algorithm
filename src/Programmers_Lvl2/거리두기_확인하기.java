package Programmers_Lvl2;

public class 거리두기_확인하기 {

    public static int[] solution(String[][] places) {
        int[] answer = new int[places.length];

        for(int i = 0; i < 5; i++){
            boolean chk = true;
            for(int j = 0; j < 5 && chk; j++){
                for(int k = 0; k < 5 && chk; k++){
                    if(places[i][j].charAt(k) == 'P'
                            && !dfs(j, k, places[i])) chk = false;
                }
            }
            if(chk) answer[i] = 1;
        }
        return answer;
    }

    public static boolean dfs(int r1, int c1, String[] place){

        return true;
    }



    public static void main(String[] args) {
        String[][] places = {{"POOOP", "OXXOX", "OPXPX", "OOXOX", "POXXP"}
                , {"POOPX", "OXPXP", "PXXXO", "OXXXO", "OOOPP"}
                , {"PXOPX", "OXOXP", "OXPOX", "OXXOP", "PXPOX"}
                , {"OOOXX", "XOOOX", "OOOXX", "OXOOX", "OOOOO"}
                , {"PXPXP", "XPXPX", "PXPXP", "XPXPX", "PXPXP"}};
        solution(places);
    }
}
