import java.util.*;
import java.io.*;
import java.awt.geom.*;
import java.math.*;

public class AOJ1129 {

	static final Scanner in = new Scanner(System.in);
	static final PrintWriter out = new PrintWriter(System.out,false);

	static boolean solve() {
		int n = in.nextInt();
		int r = in.nextInt();
		if (n + r == 0) return false;

		ArrayList<Integer> list = new ArrayList<Integer>();
		ArrayList<Integer> list2 = new ArrayList<Integer>();
		for (int i=1; i<=n; i++) {
			list.add(i);
		}
		while (r-- > 0) {
			int p = in.nextInt();
			int c = in.nextInt();
			for (int i=0; i<c; i++) {
				list2.add(list.get(n-p-i));
				list.remove(n-p-i);
			}
			for (int i=list2.size()-1; i>=0; i--) {
				list.add(list2.get(i));
			}
			list2.clear();
		}

		out.println(list.get(n-1));
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