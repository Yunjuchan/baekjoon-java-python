import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Main {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int N = Integer.parseInt(st.nextToken());
        int[] scores = new int[3];
        int[] winningTime = new int[3];
        int lastSecond = 0;
        int winner = 0;
        for (int i=0; i<N; i++) {
            st = new StringTokenizer(br.readLine());
            int team = Integer.parseInt(st.nextToken());
            String[] timeFormat = st.nextToken().split(":");
            int second = Integer.parseInt(timeFormat[0]) * 60 + Integer.parseInt(timeFormat[1]);
            scores[team]++;
            if (scores[1] > scores[2]) {
                if (winner == 1) {
                    winningTime[1] += second - lastSecond;
                } else {
                    winner = 1;
                }
            } else if (scores[1] < scores[2]) {
                if (winner == 2) {
                    winningTime[2] += second - lastSecond;
                } else {
                    winner = 2;
                }
            } else {
                winningTime[winner] += second - lastSecond;
                winner = 0;
            }
            lastSecond = second;
        }
        if (winner != 0) {
            winningTime[winner] += 48*60 - lastSecond;
        }
        for (int i=1; i<=2; i++) {
            System.out.printf("%02d:%02d\n", winningTime[i] / 60, winningTime[i] % 60);
        }
    }
}