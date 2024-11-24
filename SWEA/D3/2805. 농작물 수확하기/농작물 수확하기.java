import java.io.*;

class Solution {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int T = Integer.parseInt(br.readLine().trim());

        for (int tc = 1; tc <= T; tc++) {
            int N = Integer.parseInt(br.readLine().trim());
            int[][] arr = new int[N][N];
            for (int i = 0; i < N; i++) {
                String line = br.readLine();
                for (int j = 0; j < N; j++) {
                    arr[i][j] = line.charAt(j) - '0';
                }
            }

            int result = 0;
            int mid = N / 2;
            for (int i = 0; i < N; i++) {
                int offset = Math.abs(mid - i);
                for (int j = offset; j < N - offset; j++) {
                    result += arr[i][j];
                }
            }
            System.out.println("#" + tc + " " + result);
        }
    }
}