package Array;

import java.util.Arrays;
import java.util.Objects;

public class 가장큰수 {

    public static String solution(int[] numbers) {

        String[] str = new String[numbers.length];
        for(int i = 0; i < numbers.length; i++){
            str[i] = String.valueOf(numbers[i]);
        }
        Arrays.sort(str, (o1, o2) -> (o2 + o1).compareTo(o1 + o2));

        if(Objects.equals(str[0], "0")) return "0";

        StringBuilder sb = new StringBuilder();
        for(String s : str){
            sb.append(s);
        }
        return sb.toString();
    }

    public static void main(String[] args) {
        int[] arr = {6, 10, 2};
        System.out.println(solution(arr));
    }
}
