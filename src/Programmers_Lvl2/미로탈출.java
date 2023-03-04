package Programmers_Lvl2;

import java.util.Arrays;
import java.util.LinkedList;
import java.util.Queue;

public class 미로탈출 {

    static class Info{
        int x;
        int y;
        int dist;
        public Info(int _x, int _y, int _dist){
            this.x = _x;
            this.y = _y;
            this.dist = _dist;
        }
    }

    static int[][] dist;
    static int[] val = {1,-1};

    public static int solution(String[] maps) {
        int answer = 0;
        dist = new int[maps.length][maps[0].length()];
        int startX = 0;
        int startY = 0;
        int labX = 0;
        int labY = 0;
        int exitX = 0;
        int exitY = 0;
        for(int i = 0; i < maps.length; i++){
            for(int j = 0; j < maps[i].length(); j++){
                if(maps[i].charAt(j) == 'S') {
                    startX = j;
                    startY = i;
                    continue;
                }
                if(maps[i].charAt(j) == 'L') {
                    labX = j;
                    labY = i;
                    continue;
                }
                if(maps[i].charAt(j) == 'E') {
                    exitX = j;
                    exitY = i;
                }
            }
        }
        dijkstra(startX,startY,0,maps);
        if(dist[labY][labX] == Integer.MAX_VALUE) return -1;
        dijkstra(labX,labY,dist[labY][labX], maps);
        if(dist[exitY][exitX] == Integer.MAX_VALUE) return -1;
        return dist[exitY][exitX];
    }

    public static void dijkstra(int startX, int startY, int startDist, String[] maps){
        Queue<Info> queue = new LinkedList<>();
        for(int i = 0; i < maps.length; i++){
            Arrays.fill(dist[i], Integer.MAX_VALUE);
        }
        dist[startY][startX] = startDist;
        queue.add(new Info(startX,startY,dist[startY][startX]));
        while(!queue.isEmpty()){
            Info info = queue.poll();
            if(info.dist != dist[info.y][info.x]) continue;
            for(int i = 0; i < 2; i++){
                int newY = info.y + val[i];
                if(newY >= dist.length || newY < 0) continue;
                if(maps[newY].charAt(info.x) == 'X') continue;
                if(dist[newY][info.x] > dist[info.y][info.x] + 1){
                    dist[newY][info.x] = dist[info.y][info.x] + 1;
                    queue.add(new Info(info.x, newY, dist[newY][info.x]));
                }
            }
            for(int i = 0; i < 2; i++){
                int newX = info.x + val[i];
                if(newX >= dist[0].length || newX < 0) continue;
                if(maps[info.y].charAt(newX) == 'X') continue;
                if(dist[info.y][newX] > dist[info.y][info.x] + 1){
                    dist[info.y][newX] = dist[info.y][info.x] + 1;
                    queue.add(new Info(newX, info.y, dist[info.y][newX]));
                }
            }
        }
    }

    public static void main(String[] args) {
        String[] map = {"LOOXS","OOOOX","OOOOO","OOOOO","EOOOO"};
        solution(map);
    }
}
