import java.io.*;
import java.util.*;

public class Main {


    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;

        int N = Integer.parseInt(br.readLine());
        int leftCnt = 0;
        long leftDist = 0;
        int rightCnt = 0;
        long rightDist = 0;
        long dist = Long.MAX_VALUE;
        int answer = -1;
        int[] houses = new int[100_001];

        st = new StringTokenizer(br.readLine());

        for (int i = 0; i < N; i++) {
            int h = Integer.parseInt(st.nextToken());
            houses[h] += 1;
            rightCnt += 1;
            rightDist += h - 1;
        }

        for (int i = 1; i <= 100_000; i++) {
            if (houses[i] == 0) {
                rightDist -= rightCnt;
                leftDist += leftCnt;
                continue;
            }

            if (dist > rightDist + leftDist) {
                dist = rightDist + leftDist;
                answer = i;
            }
            
            int hCnt = houses[i];
            rightCnt -= hCnt;
            leftCnt += hCnt;

            rightDist -= rightCnt;
            leftDist += leftCnt;
        }

        System.out.println(answer);
    }
}