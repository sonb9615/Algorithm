package TwoPointers;

import java.io.*;
import java.util.Arrays;
import java.util.StringTokenizer;

public class 두용액 {

    static FastReader scan = new FastReader();
    static StringBuilder sb = new StringBuilder();

    public static int n;
    public static int[] liquids;

    public static void input(){
        n = scan.nextInt();
        liquids = new int[n + 1];
        for(int i = 1; i < n + 1; i++){
            liquids[i] = scan.nextInt();
        }
    }

    public static void pro(){

        Arrays.sort(liquids, 1 , n+1);
        int min = Integer.MAX_VALUE;
        int num1 = 0;
        int num2 = 0;
        int L = 1;
        int R = n;
        while(L < R){
            if(min > Math.abs(liquids[L] + liquids[R])){
                min = Math.abs(liquids[L] + liquids[R]);
                num1 = liquids[L];
                num2 = liquids[R];
            }
            if(liquids[L] + liquids[R] > 0){
                R--;
            }else{
                L++;
            }
        }
        System.out.println(sb.append(num1).append(' ').append(num2));
    }

    public static void main(String[] args) {
        input();
        pro();
    }

    static class FastReader {
        BufferedReader br;
        StringTokenizer st;

        public FastReader() {
            br = new BufferedReader(new InputStreamReader(System.in));
        }

        String next() {
            while (st == null || !st.hasMoreElements()) {
                try {
                    st = new StringTokenizer(br.readLine());
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
            return st.nextToken();
        }

        int nextInt() {
            return Integer.parseInt(next());
        }
    }
}
