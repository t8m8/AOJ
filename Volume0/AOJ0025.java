import java.util.*;
import java.io.*;
import java.awt.geom.*;
import java.math.*;

public class AOJ0025 {

	static final Scanner in = new Scanner(System.in);
	static final PrintWriter out = new PrintWriter(System.out,false);

	static void solve() {

		int[] a = new int[4];
		int[] b = new int[4];

		for (int i=0; i<4; i++) {
			a[i] = in.nextInt();
		}
		for (int i=0; i<4; i++) {
			b[i] = in.nextInt();
		}

		int[] cnt = new int[10];
		int cnt1 = 0, cnt2 = 0;
		for (int i=0; i<4; i++) {
			if (a[i] == b[i]) {
				cnt1++;
			} else {
				cnt[a[i]]++;
				cnt[b[i]]++;
			}
		}

		for (int i=0; i<10; i++) {
			if (cnt[i] > 1) {
				cnt2++;
			}
		}

		out.println(cnt1 + " " + cnt2);
	}

	public static void main(String[] args) {
		long start = System.currentTimeMillis();

		while (in.hasNext()) solve();
		out.flush();

		long end = System.currentTimeMillis();
		//trace(end-start + "ms");
		in.close();
		out.close();
	}

	static void trace(Object... o) { System.out.println(Arrays.deepToString(o));}
}