package Programmers_Lvl1;

public class 바탕화면정리 {
    public static int[] solution(String[] wallpaper) {
        int[] answer = new int[4];
        answer[0] = 51;
        answer[1] = 51;
        answer[2] = -1;
        answer[3] = -1;
        for(int i = 0 ; i < wallpaper.length; i++){
            for(int j = 0 ; j < wallpaper[i].length(); j++){
                if(wallpaper[i].charAt(j) == '#'){
                    answer[0] = Integer.min(answer[0], i);
                    answer[1] = Integer.min(answer[1], j);
                    answer[2] = Integer.max(answer[2], i+1);
                    answer[3] = Integer.max(answer[3], j+1);
                }
            }
        }
        return answer;
    }

    public static void main(String[] args) {
        String[] arr = {".#...", "..#..", "...#."};
        int[] ans = solution(arr);
        for(int i : ans){
            System.out.println(i);
        }
    }
}
