import java.io.*;
import java.util.*;

public class I {

    static int k, d;
    static HashMap<String, Integer> freqMap = new HashMap<String, Integer>();

    static void increase(String pattern) {
        Integer val = freqMap.get(pattern);
        if(val != null) {
            freqMap.put(pattern, val + 1);
        } else {
            freqMap.put(pattern, 1);
        }
    }
    static char[] nucliotides = {'A', 'C', 'G', 'T'};

    static void neighbors(String pattern, int index, int dLeft) {
        if(dLeft == 0) {
            increase(pattern);
        }
        if(k == index - 1) {
            for(int i=0; i<4; i++) {
                if(nucliotides[i] == pattern.charAt(index)) {
                     
                }
            }
        }
    }

    public static void main(String[] args) throws IOException {
        Kattio io = new Kattio();

        String text = io.next();
        k = io.nextInt();
        d = io.nextInt();

        for(int i=0; i<text.length() - k; i++) {
            String pattern = text.substring(i, i + k);

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
