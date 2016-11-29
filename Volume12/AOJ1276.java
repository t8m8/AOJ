import java.util.*;
import java.io.*;
import java.awt.geom.*;
import java.math.*;

public class AOJ1276 {

	static final Scanner in = new Scanner(System.in);
	static final PrintWriter out = new PrintWriter(System.out,false);
	static boolean debug = false;

	static BitSet ps;

	static BitSet eratosthenes(int m) {
		int n = m + 1;
		BitSet isp = new BitSet();
		if (n < 2) return isp;

		isp.set(2, n, true);

		for (int i=2; i*i<n; i=isp.nextSetBit(i+1)) {
			for (int j=i+i; j<n; j+=i) {
				isp.set(j,false);
			}
		}

		return isp;
	}


	static boolean solve() {
		int n = in.nextInt();
		if (n == 0) return false;

		if (ps.get(n)) {
			out.println("0");
		} else {
			int l = n, r = n;
			while (!ps.get(--l));
			while (!ps.get(++r));
			out.println((r-l));
		}

		return true;
	}

	public static void main(String[] args) {
		debug = args.length > 0;
		long start = System.nanoTime();

		ps = eratosthenes(1300000);

		while(solve());
		out.flush();

		long end = System.nanoTime();
		dump((end - start) / 1000000 + " ms");
		in.close();
		out.close();
	}

	static void dump(Object... o) { if (debug) System.err.println(Arrays.deepToString(o)); }
}