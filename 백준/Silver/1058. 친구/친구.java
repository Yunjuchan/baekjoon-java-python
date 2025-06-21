import java.io.*;
import java.util.*;

public class Main {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int N = Integer.parseInt(br.readLine());
        int maxCount = 0;

        boolean[][] isFriends = new boolean[N][N];
        boolean[][] isSecondFriends = new boolean[N][N];
        for (int i = 0; i < N; i++) {
            String line = br.readLine();
            for (int j = 0; j < N; j++) {
                char f = line.charAt(j);
                if (f == 'N') {
                    continue;
                }
                isFriends[i][j] = true;
                isSecondFriends[i][j] = true;
            }
        }

        for (int i = 0; i < N; i++) {
            for (int j = 0; j < N; j++) {
                if (i == j || isFriends[i][j]) {
                    continue;
                }

                for (int k = 0; k < N; k++) {
                    if (i == k || j == k || !isFriends[i][k] || !isFriends[j][k]) {
                        continue;
                    }
                    isSecondFriends[i][j] = true;
                    isSecondFriends[j][i] = true;
                }
            }
        }

        for (int i = 0; i < N; i++) {
            int cur = 0;
            for (int j = 0; j < N; j++) {
                if (!isSecondFriends[i][j]) {
                    continue;
                }
                cur++;
            }
            maxCount = Math.max(maxCount, cur);
        }

        System.out.println(maxCount);
    }
}