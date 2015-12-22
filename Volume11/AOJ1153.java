import java.util.*;
import java.io.*;
import java.awt.geom.*;
import java.math.*;

public class AOJ1153 {

	static final Scanner in = new Scanner(System.in);
	static final PrintWriter out = new PrintWriter(System.out,false);

	static boolean solve() {
		int n = in.nextInt();
		int m = in.nextInt();
		if (n + m == 0) return false;

		int[] s = new int[n];
		int ssum = 0;
		for (int i=0; i<n; i++) {
			s[i] = in.nextInt();
			ssum += s[i];
		}

		int[] t = new int[m];
		int tsum = 0;
		for (int i=0; i<m; i++) {
			t[i] = in.nextInt();
			tsum += t[i];
		}

		int max = Integer.MAX_VALUE;
		int sans = -1, tans = -1;

		for (int i=0; i<n; i++) {
			for (int j=0; j<m; j++) {
				if (ssum - s[i] + t[j] == tsum - t[j] + s[i]) {
					if (max > s[i] + t[j]) {
						max = s[i] + t[j];
						sans = s[i];
						tans = t[j];
					}
				}
			}
		}

		out.println(max != Integer.MAX_VALUE ? sans+" "+tans : -1);

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