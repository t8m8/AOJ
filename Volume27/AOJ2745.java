import java.util.*;
import java.io.*;
import java.awt.geom.*;
import java.math.*;

public class AOJ2745 {

	static final Scanner in = new Scanner(System.in);
	static final PrintWriter out = new PrintWriter(System.out,false);
	static boolean debug = false;

	static boolean solve() {
		int ri = in.nextInt();
		int wi = in.nextInt();
		int c = in.nextInt();
		int r = in.nextInt();
		if (ri + wi + c + r == 0) return false;

		int l = -1, u = 1<<30;
		while (u - l > 1) {
			int m = (l + u)/2;
			if (ri + (long)m*r >= (long)wi*c) u = m;
			else l = m;
		}

		out.println(u);

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