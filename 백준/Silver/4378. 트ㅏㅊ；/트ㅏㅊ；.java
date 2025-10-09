import java.io.*;
import java.util.*;

public class Main {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();

        Map<String, String> map = new HashMap<>();
        map.put("1", "`");map.put("2", "1");map.put("3", "2");map.put("4", "3");map.put("5", "4");
        map.put("6", "5");map.put("7", "6");map.put("8", "7");map.put("9", "8");map.put("0", "9");
        map.put("-", "0");map.put("=", "-");
        map.put("W", "Q");map.put("E", "W");map.put("R", "E");map.put("T", "R");map.put("Y", "T");
        map.put("U", "Y");map.put("I", "U");map.put("O", "I");map.put("P", "O");map.put("[", "P");
        map.put("]", "[");map.put("\\", "]");
        map.put("S", "A");map.put("D", "S");map.put("F", "D");map.put("G", "F");map.put("H", "G");
        map.put("J", "H");map.put("K", "J");map.put("L", "K");map.put(";", "L");map.put("'", ";");
        map.put("X", "Z");map.put("C", "X");map.put("V", "C");map.put("B", "V");map.put("N", "B");
        map.put("M", "N");map.put(",", "M");map.put(".", ",");map.put("/", ".");map.put(" ", " ");

        while (true) {
            String line = br.readLine();
            if (line == null || line.isEmpty()) {
                break;
            }

            for (char c : line.toCharArray()) {
                String s = String.valueOf(c);
                sb.append(map.get(s));
            }
            sb.append("\n");
        }


        System.out.println(sb);
    }
}