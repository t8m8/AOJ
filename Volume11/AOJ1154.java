import java.util.*;
import java.io.*;
import java.awt.geom.*;
import java.math.*;

public class AOJ1154 {

	static final Scanner in = new Scanner(System.in);
	static final PrintWriter out = new PrintWriter(System.out,false);
	static boolean debug = false;

	static ArrayList<Integer> ps = new ArrayList<>();
	static final int M = 300001;
	static HashSet<Integer> ans;

	static void init() {
		ArrayList<Integer> list = new ArrayList<>();
		for (int i=6; i<=M; i++) {
			if (i%7 == 1 || i%7 == 6) list.add(i);
		}

		boolean[] f = new boolean[M+1];
		for (int i=0; i<list.size(); i++) {
			f[list.get(i)] = true;
		}

		for (int i=6; i<=M; i++) {
			if (!f[i]) continue;
			ps.add(i);
			for (int j=i+i; j<M; j+=i) {
				f[j] = false;
			}
		}

		// dump(ps);
	}

	static boolean rec(int n) {
		if (n == 1) return true;
		boolean f = false;
		for (int i=0; i<ps.size(); i++) {
			if (n%ps.get(i) == 0) {
				if (rec(n/ps.get(i))) {
					ans.add(ps.get(i));
					f = true;
				}
			}
		}
		return f;
	}

	static boolean solve() {
		int n = in.nextInt();
		if (n == 1) return false;

		// dump(ps);

		ans = new HashSet<Integer>();
		rec(n);
		ArrayList<Integer> list = new ArrayList<>(ans);
		Collections.sort(list);
		out.print(n+":");
		for (int i=0; i<list.size(); i++) {
			out.print(" "+list.get(i));
		}
		out.println();
		// dump(ans);

		return true;
	}

	public static void main(String[] args) {
		debug = args.length > 0;
		long start = System.nanoTime();

		init();
		while(solve());
		out.flush();

		long end = System.nanoTime();
		dump((end - start) / 1000000 + " ms");
		in.close();
		out.close();
	}

	static void dump(Object... o) { if (debug) System.err.println(Arrays.deepToString(o)); }
}