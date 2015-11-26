import java.util.*;
import java.io.*;
import java.awt.geom.*;
import java.math.*;

public class AOJ0085 {

	static final Scanner in = new Scanner(System.in);
	static final PrintWriter out = new PrintWriter(System.out,false);

	static boolean solve() {
		int n = in.nextInt();
		int m = in.nextInt();
		if (n + m == 0) return false;

		ArrayList<Integer> list = new ArrayList<Integer>();
		for (int i=1; i<=n; i++) {
			list.add(i);
		}

		int p = 0;
		while (list.size() > 1) {
			int idx = (p + m - 1)%list.size();
			list.remove(idx);
			p = idx;
		}

		out.println(list.get(0));

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