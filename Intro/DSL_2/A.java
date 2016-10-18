import java.util.*;
import java.io.*;
import java.awt.geom.*;
import java.math.*;

public class A {

	static final Scanner in = new Scanner(System.in);
	static final PrintWriter out = new PrintWriter(System.out,false);
	static boolean debug = false;

	static void solve() {
		int n = in.nextInt();
		int q = in.nextInt();
		STRMQ rmq = new STRMQ(n);
		while (q-- > 0) {
			int com = in.nextInt();
			if (com == 0) {
				rmq.set(in.nextInt(), in.nextInt());
			} else {
				out.println(rmq.min(in.nextInt(), in.nextInt()+1));
			}
		}
	}

	public static void main(String[] args) {
		debug = args.length > 0;
		long start = System.currentTimeMillis();

		solve();
		out.flush();

		long end = System.currentTimeMillis();
		dump((end-start) + "ms");
		in.close();
		out.close();
	}

	static void dump(Object... o) { if (debug) System.err.println(Arrays.deepToString(o)); }
}

class STRMQ {

	public static final long INF = (1<<31)-1;
	public final int length;
	private final int reviceLen;
	private final int internalLen;
	private long[] data;

	public STRMQ(int n) {
		this.length = n;
		this.reviceLen = Integer.highestOneBit(Math.max(length-1,1))<<1;
		this.internalLen = 2*reviceLen - 1;
		this.data = new long[internalLen];
		for (int i=0; i<internalLen; i++) data[i] = INF;
	}

	public void set(int idx, int val) {
		idx += reviceLen-1;
		data[idx] = val;
		while (idx > 0) {
			idx = (idx - 1) / 2;
			data[idx] = Math.min(data[idx*2+1], data[idx*2+2]);
		}
	}

	public long get(int idx) {
		return data[idx + reviceLen - 1];
	}

	// [begin, end)
	public long min(int begin, int end) {
		return min(begin, end, 0, 0, reviceLen);
	}

	private long min(int begin, int end, int idx, int l, int r) {
		if (r <= begin || end <= l) return INF;
		if (begin <= l && r <= end) return data[idx];

		long vl = min(begin, end, idx*2+1, l, (l+r)/2);
		long vr = min(begin, end, idx*2+2, (l+r)/2, r);
		return Math.min(vl, vr);
	}

	public String toString() {
		long[] val = new long[length];
		for (int i=0; i<length; i++) val[i] = data[i + reviceLen - 1];
		return Arrays.toString(val);
	}
}