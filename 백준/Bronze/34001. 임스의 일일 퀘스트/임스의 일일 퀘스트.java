import java.io.*;
import java.util.*;

public class Main {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int L = Integer.parseInt(br.readLine());

        int[] arcane = new int[6];
        int[] grandis = new int[7];


        if (L < 210) {
            arcane[0] = 500;
        } else if (L < 220) {
            arcane[0] = 300;
            arcane[1] = 500;
        } else if (L < 225) {
            arcane[0] = 100;
            arcane[1] = 300;
            arcane[2] = 500;
        } else if (L < 230) {
            arcane[0] = 100;
            arcane[1] = 100;
            arcane[2] = 300;
            arcane[3] = 500;
        } else if (L < 235) {
            arcane[0] = 100;
            arcane[1] = 100;
            arcane[2] = 100;
            arcane[3] = 300;
            arcane[4] = 500;
        } else if (L < 245) {
            arcane[0] = 100;
            arcane[1] = 100;
            arcane[2] = 100;
            arcane[3] = 100;
            arcane[4] = 300;
            arcane[5] = 500;
        } else if (L < 250) {
            arcane[0] = 100;
            arcane[1] = 100;
            arcane[2] = 100;
            arcane[3] = 100;
            arcane[4] = 100;
            arcane[5] = 300;
        } else if (L < 260) {
            Arrays.fill(arcane, 100);
        } else if (L < 265) {
            Arrays.fill(arcane, 100);
            grandis[0] = 500;
        } else if (L < 270) {
            Arrays.fill(arcane, 100);
            grandis[0] = 300;
            grandis[1] = 500;
        } else if (L < 275) {
            Arrays.fill(arcane, 100);
            grandis[0] = 100;
            grandis[1] = 300;
            grandis[2] = 500;
        } else if (L < 280) {
            Arrays.fill(arcane, 100);
            grandis[0] = 100;
            grandis[1] = 100;
            grandis[2] = 300;
            grandis[3] = 500;
        } else if (L < 285) {
            Arrays.fill(arcane, 100);
            grandis[0] = 100;
            grandis[1] = 100;
            grandis[2] = 100;
            grandis[3] = 300;
            grandis[4] = 500;
        } else if (L < 290) {
            Arrays.fill(arcane, 100);
            grandis[0] = 100;
            grandis[1] = 100;
            grandis[2] = 100;
            grandis[3] = 100;
            grandis[4] = 300;
            grandis[5] = 500;
        } else if (L < 295) {
            Arrays.fill(arcane, 100);
            grandis[0] = 100;
            grandis[1] = 100;
            grandis[2] = 100;
            grandis[3] = 100;
            grandis[4] = 100;
            grandis[5] = 300;
            grandis[6] = 500;
        } else if (L < 300){
            Arrays.fill(arcane, 100);
            Arrays.fill(grandis, 100);
            grandis[6] = 300;
        } else {
            Arrays.fill(arcane, 100);
            Arrays.fill(grandis, 100);
        }

        for (int i = 0; i < 6; i++) {
            System.out.print(arcane[i] + " ");
        }
        System.out.println();
        for (int i = 0; i < 7; i++) {
            System.out.print(grandis[i] + " ");
        }
    }
}