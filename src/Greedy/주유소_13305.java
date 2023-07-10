package Greedy;

import java.io.*;
import java.util.StringTokenizer;

public class 주유소_13305 {

    static FastReader scan = new FastReader();
    static int n;
    static long[] kmArr,oilCostArr;
    static void input(){
        n = scan.nextInt();
        kmArr = new long[n-1];
        oilCostArr = new long[n];
        for(int i = 0; i < n-1; i++){
            kmArr[i] = scan.nextInt();
        }
        for(int i = 0; i < n; i++){
            oilCostArr[i] = scan.nextInt();
        }
    }

    static void func(){
        long oilcost = oilCostArr[0];
        long km = kmArr[0];
        long result = 0;
        for(int i = 1; i < n-1; i++){
            if(oilCostArr[i] < oilcost){
                result += oilcost * km;
                oilcost = oilCostArr[i];
                km = kmArr[i];
            }else km += kmArr[i];
        }
        result += oilcost * km;
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
