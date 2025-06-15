import java.io.*;
import java.util.*;

public class Main {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        while (true) {
            String number = br.readLine();
            if (number.equals("0")) {
                System.out.println(sb);
                return;
            }

            int N = number.length();
            boolean isNotPalindrome = false;
            for (int i = 0; i < N / 2; i++) {
                if (number.charAt(i) != number.charAt(N - i - 1)) {
                    sb.append("no").append("\n");
                    isNotPalindrome = true;
                    break;
                }
            }

            if (isNotPalindrome) {
                continue;
            }
            
            sb.append("yes").append("\n");
        }
    }
}
