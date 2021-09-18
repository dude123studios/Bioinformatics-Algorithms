import java.io.*;
import java.util.*;

public class H {

    static int hammingDist(String pattern1, String pattern2) {
        int dist = 0;
        for (int i = 0; i < pattern1.length(); i++) {
            if (pattern1.charAt(i) != pattern2.charAt(i))
                dist++;
        }
        return dist;
    }

    public static void main(String[] args) throws IOException {
        Kattio io = new Kattio("q");

        String pattern = io.next(), text = io.next();
        int d = io.nextInt();

        int pLength = pattern.length();
        for (int i = 0; i < text.length() - pLength; i++) {
            if (hammingDist(text.substring(i, i + pLength), pattern) <= d)
                io.print(i + " ");
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
