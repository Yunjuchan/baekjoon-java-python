import java.io.*;
import java.util.*;

public class Main {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;
        StringBuilder sb = new StringBuilder();

        int N = Integer.parseInt(br.readLine());
        int count = 0;
        Map<String, List<String>> couples = new HashMap<>();
        for (int i = 0; i < N; i++) {
            st = new StringTokenizer(br.readLine());
            String name = st.nextToken();
            String ring = st.nextToken();
            if (ring.equals("-")) {
                continue;
            }
            couples.putIfAbsent(ring, new ArrayList<>());
            couples.get(ring).add(name);
        }

        for (String ring : couples.keySet()) {
            List<String> couple = couples.get(ring);
            if (couple.size() != 2) {
                continue;
            }
            count++;
            for (String name : couple) {
                sb.append(name).append(" ");
            }
            sb.append("\n");
        }

        System.out.println(count);
        System.out.println(sb);
    }
}