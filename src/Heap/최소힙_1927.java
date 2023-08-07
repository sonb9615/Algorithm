package Heap;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.PriorityQueue;
import java.util.StringTokenizer;

public class 최소힙_1927 {

    static void input() throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int N = Integer.parseInt(st.nextToken());
        PriorityQueue<Integer> queue = new PriorityQueue<>();
        StringBuilder sb = new StringBuilder();
        for(int i = 0; i < N; i++){
            st = new StringTokenizer(br.readLine());
            int x = Integer.parseInt(st.nextToken());
            if(x == 0) {
                if(queue.isEmpty()){
                    sb.append(0).append('\n');
                }else{
                    sb.append(queue.poll()).append('\n');
                }
                continue;
            }
            queue.add(x);
        }
        System.out.println(sb);
    }

    public static void main(String[] args) throws IOException {
        input();
    }
}
