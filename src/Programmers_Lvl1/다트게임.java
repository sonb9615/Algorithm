package Programmers_Lvl1;

import java.util.ArrayList;
import java.util.List;

public class 다트게임 {

    public static int solution(String dartResult) {
        int answer = 0;
        List<Integer> arr  =new ArrayList<>();
        int idx = -1;
        for(int i = 0; i < dartResult.length(); i++){
            char trg = dartResult.charAt(i);
            int val = trg - '0';
            if(val >= 0 && val <= 9){
                if(val == 1 && dartResult.charAt(i+1) - '0' == 0){
                    val = 10;
                    ++i;
                }
                arr.add(val);
            }else{
                if(trg == 'D'){
                    arr.set(arr.size()-1, (int)Math.pow(arr.get(arr.size()-1),2));
                }else if(trg == 'T'){
                    arr.set(arr.size()-1, (int)Math.pow(arr.get(arr.size()-1),3));
                }else if(trg == '*'){
                    arr.set(arr.size()-1,arr.get(arr.size()-1) * 2);
                    if(arr.size() > 1){
                        arr.set(arr.size()-2,arr.get(arr.size()-2) * 2);
                    }
                }else if(trg == '#'){
                    arr.set(arr.size()-1,arr.get(arr.size()-1) * -1);
                }
            }
        }

        for(int a : arr){
            answer += a;
        }
        return answer;
    }

    public static void main(String[] args) {
        System.out.println(solution("10D10D"));
    }

}
