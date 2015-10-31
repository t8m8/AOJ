import java.util.*;
import java.io.*;
import java.awt.geom.*;
import java.math.*;

public class AOJ0053 {

	static final Scanner in = new Scanner(System.in);
	static final PrintWriter out = new PrintWriter(System.out,false);

	static ArrayList<Integer> ps;

	static boolean solve() {
		int n = in.nextInt();
		if (n == 0) return false;

		long ans = 0;
		for (int i=0; i<n; i++) {
			ans += ps.get(i);
		}
		out.println(ans);

		return true;
	}

	static ArrayList<Integer> createPrimeList(int n) {
		if (n < 2) return null;
		ArrayList<Integer> res = new ArrayList<Integer>();
		BitSet isPrimeBit = createIsPrimeBit(n);
		int p = 1;
		while ((p = isPrimeBit.nextSetBit(p+1)) >= 0) {
			res.add(p);
		}
		return res;
	}

	static BitSet createIsPrimeBit(int n) {
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

		ps = createPrimeList(10000000);

		while(solve());
		out.flush();

		long end = System.currentTimeMillis();
		//trace(end-start + "ms");
		in.close();
		out.close();
	}

	static void trace(Object... o) { System.out.println(Arrays.deepToString(o));}
}