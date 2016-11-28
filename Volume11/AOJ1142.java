import java.util.*;
import java.io.*;
import java.awt.geom.*;
import java.math.*;

public class AOJ1142 {

	static final Scanner in = new Scanner(System.in);
	static final PrintWriter out = new PrintWriter(System.out,false);
	static boolean debug = false;

	static void solve() {
		int m = in.nextInt();
		while(m-- > 0) {
			HashSet<String> set = new HashSet<>();
			String s = in.next();
			int n = s.length();
			for (int i=1; i<n; i++) {
				String a = s.substring(0, i);
				String b = s.substring(i, n);
				String ra = new StringBuilder(a).reverse().toString();
				String rb = new StringBuilder(b).reverse().toString();
				set.add(a + b);
				set.add(a + rb);
				set.add(ra + b);
				set.add(ra + rb);
				set.add(b + a);
				set.add(b + ra);
				set.add(rb + a);
				set.add(rb + ra);
			}
			// dump(set);
			out.println(set.size());
		}
	}

	public static void main(String[] args) {
		debug = args.length > 0;
		long start = System.nanoTime();

		solve();
		out.flush();

		long end = System.nanoTime();
		dump((end - start) / 1000000 + " ms");
		in.close();
		out.close();
	}

	static void dump(Object... o) { if (debug) System.err.println(Arrays.deepToString(o)); }
}