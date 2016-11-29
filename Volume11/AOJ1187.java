import java.util.*;
import java.io.*;
import java.awt.geom.*;
import java.math.*;

public class AOJ1187 {

	static final Scanner in = new Scanner(System.in);
	static final PrintWriter out = new PrintWriter(System.out,false);
	static boolean debug = false;

	static boolean solve() {
		int M = in.nextInt();
		int T = in.nextInt();
		int P = in.nextInt();
		int r = in.nextInt();
		if (M + T + P + r == 0) return false;

		int[][] a = new int[T][3];
		for (int i=0; i<T; i++) {
			a[i][0] = i+1;
		}

		int[][] wrong = new int[T][P];

		for (int i=0; i<r; i++) {
			int m = in.nextInt();
			int t = in.nextInt() - 1;
			int p = in.nextInt() - 1;
			int j = in.nextInt();
			if (j == 0) {
				a[t][1]++;
				a[t][2] += m + 20*wrong[t][p];
			} else {
				wrong[t][p]++;
			}
		}

		Arrays.sort(a, new Comparator<int[]>(){
			public int compare(int[] a, int[] b) {
				if (a[1] != b[1]) return b[1] - a[1];
				if (a[2] != b[2]) return a[2] - b[2];
				return b[0] - a[0];
			}
		});

		boolean f = true;
		ArrayList<Integer> ans = new ArrayList<>();
		for (int i=0; i<T; ) {
			ans.add(a[i][0]);
			i++;
			while (i < T && a[i][1] == a[i-1][1] && a[i][2] == a[i-1][2]) {
				ans.add(a[i][0]);
				i++;
			}
			if (!f) {
				out.print(",");
			} else {
				f = false;
			}
			for (int j=0; j<ans.size(); j++) {
				if (j != 0) out.print("=");
				out.print(ans.get(j));
			}
			ans.clear();
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