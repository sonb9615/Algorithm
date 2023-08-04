package Greedy;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.Comparator;
import java.util.StringTokenizer;

public class 회의실배정_1931 {

    static int N;
    static int[][] meeting;
    static void input() throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;
        N = Integer.parseInt(br.readLine());
        meeting = new int[N][2];
        for(int i = 0; i < N; i++){
            st = new StringTokenizer(br.readLine(), " ");
            meeting[i][0] = Integer.parseInt(st.nextToken());
            meeting[i][1] = Integer.parseInt(st.nextToken());
        }

        Arrays.sort(meeting, new Comparator<int[]>() {
            @Override
            public int compare(int[] o1, int[] o2) {
                if(o1[1] == o2[1]){
                    return o1[0] - o2[0];
                }
                return o1[1] - o2[1];
            }
        });
    }

    static void pro(){

        int answer = 0;
        int lastFinishTime = Integer.MIN_VALUE;
        for(int i = 0; i < N; i++){
            if(lastFinishTime <= meeting[i][0]){
                ++answer;
                lastFinishTime = meeting[i][1];
            }
        }
        System.out.println(answer);
    }

    public static void main(String[] args) throws IOException{
        input();
        pro();
    }
}
