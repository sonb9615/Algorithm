package Simulation;

public class 풍선터뜨리기 {

    public int solution(int[] a) {
        int[] leftMin = new int[a.length];
        int[] rightMin = new int[a.length];
        int l = a[0];
        int r = a[a.length-1];

        for(int i = 1; i < a.length; i++){
            if(l > a[i]) l = a[i];
            leftMin[i] = l;
        }

        for(int i = a.length - 2; i > -1; i--){
            if(r > a[i]) r = a[i];
            rightMin[i] = r;
        }
        if(a.length == 1) return 1;
        int answer = 2;
        for(int i = 1; i <= a.length-2; i++){
            if(a[i] > leftMin[i] && a[i] > rightMin[i]) continue;
            ++answer;
        }

        return answer;
    }
}
