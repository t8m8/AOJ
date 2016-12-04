import java.util.*;
import java.io.*;
import java.awt.geom.*;
import java.math.*;

public class AOJ2700 {

	static final Scanner in = new Scanner(System.in);
	static final PrintWriter out = new PrintWriter(System.out,false);
	static boolean debug = false;

	static String req(String s, int k) {
		StringBuilder res = new StringBuilder();
		res.append(s.charAt(0));
		int n = s.length();
		for (int i=0; i<n; i++) {
			if (i != n-1 && (s.charAt(i) == 'a' || s.charAt(i) == 'i' || s.charAt(i) == 'u' || s.charAt(i) == 'e' || s.charAt(i) == 'o'))
				res.append(s.charAt(i+1));
		}
		return res.substring(0, Math.min(k, res.length()));
	}

	static boolean solve() {
		int n = in.nextInt();
		if (n == 0) return false;

		String[] s = new String[n];
		for (int i=0; i<n; i++) {
			s[i] = in.next();
		}

		for (int k=1; k<=50; k++) {
			HashSet<String> set = new HashSet<>();
			for (int i=0; i<n; i++) {
				set.add(req(s[i], k));
			}
			if (set.size() == n) {
				out.println(k);
				return true;
			}
		}

		out.println("-1");

		return true;
	}

	public static void main(String[] args) {
		debug = args.length > 0;
		long start = System.nanoTime();

		while(solve());
		out.flush();

		long end = System.nanoTime();
		dump((end - start) / 1000000 + " ms");
		in.close();
		out.close();
	}

	static void dump(Object... o) { if (debug) System.err.println(Arrays.deepToString(o)); }
}