package Greedy;

import java.io.*;
import java.util.StringTokenizer;

public class 잃어버린_괄호_1541 {

    static FastReader scan = new FastReader();
    static String str;
    static void input(){
        str = scan.nextLine();
    }

    static void func(){
        int result = 0;
        int preSum = 0;
        boolean minusCheck = false;
        StringBuilder sb = new StringBuilder();
        for(char c : str.toCharArray()){
            if(c == '-'){
                if(!minusCheck) result += Integer.parseInt(sb.toString());
                else preSum += Integer.parseInt(sb.toString());
                minusCheck = true;
                result -= preSum;
                sb = new StringBuilder();
                preSum = 0;
            }else if(c == '+'){
                if(minusCheck){
                    preSum += Integer.parseInt(sb.toString());
                }else{
                    result += Integer.parseInt(sb.toString());
                }
                sb = new StringBuilder();
            }else{
                sb.append(c);
            }
        }
        if(minusCheck) {
            preSum += Integer.parseInt(sb.toString());
            result -= preSum;
        } else {
            result += Integer.parseInt(sb.toString());
        }
        System.out.println(result);
    }

    public static void main(String[] args) {
        input();
        func();
    }

    static class FastReader {
        BufferedReader br;
        StringTokenizer st;

        public FastReader() {
            br = new BufferedReader(new InputStreamReader(System.in));
        }

        public FastReader(String s) throws FileNotFoundException {
            br = new BufferedReader(new FileReader(new File(s)));
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

        long nextLong() {
            return Long.parseLong(next());
        }

        double nextDouble() {
            return Double.parseDouble(next());
        }

        String nextLine() {
            String str = "";
            try {
                str = br.readLine();
            } catch (IOException e) {
                e.printStackTrace();
            }
            return str;
        }
    }
}
