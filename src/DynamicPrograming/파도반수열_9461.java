package DynamicPrograming;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class 파도반수열_9461 {

    static void pro() throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        int N = Integer.parseInt(br.readLine());
        long[] p = new long[101];
        p[1] = 1;
        p[2] = 1;
        p[3] = 1;
        for(int i = 4; i < 101; i++){
            p[i] = p[i-2] + p[i-3];
        }
        for(int i = 0; i < N; i++){
            int idx = Integer.parseInt(br.readLine());
            sb.append(p[idx]).append('\n');
        }
        System.out.println(sb);
    }

    public static void main(String[] args) throws IOException {
        pro();
    }
}
