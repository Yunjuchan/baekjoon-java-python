import java.io.*;
import java.util.*;

public class Main {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;
        while (true) {
            st = new StringTokenizer(br.readLine());
            int N = Integer.parseInt(st.nextToken());
            int M = Integer.parseInt(st.nextToken());

            if (N == 0 && M == 0) {
                return;
            }

            Set<Integer> set = new HashSet<>();
            int result = 0;

            for (int i = 0; i < N; i++) {
                int cd = Integer.parseInt(br.readLine());
                set.add(cd);
            }

            for (int i = 0; i < M; i++) {
                int cd = Integer.parseInt(br.readLine());
                if (set.contains(cd)) {
                    result++;
                }
            }
            System.out.println(result);
        }
    }
}
