import java.util.*;
import java.io.*;
import java.awt.geom.*;
import java.math.*;

public class AOJ0086 {

	static final Scanner in = new Scanner(System.in);
	static final PrintWriter out = new PrintWriter(System.out,false);

	static String solve() {
		int[] cnt = new int[101];
		while (true) {
			int a = in.nextInt();
			int b = in.nextInt();
			if (a + b == 0) break;
			cnt[a]++;
			cnt[b]++;
		}

		for (int i=3; i<101; i++) {
			if (cnt[i]%2 != 0) {
				return "NG";
			}
		}

		return cnt[1]%2 == 1 && cnt[2]%2 == 1 ? "OK" : "NG";
	}

	public static void main(String[] args) {
		long start = System.currentTimeMillis();

		while(in.hasNext()) out.println(solve());
		out.flush();

		long end = System.currentTimeMillis();
		//trace(end-start + "ms");
		in.close();
		out.close();
	}

	static void trace(Object... o) { System.out.println(Arrays.deepToString(o));}
}