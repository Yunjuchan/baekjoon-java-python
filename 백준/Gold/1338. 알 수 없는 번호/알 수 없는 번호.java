import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        long s = Long.parseLong(st.nextToken());
        long e = Long.parseLong(st.nextToken());

        st = new StringTokenizer(br.readLine());
        long x = Math.abs(Long.parseLong(st.nextToken()));
        long y = Long.parseLong(st.nextToken());

        if (s > e) {
            long tmp = s;
            s = e;
            e = tmp;
        }

        boolean flag = true;
        if (y < 0 || y >= x) {
            flag = false;
        }

        long first = (s / x) * x + y;
        if ((first - s) >= x) {
            first -= x;
        } else if (s - first > 0 ) {
            first += x;
        }

        if (!flag) {
            System.out.println("Unknwon Number");
        } else if (e >= first) {
            if (e >= first + x) {
                System.out.println("Unknwon Number");
            } else {
                System.out.println(first);
            }
        } else {
            System.out.println("Unknwon Number");
        }
    }
}