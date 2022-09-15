package Programmers_Lvl1;

public class 최소직사각형 {


    public static int solution(int[][] sizes) {
        int answer = 0;
        int max = 0; // max
        int min = 0;  //tmp

        for(int[] size : sizes){

            if(size[0] > size[1]){
                if(max < size[0]){
                    max = size[0];
                }
                if(min < size[1]){
                    min = size[1];
                }
            }else{
                if(max < size[1]){
                    max = size[1];
                }
                if(min < size[0]){
                    min = size[0];
                }
            }
        }

        answer = max * min;
        return answer;
    }

    public static void main(String[] args) {

        int[][] sizes = {{60, 50}, {30, 70}, {60, 30}, {80, 40}};
        System.out.println(solution(sizes));
    }
}
