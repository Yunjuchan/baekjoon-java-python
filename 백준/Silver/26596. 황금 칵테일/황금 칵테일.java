import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.*;

public class Main {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int N = Integer.parseInt(st.nextToken());
        Map<String, Integer> m = new HashMap<>();

        boolean flag = false;
        for (int i = 0; i < N; i++) {
            st = new StringTokenizer(br.readLine());
            String name = st.nextToken();
            int A = Integer.parseInt(st.nextToken());
            m.put(name, m.getOrDefault(name, 0) + A);
        }
        for (String name : m.keySet()) {
            int c = m.get(name);
            for (String n : m.keySet()) {
                if (n.equals(name)) {
                    continue;
                }
                int c2 = (int) (m.get(n) * 1.618);
                if (c == c2) {
                    flag = true;
                }
            }
        }
        if (flag) {
            System.out.println("Delicious!");
        } else {
            System.out.println("Not Delicious...");
        }
    }
}