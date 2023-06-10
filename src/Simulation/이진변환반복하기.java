package Simulation;

public class 이진변환반복하기 {
    public static int[] solution(String s) {
        int[] answer = new int[2];
        while(!"1".equals(s)){
            StringBuilder sb = new StringBuilder();
            for(char c : s.toCharArray()){
                if(c == '1') sb.append(c);
                else ++answer[1];
            }
            int x = sb.length();
            sb = new StringBuilder();
            while (x > 1) {
                sb.insert(0,x % 2);
                x = x / 2;
            }
            sb.insert(0,"1");
            ++answer[0];
            s = sb.toString();
        }
        return answer;
    }

    public static void main(String[] args) {
        String str = "110010101001";
        solution(str);
    }

}
