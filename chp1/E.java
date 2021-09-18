import java.io.*;
import java.util.*;

public class E {

    public static void main(String[] args) throws IOException {
        Kattio io = new Kattio("q");

        String genome = io.next();
        int k = io.nextInt(), l = io.nextInt(), t = io.nextInt();

        HashSet<String> clump = new HashSet<String>();

        HashMap<String, Integer> frequency = new HashMap<String, Integer>();

        for (int i = 0; i <= l - k; i++) {
            String key = genome.substring(i, i + k);
            if (frequency.containsKey(key)) {
                frequency.put(key, frequency.get(key) + 1);
            } else {
                frequency.put(key, 1);
            }
        }
        for (String item : frequency.keySet()) {
            if (frequency.get(item) >= t) {
                clump.add(item);
            }
        }

        // Sliding window type algorithm
        for (int i = 1; i < genome.length() - l; i++) {
            // Remove old patterns
            String firstPattern = genome.substring(i - 1, i - 1 + k);
            frequency.put(firstPattern, frequency.get(firstPattern) - 1);

            // Insert new patterns
            String lastPattern = genome.substring(i + l - k, i + l);
            if (frequency.containsKey(lastPattern)) {
                frequency.put(lastPattern, frequency.get(lastPattern) + 1);
            } else {
                frequency.put(lastPattern, 1);
            }

            if (frequency.get(lastPattern) >= t) {
                clump.add(lastPattern);
            }
        }

        for (String pattern : clump) {
            io.print(pattern + " ");
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
