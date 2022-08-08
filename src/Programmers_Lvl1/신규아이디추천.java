package Programmers_Lvl1;

public class 신규아이디추천 {

    public static String solution(String new_id) {
        String answer = "";
        answer = new_id.toLowerCase();
        answer = answer.replaceAll("[^a-z0-9_.-]","");
        int stIdx = -1;
        String str = "";
        for(int i = 0; i < answer.length(); i++){
            if(answer.charAt(i) == '.'){
                if(stIdx == -1){
                    stIdx = i;
                }
            }else{
                if(stIdx > -1){
                    str += ".";
                }
                str += answer.charAt(i);
                stIdx = -1;
            }
        }
        answer = str;
        if(answer.length() > 0){
            if(answer.charAt(0) == '.'){
                answer = answer.substring(1);
            }
            if(answer.length() > 0 && answer.charAt(answer.length()-1) == '.'){
                if(answer.length() == 1){
                    answer = "";
                }else{
                    answer = answer.substring(0,answer.length()-2);
                }
            }
        }
        if(answer.length() == 0){
            answer += "a";
        }
        if(answer.length() > 15){
            if(answer.charAt(14) == '.'){
                answer = answer.substring(0,14);
            }else{
                answer = answer.substring(0,15);
            }
        }
        if(answer.length() <= 2){
            char last = answer.charAt(answer.length() -1);
            while (answer.length() < 3){
                answer += last;
            }
        }
        return answer;
    }

    public static void main(String[] args) {
        String tmp = "...!@BaT#*..y.abcdefghijklm";
        System.out.println(solution(tmp));
    }

}
