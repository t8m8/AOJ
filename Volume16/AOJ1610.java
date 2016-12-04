import java.util.*;
import java.io.*;
import java.awt.geom.*;
import java.math.*;

public class AOJ1610 {

	static final Scanner in = new Scanner(System.in);
	static final PrintWriter out = new PrintWriter(System.out,false);
	static boolean debug = false;

	static boolean solve() {
		int m = in.nextInt();
		int n = in.nextInt();
		if (m + n == 0) return false;

		int N = 10000000;
		boolean[] f = new boolean[N];
		int cnt = 0;
		Arrays.fill(f, true);
		for (int i=m; i<N; i++) {
			if (!f[i]) continue;
			cnt++;
			if (cnt > n) {
				out.println(i);
				return true;
			}
			for (int j=i+i; j<N; j+=i) {
				f[j] = false;
			}
		}

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