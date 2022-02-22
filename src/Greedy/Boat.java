package Greedy;

import java.util.Arrays;

public class Boat {

	public static int solution(int[] people, int limit) {
        int answer = 0;
        Arrays.sort(people);
        int min = people[0];
        int idx = 0;

        for(int i = people.length-1; i >= idx; i--){
            int remain = limit - people[i];
            if(remain >= min){
                ++idx;
                min = people[idx];
            }
            answer++;

        }

        return answer;
    }
	
	public static void main(String[] args) {

        int[] people = {70,50,80,50};
        int limit = 100;
        System.out.println(solution(people,limit));
	}

}
