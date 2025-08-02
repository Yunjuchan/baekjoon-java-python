import java.io.*;
import java.util.*;

public class Main {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        String N = br.readLine();

        Map<Integer, Integer> map = new HashMap<>();
        map.put(0, 0);
        map.put(1, 1);
        map.put(10, 2);
        map.put(11, 3);
        map.put(100, 4);
        map.put(101, 5);
        map.put(110, 6);
        map.put(111, 7);


        int res = N.length() % 3;
        int idx = 0;
        if (res == 1) {
            String init = N.substring(0, 1);
            int n = Integer.parseInt(init);
            sb.append(map.get(n));
            idx = 1;
        } else if (res == 2) {
            String init = N.substring(0, 2);
            int n = Integer.parseInt(init);
            sb.append(map.get(n));
            idx = 2;
        }

        while (idx < N.length()) {
            String cur = N.substring(idx, idx + 3);
            int n = Integer.parseInt(cur);
            sb.append(map.get(n));
            idx += 3;
        }

        System.out.println(sb);
    }
}