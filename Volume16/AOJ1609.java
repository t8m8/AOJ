import java.util.*;
import java.io.*;
import java.awt.geom.*;
import java.math.*;

public class AOJ1609 {

	static final Scanner in = new Scanner(System.in);
	static final PrintWriter out = new PrintWriter(System.out,false);
	static boolean debug = false;

	static boolean solve() {
		int n = in.nextInt();
		if (n == 0) return false;

		int[] cnt = new int[26];
		boolean f = false;
		for (int i=0; i<n; i++) {
			int p = in.next().charAt(0) - 'A';
			cnt[p]++;
			int[] tmp = Arrays.copyOfRange(cnt, 0, 26);
			Arrays.sort(tmp);
			if (!f && tmp[24] + n-i-1 < tmp[25]) {
				int idx = -1;
				for (int j=0; j<26; j++) {
					if (tmp[25] == cnt[j]) idx = j;
				}
				out.println((char)(idx+'A')+" "+(i+1));
				f = true;
			}
		}

		if (!f) out.println("TIE");

		return true;
	}

	public static void main(String[] args) {
		debug = args.length > 0;
		long start = System.nanoTime();

		while(solve());
		out.flush();

		long end = System.nanoTime();
		dump((end - start) / 1000000 + " ms");
		in.close();
		out.close();
	}

	static void dump(Object... o) { if (debug) System.err.println(Arrays.deepToString(o)); }
}