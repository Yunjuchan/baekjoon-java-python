import java.io.*;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;

        int[][] fruits = new int[2][2];

        for (int i = 0; i < 2; i++) {
            st = new StringTokenizer(br.readLine());
            for (int j = 0; j < 2; j++) {
                fruits[i][j] = Integer.parseInt(st.nextToken());
            }
        }

        int A = fruits[0][0] + fruits[1][1];
        int B = fruits[1][0] + fruits[0][1];

        int min = Math.min(A, B);

        System.out.println(min);
    }
}