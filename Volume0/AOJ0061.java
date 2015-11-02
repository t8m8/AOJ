import java.util.*;
import java.io.*;
import java.awt.geom.*;
import java.math.*;

public class AOJ0061 {

	static final Scanner in = new Scanner(System.in);
	static final PrintWriter out = new PrintWriter(System.out,false);

	static int[] rank;

	static void solve() {
		out.println(rank[in.nextInt()]);
	}

	public static void main(String[] args) {
		long start = System.currentTimeMillis();

		ArrayList<int[]> list = new ArrayList<int[]>();

		while (true) {
			String[] s = in.next().split(",");
			int t = Integer.parseInt(s[0]);
			int c = Integer.parseInt(s[1]);
			if (t + c == 0) break;
			list.add(new int[]{t,c});
		}

		Collections.sort(list,new Comparator<int[]>(){
			public int compare(int[] a, int[] b) {
				return b[1] - a[1];
			}
		});

		rank = new int[list.size()+1];

		int r = 0, c = Integer.MAX_VALUE;
		for (int i=0; i<list.size(); i++) {
			int[] cur = list.get(i);
			if (c > cur[1]) {
				r++;
				c = cur[1];
			}
			rank[cur[0]] = r;
		}

		while(in.hasNext()) solve();
		out.flush();

		long end = System.currentTimeMillis();
		//trace(end-start + "ms");
		in.close();
		out.close();
	}

	static void trace(Object... o) { System.out.println(Arrays.deepToString(o));}
}