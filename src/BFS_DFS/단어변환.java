package Simulation;

public class 단어변환 {

    static boolean[] visited;
    static int answer;

    public static int solution(String begin, String target, String[] words) {
        visited = new boolean[words.length];
        answer = Integer.MAX_VALUE;
        dfs(begin, target, words, 0);
        if(answer == Integer.MAX_VALUE) answer = 0;
        return answer;
    }

    public static void dfs(String begin, String target, String[] words, int cnt){
        if(begin.equals(target)){
            if(answer > cnt){
                answer = cnt;
            }
            return;
        }

        for(int i = 0; i < words.length; i++){
            if(visited[i]) continue;
            int diff = 0;
            for(int j = 0; j < begin.length(); j++){
                if(begin.charAt(j) != words[i].charAt(j)){
                    ++diff;
                }
            }
            if(diff == 1){
                visited[i] = true;
                dfs(words[i], target, words, cnt + 1);
                visited[i] = false;
            }
        }
    }

    public static void main(String[] args) {
        String[] words = {"hot", "dot", "dog", "lot", "log", "cog"};
        solution("hit", "cog", words);
    }
}
