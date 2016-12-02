import java.util.*;
import java.io.*;
import java.awt.geom.*;
import java.math.*;

public class AOJ1275 {

	static final Scanner in = new Scanner(System.in);
	static final PrintWriter out = new PrintWriter(System.out,false);
	static boolean debug = false;

	static boolean solve() {
		int n = in.nextInt();
		int k = in.nextInt();
		int m = in.nextInt();
		if (n + k + m == 0) return false;

		ArrayList<Integer> list = new ArrayList<>();
		for (int i=0; i<n; i++) {
			list.add(i+1);
		}

		int pos = m - 1;
		k = k - 1;
		while (list.size() > 1) {
			list.remove(pos);
			pos = (pos + k) % list.size();
		}

		out.println(list.get(0));

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