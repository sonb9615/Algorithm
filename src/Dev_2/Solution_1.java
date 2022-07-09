package Dev_2;

public class Solution_1 {


    public static int solution(int[] grade) {
        int answer = 0;

        for(int i = grade.length -1 ; i > 0; i--){
            int diff;
            if(grade[i] <= grade[i-1]){
                diff = grade[i-1] - grade[i];
                grade[i-1] -= diff;
                answer += diff;
            }
        }

        return answer;
    }


    public static void main(String[] args) {

        int[] grade = {5,4,3,2,1};
        solution(grade);

    }


}
