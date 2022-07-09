package Stack_Queue;
import java.util.Stack;
import java.util.ArrayList;

public class Stick {

	public static int solution(String arrangement) {
		int answer = 0;
		Stack st = new Stack<Character>();
		char[] ch = arrangement.toCharArray();
		int ck = 0; // 레이저인지 스틱인지 확인

		for(int i = 0; i < arrangement.length(); i++) {
			ch[i] = arrangement.charAt(i);
		}

		for(int i = 0; i < ch.length; i++) {
			if(ch[i] == '(') {
				st.push('(');
				ck = 1;
			}
			else if(ch[i] == ')') {

				if(ck == 1) {
					st.pop();
					answer = answer + st.size();
					System.out.println("answer : " + answer);
				}

				else if(ck == 0) {
					st.pop();
					answer = answer + 1;
				}

				else if(st.isEmpty()) {
					st.pop();
				}
				ck = 0;
			}

		}


		return answer;

	}

	public static void main(String[] args) {

		String arrangement = "()(((()())(())()))(())";
		int a = solution(arrangement);
		System.out.println(a);
	}
}
