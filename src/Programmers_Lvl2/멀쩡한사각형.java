package Programmers_Lvl2;

public class 멀쩡한사각형 {

    public static long solution(int w, int h) {
        long answer = 1;

        long longW = Long.valueOf(w);
        long longH = Long.valueOf(h);

        if(w == h){
            answer = (longH * longW) - longH;
        }else{
            long wHGcd = Long.valueOf(gcd(w,h));
            answer = longH * longW - (longH + longW - wHGcd);
        }


        return answer;
    }

    public static int gcd(int a, int b){

        int rtn = 1;
        int min = (a > b) ? b : a;
        for(int i = 1; i <= min; i++){
            if(a % i == 0 && b % i == 0){
                rtn = i;
            }

        }

        return rtn;
    }

    public static void main(String[] args){

    }
}
