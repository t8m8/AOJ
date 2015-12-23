import java.util.*;
import java.io.*;
import java.awt.geom.*;
import java.math.*;

public class AOJ2015 {

	static final Scanner in = new Scanner(System.in);
	static final PrintWriter out = new PrintWriter(System.out,false);

	static int[] cnth = new int[1500001];
	static int[] cntw = new int[1500001];

	static boolean solve() {
		int n = in.nextInt();
		int m = in.nextInt();
		if (n + m == 0) return false;

		int[] h = new int[n+1];
		for (int i=1; i<=n; i++) {
			h[i] = in.nextInt();
			h[i] += h[i-1];
		}

		int[] w = new int[m+1];
		for (int i=1; i<=m; i++) {
			w[i] = in.nextInt();
			w[i] += w[i-1];
		}

		Arrays.fill(cnth,0);

		for (int i=1; i<=n; i++) {
			for (int j=1; j<=n; j++) {
				if (i-j < 0) continue;
				cnth[h[i] - h[i-j]]++;
			}
		}

		Arrays.fill(cntw,0);

		for (int i=1; i<=m; i++) {
			for (int j=1; j<=m; j++) {
				if (i-j < 0) continue;
				cntw[w[i] - w[i-j]]++;
			}
		}

		int ans = 0;
		for (int i=0; i<1500001; i++) {
			ans += cnth[i] * cntw[i];
		}

		out.println(ans);

		return true;
	}

	public static void main(String[] args) {
		long start = System.currentTimeMillis();

		while(solve());
		out.flush();

		long end = System.currentTimeMillis();
		//trace(end-start + "ms");
		in.close();
		out.close();
	}

	static void trace(Object... o) { System.out.println(Arrays.deepToString(o));}
}