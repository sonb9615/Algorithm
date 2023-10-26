package Simulation;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;

public class IOIOI_5525 {

    static int N, M;
    static ArrayList<Integer> arr;
    static String str;
    static void input() throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        N = Integer.parseInt(br.readLine());
        M = Integer.parseInt(br.readLine());
        str = br.readLine();
        arr = new ArrayList<>();
    }

    static void pro(){
        for(int i = 0; i < M; i++){
            if(str.charAt(i) == 'I'){
                arr.add(i);
            }
        }
        int rtn = 0;
        int sum = 0;
        for(int i = 1; i < arr.size(); i++){
            if(arr.get(i) - arr.get(i-1) == 2) ++sum;
            else sum = 0;
            if(sum >= N) ++rtn;
        }
        System.out.println(rtn);
    }

    public static void main(String[] args) throws IOException {
        input();
        pro();
    }
}
