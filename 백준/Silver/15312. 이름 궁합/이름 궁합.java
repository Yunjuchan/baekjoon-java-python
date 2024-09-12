import java.io.BufferedReader;
import java.io.InputStreamReader;

public class Main {

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String[] name = new String[2];
        name[0] = br.readLine();
        name[1] = br.readLine();

        int[] numbers = new int[]{3, 2, 1, 2, 3, 3, 2, 3, 3, 2, 2, 1, 2, 2, 1, 2, 2, 2, 1, 2, 1, 1, 1, 2, 2, 1};
        int N = 2 * name[0].length();
        int[] percent = new int[N];

        for (int i = 0; i < N; i++) {
            percent[i] = numbers[(int) name[i % 2].charAt(i / 2) - 65];
        }
        for (int i = 0; i < N - 2; i++) {
            for (int j = 0; j < N - i - 1; j++) {
                percent[j] += percent[j + 1];
                percent[j] %= 10;
            }
        }
        System.out.println(percent[0] + "" + percent[1]);
    }
}