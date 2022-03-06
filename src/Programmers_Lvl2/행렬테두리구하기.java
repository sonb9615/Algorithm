package Programmers_Lvl2;

public class 행렬테두리구하기 {

    public static int[] solution(int rows, int columns, int[][] queries) {
        int[] answer = new int[queries.length];
        int[][] sq = new int[rows][columns];
        int[][] currSq = new int[rows][columns];
        int val = 1;
        for(int i = 0; i < rows; i++){
            for(int j = 0; j < columns; j++){
                sq[i][j] = val;
                currSq[i][j] = val;
                ++val;
            }
        }

        for(int x=0; x < queries.length; x++){
            int i1 = queries[x][0];
            int j1 = queries[x][1];
            int i2 = queries[x][2];
            int j2 = queries[x][3];
            int min = 10001;
            for(int i = i1-1; i < i2; i++){
                for(int j = j1-1; j < j2; j++){
                    if(j == j1 -1){
                        if(i == i2-1){
                            currSq[i][j] = sq[i][j+1];
                        }else{
                            currSq[i][j] = sq[i+1][j];
                        }

                    }else if(j == j2-1){
                        if(i ==i1-1){
                            currSq[i][j] = sq[i][j-1];
                        }else{
                            currSq[i][j] = sq[i-1][j];
                        }
                    }else{
                        if(i ==i1-1){
                            currSq[i][j] = sq[i][j-1];
                        } else if(i == i2-1){
                            currSq[i][j] = sq[i][j+1];
                        }
                        else{
                            continue;
                        }
                    }
                    if(min > currSq[i][j]){
                        min = currSq[i][j];
                    }
                }
            }
            answer[x] = min;
            System.out.println(min);

            for(int i = 0; i < rows; i++){
                for(int j = 0; j < columns; j++){
                    sq[i][j] = currSq[i][j];
                }
            }
        }

        return answer;
    }



    public static void main(String[] args){

        int[][] queries = {{2,1,5,4},{2,2,5,5}};
        /*int[][] queries = {{2,2,5,4},{3,3,6,6},{5,1,6,3}};*/
        solution(6,5,queries);
    }
}
