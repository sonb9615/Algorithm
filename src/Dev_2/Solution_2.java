package Dev_2;

public class Solution_2 {

    public static int[][] solution(int n, boolean horizontal) {
        int[][] answer = new int[n][n];
        int ord = 0;
        int max = 0;

        for(int i = 0; i < n; i++){
            max += 1;
            if(max == n){
                break;
            }
            if(horizontal){
                if(max == 1){
                    for(int j = 0; j <= max; j++){
                        answer[i][j] = ++ord;
                    }
                    for(int j = max; j >= 0; j--){
                        answer[max][j] = ++ord;
                    }
                }else{
                    if(i % 2 == 0){
                        for(int j = 0; j <= max; j++){
                            if(answer[j][max] > 0){
                                continue;
                            }else{
                                answer[j][max] = ++ord;
                            }
                        }
                        for(int j = max; j >= 0; j--){
                            if(answer[max][j] > 0){
                                continue;
                            }else{
                                answer[max][j] = ++ord;
                            }
                        }
                    }else{
                        for(int j = 0; j <= max; j++){
                            if(answer[max][j] > 0){
                                continue;
                            }else{
                                answer[max][j] = ++ord;
                            }
                        }
                        for(int j = max; j >= 0; j--){
                            if(answer[j][max] > 0){
                                continue;
                            }else{
                                answer[j][max] = ++ord;
                            }
                        }

                    }
                }
            }else{
                if(max == 1){
                    for(int j = 0; j <= max; j++){
                        answer[j][i] = ++ord;

                    }
                    for(int j = max; j >= 0; j--){
                        answer[j][max] = ++ord;
                    }

                }else{
                    if(i % 2 == 0){
                        for(int j = 0; j <= max; j++){
                            if(answer[max][j] > 0){
                                continue;
                            }else{
                                answer[max][j] = ++ord;
                            }
                        }
                        for(int j = max; j >= 0; j--){
                            if(answer[j][max] > 0){
                                continue;
                            }else{
                                answer[j][max] = ++ord;
                            }
                        }


                    }else{
                        for(int j = 0; j <= max; j++){
                            if(answer[j][max] > 0){
                                continue;
                            }else{
                                answer[j][max] = ++ord;
                            }
                        }
                        for(int j = max; j >= 0; j--){
                            if(answer[max][j] > 0){
                                continue;
                            }else{
                                answer[max][j] = ++ord;
                            }
                        }

                    }
                }
            }
        }

        return answer;
    }

    public static void main(String[] args) {

        int[][] ans = solution(5, false);





    }
}
