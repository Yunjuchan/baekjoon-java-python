import java.io.*;
import java.util.*;

public class Main {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int N = Integer.parseInt(st.nextToken());
        int M = Integer.parseInt(st.nextToken());
        Map<Long, List<String>> map = new HashMap<>();
        int[] alpha = new int[]{2,2,2,3,3,3,4,4,4,5,5,5,6,6,6,7,7,7,7,8,8,8,9,9,9,9};
        for (int i = 0; i < N; i++) {
            String name = br.readLine();
            long num = 0;
            for (char c : name.toCharArray()) {
                num *= 10;
                num += alpha[c - 'a'];
            }
            map.putIfAbsent(num, new ArrayList<>());
            map.get(num).add(name);
        }

        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < M; i++) {
            long p = Long.parseLong(br.readLine());
            List<String> words = map.getOrDefault(p, Collections.emptyList());
            sb.append(words.size());
            for (String word : words) {
                sb.append(" ").append(word);
            }
            sb.append("\n");
        }
        System.out.print(sb);
    }
}