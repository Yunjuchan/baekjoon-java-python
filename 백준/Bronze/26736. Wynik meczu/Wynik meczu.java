import java.io.*;
import java.util.*;

public class Main {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        String word = st.nextToken();
        int cntA = 0;
        int cntB = 0;
        for (int i=0; i<word.length(); i++) {
            if (word.charAt(i) == 'A') {
                cntA++;
            } else {
                cntB++;
            }
        }
        System.out.println(cntA + " : " + cntB);
    }
}