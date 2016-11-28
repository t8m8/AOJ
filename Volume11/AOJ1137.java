import java.util.*;
import java.io.*;
import java.awt.geom.*;
import java.math.*;

public class AOJ1137 {

	static final Scanner in = new Scanner(System.in);
	static final PrintWriter out = new PrintWriter(System.out,false);
	static boolean debug = false;

	static void solve() {
		int q = in.nextInt();
		while (q-- > 0) {
			String s = in.next();
			String t = in.next();
			int[] cnt = new int[4];
			int n = s.length();
			for (int i=0; i<n; i++) {
				if (s.charAt(i) == 'm') {
					if (i == 0 || !('2' <= s.charAt(i-1) && s.charAt(i-1) <= '9')) cnt[0]++;
					else cnt[0] += s.charAt(i-1) - '0';
				} else if (s.charAt(i) == 'c') {
					if (i == 0 || !('2' <= s.charAt(i-1) && s.charAt(i-1) <= '9')) cnt[1]++;
					else cnt[1] += s.charAt(i-1) - '0';
				} else if (s.charAt(i) == 'x') {
					if (i == 0 || !('2' <= s.charAt(i-1) && s.charAt(i-1) <= '9')) cnt[2]++;
					else cnt[2] += s.charAt(i-1) - '0';
				} else if (s.charAt(i) == 'i') {
					if (i == 0 || !('2' <= s.charAt(i-1) && s.charAt(i-1) <= '9')) cnt[3]++;
					else cnt[3] += s.charAt(i-1) - '0';
				}
			}

			dump(cnt);

			int m = t.length();
			for (int i=0; i<m; i++) {
				if (t.charAt(i) == 'm') {
					if (i == 0 || !('2' <= t.charAt(i-1) && t.charAt(i-1) <= '9')) cnt[0]++;
					else cnt[0] += t.charAt(i-1) - '0';
				} else if (t.charAt(i) == 'c') {
					if (i == 0 || !('2' <= t.charAt(i-1) && t.charAt(i-1) <= '9')) cnt[1]++;
					else cnt[1] += t.charAt(i-1) - '0';
				} else if (t.charAt(i) == 'x') {
					if (i == 0 || !('2' <= t.charAt(i-1) && t.charAt(i-1) <= '9')) cnt[2]++;
					else cnt[2] += t.charAt(i-1) - '0';
				} else if (t.charAt(i) == 'i') {
					if (i == 0 || !('2' <= t.charAt(i-1) && t.charAt(i-1) <= '9')) cnt[3]++;
					else cnt[3] += t.charAt(i-1) - '0';
				}
			}

			dump(cnt);

			for (int i=3; i>0; i--) {
				while (cnt[i] >= 10) {
					cnt[i-1] += cnt[i]/10;
					cnt[i] = cnt[i]%10;
				}
			}

			dump(cnt);

			StringBuilder ans = new StringBuilder();
			if (cnt[0] != 0) {
				ans.append((cnt[0] == 1 ? "" : cnt[0]) + "m");
			}
			if (cnt[1] != 0) {
				ans.append((cnt[1] == 1 ? "" : cnt[1]) + "c");
			}
			if (cnt[2] != 0) {
				ans.append((cnt[2] == 1 ? "" : cnt[2]) + "x");
			}
			if (cnt[3] != 0) {
				ans.append((cnt[3] == 1 ? "" : cnt[3]) + "i");
			}
			out.println(ans);
		}
	}

	public static void main(String[] args) {
		debug = args.length > 0;
		long start = System.nanoTime();

		solve();
		out.flush();

		long end = System.nanoTime();
		dump((end - start) / 1000000 + " ms");
		in.close();
		out.close();
	}

	static void dump(Object... o) { if (debug) System.err.println(Arrays.deepToString(o)); }
}