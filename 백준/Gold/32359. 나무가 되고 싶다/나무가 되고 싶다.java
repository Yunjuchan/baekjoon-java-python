import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Main {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int N = Integer.parseInt(st.nextToken());
        st = new StringTokenizer(br.readLine());
        Set<Long> v = new HashSet<>();
        List<List<Long>> tree = new ArrayList<>();
        for (int i=0; i<60; i++) {
            tree.add(new ArrayList<>());
        }
        for (int i=0; i<N; i++) {
            long x = Long.parseLong(st.nextToken());
            v.add(x);
            long y = x;
            boolean flag = false;
            int cnt = -1;
            while (y > 0) {
                y /= 2;
                cnt++;
                if (v.contains(y)) {
                    flag = true;
                }
            }
            if (!flag) {
                tree.get(cnt).add(x);
            }
        }
        long result = 1;
        long res = 2;
        if (tree.get(0).isEmpty()) {
            for (int i=1; i<60; i++) {
                res -= tree.get(i).size();
                result += res;
                res *= 2;
                if (res == 0) {
                    break;
                }
            }
        } else {
            result = 0;
            res = 0;
        }
        if (res != 0) {
            result = -1;
        }
        System.out.println(result);
    }
}