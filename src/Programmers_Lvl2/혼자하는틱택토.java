package Programmers_Lvl2;

public class 혼자하는틱택토 {

    public static int solution(String[] board) {
        int answer = 1;
        int[] arr = new int[2];
        for(int i = 0; i < 3; i++){
            String str = board[i];
            for(int j = 0; j < 3; j++){
                if(str.charAt(j) == '.') continue;
                if(str.charAt(j) == 'O') ++arr[0];
                else ++arr[1];
            }
        }
        // O가 X보다 적은경우 || O > X+1 인경우
        if(arr[0] - arr[1] < 0 || arr[0] - arr[1] > 1) return 0;
        if(arr[0] >= 3){
            //O로 끝나는 경우
            if(isSame(board,'O')){
                if(isSame(board,'X')) return 0; // X 3개 연속
                if(arr[0] - arr[1] == 1) return 1; // O == X+1
                else return 0;
            }
        }
        // X로 끝나는 경우
        if(arr[1] >= 3){
            if(isSame(board,'X')){
                if(arr[0] - arr[1] == 0) return 1; // O == X
                else return 0;
            }
        }
        return answer;
    }

    public static boolean isSame(String[] board, char c){

        for(int i = 0; i < 3; i++){
            boolean chk = true;
            for(int j = 0; j < 3; j++){
                if(board[i].charAt(j) != c) chk = false;
            }
            if(chk) return true;
        }

        for(int i = 0; i < 3; i++){
            boolean chk = true;
            for(int j = 0; j < 3; j++){
                if(board[j].charAt(i) != c) chk = false;
            }
            if(chk) return true;
        }

        if(board[0].charAt(0) == c && board[1].charAt(1) == c && board[2].charAt(2) == c){
            return true;
        }
        if(board[0].charAt(2) == c && board[1].charAt(1) == c && board[2].charAt(0) == c){
            return true;
        }
        return false;
    }

    public static void main(String[] args) {
        String[] board = {"XXX", "XOO", "OOO"};
//        String[] board = {"OOO", "XOO", "XXX"};
        System.out.println(solution(board));
    }
}
