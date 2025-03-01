import java.io.*;
import java.util.*;

public class Main {


    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());
        int M = Integer.parseInt(br.readLine());
        String line = br.readLine();

        int result = 0;
        int cnt = -1;
        boolean b = false;
        char prev = line.charAt(0);
        if (prev == 'I') {
            b = true;
            cnt = 0;
        }

        for (int i = 1; i < M; i++) {
            if (b) {
                if (prev == 'O' && line.charAt(i) == 'I') {
                    cnt++;
                } else if (prev == line.charAt(i)) {
                    result += Math.max(0, cnt - N + 1);
                    cnt = -1;
                    b = false;
                    if (line.charAt(i) == 'I') {
                        cnt++;
                        b = true;
                    }
                }
            } else {
                if (line.charAt(i) == 'I') {
                    cnt = 0;
                    b = true;
                }
            }
            prev = line.charAt(i);
        }
        result += Math.max(0, cnt - N + 1);
        System.out.println(result);
    }
}