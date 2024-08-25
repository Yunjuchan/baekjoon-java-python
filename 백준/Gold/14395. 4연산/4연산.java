import java.io.*;
import java.util.*;

public class Main {

    public static class Route {
        long n;
        String r;

        public Route (long n, String r) {
            this.n = n;
            this.r = r;
        }
    }

    public static Route plus(Route x) {
        return new Route(x.n+x.n, x.r+"+");
    }

    public static Route minus(Route x) {
        return new Route(0, x.r+"-");
    }

    public static Route multi(Route x) {
        return new Route(x.n*x.n, x.r+"*");
    }

    public static Route divied(Route x) {
        return new Route(1, x.r+"/");
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        long s = Long.parseLong(st.nextToken());
        int t = Integer.parseInt(st.nextToken());
        Queue<Route> que = new LinkedList<>();
        que.add(new Route(s, ""));
        Set<Long> set = new HashSet<>();
        set.add(s);
        boolean flag = false;
        while (!que.isEmpty()) {
            Route now = que.poll();
            if (now.n == t) {

                if (now.r.isEmpty()) {
                    System.out.println(0);
                } else {
                    System.out.println(now.r);
                }
                flag = true;
                break;
            }
            if (now.n <= 100000) {
                Route mu = multi(now);
                if (!set.contains(mu.n)) {
                    set.add(mu.n);
                    que.add(mu);
                }
            }
            if (now.n <= 500000000) {
                Route pl = plus(now);
                if (!set.contains(pl.n)) {
                    set.add(pl.n);
                    que.add(pl);
                }
            }
            Route mi = minus(now);
            if (!set.contains(mi.n)) {
                set.add(mi.n);
                que.add(mi);
            }
            if (now.n != 0) {
                Route di = divied(now);
                if (!set.contains(di.n)) {
                    set.add(di.n);
                    que.add(di);
                }
            }
        }
        if (!flag) {
            System.out.println(-1);
        }
    }
}