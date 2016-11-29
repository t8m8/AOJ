import java.util.*;
import java.io.*;
import java.awt.geom.*;
import java.math.*;

public class AOJ2508 {

	static final Scanner in = new Scanner(System.in);
	static final PrintWriter out = new PrintWriter(System.out,false);
	static boolean debug = false;

	static boolean solve() {
		int n = in.nextInt();
		if (n == 0) return false;

		int[] k = new int[n];
		for (int i=0; i<n; i++) {
			k[i] = in.nextInt();
		}
		String s = in.next();
		int pos = 0;
		for (int i=0; i<s.length(); i++, pos = (pos+1)%n) {
			int c = 'a' <= s.charAt(i) && s.charAt(i) <= 'z' ? s.charAt(i) - 'a' : (s.charAt(i) - 'A' + 26);
			c = (c + 52 - k[pos])%52;
			out.print(c < 26 ? (char)(c + 'a') : (char)(c + 'A' - 26));
		}
		out.println();


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