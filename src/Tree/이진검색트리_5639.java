package Tree;

import java.io.*;
import java.util.ArrayList;

public class 이진검색트리_5639 {

    static StringBuilder sb = new StringBuilder();
    static ArrayList<Integer> A;

    static void input() throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String input = "";
        A = new ArrayList<>();
        while ((input = br.readLine()) != null){
            A.add(Integer.parseInt(input));
        }
    }

    static void makeTree(int l, int r){
        // 트리를 분리
        if(l > r) return;
        int mid = r;
        for(int i = l + 1; i <= r; i++){
            if(A.get(i) > A.get(l)){
                mid = i - 1;
                break;
            }
        }

        //후위순회
        makeTree(l+1, mid);
        makeTree(mid+1, r);
        sb.append(A.get(l)).append('\n');
    }

    static void pro(){
        makeTree(0, A.size() - 1);
        System.out.println(sb);
    }

    public static void main(String[] args) throws IOException {
        input();
        pro();
    }

}
