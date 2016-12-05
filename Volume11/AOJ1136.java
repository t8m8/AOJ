import java.util.*;
import java.io.*;
import java.awt.geom.*;
import java.math.*;

public class AOJ1136 {

	static final Scanner in = new Scanner(System.in);
	static final PrintWriter out = new PrintWriter(System.out,false);
	static boolean debug = false;

	static boolean f(ArrayList<int[]> p, ArrayList<int[]> q) {
		if (p.size() != q.size()) return false;
		int n = p.size();
		int dx = p.get(0)[0], dy = p.get(0)[1];
		for (int i=0; i<n; i++) {
			p.get(i)[0] -= dx;
			p.get(i)[1] -= dy;
		}
		dx = q.get(0)[0]; dy = q.get(0)[1];

		for (int i=0; i<n; i++) {
			q.get(i)[0] -= dx;
			q.get(i)[1] -= dy;
		}

		for (int k=0; k<4; k++) {
			boolean res = true;
			for (int i=0; i<n; i++) {
				if (p.get(i)[0] != q.get(i)[0] || p.get(i)[1] != q.get(i)[1]) {
					res = false;
				}
			}

			if (res) return true;
			res = true;

			for (int i=0; i<n; i++) {
				int x = q.get(i)[0];
				int y = q.get(i)[1];
				q.get(i)[0] = -y;
				q.get(i)[1] = x;
			}
		}

		return false;
	}

	static boolean solve() {
		int n = in.nextInt();
		if (n == 0) return false;
		n = n + 1;

		ArrayList<ArrayList<int[]>> p = new ArrayList<>();
		for (int i=0; i<n; i++) {
			p.add(new ArrayList<int[]>());
		}

		for (int i=0; i<n; i++) {
			int m = in.nextInt();
			for (int j=0; j<m; j++) {
				p.get(i).add(new int[]{in.nextInt(), in.nextInt()});
			}
		}

		for (int i=1; i<n; i++) {
			ArrayList<int[]> q = new ArrayList<>();
			for (int j=p.get(i).size()-1; j>=0; j--) {
				q.add(p.get(i).get(j));
			}

			if (f(p.get(0), p.get(i))) {
				out.println(i);
			} else if (f(p.get(0), q)) {
				out.println(i);
			}
		}
		out.println("+++++");

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