package 최단거리;

import java.util.Arrays;
import java.util.Comparator;

public class 섬연결하기 {

    public int solution(int n, int[][] costs) {
        int answer = 0;
        int[] parent = new int[n];
        for(int i = 0; i < n; i++) parent[i] = i;
        Arrays.sort(costs, new Comparator<int[]>() {
            @Override
            public int compare(int[] o1, int[] o2) {
                return o1[2] - o2[2];
            }
        });

        for(int i = 0; i < costs.length; i++){
            if(findParent(parent, costs[i][0]) != findParent(parent, costs[i][1])){
                answer += costs[i][2];
                find(parent, costs[i][0], costs[i][1]);
            }
        }

        return answer;
    }

    public static void find(int[] parent, int x, int y){
        int x_parent = findParent(parent, x);
        int y_parent = findParent(parent, y);
        if(x_parent < y_parent) parent[y_parent] = x_parent;
        else parent[x_parent] = y_parent;
    }

    public static int findParent(int[] parent, int idx){
        if(parent[idx] == idx) return idx;
        return findParent(parent, parent[idx]);
    }
}
