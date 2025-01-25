import java.io.*;
import java.util.*;

public class Main {
    static int N, result = 0;
    static int[][] batters;
    static boolean[] visited;

    public static int calcScore(int[] order) {
        int now = 0;
        int score = 0;

        for (int i = 0; i < N; i++) {
            int outCount = 0;
            boolean[] base = new boolean[4];
            while (outCount < 3) {
//                System.out.println((i+1) + "이닝: " + (now+1) + "타석 " + "아웃 카운트는: " + outCount);
                base[0] = true;
                if (batters[i][order[now]] == 0) {
                    outCount++;
                } else {
                    for (int j = 3; j >= 0; j--) {
                        if (base[j]) {
                            base[j] = false;
                            if (j + batters[i][order[now]] >= 4) {
                                score++;
//                                    System.out.println("now: " + now + " tmpScore: " + tmpScore);
                            } else {
                                base[j + batters[i][order[now]]] = true;
                            }
                        }
                    }
                }
                now++;
                now %= 9;
            }
//                System.out.println("첫 순번을 " + start + "로 했을 때 " + i + "이닝까지 점수 : " + tmpScore);
        }
        return score;
    }

    public static void dfs(int level, int[] order) {
        if (level == 9) {

            int nowScore = calcScore(order);
            result = Math.max(result, nowScore);
            return;
        }
        if (level == 3) {
            dfs(level+1, order);
        } else {
            for (int i=1; i<9; i++) {
                if (visited[i]) {
                    continue;
                }
                visited[i] = true;
                order[level] = i;
                dfs(level+1, order);
                visited[i] = false;
                order[level] = 0;
            }
        }
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;
        N = Integer.parseInt(br.readLine());
        batters = new int[N][9];
        visited = new boolean[9];

        for (int i = 0; i < N; i++) {
            st = new StringTokenizer(br.readLine());
            for (int j = 0; j < 9; j++) {
                batters[i][j] = Integer.parseInt(st.nextToken());
            }
        }
        dfs(0, new int[9]);
        System.out.println(result);
    }
}