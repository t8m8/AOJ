import java.util.*;
import java.io.*;
import java.awt.geom.*;
import java.math.*;

public class AOJ1148 {

	static final Scanner in = new Scanner(System.in);
	static final PrintWriter out = new PrintWriter(System.out,false);
	static boolean debug = false;

	static boolean solve() {
		int n = in.nextInt();
		int m = in.nextInt();
		if (n + m == 0) return false;

		boolean[][] time = new boolean[m][2000];

		HashMap<Integer,Integer> map = new HashMap<>();

		int r = in.nextInt();
		for (int i=0; i<r; i++) {
			int t = in.nextInt();
			int p = in.nextInt() - 1;
			int x = in.nextInt() - 1;
			int s = in.nextInt();
			if (s == 1) {
				map.put(x*n+p, t);
			} else {
				int from = map.get(x*n+p);
				for (int j=from; j<t; j++) {
					time[x][j] = true;
				}
			}
		}

		int q = in.nextInt();
		while (q-- > 0) {
			int s = in.nextInt();
			int e = in.nextInt();
			int x = in.nextInt() - 1;
			int ans = 0;
			for (int i=s; i<e; i++) {
				if (time[x][i]) ans++;
			}
			out.println(ans);
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