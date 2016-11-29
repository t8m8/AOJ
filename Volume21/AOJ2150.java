import java.util.*;
import java.io.*;
import java.awt.geom.*;
import java.math.*;

public class AOJ2150 {

	static final Scanner in = new Scanner(System.in);
	static final PrintWriter out = new PrintWriter(System.out,false);
	static boolean debug = false;

	static BitSet primes;

	static BitSet eratosthenes(int m) {
		int n = m + 1;
		BitSet isp = new BitSet();
		if (n < 2) return isp;

		isp.set(2, n, true);

		for (int i=2; i*i<n; i=isp.nextSetBit(i+1)) {
			for (int j=i+i; j<n; j+=i) {
				isp.set(j,false);
			}
		}

		return isp;
	}

	static void init() {
		primes = eratosthenes(1000000);
		// dump(primes);
	}

	static boolean solve() {
		int n = in.nextInt();
		int p = in.nextInt();
		if (n + p == -2) return false;

		int[] ps = new int[50];
		int pos = n;
		for (int i=0; i<50; i++) {
			while(!primes.get(++pos));
			ps[i] = pos;
		}

		PriorityQueue<Integer> pQ = new PriorityQueue<>();

		for (int i=0; i<50; i++) {
			for (int j=i; j<50; j++) {
				pQ.add(ps[i]+ps[j]);
			}
		}

		for (int i=0; i<p-1; i++) {
			pQ.poll();
		}

		// dump(pQ);

		out.println(pQ.poll());

		return true;
	}

	public static void main(String[] args) {
		debug = args.length > 0;
		long start = System.nanoTime();

		init();
		while(solve());
		out.flush();

		long end = System.nanoTime();
		dump((end - start) / 1000000 + " ms");
		in.close();
		out.close();
	}

	static void dump(Object... o) { if (debug) System.err.println(Arrays.deepToString(o)); }
}