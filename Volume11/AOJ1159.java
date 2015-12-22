import java.util.*;
import java.io.*;
import java.awt.geom.*;
import java.math.*;

public class AOJ1159 {

	static final Scanner in = new Scanner(System.in);
	static final PrintWriter out = new PrintWriter(System.out,false);

	static boolean solve() {
		int n = in.nextInt();
		int p = in.nextInt();
		if (n + p == 0) return false;


		int[] cnt = new int[n];
		int cur = 0, q = p;
		while (true) {

			if (p > 0) {
				p--;
				cnt[cur]++;
				if (cnt[cur] == q) {
					out.println(cur);
					break;
				}
			} else {
				p += cnt[cur];
				cnt[cur] = 0;
			}

			cur = (cur + 1)%n;
		}

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