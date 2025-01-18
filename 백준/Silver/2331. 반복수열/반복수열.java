import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int N = Integer.parseInt(st.nextToken());
        int P = Integer.parseInt(st.nextToken());

        List<Integer> D = new ArrayList<>();
        Set<Integer> set = new HashSet<>();
        D.add(N);
        set.add(N);

        int duplicated = 0;
        int i = 0;

        while (true) {
            int x = D.get(i);
            int tmp = 0;
            while (x > 0) {
                tmp += (int) Math.pow(x % 10, P);
                x /= 10;
            }

            if (set.contains(tmp)) {
                duplicated = tmp;
                break;
            }

            set.add(tmp);
            D.add(tmp);
            i++;
        }

        int result = 0;
        while (D.get(result) != duplicated) {
            result++;
        }

        System.out.println(result);
    }
}