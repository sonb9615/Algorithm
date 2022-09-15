package Programmers_Lvl1;

public class 소수찾기 {

    public int solution(int n) {
        int answer = 0;
        boolean[] prime_list = check_prime(n);

        for(int i = 0; i < prime_list.length; i++){
            if(!prime_list[i]){
                ++answer;
            }
        }
        return answer;
    }

    public static boolean[] check_prime(int n){
        boolean[] chk_list = new boolean[n+1];
        chk_list[0] = true;
        chk_list[1] = true;
        for(int i = 2; i < Math.sqrt(n); i++){
            if(chk_list[i]){
                continue;
            }
            for(int j = i*i; j < chk_list.length; j = j + i){
                chk_list[j] = true;
            }
        }
        return chk_list;
    }


    public static void main(String[] args) {

    }


}
