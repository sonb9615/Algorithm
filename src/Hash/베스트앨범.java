package Hash;

import java.util.HashMap;
import java.util.Map;
import java.util.Objects;

public class 베스트앨범 {

    public int[] solution(String[] genres, int[] plays) {
        int len = plays.length;
        int[] answer = new int[len];
        Map<String, Integer> genrePlayNum = new HashMap<>();


        for(int i = 0; i < len; i++){
            String genre = genres[i];
            int play = plays[i];
            if (Objects.isNull(genrePlayNum.get(genre))) {
                genrePlayNum.put(genre, genrePlayNum.get(genre) + play);
            }

        }

        return answer;
    }
}
