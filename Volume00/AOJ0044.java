import java.util.*;
import java.io.*;
import java.awt.geom.*;
import java.math.*;

public class AOJ0044 {

	static final Scanner in = new Scanner(System.in);
	static final PrintWriter out = new PrintWriter(System.out,false);

	static void solve() {

		BitSet ps = createIsPrimeBit(50100);

		while (in.hasNext()) {
			int n = in.nextInt();
			int m = n + 1;
			n--;
			while (n > 1 && !ps.get(n)) n--;
			while (!ps.get(m)) m++;
			out.println(n + " " + m);
		}
	}

	public static BitSet createIsPrimeBit(int n) {
		if (n < 2) return null;
		BitSet res = new BitSet();
		res.set(2,n,true);
		for (int i=2; i*i<n; i=res.nextSetBit(i+1)) {
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