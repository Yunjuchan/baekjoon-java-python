import java.io.*;
import java.util.*;

public class Main {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;

        int N = Integer.parseInt(br.readLine());
        int[] honey = new int[N];
        st = new StringTokenizer(br.readLine());
        for (int i = 0; i < N; i++) {
            honey[i] = Integer.parseInt(st.nextToken());
        }

        int[] sum = new int[N];
        int[] reverseSum = new int[N];

        sum[0] = honey[0];
        reverseSum[N - 1] = honey[N - 1];

        for (int i = 1; i < N; i++) {
            sum[i] = sum[i - 1] + honey[i];
        }

        for (int i = N - 2; i >= 0; i--) {
            reverseSum[i] = reverseSum[i + 1] + honey[i];
        }

        int max = 0;

        // 벌이 벌집 좌우에 있을 때
        for (int i = 1; i < N - 1; i++) {
            int cur = (sum[i] - sum[0]) + (reverseSum[i] - reverseSum[N - 1]);
            max = Math.max(max, cur);
        }

        // 벌이 벌집 왼쪽에 있을 때 (벌집 무조건 제일 마지막)
        for (int i = 1; i < N - 1; i++) {
            int cur = (sum[N - 1] - sum[0]) + (sum[N - 1] - sum[i] - honey[i]);
            max = Math.max(max, cur);
        }

        // 벌이 벌집 오른쪽에 있을 때 (벌집 무조건 제일 처음)
        for (int i = 1; i < N - 1; i++) {
            int cur = (reverseSum[0] - reverseSum[N - 1]) + (reverseSum[0] - reverseSum[i] - honey[i]);
            max = Math.max(max, cur);
        }

        System.out.println(max);
    }
}