import java.io.*;
import java.util.*;

public class Main {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;

        int T = Integer.parseInt(br.readLine());

        for (int t = 0; t < T; t++) {
            int M = Integer.parseInt(br.readLine());
            Set<Integer> left = new HashSet<>();
            Set<Integer> right = new HashSet<>();
            int cnt = 0;

            st = new StringTokenizer(br.readLine());
            for (int i = 0; i < M; i++) {
                left.add(Integer.parseInt(st.nextToken()));
            }

            st = new StringTokenizer(br.readLine());
            for (int i = 0; i < M; i++) {
                right.add(Integer.parseInt(st.nextToken()));
            }

            for (int x : left) {
                if (left.contains(x + 500) && right.contains(x + 1000) && right.contains(x + 1500)) {
                    cnt++;
                }
            }

            System.out.println(cnt);
        }
    }
}
