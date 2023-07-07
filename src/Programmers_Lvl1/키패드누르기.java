package Programmers_Lvl1;

public class 키패드누르기 {

    static StringBuilder sb;
    static int L, R;

    public static String solution(int[] numbers, String hand) {
        sb = new StringBuilder();
        L = 10;
        R = 12;
        for(int num : numbers){
            if(num == 0) num = 11;
            if(num == 1 || num == 4 || num == 7) {
                convertLocation(0, num);
                continue;
            }
            if(num == 3 || num == 6 || num == 9){
                convertLocation(1, num);
                continue;
            }
            int fromL = calcDist(L, num);
            int fromR = calcDist(R, num);
            if(fromL == fromR){
                if("left".equals(hand)){
                    convertLocation(0, num);
                }else{
                    convertLocation(1, num);
                }
                continue;
            }
            if(fromL > fromR) convertLocation(1, num);
            if(fromL < fromR) convertLocation(0, num);

        }
        return sb.toString();
    }

    public static void convertLocation(int LR, int num){
        if(LR == 0){
            sb.append("L");
            L = num;
        }else{
            sb.append("R");
            R = num;
        }
    }

    public static int calcDist(int start, int end){
        int cnt = 0;
        while(start != end){
            if(start < end){
                if(start + 3 > end) start++;
                else start += 3;
            }else{
                if(start - 3 < end) start--;
                else start -= 3;
            }
            ++cnt;
        }
        return cnt;
    }

    public static void main(String[] args) {
        int[] numbers = {7, 0, 8, 2, 8, 3, 1, 5, 7, 6, 2};
        String hand = "left";
        System.out.println(solution(numbers, hand));

    }
}