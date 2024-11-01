import java.io.*;

public class Main {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();

        String line;
        while ((line = br.readLine()) != null) {
            int[] cnt = new int[4];
            for (char c : line.toCharArray()) {
                if (c >= 'a' && c <= 'z') {
                    cnt[0]++;
                } else if (c >= 'A' && c <= 'Z') {
                    cnt[1]++;
                } else if (c >= '0' && c <= '9') {
                    cnt[2]++;
                } else if (c == ' ') {
                    cnt[3]++;
                }
            }
            sb.append(cnt[0]).append(" ").append(cnt[1]).append(" ").append(cnt[2]).append(" ").append(cnt[3]).append("\n");
        }

        System.out.print(sb.toString());
    }
}