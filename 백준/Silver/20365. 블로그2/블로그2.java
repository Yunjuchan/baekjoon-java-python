import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        char now = ' ';
        int[] result = new int[2];
        String line = br.readLine();
        for (char x : line.toCharArray()) {
            if (now != x) {
                if (x == 'B') {
                    result[0]++;
                } else {
                    result[1]++;
                }
            }
            now = x;
        }
        System.out.println(Math.min(result[0], result[1])+1);
    }
}