package ShowMeTheCode_2;

import java.io.*;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Solution_1 {

    // SHOW ME THE DUNGEON

        /*5 5
        5 3 1 2 4
        10 10 10 10 10

        20
        */

        /*
        *
        * 5 100
1 1 1 1 1
10 10 10 10 10
*
* 50
        *
        * */


            /*5 1
            2 2 2 2 2
            2 2 2 2 2

            0
            */


    static FastReader scan = new FastReader();
    static StringBuilder sb = new StringBuilder();

    static int N;
    static int K;

    static class Elem implements Comparable<Elem>{

        public int monster;
        public int num;

        @Override
        public int compareTo(Elem other){
            return monster - other.monster;
        }
    }

    static Elem[] elem;

    public static void main(String[] args) {

        input();
        fn();
    }

    static void input(){
        N = scan.nextInt();
        K = scan.nextInt();
        elem = new Elem[N];
        for(int i = 0; i < N; i++){
            elem[i] = new Elem();
            elem[i].monster = scan.nextInt();
        }

        for(int i = 0; i < N; i++){
            elem[i].num = scan.nextInt();
        }

        Arrays.sort(elem);
    }

    static void fn(){
        int currMax = 0;
        int max = 0;

        for(int i = 0; i < N; i++){
            int limit = elem[i].monster;
            if(limit > K){
                continue;
            }
            currMax = elem[i].num;

            int idx = i+1;
            while(idx < N){

                limit += limit + elem[idx].monster;
                if(limit <= K){
                    currMax += elem[idx].num;
                    ++idx;
                }else{
                    break;
                }
            }
            if(currMax > max){
                max = currMax;
            }
        }
        System.out.println(max);
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
