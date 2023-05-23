package DynamicPrograming;

import java.util.Arrays;

public class 정수삼각형 {
    public static int solution(int[][] triangle) {
        int[][] dy = new int[triangle.length][triangle.length+1];
        if(triangle.length == 1) return  triangle[0][0];
        dy[0][0] = triangle[0][0];
        dy[1][0] = triangle[0][0] + triangle[1][0];
        dy[1][1] = triangle[0][0] + triangle[1][1];
        for(int i = 2; i < triangle.length; i++){
            dy[i][0] = dy[i-1][0] + triangle[i][0];
            for(int j = 1; j < i+1; j++){
                dy[i][j] = Math.max(dy[i-1][j-1], dy[i-1][j]) + triangle[i][j];
            }
        }
        Arrays.sort(dy[triangle.length-1]);
        return dy[triangle.length - 1][triangle.length];
    }

    public static void main(String[] args) {
        int[][] tri = {{7}, {3, 8}, {8, 1, 0}, {2, 7, 4, 4}, {4, 5, 2, 6, 5}};
        solution(tri);
    }
}
