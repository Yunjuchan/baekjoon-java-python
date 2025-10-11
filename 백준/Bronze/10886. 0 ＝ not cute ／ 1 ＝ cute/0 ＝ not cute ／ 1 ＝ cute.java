import java.io.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());

        int[] vote = new int[2];
        for (int i = 0; i < N; i++) {
            int o = Integer.parseInt(br.readLine());
            vote[o]++;
        }

        if (vote[0] > vote[1]) {
            System.out.println("Junhee is not cute!");
        } else {
            System.out.println("Junhee is cute!");
        }

    }
}