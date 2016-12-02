import java.util.*;
import java.io.*;
import java.awt.geom.*;
import java.math.*;

public class AOJ2242 {

	static final Scanner in = new Scanner(System.in);
	static final PrintWriter out = new PrintWriter(System.out,false);
	static boolean debug = false;

	static boolean solve() {
		int n = in.nextInt();
		int q = in.nextInt();
		if (n + q == 0) return false;

		String[] names = new String[n];
		ArrayList<int[]> list = new ArrayList<>();

		for (int i=0; i<n; i++) {
			names[i] = in.next();
			int eb = in.nextInt();
			int y = in.nextInt();
			list.add(new int[]{i, eb, y});
		}

		Collections.sort(list, new Comparator<int[]>(){
			public int compare(int[] a, int[] b) {
				return (a[2] - a[1]) - (b[2] - b[1]);
			}
		});

		for (int i=0; i<n; i++) {
			dump(list.get(i));
		}

		while (q-- > 0) {
			int y = in.nextInt();
			if (y <= list.get(0)[2] - list.get(0)[1]) {
				out.println("Unknown");
			} else {
				int pos = 1;
				while (pos < n && list.get(pos)[2] - list.get(pos)[1] < y) pos++;
				pos--;
				int x = y - (list.get(pos)[2] - list.get(pos)[1]);
				if (list.get(pos)[1] < x) {
					out.println("Unknown");
				} else {
					out.println(names[list.get(pos)[0]] + " " +x);
				}
			}
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