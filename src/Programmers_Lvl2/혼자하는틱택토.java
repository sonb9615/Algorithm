package Programmers_Lvl2;

public class 혼자하는틱택토 {

    public static int solution(String[] board) {
        int answer = 1;
        int[] arr = new int[2];
        int crsCnt = 0;
        int[] cnt = new int[5];
        for(int i = 0; i < 3; i++){
            String str = board[i];
            int chk = 0;
            for(int j = 0; j < 3; j++){
                if(str.charAt(j) == '.') continue;
                if(str.charAt(j) == 'O') ++arr[0];
                else ++arr[1];
                ++chk;
                ++cnt[j];
                if(i == j) ++cnt[3];
                if(i == 0 && j == 2 || i == 1 && j == 1 || i == 2 && j == 0) ++ cnt[4];
            }
            if(chk == 3) ++crsCnt;
        }

        for(int x : cnt){
            if(x == 3) ++crsCnt;
        }

        if(arr[0] < arr[1]) return 0;
        if(arr[0] + arr[1] > 6) return 0;
        if(arr[0] == arr[1]){
            if(arr[0] > 3) return 1;
            else{
                if(crsCnt > 1) return 0;
            }
        }
        if(arr[0] != arr[1] && arr[0] != arr[1] + 1) return 0;
        return answer;
    }

    public static void main(String[] args) {
        String[] board = {"OOO", "...", "XXX"};
        System.out.println(solution(board));
    }
}
