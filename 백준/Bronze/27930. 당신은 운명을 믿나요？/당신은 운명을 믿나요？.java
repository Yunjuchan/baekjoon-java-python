import java.io.*;
import java.util.*;

public class Main {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        String str = st.nextToken();
        
        int yonsei = 0;
        int korea = 0;
        boolean flag1, flag2;
        for (int i=0; i<str.length(); i++) {
            char c = str.charAt(i);
            if (yonsei == 0 && c == 'Y') {
                yonsei += 1;
            } else if (yonsei == 1 && c == 'O') {
                yonsei += 1;
            } else if (yonsei == 2 && c == 'N') {
                yonsei += 1;
            } else if (yonsei == 3 && c == 'S') {
                yonsei += 1;
            } else if (yonsei == 4 && c == 'E') {
                yonsei += 1;
            } else if (yonsei == 5 && c == 'I') {
                yonsei += 1;
            }
            if (korea == 0 && c == 'K') {
                korea += 1;
            } else if (korea == 1 && c == 'O') {
                korea += 1;
            } else if (korea == 2 && c == 'R') {
                korea += 1;
            } else if (korea == 3 && c == 'E') {
                korea += 1;
            } else if (korea == 4 && c == 'A') {
                korea += 1;
            }
            if (yonsei == 6) {
                System.out.println("YONSEI");
                break;
            }
            if (korea == 5) {
                System.out.println("KOREA");
                break;
            }
            
        }
    }
}