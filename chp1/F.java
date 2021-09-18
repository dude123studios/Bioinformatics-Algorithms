import java.io.*;
import java.util.*;

public class F {

    public static void main(String[] args) throws IOException {
        Kattio io = new Kattio("q");
        String dna = io.next();

        int val = 0;
        int min = 0;

        for (int i = 0; i < dna.length(); i++) {
            if (dna.charAt(i) == 'C') {
                val--;
            } else if (dna.charAt(i) == 'G') {
                val++;
            }
            min = Math.min(min, val);
        }
        val = 0;
        for (int i = 0; i < dna.length(); i++) {
            if (dna.charAt(i) == 'C') {
                val--;
            } else if (dna.charAt(i) == 'G') {
                val++;
            }
            if (val == min) {
                io.print(i + 1 + " ");
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
