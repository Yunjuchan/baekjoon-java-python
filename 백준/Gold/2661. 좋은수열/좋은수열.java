import java.io.*;
import java.util.*;

public class Main {

    static String result = "";

    static int N;

    public static boolean isadj(String number) {

        int length = number.length();

        for (int i=1; i<=length/2; i++) {
            String left = number.substring(length-i, length);
            String right = number.substring(length-2*i,length-i);
            if (left.equals(right)) {
                return true;
            }
        }
        return false;
    }

    public static void dfs(int level, String number) {

        if (!result.isEmpty()) {
            return;
        }

        if (level == N) {
            result = number;
            return;
        }

        for (int i=1; i<=3; i++) {
            String next = number + i;
            if (isadj(next)) {
                continue;
            }
            dfs(level+1, next);
        }
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
//        StringTokenizer st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(br.readLine());

        dfs(0, "");
        System.out.println(result);
    }
}