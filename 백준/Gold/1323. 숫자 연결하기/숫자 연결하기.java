import java.io.*;
import java.util.*;

public class Main {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        long N = Integer.parseInt(st.nextToken());
        long K = Integer.parseInt(st.nextToken());
        long res = N % K;
        int cnt = 1;
        Set<Long> set = new HashSet<>();

        set.add(res);
        while (res != 0) {
            res = Long.parseLong(res + "" + N) % K;
            if (set.contains(res)) {
                System.out.println(-1);
                return;
            }
            set.add(res);
            cnt++;
        }

        System.out.println(cnt);
    }
}