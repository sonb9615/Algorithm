package NHN_201024;

import java.util.HashMap;
import java.util.Map;

//수건돌리기
public class solution_01 {

	public static void main(String[] args) {
//		char[] namesOfQuickPlayers = {'B', 'C'};
//		int[] numOfMovesPerGame = {3,2};
//		
//		solution(6,2,namesOfQuickPlayers,2,numOfMovesPerGame);
		/*
		 * B 0 C 0 D 0 A 1 F 0 E 2
		 */
		
		
		char[] namesOfQuickPlayers = {'B', 'D', 'I', 'M', 'P'}; 
		int[] numOfMovesPerGame = {3, -4, 5, 6, -7, -8, 10, -12, -15, -20, 23};
	    solution(17,5,namesOfQuickPlayers,11,numOfMovesPerGame);

	    /*
		 * B 0 C 0 D 0 L 1 Q 1 A 3 F 2 I 0 J 0 G 1 K 1 M 0 N 0 H 1 P 0 E 1 O 1
		 */
	}
	
	public static void solution(int numOfAllPlayers, int numOfQuickPlayers, char[] namesOfQuickPlayers, int numOfGames,
			int[] numOfMovesPerGame) {
		
		char[] players = new char[numOfAllPlayers];
		int cnt = 0;
		Map<Character, Integer> result = new HashMap();
		
		result.put('A', 1);
		for(char ch = 'B'; ch <= 'A'+numOfAllPlayers -1 ; ch++) {
			players[cnt] = ch;
			cnt++;
			result.put(ch, 0);
		}
		
		
		char start = 'A';
		int startPoint = 0;
		
		for(int i = 0; i < numOfGames; i++) {
			
			int moveCnt = (numOfMovesPerGame[i] + startPoint)%(numOfAllPlayers-1);
			
			if(moveCnt < 0) {
				moveCnt = moveCnt + numOfAllPlayers -1;
			}
			
			boolean gatcah = false;
			for(int j = 0; j < numOfQuickPlayers; j++) {
				if(players[moveCnt] == namesOfQuickPlayers[j]) {
					int catchCnt = result.get(start);
					result.put(start,catchCnt+1);
					gatcah = true;
					break;
				}
			}
			if(!gatcah) {
				
				char me = players[moveCnt];
				int catchCnt = result.get(me);
				result.put(me,catchCnt+1);
				players[moveCnt] = start;
				start = me;
				
			}
			
			startPoint = moveCnt;
		}
		System.out.println(result);
	}
}
