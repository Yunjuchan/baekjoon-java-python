import java.io.*;
import java.util.*;

public class Main {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;
        int N = Integer.parseInt(br.readLine());
        int[] arr = new int[N];
        int[] sortedArr = new int[N];
        Map<Integer, Integer> rank = new HashMap<>();

        st = new StringTokenizer(br.readLine());
        for (int i = 0; i < N; i++) {
            int x = Integer.parseInt(st.nextToken());
            arr[i] = sortedArr[i] = x;
        }

        Arrays.sort(sortedArr);

        int r = 0;
        int prev = Integer.MIN_VALUE;
        for (int i = 0; i < N; i++) {
            if (sortedArr[i] == prev) {
                continue;
            }

            rank.put(sortedArr[i], r++);
            prev = sortedArr[i];
        }

        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < N; i++) {
            sb.append(rank.get(arr[i])).append(" ");
        }
        System.out.println(sb);

    }
}