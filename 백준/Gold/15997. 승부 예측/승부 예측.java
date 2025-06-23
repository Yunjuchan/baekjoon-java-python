import java.io.*;
import java.util.*;

public class Main {

    static double[] nextRound = new double[4];
    static double[][][] P;

    public static void calcNextRound(double p, int[] points) {
        int[][] sortedPoints = new int[4][2];
        int[] rank = new int[4];

        for (int i = 0; i < 4; i++) {
            sortedPoints[i][0] = i;
            sortedPoints[i][1] = points[i];
        }

        Arrays.sort(sortedPoints, new Comparator<int[]>() {
            @Override
            public int compare(int[] o1, int[] o2) {
                return o2[1] - o1[1];
            }
        });

        rank[sortedPoints[0][0]] = 1;

        for (int i = 1; i < 4; i++) {
            if (sortedPoints[i - 1][1] == sortedPoints[i][1]) {
                rank[sortedPoints[i][0]] = rank[sortedPoints[i - 1][0]];
            } else {
                rank[sortedPoints[i][0]] = i + 1;
            }
        }
        int left = 2;
        for (int i = 1; i <= 2; i++) {
            List<Integer> candidate = new ArrayList<>();
            int count = 0;
            for (int j = 0; j < 4; j++) {
                if (rank[j] == i) {
                    candidate.add(j);
                    count++;
                }
            }
            if (i == 1) {
                if (count == 1) {
                    nextRound[candidate.get(0)] += p;
                } else {
                    for (int c : candidate) {
                        nextRound[c] += p * 2 / count;
                    }
                    return;
                }
            } else {
                for (int c : candidate) {
                    nextRound[c] += p * 1 / count;
                }
                return;
            }
        }
    }

    public static void dfs(int level, double p, int[] points) {
        if (p == 0) {
            return;
        }

        if (level == 6) {
            calcNextRound(p, points);
            return;
        }

        int A = order[level][0];
        int B = order[level][1];
        for (int i = 0; i < 3; i++) {
            points[A] += 6 / (3 * i + 2);
            points[B] += 6 / (3 * (2 - i) + 2);
            dfs(level + 1, p * P[A][B][i], points);
            points[A] -= 6 / (3 * i + 2);
            points[B] -= 6 / (3 * (2 - i) + 2);
        }

    }
    static int[][] order = new int[][] {{0, 1}, {0, 2}, {0, 3}, {1, 2}, {1, 3}, {2, 3}};

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        Map<String, Integer> nations = new HashMap<>();

        for (int i = 0; i < 4; i++) {
            nations.put(st.nextToken(), i);
        }

        P = new double[4][4][3];

        for (int i = 0; i < 6; i++) {
            st = new StringTokenizer(br.readLine());
            int A = nations.get(st.nextToken());
            int B = nations.get(st.nextToken());
            for (int j = 0; j < 3; j++) {
                P[A][B][j] = P[B][A][2 - j] = Double.parseDouble(st.nextToken());
            }
        }

        dfs(0, 1, new int[4]);
        for (int i = 0; i < 4; i++) {
            System.out.println(nextRound[i]);
        }
    }
}