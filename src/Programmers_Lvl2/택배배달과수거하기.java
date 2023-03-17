package Programmers_Lvl2;

public class 택배배달과수거하기 {

    public static long solution(int cap, int n, int[] deliveries, int[] pickups) {
        long answer = 0;
        int go = cap;
        int out = 0;
        for(int i = n-1; i >= 0; i--){
            int delX = 0;
            int delY = 0;
            int pikX = 0;
            int pikY = 0;
            if(deliveries[i] > 0){
                delX = (deliveries[i]/cap);
                delY = (deliveries[i]%cap);
                if(delY > 0) go = delY;
            }
            if(pickups[i] > 0){
                pikX = (pickups[i]/cap);
                pikY = (pickups[i]%cap);
            }

        }
        return answer;
    }


    public static void main(String[] args) {
        int cap = 4;
        int n = 5;
        int[] del = {1, 0, 3, 1, 2};
        int[] pic = {0, 3, 0, 4, 0};
        solution(cap,n,del,pic);
    }
}
