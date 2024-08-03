import java.io.*;
import java.util.*;


public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
//        StringTokenizer st = new StringTokenizer(br.readLine());
        char[] line = br.readLine().toCharArray();
        int cnt = 0;
        int result = 0;
        char prev = ' ';
        for (char x : line) {
            if (x == '(') {
                cnt++;
                prev = x;
            } else {
                cnt--;
                if (prev == '(') {
                    result += cnt;
                } else {
                    result++;
                }
                prev = ')';
            }
        }
        System.out.println(result);
    }
}