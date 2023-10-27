package Simulation;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.PriorityQueue;

public class 절대값힙_11286 {

    static PriorityQueue<Integer> pq = new PriorityQueue<>((o1, o2) -> {
        if(Math.abs(o1) == Math.abs(o2)){
            return o1 - o2;
        }
        return Math.abs(o1) - Math.abs(o2);
    });

    static void pro() throws IOException {
        StringBuilder sb = new StringBuilder();
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());
        for(int i = 0; i < N; i++){
            int n = Integer.parseInt(br.readLine());
            if(n == 0){
                if(pq.isEmpty()){
                    sb.append(0).append('\n');
                }else{
                    sb.append(pq.poll()).append('\n');
                }
                continue;
            }
            pq.add(n);
        }
        System.out.println(sb);
    }

    public static void main(String[] args) throws IOException {
        pro();
    }
}
