import java.util.*;
import java.io.*;
import java.awt.geom.*;
import java.math.*;

public class AOJ1172 {

	static final Scanner in = new Scanner(System.in);
	static final PrintWriter out = new PrintWriter(System.out,false);
	static boolean debug = false;

	static boolean solve(boolean[] isp) {
		int n = in.nextInt();
		if (n == 0) return false;

		int cnt = 0;

		for (int i=n+1; i<=2*n; i++) {
			if (isp[i]) cnt++;
		}

		out.println(cnt);

		return true;
	}

	public static void main(String[] args) {
		debug = args.length > 0;
		long start = System.nanoTime();

		int MAX = 300000;
		boolean[] isp = new boolean[MAX];
		Arrays.fill(isp, true);
		isp[0] = isp[1] = false;
		for (int i=2; i<MAX; i++) {
			if (!isp[i]) continue;
			for (int j=i+i; j<MAX; j+=i) {
				isp[j] = false;
			}
		}

		while(solve(isp));
		out.flush();

		long end = System.nanoTime();
		dump((end - start) / 1000000 + " ms");
		in.close();
		out.close();
	}

	static void dump(Object... o) { if (debug) System.err.println(Arrays.deepToString(o)); }
}