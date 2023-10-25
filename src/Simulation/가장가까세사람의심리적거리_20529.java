package Simulation;

import java.io.*;
import java.util.ArrayList;
import java.util.StringTokenizer;

public class 가장가까세사람의심리적거리_20529 {

    static FastReader scan = new FastReader();
    static int ans;

    static void pro(){
        StringBuilder sb = new StringBuilder();
        int N = scan.nextInt();
        while(--N >= 0){
            ans = Integer.MAX_VALUE;
            int num = scan.nextInt();
            String str = scan.nextLine();
            String[] targets = str.split(" ");
            if(targets.length > 32){
                sb.append(0).append('\n');
                continue;
            }
            ArrayList<String> temp = new ArrayList<>();
            makeComb(temp, targets, -1);
            sb.append(ans).append('\n');
        }
        System.out.println(sb);
    }

    static void makeComb(ArrayList<String> temp, String[] arr, int idx){
        if(temp.size() == 3){
            calc(temp);
            return;
        }
        for(int i = idx + 1; i < arr.length; i++){
            temp.add(arr[i]);
            makeComb(temp, arr, ++idx);
            temp.remove(temp.size()-1);
        }
    }

    static void calc(ArrayList<String> arr){
        int rtn = 0;
        for(int i = 0; i < 3; i++){
            String x = arr.get(i);
            for(int j = i+1; j < 3; j++){
                String y = arr.get(j);
                int sum = 0;
                for(int k = 0; k < 4; k++){
                    if(x.charAt(k) != y.charAt(k)) ++sum;
                }
                rtn += sum;
            }
        }
        ans = Math.min(ans, rtn);
    }

    public static void main(String[] args) {
        pro();
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
