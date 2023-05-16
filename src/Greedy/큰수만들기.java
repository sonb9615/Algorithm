package Greedy;

public class 큰수만들기 {

    public static String solution(String number, int k) {
        StringBuilder sb = new StringBuilder();
        int idx = 0;
        for(int i = 0; i < number.length() - k; i++){   // 최종 길이
            int max = 0;
            for(int j = idx; j <= i + k; j++){  // 제외시킬 단어 수 포함
                if(max < number.charAt(j) - '0'){
                    max = number.charAt(j) - '0';
                    // 시작점 갱신
                    idx = j+1;
                }
            }
            sb.append(max);
        }
        return sb.toString();
    }

    public static void main(String[] args) {
        System.out.println(solution("4177252841", 4));
    }
}
