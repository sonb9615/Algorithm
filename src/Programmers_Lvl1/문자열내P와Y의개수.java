package Programmers_Lvl1;

public class 문자열내P와Y의개수 {

    boolean solution(String s) {
        int pCnt = 0;
        int yCnt = 0;
        for(char c : s.toCharArray()){
            if(c == 'P' || c == 'p') pCnt++;
            if(c == 'y' || c == 'Y') yCnt++;
        }
        if(pCnt == yCnt) return true;
        else return false;
    }
}
