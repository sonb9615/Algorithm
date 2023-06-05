package 완전탐색;

import java.util.ArrayList;

public class 수식최대화 {
    public static long solution(String expression) {
        long answer = Long.MIN_VALUE;
        String[][] arr = {{"+","-","*"}, {"+","*","-"}, {"-","+","*"}, {"-","*","+"}, {"*","+","-"}, {"*","-","+"}};
        ArrayList<String> list = new ArrayList<>();
        StringBuilder sb = new StringBuilder();
        for(int x = 0; x < expression.length(); x++){
            if(expression.charAt(x) == '+' || expression.charAt(x) == '-' || expression.charAt(x) == '*'){
                list.add(sb.toString());
                list.add(String.valueOf(expression.charAt(x)));
                sb = new StringBuilder();
            } else sb.append(expression.charAt(x));
        }
        list.add(sb.toString());

        for(int i = 0; i < 6; i++){
            ArrayList<String> op = new ArrayList<>(list);
            for(int j = 0; j < 3; j++){
                for(int k = 0; k < op.size(); k++){
                    if(op.get(k).equals(arr[i][j])){
                        op.set(k - 1, calc(op.get(k), Long.parseLong(op.get(k-1)), Long.parseLong(op.get(k+1))));
                        op.remove(k);
                        op.remove(k);
                        --k;
                    }
                }
            }
            answer = Long.max(answer, Math.abs(Long.parseLong(op.get(0))));
        }

        return answer;
    }

    public static String calc(String op, long num1, long num2){
        long num = 0;
        if("+".equals(op)){
            num = num1 + num2;
        }else if ("-".equals(op)){
            num = num1 - num2;
        }else num = num1 * num2;
        return String.valueOf(num);
    }

    public static void main(String[] args) {
        String str = "50*6-3*2";
        System.out.println(solution(str));
    }
}
