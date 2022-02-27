package Programmers_Lvl2;

public class dungeons_피로도 {

    static int answer = -1;
    static int cnt = 0;

    public static void makePermutation(int r, int current, boolean[] visited, int[][] arr, int k) {
        if (r == current) {
            if(cnt > answer){
                answer = cnt;
            }

        } else {
            for (int i = 0; i < arr.length; i++) {
                if (!visited[i]) {
                    boolean chk = false;
                    visited[i] = true;
                    if(arr[i][0] <= k){
                        cnt = cnt + 1;
                        k = k - arr[i][1];
                        chk = true;
                    }
                    makePermutation(r,current +1, visited, arr, k);
                    visited[i] = false;
                    if(chk){
                        cnt = cnt - 1;
                        k = k + arr[i][1];
                    }
                }
            }
        }
    }

    public static int solution(int k, int[][] dungeons) {

        boolean[] visited = new boolean[dungeons.length];
        makePermutation(dungeons.length, 0, visited, dungeons, k);
        return answer;
    }

    public static void main(String[] args){

        int k = 80;
        int[][] dungeons = {{80,20},{50,40},{30,10}};

        System.out.println(solution(k,dungeons));
    }
}
