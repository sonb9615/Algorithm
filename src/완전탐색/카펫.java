package 완전탐색;

public class 카펫 {
    public int[] solution(int brown, int yellow) {
        int[] answer = new int[2];
        int sum = brown + yellow;

        for(int i = 1; i <= sum; i++){
            int cols = sum / i;
            if((i -2) * (cols - 2) == yellow) {
                answer[0] = cols;
                answer[1] = i;
                break;
            }
        }
        return answer;
    }
}
