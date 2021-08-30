package Heap;

import java.util.Comparator;
import java.util.PriorityQueue;

public class DiskController {

	public static int solution(int[][] jobs) {
        
		int answer = 0;
        
		//작업이 완료된 시점
		int endPt = 0;
		
		class jobList{
			int p;
			int t;
			
			public jobList(int p, int t) {
				this.p = p;
				this.t = t;
			}
		}
		

        PriorityQueue<jobList> pq = new PriorityQueue<>(new Comparator<jobList>() {
        	
			@Override
			public int compare(jobList o1, jobList o2) {
				int end1 = o1.p + o1.t;
				int end2 = o2.p + o2.t;
				
				if(end1 > end2) {
					return 1;
				}else if(end1 < end2) {
					return -1;
				}else {
					if(o1.p > o2.p) {
						return 1;
					}else {
						return 0;
					}
				}
			}
        });

        for(int i = 0; i < jobs.length; i++) {
        	pq.offer(new jobList(jobs[i][0],jobs[i][1]));
        }
        
        
        while(!pq.isEmpty()) {
        	
        	endPt += pq.peek().t;
        	answer += Math.abs(endPt - pq.poll().p);
        }
        
        
        answer = answer / jobs.length;
        
        return answer;
    }
	
	public static void main(String[] args) {
		
		/*
		 * 
		 * print(solution([[0, 10], [2, 10], [9, 10], [15, 2]]), 14)
print(solution([[0, 10], [2, 12], [9, 19], [15, 17]]), 25)
print(solution([[0, 3], [1, 9], [2, 6]]), 9)
print(solution([[0, 1]]), 1)
print(solution([[1000, 1000]]), 1000)
print(solution([[0, 1], [0, 1], [0, 1]]), 2)
print(solution([[0, 1], [0, 1], [0, 1], [0, 1]]), 2)
print(solution([[0, 1], [1000, 1000]]), 500)
print(solution([[10, 10], [30, 10], [50, 2], [51, 2]]), 6)
print(solution([[0, 3], [1, 9], [2, 6], [30, 3]]), 7)

		 * */
		
//		int[][] jobs = {{0, 3}, {1, 9}, {2, 6}};
//		
		int[][] jobs = {{0, 10}, {2, 12}, {9, 19}, {15, 17}};
		
		
		int result = solution(jobs);
		
		System.out.println(result);
	}
}
