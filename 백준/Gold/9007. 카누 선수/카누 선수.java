import java.io.*;
import java.util.*;

public class Main {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int T = Integer.parseInt(st.nextToken());

        for (int t = 0; t < T; t++) {
            st = new StringTokenizer(br.readLine());
            int k = Integer.parseInt(st.nextToken());
            int n = Integer.parseInt(st.nextToken());

            int[] A = new int[n];
            st = new StringTokenizer(br.readLine());
            for (int i = 0; i < n; i++) {
                A[i] = Integer.parseInt(st.nextToken());
            }

            int[] team1 = new int[n * n];
            st = new StringTokenizer(br.readLine());
            for (int i = 0; i < n; i++) {
                int x = Integer.parseInt(st.nextToken());
                for (int j = 0; j < n; j++) {
                    team1[i * n + j] = x + A[j];
                }
            }

            st = new StringTokenizer(br.readLine());
            A = new int[n];
            for (int i = 0; i < n; i++) {
                A[i] = Integer.parseInt(st.nextToken());
            }

            int[] team2 = new int[n * n];
            st = new StringTokenizer(br.readLine());
            for (int i = 0; i < n; i++) {
                int x = Integer.parseInt(st.nextToken());
                for (int j = 0; j < n; j++) {
                    team2[i * n + j] = x + A[j];
                }
            }

            Arrays.sort(team2);

            int closestSum = Integer.MAX_VALUE;
            int minDiff = Integer.MAX_VALUE;

            for (int i = 0; i < n * n; i++) {
                int tmp = team1[i];
                int target = k - tmp;

                int low = 0, high = team2.length - 1;
                while (low <= high) {
                    int mid = (low + high) / 2;
                    int sum = tmp + team2[mid];
                    int diff = Math.abs(sum - k);

                    if (diff < minDiff || (diff == minDiff && sum < closestSum)) {
                        minDiff = diff;
                        closestSum = sum;
                    }

                    if (sum < k) {
                        low = mid + 1;
                    } else {
                        high = mid - 1;
                    }
                }
            }
            System.out.println(closestSum);
        }
    }
}