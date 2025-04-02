import java.io.*;
import java.util.*;

public class Main {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;

        int cnt = 0;

        for (int i = 0; i < 8; i++) {
            String line = br.readLine();

            for (int j = 0; j < 8; j++) {
                if ((i + j) % 2 == 1) {
                    continue;
                }
                if (line.charAt(j) == 'F') {
                    cnt++;
                }
            }
        }

        System.out.println(cnt);
    }
}
