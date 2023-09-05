package 누적합;

public class 광고삽입 {

    public static String solution(String play_time, String adv_time, String[] logs) {
        String answer = "";
        int playTime = timeToInt(play_time);
        int[] sum = new int[playTime+1];
        for(int i = 0; i < logs.length; i++){
            String[] sp = logs[i].split("-");
            int start = timeToInt(sp[0]);
            int end = timeToInt(sp[1]);
            ++sum[start];
            --sum[end];
        }
        int advTime = timeToInt(adv_time);
        long max = 0;
        for(int i = 1; i < sum.length; i++){
            sum[i] += sum[i-1];
            if(i < advTime){
                max += sum[i];
            }
        }
        long now = max;
        int maxStart = 0;
        for(int i = 0, j = advTime; j < playTime; i++, j++){
            now = now-sum[i]+sum[j];
            if(max < now){
                max = now;
                maxStart = i + 1;
            }
        }
        answer = intToTime(maxStart);
        return answer;
    }

    public static int timeToInt(String time){
        String[] sp = time.split(":");
        int h = Integer.parseInt(sp[0]) * 3600;
        int m = Integer.parseInt(sp[1]) * 60;
        int s = Integer.parseInt(sp[2]);
        return h + m + s;
    }

    public static String intToTime(int time){
        StringBuilder sb = new StringBuilder();
        int hh = time / 3600;
        int mm = time % 3600 / 60;
        int ss = time % 3600 % 60;
        if(hh < 10) sb.append("0");
        sb.append(hh).append(":");
        if(mm < 10) sb.append("0");
        sb.append(mm).append(":");
        if(ss < 10) sb.append("0");
        sb.append(ss);
        return sb.toString();
    }

    public static void main(String[] args) {
        String[] logs = {"24:00:01-25:00:00"};
        solution("25:00:00","00:01:00", logs);
    }

}
