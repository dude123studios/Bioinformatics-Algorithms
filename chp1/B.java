import java.io.*;
import java.util.*;

public class B {

    public static void main(String[] args) throws IOException {
        Kattio io = new Kattio("q");

        String text = io.next();
        int k = io.nextInt();
        HashMap<String, Integer> patterns = new HashMap<String, Integer>();

        for (int i = 0; i < text.length() - k; i++) {
            String key = text.substring(i, i + k);
            if (patterns.containsKey(key)) {
                patterns.put(key, patterns.get(key) + 1);
            } else {
                patterns.put(key, 1);
            }
        }

        Set<String> keyset = patterns.keySet();
        int max = 0;
        for (String item : keyset) {
            max = Math.max(max, patterns.get(item));
        }
        for (String item : keyset) {
            if (patterns.get(item) == max) {
                io.println(item);
            }
        }
        io.close();
    }

    static class Kattio extends PrintWriter {
        private BufferedReader r;
        private StringTokenizer st;

        // standard input
        public Kattio() {
            this(System.in, System.out);
        }

        public Kattio(InputStream i, OutputStream o) {
            super(o);
            r = new BufferedReader(new InputStreamReader(i));
        }

        // USACO-style file input
        public Kattio(String problemName) throws IOException {
            super(new FileWriter(problemName + ".out"));
            r = new BufferedReader(new FileReader(problemName + ".in"));
        }

        // returns null if no more input
        public String next() {
            try {
                while (st == null || !st.hasMoreTokens())
                    st = new StringTokenizer(r.readLine());
                return st.nextToken();
            } catch (Exception e) {
            }
            return null;
        }

        public int nextInt() {
            return Integer.parseInt(next());
        }

        public double nextDouble() {
            return Double.parseDouble(next());
        }

        public long nextLong() {
            return Long.parseLong(next());
        }
    }
}
