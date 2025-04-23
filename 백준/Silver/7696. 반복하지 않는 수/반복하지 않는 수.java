import java.io.*;
import java.util.*;

public class Main {

    static boolean[] used = new boolean[10];

    public static boolean notRepeat(int number) {
        Arrays.fill(used, false);
        while (number != 0) {
            int res = number % 10;
            number /= 10;
            if (used[res]) {
                return false;
            }
            used[res] = true;
        }
        return true;
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        int[] arr = new int[1000001];
        int idx = 1;
        int number = 1;

        while (idx <= 1000000) {
            if (!notRepeat(number)) {
                number++;
                continue;
            }
            arr[idx++] = number++;
        }

        while (true) {
            int N = Integer.parseInt(br.readLine());
            if (N == 0) {
                System.out.println(sb);
                return;
            }
            sb.append(arr[N]).append("\n");
        }
    }
}