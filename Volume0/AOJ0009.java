import java.util.*;
import java.io.*;
import java.awt.geom.*;
import java.math.*;

public class AOJ0009 {

	static final Scanner in = new Scanner(System.in);
	static final PrintWriter out = new PrintWriter(System.out,false);

	static void solve() {
		BitSet isPrime = createIsPrimeBit(0,1000000);
		int[] cnt = new int[1000000];
		for (int i=2; i<1000000; i++) {
			if (isPrime.get(i)) cnt[i] = cnt[i-1] + 1;
			else cnt[i] = cnt[i-1];
		}
		while (in.hasNext()) {
			int n = in.nextInt();
			out.println(cnt[n]);
			out.flush();
		}
	}

	public static BitSet createIsPrimeBit(int offset, int n) {
		if (n < 2) return null;
		BitSet res = new BitSet();
		res.set(2,n,true);
		for (int i=2; i*i<n; i=res.nextSetBit(i+1)) {
			if (i < offset) res.set(i,false);
			for (int j=i+i; j<n; j+=i) res.set(j,false);
		}
		return res;
	}

	public static void main(String[] args) {
		long start = System.currentTimeMillis();

		solve();
		out.flush();

		long end = System.currentTimeMillis();
		//trace(end-start + "ms");
		in.close();
		out.close();
	}

	static void trace(Object... o) { System.out.println(Arrays.deepToString(o));}
}