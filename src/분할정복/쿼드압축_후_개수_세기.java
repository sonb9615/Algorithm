package 분할정복;

public class 쿼드압축_후_개수_세기 {

    static int[] answer;

    public static int[] solution(int[][] arr) {
        answer = new int[2];
        pro(0,0, arr.length, arr);
        return answer;
    }

    public static void pro(int x, int y, int len, int[][] arr){
        if(check(x,y,len,arr)) {
            ++answer[arr[x][y]];
            return;
        }
        pro(x, y, len/2, arr);
        pro(x+len/2, y, len/2, arr);
        pro(x, y+len/2, len/2, arr);
        pro(x+len/2, y+len/2, len/2, arr);
    }

    public static boolean check(int x, int y, int len, int[][] arr){
        for(int i = x; i < x+len; i++){
            for(int j = y; j < y+len; j++){
                if(arr[i][j] != arr[x][y]) return false;
            }
        }
        return true;
    }


    public static void main(String[] args) {
        int[][] arr = {{1,1,1,1,1,1,1,1},{0,1,1,1,1,1,1,1},{0,0,0,0,1,1,1,1},{0,1,0,0,1,1,1,1}
        ,{0,0,0,0,0,0,1,1},{0,0,0,0,0,0,0,1},{0,0,0,0,1,0,0,1},{0,0,0,0,1,1,1,1}};
//        int[][] arr = {{1, 1, 1, 1}, {1, 1, 1, 1}, {1, 1, 1, 1}, {1, 1, 1, 1}};
        solution(arr);
    }
}
