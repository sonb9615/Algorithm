package 스킬체크_2;


import java.util.Stack;

public class Solution_2 {

    public static String solution(String p) {
        String answer = "";
        String U = "";
        String V = "";
        boolean chk = true;

        while(chk){
            int idx = getU(p);
            U = p.substring(0,idx);
            if(idx <= p.length()){
                V = p.substring(idx);
            }else{
                V ="";
            }
            if("".equals(U) || U.charAt(0) == '('){
                answer += U;
            }else{
                String tmp = "(";
                tmp += solution(V);
                tmp += ")";

                String str = U.substring(1,U.length()-1);
                for(int i = 0; i < str.length(); i++){
                    if(str.charAt(i) == '('){
                        tmp += ')';
                    }else{
                        tmp += '(';
                    }
                }
                answer += tmp;
                V = "";
            }

            if(V.length() == 0){
                chk = false;
            }else{
                p = V;
            }

        }
        return answer;
    }

    public static int getU(String str){

        String u = "";
        Stack<Character> st = new Stack<Character>();
        int idx = -1;
        int s = 0;
        int f = 0;
        for(int i = 0; i < str.length(); i++){

            if('(' == str.charAt(i)){
                ++s;
            }else{
                ++f;
            }

            if(s == f){
                idx = i;
                break;
            }
        }

        return idx+1;
    }


    public static void main(String[] args) {
        System.out.println(solution(")("));
    }
}
