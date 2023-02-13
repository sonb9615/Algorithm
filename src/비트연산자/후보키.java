package 비트연산자;

import java.util.ArrayList;
import java.util.HashSet;

public class 후보키 {
    //후보키
    public static int solution(String[][] relation) {
        int rowlen = relation.length;
        int colLen = relation[0].length;
        ArrayList<Integer> list = new ArrayList<>();

        for(int i = 0; i < (1 << colLen); i++){
            if(!checkMinStatus(i, list)) continue;
            if(!checkUniqueStatus(i, relation, rowlen, colLen)) continue;
            list.add(i);
        }
        return list.size();
    }

    public static boolean checkMinStatus(int idx, ArrayList<Integer> list){
        for(int key : list){
            if((idx & key) == key) return false;
        }
        return true;
    }

    public static boolean checkUniqueStatus(int idx, String[][] relations, int rowLen, int colLen){
        ArrayList<Integer> arr = getIdx(idx, colLen);
        HashSet<String> hashSet = new HashSet<>();
        for(int i = 0; i < rowLen; i++){
            StringBuilder sb = new StringBuilder();
            for(int j : arr){
                sb.append(relations[i][j]).append(" ");
            }
            hashSet.add(sb.toString());
        }
        return hashSet.size() == rowLen;
    }

    public static ArrayList<Integer> getIdx(int idx, int colLen){
        ArrayList<Integer> result = new ArrayList<>();
        for(int i = 0; i < colLen; i++){
            if((idx >> i & 1) == 1) result.add(i);
        }
        return result;
    }

    public static void main(String[] args) {
        String[][] relation = {{"100","ryan","music","2"}
                ,{"200","apeach","math","2"}
                ,{"300","tube","computer","3"}
                ,{"400","con","computer","4"}
                ,{"500","muzi","music","3"}
                ,{"600","apeach","music","2"}};
        System.out.println(solution(relation));
    }
}
