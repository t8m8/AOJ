import java.util.*;
import java.io.*;
import java.awt.geom.*;
import java.math.*;

public class AOJ0096 {

	static final Scanner in = new Scanner(System.in);
	static final PrintWriter out = new PrintWriter(System.out,false);

	static void solve() {

		int n = in.nextInt();

		int[] cnt = new int[2001];
		for (int i=0; i<=1000; i++) {
			for (int j=0; j<=1000; j++) {
				cnt[i+j]++;
			}
		}

		int ans = 0;

		for (int i=0; i<=2000; i++) {
			for (int j=0; j<=2000; j++) {
				if (i + j == n) {
					ans += cnt[i] * cnt[j];
				}
			}
		}

		out.println(ans);
	}

	public static void main(String[] args) {
		long start = System.currentTimeMillis();

		while(in.hasNext()) solve();
		out.flush();

		long end = System.currentTimeMillis();
		//trace(end-start + "ms");
		in.close();
		out.close();
	}

	static void trace(Object... o) { System.out.println(Arrays.deepToString(o));}
}