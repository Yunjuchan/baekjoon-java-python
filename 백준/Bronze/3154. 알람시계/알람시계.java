import java.io.*;
import java.util.*;

public class Main {
    static int[][] grid;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
//        StringTokenizer st;
        String[] time = br.readLine().split(":");
        List<Integer> hour = new ArrayList<>();
        List<Integer> minute = new ArrayList<>();
        int resultEffort = Integer.MAX_VALUE;
        String result = "";

        grid = new int[10][2];
        grid[0] = new int[]{1, 3};
        grid[1] = new int[]{0, 0};
        grid[2] = new int[]{1, 0};
        grid[3] = new int[]{2, 0};
        grid[4] = new int[]{0, 1};
        grid[5] = new int[]{1, 1};
        grid[6] = new int[]{2, 1};
        grid[7] = new int[]{0, 2};
        grid[8] = new int[]{1, 2};
        grid[9] = new int[]{2, 2};

        int idx = 0;
        while (Integer.parseInt(time[0]) + 24 * idx < 100) {
            hour.add(Integer.parseInt(time[0]) + 24 * idx);
            idx++;
        }

        idx = 0;
        while (Integer.parseInt(time[1]) + 60 * idx < 100) {
            minute.add(Integer.parseInt(time[1]) + 60 * idx);
            idx++;
        }

        for (int h : hour) {
            int tmpH = 0;
            int prev = h / 10;
            tmpH += Math.abs(grid[prev][0] - grid[h % 10][0]) + Math.abs(grid[prev][1] - grid[h % 10][1]);
            for (int m : minute) {
                int tmpM = 0;
                prev = h % 10;
                tmpM += Math.abs(grid[prev][0] - grid[m / 10][0]) + Math.abs(grid[prev][1] - grid[m / 10][1]);
                prev = m / 10;
                tmpM += Math.abs(grid[prev][0] - grid[m % 10][0]) + Math.abs(grid[prev][1] - grid[m % 10][1]);
                if (resultEffort > tmpH + tmpM) {
                    resultEffort = tmpH + tmpM;
                    result = (h >= 10 ? h : "0" + h) + ":" + (m >= 10 ? m : "0" + m);
                }
            }
        }

        System.out.println(result);
    }
}