import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int[] rgb = new int[3];
        for (int i = 0; i < 3; i++) {
            rgb[i] = Integer.parseInt(st.nextToken());
        }

        int answer = 0;

        int mix = Math.min(rgb[0], Math.min(rgb[1], rgb[2]));
        answer += mix;
        for (int i = 0; i < 3; i++) {
            rgb[i] -= mix;
        }

        for (int i = 0; i < 3; i++) {
            answer += rgb[i] / 3;
            rgb[i] %= 3;
        }

        Arrays.sort(rgb);

        if (rgb[2] == 0) {
        } else if (rgb[1] != 0 && rgb[2] == 2) {
            answer += 2;
        } else {
            answer += 1;
        }

        System.out.println(answer);
    }
}
