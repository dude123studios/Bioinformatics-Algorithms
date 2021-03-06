import java.io.*;
import java.util.*;

public class C {

    public static void main(String[] args) throws IOException {
        Kattio io = new Kattio("q");

        String string = io.next();
        StringBuilder sb = new StringBuilder();

        HashMap<Character, String> inverseMap = new HashMap<Character, String>();
        inverseMap.put('A', "T");
        inverseMap.put('T', "A");
        inverseMap.put('C', "G");
        inverseMap.put('G', "C");

        for (int i = string.length() - 1; i >= 0; i--) {
            sb.append(inverseMap.get(string.charAt(i)));
        }

        io.println(sb.toString());
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
