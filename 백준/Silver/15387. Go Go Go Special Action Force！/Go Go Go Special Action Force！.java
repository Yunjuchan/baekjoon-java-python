import java.io.*;
import java.util.*;

public class Main {
    static String[][] arr;
    public static boolean infiltrate () {
        Set<String> force;
        for (int i = 0; i < 9; i++) {
            force = new HashSet<>();
            for (int j = 0; j < 9; j++) {
                force.add(arr[j][i]);
            }
            if (force.size() != 9) {
                return false;
            }
        }
        return true;
    }

    public static boolean maneuver () {
        Set<String> force;
        for (int i = 0; i < 9; i++) {
            force = new HashSet<>();
            for (int j = 0; j < 9; j++) {
                force.add(arr[i][j]);
            }
            if (force.size() != 9) {
                return false;
            }
        }
        return true;
    }

    public static boolean deploy () {
        Set<String> force;
        for (int i = 0; i < 3; i++) {
            for (int j = 0; j < 3; j++) {
                force = new HashSet<>();
                for (int k = 0; k < 3; k++) {
                    for (int l = 0; l < 3; l++) {
                        force.add(arr[i * 3 + k][j * 3 + l]);
                    }
                }
                if (force.size() != 9) {
                    return false;
                }
            }
        }
        return true;
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;
        StringBuilder sb = new StringBuilder();
        int T = Integer.parseInt(br.readLine());

        for (int t = 0; t < T; t++) {
            arr = new String[9][9];
            for (int i = 0; i < 9; i++) {
                st = new StringTokenizer(br.readLine());
                for (int j = 0; j < 9; j++) {
                    arr[i][j] = st.nextToken();
                }
            }

            if (infiltrate() && maneuver() && deploy()) {
                sb.append("all 3\n");
            } else {
                sb.append("not\n");
            }
        }
        System.out.println(sb);
    }
}