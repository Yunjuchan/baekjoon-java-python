import java.io.*;
import java.util.*;

public class Main {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
//        StringTokenizer st = new StringTokenizer(br.readLine());
        int N = Integer.parseInt(br.readLine());
        char[][] pan = new char[N][N];
        for (int i=0; i<N; i++) {
            for (int j=0; j<N; j++) {
                pan[i][j] = 46;
            }
        }

        String order = br.readLine();
        int idx = 0;
        int y = 0;
        int x = 0;

        while (idx != order.length()) {
            if (order.charAt(idx) == 'L' || order.charAt(idx) == 'U') {
                idx++;
            } else if (order.charAt(idx) == 'R') {
                pan[y][x] = 45;
                x++;
                pan[y][x] = 45;
                idx++;
                break;
            } else {
                pan[y][x] = 124;
                y++;
                pan[y][x] = 124;
                idx++;
                break;
            }
        }
        while (idx != order.length()) {
            if (order.charAt(idx) == 'L') {
                if (x-1<0) {
                    idx++;
                    continue;
                }
                if (pan[y][x] == 124) {
                    pan[y][x] = 43;
                }
                x--;
                if (pan[y][x] == 124) {
                    pan[y][x] = 43;
                } else if (pan[y][x] == 46) {
                    pan[y][x] = 45;
                }
            } else if (order.charAt(idx) == 'R') {
                if (x+1>=N) {
                    idx++;
                    continue;
                }
                if (pan[y][x] == 124) {
                    pan[y][x] = 43;
                }
                x++;
                if (pan[y][x] == 124) {
                    pan[y][x] = 43;
                } else if (pan[y][x] == 46) {
                    pan[y][x] = 45;
                }
            } else if (order.charAt(idx) == 'U') {
                if (y-1<0) {
                    idx++;
                    continue;
                }
                if (pan[y][x] == 45) {
                    pan[y][x] = 43;
                }
                y--;
                if (pan[y][x] == 45) {
                    pan[y][x] = 43;
                } else if (pan[y][x] == 46) {
                    pan[y][x] = 124;
                }
            } else {
                if (y+1>=N) {
                    idx++;
                    continue;
                }
                if (pan[y][x] == 45) {
                    pan[y][x] = 43;
                }
                y++;
                if (pan[y][x] == 45) {
                    pan[y][x] = 43;
                } else if (pan[y][x] == 46) {
                    pan[y][x] = 124;
                }
            }
//            System.out.println("now order: " + order.charAt(idx));
            idx++;
//            for (int i=0; i<N; i++) {
//                for (int j=0; j<N; j++) {
//                    System.out.print(pan[i][j]);
//                }
//                System.out.println();
//            }
        }
        
        for (int i=0; i<N; i++) {
            for (int j=0; j<N; j++) {
                System.out.print(pan[i][j]);
            }
            System.out.println();
        }
    }

}