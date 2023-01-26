package Programmers_Lvl3;

public class 가장긴팰린드롬 {

    public static int solution(String s){
        int answer = 0;
        int right = s.length()-1;
        int max = Integer.MIN_VALUE;

        for(int i = 0; i < s.length(); i++){
            max = check(s, i, right);
            answer = Integer.max(answer, max);
        }

        return answer;
    }

    public static int check(String s, int left, int right){
        int rtn = 0;
        int start = left;
        int cnt = 1;
        while(left <= right){
            if(left == right){
                ++rtn;
                break;
            }
            if(s.charAt(left) == s.charAt(right)){
                ++left;
                rtn += 2;
                --right;
            }else{
                left = start;
                rtn = 0;
                right = s.length() - 1 - cnt;
                ++cnt;
            }

        }

        return rtn;
    }

    public static void main(String[] args) {
        String s = "abbb";
        System.out.println(solution(s));
    }
}
