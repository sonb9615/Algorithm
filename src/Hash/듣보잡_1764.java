package Hash;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;
import java.util.TreeMap;

public class 듣보잡_1764 {

    static int N,M;
    static TreeMap<String, Integer> map1, map2;
    static void pro() throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine(), " ");
        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());
        map1 = new TreeMap<>();
        for(int i = 0; i < N; i++){
            st = new StringTokenizer(br.readLine());
            String str = st.nextToken();
            map1.put(str, 1);
        }
        map2 = new TreeMap<>();
        for(int i = 0; i < M; i++){
            st = new StringTokenizer(br.readLine());
            String str = st.nextToken();
            if(map1.containsKey(str)){
                map2.put(str, 1);
            }
        }
        StringBuilder sb = new StringBuilder();
        if(map2.size() == 0) sb.append(0);
        else{
            sb.append(map2.size()).append('\n');
            for(String key : map2.keySet()){
                sb.append(key).append('\n');
            }
        }
        System.out.println(sb.toString());
    }

    public static void main(String[] args) throws IOException {
        pro();
    }

}
