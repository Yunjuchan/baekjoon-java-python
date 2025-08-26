import java.io.*;
import java.util.*;

public class Main {

    static int N;
    static String[] robots;
    static boolean[] isDead;

    static int[] countRsp(int round) {
        int[] rsp = new int[3];
        for (int j = 0; j < N; j++) {
            if (isDead[j]) {
                continue;
            }
            char c = robots[j].charAt(round);
            if (c == 'R') {
                rsp[0]++;
            } else if (c == 'S') {
                rsp[1]++;
            } else {
                rsp[2]++;
            }
        }
        return rsp;
    }

    static void game(int round, int[] rsp) {
        int winner = -1;
        if (rsp[0] > 0 && rsp[1] > 0 && rsp[2] == 0) {
            winner = 0;
        } else if (rsp[0] == 0 && rsp[1] > 0 && rsp[2] > 0) {
            winner = 1;
        } else if (rsp[0] > 0 && rsp[1] == 0 && rsp[2] > 0) {
            winner = 2;
        }

        for (int i = 0; i < N; i++) {
            if (isDead[i]) {
                continue;
            }

            if (winner == 0 && robots[i].charAt(round) == 'S') {
                isDead[i] = true;
            } else if (winner == 1 && robots[i].charAt(round) == 'P') {
                isDead[i] = true;
            } else if (winner == 2 && robots[i].charAt(round) == 'R') {
                isDead[i] = true;
            }
        }
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        int T = Integer.parseInt(br.readLine());

        for (int t = 0; t < T; t++) {
            N = Integer.parseInt(br.readLine());
            robots = new String[N];
            isDead = new boolean[N];
            for (int i = 0; i < N; i++) {
                robots[i] = br.readLine();
            }

            int K = robots[0].length();

            for (int round = 0; round < K; round++) {
                int[] rsp = countRsp(round);
                game(round, rsp);
            }

            int count = 0;
            int winner = 0;

            for (int i = 0; i < N; i++) {
                if (!isDead[i]) {
                    count++;
                    winner = i + 1;
                }
            }

            if (count != 1) {
                sb.append(0).append("\n");
            } else {
                sb.append(winner).append("\n");
            }
        }
        System.out.println(sb);
    }
}