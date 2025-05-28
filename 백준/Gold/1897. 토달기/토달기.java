import java.io.*;
import java.util.*;

public class Main {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int d = Integer.parseInt(st.nextToken());
        String init = st.nextToken();
        String result = init;

        Set<String> dictionary = new HashSet<>();
        Set<String> used = new HashSet<>();
        used.add(init);

        for (int i = 0; i < d; i++) {
            dictionary.add(br.readLine());
        }

        Queue<String> que = new LinkedList<>();

        que.offer(init);

        while (!que.isEmpty()) {
            String cur = que.poll();
            result = cur;
            for (char c = 'a'; c <= 'z'; c++) {
                for (int i = 0; i <= cur.length(); i++) {
                    String next = cur.substring(0, i) + c + cur.substring(i);
                    if (dictionary.contains(next) && !used.contains(next)) {
                        used.add(next);
                        que.offer(next);
                    }
                }
            }
        }

        System.out.println(result);
    }
}