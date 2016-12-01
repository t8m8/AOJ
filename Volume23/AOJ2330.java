import java.util.*;
import java.io.*;
import java.awt.geom.*;
import java.math.*;

public class AOJ2330 {

	static final Scanner in = new Scanner(System.in);
	static final PrintWriter out = new PrintWriter(System.out,false);
	static boolean debug = false;

	static void solve() {
		double n = in.nextInt();
		int cnt = 0;
		while (n > 1) {
			n = (int)Math.ceil(n/3);
			cnt++;
		}
		out.println(cnt);
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