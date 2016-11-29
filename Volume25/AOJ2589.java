import java.util.*;
import java.io.*;
import java.awt.geom.*;
import java.math.*;

public class AOJ2589 {

	static final Scanner in = new Scanner(System.in);
	static final PrintWriter out = new PrintWriter(System.out,false);
	static boolean debug = false;

	static boolean solve() {
		String s = in.next();
		if ("#".equals(s)) return false;

		int pos = s.length(), cnt = 0;
		double d = -1;
		while (pos >= 0) {
			while (s.charAt(--pos) != 'w' && s.charAt(pos) != 'n');
			if (s.charAt(pos) == 'n') {
				if (cnt == 0) d = 0;
				else d -= 90.0 / (1<<cnt);
			} else {
				if (cnt == 0) d = 90;
				else d += 90.0 / (1<<cnt);
			}
			cnt++;
			pos--;
		}

		int div = 1;
		while ((int)d != d) {
			d *= 2;
			div *= 2;
		}

		int ans = (int)d;

		out.println(ans + (div == 1 ? "" : ("/"+div)));

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