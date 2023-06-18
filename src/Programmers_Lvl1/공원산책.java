package Programmers_Lvl1;

public class 공원산책 {
    public static int[] solution(String[] park, String[] routes) {
        int[] answer = new int[2];
        int startX = 0;
        int startY = 0;
        for(int i = 0 ; i < park.length; i++){
            for(int j = 0; j < park[i].length(); j++){
                if(park[i].charAt(j) == 'S'){
                    startY = i;
                    startX = j;
                }
            }
        }

        for (String route : routes) {
            int dir = Integer.parseInt(String.valueOf(route.charAt(2)));
            int dirX = 0;
            int dirY = 0;
            if (route.charAt(0) == 'E') dirX = 1;
            else if (route.charAt(0) == 'W') dirX = -1;
            else if (route.charAt(0) == 'S') dirY += 1;
            else dirY = -1;
            if(checkRoute(startX, startY, dir, dirX, dirY, park)){
                if(dirX != 0) startX += dir*dirX;
                else startY += dir*dirY;
            }
        }

        answer[0] = startY;
        answer[1] = startX;
        return answer;
    }

    public static boolean checkRoute(int x, int y, int cnt, int dirX, int dirY, String[] park){
        for(int i = 0; i < cnt; i++){
            if(x + dirX < 0 || x + dirX >= park[0].length()
                    || y + dirY < 0 || y + dirY >= park.length
                    || park[dirY + y].charAt(dirX + x) == 'X') return false;
            x += dirX;
            y += dirY;
        }
        return true;
    }

    public static void main(String[] args) {
        String[] park = {"SOO","OXX","OOO"};
        String[] routes = {"E 2","S 2","W 1"};
        solution(park, routes);
    }
}
