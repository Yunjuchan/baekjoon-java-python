import java.io.*;
import java.util.*;

public class Main {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());
        Map<Integer, Integer> m = new TreeMap<>();

        // 입력 처리
        for (int i = 0; i < N; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            int s = Integer.parseInt(st.nextToken());
            int e = Integer.parseInt(st.nextToken());

            m.put(s, m.getOrDefault(s, 0) + 1);

            m.put(e, m.getOrDefault(e, 0) - 1);
        }

        int currentSum = 0;
        int maxSum = 0;

        for (Map.Entry<Integer, Integer> entry : m.entrySet()) {
            currentSum += entry.getValue();
            maxSum = Math.max(maxSum, currentSum);
        }

        System.out.println(maxSum);
    }
}