package Programmers_Lvl2;

import java.util.Arrays;
import java.util.LinkedList;
import java.util.Queue;

public class 교점에별만들기 {

    static long maxX, maxY, minX, minY;
    static Queue<Long> queue = new LinkedList<>();

    public static String[] solution(int[][] line) {

        maxX = Long.MIN_VALUE;
        minX = Long.MAX_VALUE;
        maxY = Long.MIN_VALUE;
        minY = Long.MAX_VALUE;
        for(int i = 0; i < line.length; i++){
            long a = line[i][0];
            long b = line[i][1];
            long e = line[i][2];
            getPoint(a,b,e,line,i);
        }
        long lenX = Math.abs(maxX - minX);
        long lenY = Math.abs(maxY - minY);
        String[] answer = new String[(int)(lenY+1)];
        for(int i = 0; i < lenY+1; i++){
            StringBuilder sb = new StringBuilder();
            for(int j = 0; j < lenX+1; j++) sb.append(".");
            answer[i] = sb.toString();
        }
        int len = queue.size()/2;
        for(int i = 0; i < len; i++){
            long x = queue.poll();
            long y = queue.poll();
            long newX = lenX == 0 ? 0 : x-minX;
            long newY = lenY == 0 ? 0 : maxY-y;
            StringBuilder sb = new StringBuilder(answer[(int)newY]);
            sb.setCharAt((int)newX,'*');
            answer[(int)newY] = sb.toString();
        }

        return answer;
    }

    public static void getPoint(long a, long b, long e, int[][] line, int idx){
        for(int i = idx+1; i < line.length; i++){
            long c = line[i][0];
            long d = line[i][1];
            long f = line[i][2];
            long adbc = (a*d) - (b*c);
            if(adbc == 0) continue;
            long bfed = (b*f) - (e*d);
            if(bfed % adbc != 0) continue;
            long x = bfed / adbc;
            long ecaf = (e*c) - (a*f);
            if(ecaf % adbc != 0) continue;
            long y = ecaf / adbc;
            queue.add(x);
            queue.add(y);
            maxX = Math.max(maxX, x);
            maxY = Math.max(maxY, y);
            minX = Math.min(minX, x);
            minY = Math.min(minY, y);
        }
    }

    public static void main(String[] args) {
        int[][] lines= {{2, -1, 4}, {-2, -1, 4}, {0, -1, 1}, {5, -8, -12}, {5, 8, 12}};
        solution(lines);

    }
}
