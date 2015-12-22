import java.util.*;
import java.io.*;
import java.awt.geom.*;
import java.math.*;

public class AOJ1124 {

	static final Scanner in = new Scanner(System.in);
	static final PrintWriter out = new PrintWriter(System.out,false);

	static boolean solve() {
		int n = in.nextInt();
		int q = in.nextInt();
		if (n + q == 0) return false;

		int[] cnt = new int[101];

		for (int i=0; i<n; i++) {
			int m = in.nextInt();
			for (int j=0; j<m; j++) {
				cnt[in.nextInt()]++;
			}
		}

		int max = q-1;
		int ans = 0;

		for (int i=1; i<101; i++) {
			if (max < cnt[i]) {
				max = cnt[i];
				ans = i;
			}
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