package BFS_DFS;

public class TargetNumber {
	
	public static int solution(int[] numbers, int target) {
        
        return dfs(numbers, target, 0, 0);
    }

	
	public static int dfs(int[] numbers, int target, int depth, int sum) {
		
		int cnt = 0;
		
		if(depth == numbers.length) {
			if(sum == target) {
				return 1;
			}else {
				return 0;
			}
		}
		
		cnt += dfs(numbers, target, depth + 1, sum + numbers[depth]);
		cnt += dfs(numbers, target, depth + 1, sum - numbers[depth]);
		return cnt;
	}
	
	
	public static void main(String[] args) {
		
		int[] numbers = {1, 1, 1, 1, 1};
		int target = 3;
		
		System.out.println(solution(numbers,target));
	}

}
