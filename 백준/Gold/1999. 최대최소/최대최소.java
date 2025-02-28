import java.io.*;
import java.util.*;

public class Main {


    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        StringBuilder sb = new StringBuilder();

        int N = Integer.parseInt(st.nextToken());
        int B = Integer.parseInt(st.nextToken());
        int K = Integer.parseInt(st.nextToken());
        int[][] matrix = new int[N][N];
        int[][] maxDp = new int[N][N - B + 1];
        int[][] minDp = new int[N][N - B + 1];

        for (int i = 0; i < N; i++) {
            st = new StringTokenizer(br.readLine());
            for (int j = 0; j < N; j++) {
                matrix[i][j] = Integer.parseInt(st.nextToken());
            }
        }

        for (int i = 0; i < N; i++) {
            PriorityQueue<int[]> minQue = new PriorityQueue<>(new Comparator<int[]>() {
                @Override
                public int compare(int[] o1, int[] o2) {
                    if (o1[0] == o2[0]) {
                        return o1[1] - o2[1];
                    }
                    return o1[0] - o2[0];
                }
            });

            PriorityQueue<int[]> maxQue = new PriorityQueue<>(new Comparator<int[]>() {
                @Override
                public int compare(int[] o1, int[] o2) {
                    if (o1[0] == o2[0]) {
                        return o1[1] - o2[1];
                    }
                    return o2[0] - o1[0];
                }
            });

            for (int j = 0; j < N - B + 1; j++) {
                if (j == 0) {
                    for (int k = 0; k < B; k++) {
                        minQue.offer(new int[]{matrix[i][k], k});
                        maxQue.offer(new int[]{matrix[i][k], k});
                    }
                } else {
                    minQue.offer(new int[]{matrix[i][j + B - 1], j + B - 1});
                    maxQue.offer(new int[]{matrix[i][j + B - 1], j + B - 1});
                    while (!minQue.isEmpty() && minQue.peek()[1] < j) {
                        minQue.poll();
                    }

                    while (!maxQue.isEmpty() && maxQue.peek()[1] < j) {
                        maxQue.poll();
                    }
                }
                minDp[i][j] = minQue.peek()[0];
                maxDp[i][j] = maxQue.peek()[0];
            }
        }

        for (int i = 0; i < N - B + 1; i++) {
            PriorityQueue<int[]> minQue = new PriorityQueue<>(new Comparator<int[]>() {
                @Override
                public int compare(int[] o1, int[] o2) {
                    if (o1[0] == o2[0]) {
                        return o1[1] - o2[1];
                    }
                    return o1[0] - o2[0];
                }
            });

            PriorityQueue<int[]> maxQue = new PriorityQueue<>(new Comparator<int[]>() {
                @Override
                public int compare(int[] o1, int[] o2) {
                    if (o1[0] == o2[0]) {
                        return o1[1] - o2[1];
                    }
                    return o2[0] - o1[0];
                }
            });

            for (int j = 0; j < N - B + 1; j++) {
                if (j == 0) {
                    for (int k = 0; k < B; k++) {
                        minQue.offer(new int[]{minDp[k][i], k});
                        maxQue.offer(new int[]{maxDp[k][i], k});
                    }
                } else {
                    minQue.offer(new int[]{minDp[j + B - 1][i], j + B - 1});
                    maxQue.offer(new int[]{maxDp[j + B - 1][i], j + B - 1});
                    while (!minQue.isEmpty() && minQue.peek()[1] < j) {
                        minQue.poll();
                    }

                    while (!maxQue.isEmpty() && maxQue.peek()[1] < j) {
                        maxQue.poll();
                    }
                }
                minDp[j][i] = minQue.peek()[0];
                maxDp[j][i] = maxQue.peek()[0];
            }
        }

        for (int k = 0; k < K; k++) {
            st = new StringTokenizer(br.readLine());
            int r = Integer.parseInt(st.nextToken()) - 1;
            int c = Integer.parseInt(st.nextToken()) - 1;
            sb.append(maxDp[r][c] - minDp[r][c]).append("\n");
        }
        System.out.println(sb);
    }
}