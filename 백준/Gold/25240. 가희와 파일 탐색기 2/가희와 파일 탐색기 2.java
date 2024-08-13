import java.io.*;
import java.util.*;

class Permission {
    int[] p;
    String owner;
    String group;

    Permission(int[] p, String owner, String group) {
        this.p = p.clone();
        this.owner = owner;
        this.group = group;
    }

}
public class Main {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        Map<String, HashSet<String>> groups = new HashMap<>();
        Map<String, Permission> files = new HashMap<>();
        int U = Integer.parseInt(st.nextToken());
        int F = Integer.parseInt(st.nextToken());

        for (int i=0; i<U; i++) {
            st = new StringTokenizer(br.readLine());
            String user = st.nextToken();
            if (st.hasMoreTokens()) {
                String[] group = st.nextToken().split(",");
                for (String g : group) {
                    if (!groups.containsKey(g)) {
                        groups.put(g, new HashSet<>());
                    }
                    groups.get(g).add(user);
                }
            }
            if (!groups.containsKey(user)) {
                groups.put(user, new HashSet<>());
            }
            groups.get(user).add(user);
        }

        for (int i=0; i<F; i++) {
            st = new StringTokenizer(br.readLine());
            String fileName = st.nextToken();
            int[] p = new int[3];
            int tmp = Integer.parseInt(st.nextToken());
            for (int j=0; j<3; j++) {
                p[2-j] = tmp % 10;
                if ((p[2-j] & 2) == 2) {
                    p[2-j] |= 4;
                }
                tmp /= 10;
            }
            String owner = st.nextToken();
            String group = st.nextToken();

            files.put(fileName, new Permission(p, owner, group));
        }
        st = new StringTokenizer(br.readLine());
        int Q = Integer.parseInt(st.nextToken());
        for (int q=0; q<Q; q++) {
            st = new StringTokenizer(br.readLine());
            String user = st.nextToken();
            String fileName = st.nextToken();
            char command = st.nextToken().charAt(0);
            Permission f = files.get(fileName);
            boolean isO = files.get(fileName).owner.equals(user);
            boolean isG = groups.get(files.get(fileName).group).contains(user);
            int result = 0;
            if (isO) {
                for (int i=0; i<3; i++) {
                    result = execute(command, f.p[i]) | result;
                }
            } else if (isG){
                for (int i=1; i<3; i++) {
                    result = execute(command, f.p[i]) | result;
                }
            } else {
                result = execute(command, f.p[2]) | result;
            }
            System.out.println(result);
        }

    }
    public static int execute(char command, int permission) {
        if (command == 'X' && (permission & 1) == 1) {
            return 1;
        } else if (command == 'W' && (permission & 2) == 2) {
            return 1;
        } else if (command == 'R' && (permission & 4) == 4) {
            return 1;
        } else {
            return 0;
        }
    }
}