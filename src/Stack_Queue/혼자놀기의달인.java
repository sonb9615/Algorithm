package Stack_Queue;

import java.util.PriorityQueue;

public class 혼자놀기의달인 {
    public static PriorityQueue<Integer> pq;

    public static int solution(int[] cards) {
        int answer = 0;

        pq = new PriorityQueue<>((o1,o2) -> {
            return o2 - o1;
        });

        boolean[] visited = new boolean[cards.length];

        for(int i = 0; i < cards.length; i++){
            if(!visited[i]){
                int cnt = open(i, visited, cards, 0);
                pq.add(cnt);
            }
        }

        if(pq.size() < 2) answer = 0;
        else answer = pq.poll() * pq.poll();
        return answer;
    }

    public static int open(int idx, boolean[] visited, int[] cards, int cnt){
        if(!visited[idx]){
            visited[idx] = true;
            return open(cards[idx] - 1, visited, cards, cnt+1);
        }else return cnt;
    }

    public static void main(String[] args) {
        int[] c = {8,6,3,7,2,5,1,4};
        solution(c);
    }
}
