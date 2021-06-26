package Stack_Queue;

import java.util.LinkedList;
import java.util.Queue;

public class FunctionDevelop {

	public static int[] solution(int[] progresses, int[] speeds) {
		
		int[] answer = {};
		int[] preAnswer = {};
		Queue q = new LinkedList();
		
		int day = 0;
		
		for(int i = 0; i < progresses.length; i++) {
			int task = 0;
			for(int j = 1; task < 100; j++) {
				task = progresses[i] + (speeds[i] * j);
				if(task >= 100) {
					day = j;
				}
			}
			progresses[i] = day;
			System.out.println(day+"day");
			q.offer(day);
		}
		
		preAnswer = new int[q.size()];
		int temp = 0;
		int num = 0;
		int index = -1;
		while(!q.isEmpty()) {
			
			if(temp >= (int)q.peek()) {			
				q.remove();
				num = num + 1;
				preAnswer[index] = num+1;				
			}
			else {
				if(num == 0 && temp != 0) {
					preAnswer[index] = 1;
				}
				temp = (int)q.poll();
				index++;
				num = 0;
				if(q.peek() == null) {
					preAnswer[index] = 1;
					break;
				}
			}
			
		}
		
		int len = 0;
		for(int i = 0; i < preAnswer.length; i++) {
			if(preAnswer[i] == 0) {
				len = i;
				break;
			}
		}
		
		answer = new int[len];
		for(int i = 0; i < answer.length; i++) {
			answer[i] = preAnswer[i];
		}
		
		return answer;
		
	}

	public static void main(String[] args) {
		int[] progresses = { 93, 30, 20, 55, 10, 10, 80 };
		int[] speeds = { 1, 30, 30, 5, 5, 5, 8 };
		int[] nn = {};
		nn = solution(progresses, speeds);
		for(int i = 0 ; i < nn.length; i++) {
			
			System.out.println(nn[i]);
		}
	}
}
