import java.util.*;
import java.io.*;
import java.awt.geom.*;
import java.math.*;

public class AOJ1241 {

	static final Scanner in = new Scanner(System.in);
	static final PrintWriter out = new PrintWriter(System.out,false);
	static boolean debug = false;


	static int rec(int n, int t, int l) {
		if (n == 0) return 1;
		if (t == 0) return 0;
		int res = 0;
		for (int i=l; i*i<=n; i++) {
			res += rec(n-i*i, t-1, i);
		}
		return res;
	}

	static boolean solve() {
		int n = in.nextInt();
		if (n == 0) return false;

		out.println(rec(n, 4, 1));

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