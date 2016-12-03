import java.util.*;
import java.io.*;
import java.awt.geom.*;
import java.math.*;

public class AOJ1232 {

	static final Scanner in = new Scanner(System.in);
	static final PrintWriter out = new PrintWriter(System.out,false);
	static boolean debug = false;

	static boolean[] isp;
	static ArrayList<Integer> ps;
	static ArrayList<int[]> ms;

	static boolean[] eratosthenes(int m) {
		int n = m + 1;
		boolean[] isp = new boolean[n];
		if (n < 2) return isp;

		Arrays.fill(isp, true);

		for (int i=2; i*i<n; i++) {
			if (!isp[i]) continue;
			for (int j=i+i; j<n; j+=i) {
				isp[j] = false;
			}
		}

		return isp;
	}

	static void init() {
		isp = eratosthenes(10000);
		ps = new ArrayList<>();
		ms = new ArrayList<>();

		for (int i=0; i<10000; i++) {
			if (isp[i]) ps.add(i);
		}
		int size = ps.size();
		for (int i=0; i<size; i++) {
			for (int j=i; j<size; j++) {
				int a = ps.get(i);
				int b = ps.get(j);
				ms.add(new int[]{a*b, a, b});
			}
		}
		Collections.sort(ms, new Comparator<int[]>(){
			public int compare(int[] a, int[] b) {
				return a[0] - b[0];
			}
		});
	}

	static boolean solve() {
		int m = in.nextInt();
		int a = in.nextInt();
		int b = in.nextInt();
		if (m + a + b == 0) return false;

		int n = ms.size();
		int pos = 0;
		while (pos < n && ms.get(pos)[0] <= m) pos++;

		for (int i=pos-1; i>=0; i--) {
			int[] t = ms.get(i);
			if (t[2]*a <= t[1]*b) {
				out.println(t[1]+" "+t[2]);
				return true;
			}
		}

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