import java.io.*;
import java.util.*;

public class Main {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;
        StringBuilder sb = new StringBuilder();

        while (true) {
            st = new StringTokenizer(br.readLine());
            int N = Integer.parseInt(st.nextToken());

            if (N == 0) {
                System.out.println(sb);
                return;
            }

            int[] numbers = new int[10];
            for (int i = 0; i < N; i++) {
                int n = Integer.parseInt(st.nextToken());
                numbers[n]++;
            }

            int A = 0;
            int B = 0;

            for (int i = 1; i < 10; i++) {
                if (numbers[i] != 0) {
                    numbers[i]--;
                    A = i;
                    break;
                }
            }

            for (int i = 1; i < 10; i++) {
                if (numbers[i] != 0) {
                    numbers[i]--;
                    B = i;
                    break;
                }
            }
            boolean turn = true;

            for (int i = 0; i < 10; i++) {
                while (numbers[i] != 0) {
                    if (turn) {
                        A *= 10;
                        A += i;
                    } else {
                        B *= 10;
                        B += i;
                    }
                    numbers[i]--;
                    turn = !turn;
                }
            }

            sb.append(A + B).append("\n");
        }
    }
}