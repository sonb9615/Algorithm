package Simulation;

public class 전광판 {

    public static int solution(int A, int B) throws Exception {

        int pt = 1;
        boolean chk = true;
        int cnt = 0;
        while(chk){
            pt = pt * 10;

            int x = A % pt;
            int y = B % pt;
            int[] a;
            int[] b;
            if(A == 0){
                a = num(-1);
            }else{
                a = num(x / (pt / 10));
            }
            if(B == 0){
                b = num(-1);
            }else{
                b = num(y / (pt / 10));
            }


            for(int i = 0; i < 7; i++){
                if(a[i] != b[i]){
                    ++cnt;
                }
            }

            A = A - x;
            B = B - y;

            if(pt == 100000){
                chk = false;
            }
        }

        return cnt;

    }

    public static int[] num(int n) throws Exception{

        if(n == 0){
            int [] rtn = {1,1,1,1,1,1,0};
            return rtn;
        }else if(n == 1){
            int [] rtn = {0,0,0,0,1,1,0};
            return rtn;
        }else if(n == 2){
            int [] rtn = {1,0,1,1,0,1,1};
            return rtn;
        }else if(n == 3){
            int [] rtn = {1,0,0,1,1,1,1};
            return rtn;
        }else if(n == 4){
            int [] rtn = {0,1,0,0,1,1,1};
            return rtn;
        }else if(n == 5){
            int [] rtn = {1,1,0,1,1,0,1};
            return rtn;
        }else if(n == 6){
            int [] rtn = {1,1,1,1,1,0,1};
            return rtn;
        }else if(n == 7){
            int [] rtn = {1,1,0,0,1,1,0};
            return rtn;
        }else if(n == 8){
            int [] rtn = {1,1,1,1,1,1,1};
            return rtn;
        }else if(n == 9){
            int [] rtn = {1,1,0,1,1,1,1};
            return rtn;
        }else{
            int [] rtn = {0,0,0,0,0,0,0};
            return rtn;
        }

    }

    public static void main(String args[]) throws Exception
    {
        System.out.println(solution(9881, 10724));

    }

}
