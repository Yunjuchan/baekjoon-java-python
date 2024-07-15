import java.io.*;
import java.math.BigInteger;
import java.util.*;

public class Main {
    public static long charge(int x) {
        long result = 0;
        if (x <= 100) {
            result = x * 2;
        } else if (x <= 10000) {
            result = 200 + (x-100) * 3;
        } else if (x <= 1000000) {
            result = 29900 + (x - 10000) * 5;
        } else {
            result = 4979900 + (x - 1000000) * 7;
        }
        return result;
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        while (true) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            int A = Integer.parseInt(st.nextToken());
            int B = Integer.parseInt(st.nextToken());
            if (A == 0 && B == 0) {
                break;
            }

            /**
             * 0 ~ 100 -> 0 ~ 200
             * 101 ~ 10000 -> 203 ~ 29900
             * 10001 ~ 1000000 -> 29905 ~ 4979900
             * 10000001 ~ -> 4979907 ~
             */
            int wh;
            int myUse;
            if (A <= 200) {
                wh = A / 2;
            } else if (A <= 29900) {
                wh = 100 + (A-200) / 3;
            } else if (A <= 4979900) {
                wh = 10000 + (A-29900) / 5;
            } else {
                wh = 1000000 + (A-4979900) / 7;
            }

            int s = 0;
            int e = wh / 2;
            while (true) {
                int mid = (s+e) / 2;
                if (charge(wh-mid) - charge(mid) > B) {
                    s = mid+1;
                } else if (charge(wh-mid) - charge(mid) < B) {
                    e = mid -1;
                } else {
                    myUse = mid;
                    break;
                }
            }
            System.out.println(charge(myUse));
        }
    }
}