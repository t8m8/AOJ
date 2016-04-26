import java.util.*;
import java.io.*;
import java.awt.geom.*;
import java.math.*;

public class AOJ0500 {

	static final Scanner in = new Scanner(System.in);
	static final PrintWriter out = new PrintWriter(System.out,false);
	static boolean debug = false;

	static boolean solve() {
		int n = in.nextInt();
		if (n == 0) return false;
		int sa = 0, sb = 0;
		for (int i=0; i<n; i++) {
			int a = in.nextInt();
			int b = in.nextInt();
			if (a == b) {
				sa += a;
				sb += b;
			} else if (a > b) {
				sa += a + b;
			} else {
				sb += a + b;
			}
		}
		out.println(sa+" "+sb);
		return true;
	}

	public static void main(String[] args) {
		debug = args.length > 0;
		long start = System.currentTimeMillis();

		while(solve());
		out.flush();

		long end = System.currentTimeMillis();
		dump((end-start) + "ms");
		in.close();
		out.close();
	}

	static void dump(Object... o) { if (debug) System.err.println(Arrays.deepToString(o)); }
}