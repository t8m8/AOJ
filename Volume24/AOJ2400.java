import java.util.*;
import java.io.*;
import java.awt.geom.*;
import java.math.*;

public class AOJ2400 {

	static final Scanner in = new Scanner(System.in);
	static final PrintWriter out = new PrintWriter(System.out,false);
	static boolean debug = false;

	static boolean solve() {
		int t = in.nextInt();
		int p = in.nextInt();
		int r = in.nextInt();
		if (t + p + r == 0) return false;

		int[][] a = new int[t][3];
		for (int i=0; i<t; i++) {
			a[i][2] = i+1;
		}
		int[][] wrong = new int[t][p];

		for (int i=0; i<r; i++) {
			int tid = in.nextInt() - 1;
			int pid = in.nextInt() - 1;
			int time = in.nextInt();
			String s = in.next();
			if (wrong[tid][pid] == -1) continue;
			if ("CORRECT".equals(s)) {
				a[tid][0]++;
				a[tid][1] += time + 1200*wrong[tid][pid];
				wrong[tid][pid] = -1;
			} else {
				wrong[tid][pid]++;
			}
		}

		Arrays.sort(a, new Comparator<int[]>(){
			public int compare(int[] a, int[] b) {
				if (a[0] != b[0]) return b[0] - a[0];
				if (a[1] != b[1]) return a[1] - b[1];
				return a[2] - b[2];
			}
		});

		for (int i=0; i<t; i++) {
			out.println(a[i][2]+" "+a[i][0]+" "+a[i][1]);
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