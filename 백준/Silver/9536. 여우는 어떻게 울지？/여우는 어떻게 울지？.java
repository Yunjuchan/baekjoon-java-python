import java.io.*;
import java.util.*;

public class Main {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        int T = Integer.parseInt(br.readLine());

        for (int tc = 0; tc < T; tc++) {
            Set<String> set = new HashSet<>();
            String[] line = br.readLine().split(" ");

            while (true) {
                String animal = br.readLine();
                if (animal.equals("what does the fox say?")) {
                    break;
                }

                String sound = animal.split(" ")[2];
                set.add(sound);
            }

            for (String sound : line) {
                if (set.contains(sound)) {
                    continue;
                }
                sb.append(sound).append(" ");
            }
            sb.append("\n");
        }

        System.out.println(sb);
    }
}