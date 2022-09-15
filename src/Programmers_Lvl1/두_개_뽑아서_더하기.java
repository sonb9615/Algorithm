package Programmers_Lvl1;

import java.util.*;

public class 두_개_뽑아서_더하기 {

    // treeSet 알아보기
    public static int[] solution(int[] numbers) {

        Map<Integer, Integer> map = new HashMap<>();
        int sum = 0;
        for(int i = 0 ; i < numbers.length-1; i++){
            for(int j = i+1; j < numbers.length; j++){
                sum = numbers[i] + numbers[j];
                if(!map.containsKey(sum)){
                    map.put(sum,1);
                }
            }
        }

        List<Integer> list = new ArrayList<>(map.keySet());
        int[] answer = new int[list.size()];
        for(int i = 0; i < list.size(); i++){
            answer[i] = list.get(i);
            System.out.println(list.get(i));
        }
        Arrays.sort(answer);
        return answer;
    }

    public static void main(String[] args) {

        int[] numbers = {2,2,2,2,2};
        solution(numbers);
    }

}
