import java.io.*;
import java.util.*;

public class Main {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;
        int M = Integer.parseInt(br.readLine());
        int result = 0;

        List<int[]> arr = new ArrayList<>();

        while (true) {
            st = new StringTokenizer(br.readLine());
            int L = Integer.parseInt(st.nextToken());
            int R = Integer.parseInt(st.nextToken());
            if (L == 0 && R == 0) {
                break;
            }

            if (R <= 0) {
                continue;
            }

            arr.add(new int[]{L, R});
        }

        arr.sort(new Comparator<int[]>() {
            @Override
            public int compare(int[] o1, int[] o2) {
                if (o1[0] == o2[0]) {
                    return o2[1] - o1[1];
                }
                return o1[0] - o2[0];
            }
        });
        if (arr.isEmpty() || arr.get(0)[0] > 0) {
            System.out.println(0);
            return;
        }

        int s = arr.get(0)[0];
        int e = arr.get(0)[1];
        int cnt = 1;
        int idx = 0;
        while (idx < arr.size() && arr.get(idx)[0] <= 0) {
            if (arr.get(idx)[0] == s) {
                idx++;
                continue;
            }

            s = arr.get(idx)[0];
            if (e < arr.get(idx)[1]) {
                e = arr.get(idx)[1];
            }
            idx++;
        }

        while (e < M) {
            if (idx >= arr.size() || arr.get(idx)[0] > e) {
                System.out.println(0);
                return;
            }

            int prev = e;
            while (idx < arr.size() && arr.get(idx)[0] <= prev) {
                if (arr.get(idx)[0] == s) {
                    idx++;
                    continue;
                }

                s = arr.get(idx)[0];
                if (e < arr.get(idx)[1]) {
                    e = arr.get(idx)[1];
                }
                idx++;
            }
            cnt++;
        }
        if (e >= M) {
            System.out.println(cnt);
        } else {
            System.out.println(0);
        }
    }
}