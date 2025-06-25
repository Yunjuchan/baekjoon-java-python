import java.io.*;

public class Main {


    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());
        int count = 1;
        int tmp = 1;
        int i = 1;

        while (tmp < N) {
            tmp += 6 * i;
            i++;
            count++;
        }
        System.out.println(count);
    }
}
