import java.io.*;
import java.util.*;

public class Main {

    static int N;
    static int[][] A;
    static int result = Integer.MAX_VALUE;

    // 행을 뒤집는 메서드
    static void flipRow(int[][] arr, int r) {
        for (int i = 0; i < N; i++) {
            arr[r][i] ^= 1; // XOR 연산을 사용하여 0과 1을 뒤집음
        }
    }

    // 열을 뒤집는 메서드
    static void flipColumn(int[][] arr, int c) {
        for (int i = 0; i < N; i++) {
            arr[i][c] ^= 1; // XOR 연산을 사용하여 0과 1을 뒤집음
        }
    }

    // 각 상태의 최소 뒤집기 횟수를 계산하는 메서드
    static int calculateMinFlips(int[][] arr) {
        int countZero = 0, countOne = 0;
        for (int i = 0; i < N; i++) {
            for (int j = 0; j < N; j++) {
                if (arr[i][j] == 0) {
                    countZero++;
                } else {
                    countOne++;
                }
            }
        }
        return Math.min(countZero, countOne);
    }

    // 조합을 찾는 메서드
    static void findCombinations(int[][] arr, int rowMask, int colMask, int count) {
        int[][] now = new int[N][N];
        for (int i = 0; i < N; i++) {
            now[i] = arr[i].clone(); // 현재 상태 복사
        }

        // 행 뒤집기
        for (int i = 0; i < N; i++) {
            if ((rowMask & (1 << i)) != 0) {
                flipRow(now, i);
                count++;
            }
        }

        // 열 뒤집기
        for (int i = 0; i < N; i++) {
            if ((colMask & (1 << i)) != 0) {
                flipColumn(now, i);
                count++;
            }
        }

        result = Math.min(result, count + calculateMinFlips(now));
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        N = Integer.parseInt(br.readLine());
        A = new int[N][N];

        for (int i = 0; i < N; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            for (int j = 0; j < N; j++) {
                A[i][j] = Integer.parseInt(st.nextToken());
            }
        }

        // 모든 조합을 찾기 위해 비트 마스크 사용
        for (int rowMask = 0; rowMask < (1 << N); rowMask++) {
            for (int colMask = 0; colMask < (1 << N); colMask++) {
                findCombinations(A, rowMask, colMask, 0);
            }
        }
        System.out.println(result);
    }
}