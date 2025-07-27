import java.io.*;
public class Main {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int N = Integer.parseInt(br.readLine());
        String surrender = br.readLine().replace("X", "");
        if (N <= 2 * surrender.length()) {
            System.out.println("Yes");
        } else {
            System.out.println("No");
        }
    }
}