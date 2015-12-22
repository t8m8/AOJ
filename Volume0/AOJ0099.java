import java.util.*;
import java.io.*;
import java.awt.geom.*;
import java.math.*;

public class AOJ0099 {

	static final Reader in = new Reader(System.in);
	static final PrintWriter out = new PrintWriter(System.out,false);

	static void solve() {
		int n = in.nextInt();
		int q = in.nextInt();

		SegmentTree rmq = new SegmentTree(n+1);

		for (int i=1; i<=n; i++) {
			rmq.set(i, new Pair(0,i));
		}

		while (q-- > 0) {
			int a = in.nextInt();
			int v = in.nextInt();
			rmq.set(a, new Pair(rmq.get(a).first+v, a));
			Pair p = rmq.get(0,n+1);
			out.println(p.second+" "+p.first);
		}
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


class SegmentTree {

	public final int length;
	public static final int I = Integer.MAX_VALUE/2;
	private final int reviceLen;
	private final int internalLen;
	private Pair[] data;

	public SegmentTree(int n) {
		this.length = n;
		this.reviceLen = Integer.highestOneBit(Math.max(length-1,1))<<1;
		this.internalLen = 2*reviceLen - 1;
		this.data = new Pair[internalLen];
		for (int i=0; i<internalLen; i++) data[i] = new Pair(-I, I);
	}

	public void set(int idx, Pair val) {
		idx += reviceLen-1;
		data[idx] = val;
		while (idx > 0) {
			idx = (idx - 1) >>> 1;
			data[idx] = Pair.eval(data[idx*2+1], data[idx*2+2]);
		}
	}

	public Pair get(int idx) {
		return data[idx + reviceLen - 1];
	}

	public Pair get(int begin, int end) {
		return get(begin, end, 0, 0, reviceLen);
	}

	private Pair get(int begin, int end, int idx, int lb, int ub) {
		if (ub <= begin || end <= lb) return new Pair(-I, I);
		if (begin <= lb && ub <= end) return data[idx];

		Pair vl = get(begin, end, idx*2+1, lb, (lb + ub)/2);
		Pair vr = get(begin, end, idx*2+2, (lb + ub)/2, ub);
		return Pair.eval(vl, vr);
	}

	public String toString() {
		Pair[] val = new Pair[length];
		for (int i=0; i<length; i++) val[i] = data[i + reviceLen - 1];
		return Arrays.toString(val);
	}
}

class Pair implements Comparable {
	int first, second;

	public Pair(int first, int second) {
		this.first = first; this.second = second;
	}

	public boolean equals(Object o) {
		Pair other = (Pair)o;
		return this.first == other.first && this.second == other.second;
	}

	public int compareTo(Object o) {
		Pair other = (Pair)o;
		if (other.first != this.first) return other.first - this.first;
		return this.second - other.second;
	}

	public static Pair eval(Pair a, Pair b) {
		return a.compareTo(b) < 0 ? a : b;
	}

	public String toString() {
		return "("+first+","+second+")";
	}
}

class Reader {
	private final InputStream in;
	private final byte[] buf = new byte[1024];
	private int ptr = 0;
	private int buflen = 0;

	public Reader() { this(System.in);}
	public Reader(InputStream source) { this.in = source;}

	private boolean hasNextByte() {
		if (ptr < buflen) return true;
		ptr = 0;
		try{
			buflen = in.read(buf);
		}catch (IOException e) {e.printStackTrace();}
		if (buflen <= 0) return false;
		return true;
	}

	private int readByte() { if (hasNextByte()) return buf[ptr++]; else return -1;}

	private boolean isPrintableChar(int c) { return 33 <= c && c <= 126;}

	private void skip() { while(hasNextByte() && !isPrintableChar(buf[ptr])) ptr++;}

	public boolean hasNext() {skip(); return hasNextByte();}

	public String next() {
		if (!hasNext()) throw new NoSuchElementException();
		StringBuilder sb = new StringBuilder();
		int b = readByte();
		while (isPrintableChar(b)) {
			sb.appendCodePoint(b);
			b = readByte();
		}
		return sb.toString();
	}

	public long nextLong() {
		if (!hasNext()) throw new NoSuchElementException();
		boolean minus = false;
		long num = readByte();

		if(num == '-'){
			num = 0;
			minus = true;
		}else if (num < '0' || '9' < num){
			throw new NumberFormatException();
		}else{
			num -= '0';
		}

		while(true){
			int b = readByte();
			if('0' <= b && b <= '9')
				num = num * 10 + (b - '0');
			else if(b == -1 || !isPrintableChar(b))
				return minus ? -num : num;
			else
				throw new NoSuchElementException();
		}
	}

	public int nextInt() {
		long num = nextLong();
		if (num < Integer.MIN_VALUE || Integer.MAX_VALUE < num)
			throw new NumberFormatException();
		return (int)num;
	}

	public double nextDouble() {
		return Double.parseDouble(next());
	}

	public char nextChar() {
		if (!hasNext()) throw new NoSuchElementException();
		return (char)readByte();
	}

	public String nextLine() {
		while (hasNextByte() && (buf[ptr] == '\n' || buf[ptr] == '\r')) ptr++;
		if (!hasNextByte()) throw new NoSuchElementException();

		StringBuilder sb = new StringBuilder();
		int b = readByte();
		while (b != '\n' && b != '\r') {
			sb.appendCodePoint(b);
			b = readByte();
		}

		return sb.toString();
	}

	public int[] nextIntArray(int n) {
		int[] res = new int[n];
		for (int i=0; i<n; i++) res[i] = nextInt();
		return res;
	}

	public char[] nextCharArray(int n) {
		char[] res = new char[n];
		for (int i=0; i<n; i++) res[i] = nextChar();
		return res;
	}

	public void close() {try{ in.close();}catch(IOException e){ e.printStackTrace();}};
}