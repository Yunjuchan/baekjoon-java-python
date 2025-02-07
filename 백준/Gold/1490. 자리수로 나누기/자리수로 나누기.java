import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String number = br.readLine();
        boolean isPossible = true;
        long num = Long.parseLong(number);

        for (int i = 0; i < number.length(); i++) {
            int x = number.charAt(i) - '0';
            if (x == 0) {
                continue;
            }
            if (num % x != 0) {
                isPossible = false;
                break;
            }
        }

        if (isPossible) {
            System.out.println(number);
            return;
        }

        int l = 1;
        long plus = 0;
        long next = 10;

        while (true) {
            String tmpNumber = number + String.format("%0" + (l) + "d", plus);
            long tmpNum = Long.parseLong(tmpNumber);

            isPossible = true;
            for (int i = 0; i < number.length(); i++) {
                int x = tmpNumber.charAt(i) - '0';
                if (x == 0) {
                    continue;
                }
                if (tmpNum % x != 0) {
                    isPossible = false;
                    break;
                }
            }

            if (isPossible) {
                System.out.println(tmpNumber);
                return;
            }

            plus++;
            if (plus == next) {
                next *= 10;
                l++;
                plus = 0;
            }
        }
    }
}