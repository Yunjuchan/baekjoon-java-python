import java.io.*;

public class Main {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        String tower = br.readLine();
        char prev = tower.charAt(0);
        int height = 10;
        for (int i = 1; i < tower.length(); i++) {
            char cur = tower.charAt(i);
            if (prev == cur) {
                height += 5;
            } else {
                height += 10;
            }

            prev = cur;
        }

        System.out.println(height);
    }
}