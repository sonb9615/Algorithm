package Programmers_Lvl1;

public class 숫자문자열과영단어 {

    public static int solution_1(String s) {
        StringBuilder answer = new StringBuilder();
        String[] numStr = {"zero","one","two","three","four","five","six","seven","eight","nine"};
        String[] num = {"0","1","2","3","4","5","6","7","8","9"};
        for(int i = 0; i < 10; i++){
            s = s.replaceAll(numStr[i],num[i]);
        }
        return Integer.parseInt(s);
    }


    public static void main(String[] args) {
        String tmp = "1";
        System.out.println(solution_1(tmp));
    }
}
