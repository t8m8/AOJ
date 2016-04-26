import java.util.*;
import java.io.*;
import java.awt.geom.*;
import java.math.*;

public class AOJ0072 {

	static final Scanner in = new Scanner(System.in);
	static final PrintWriter out = new PrintWriter(System.out,false);

	static boolean solve() {
		int n = in.nextInt();
		if (n == 0) return false;
		int m = in.nextInt();
		int[] s = new int[m];
		int[] t = new int[m];
		int[] c = new int[m];

		for (int i=0; i<m; i++) {
			String[] str = in.next().split(",");
			s[i] = Integer.parseInt(str[0]);
			t[i] = Integer.parseInt(str[1]);
			c[i] = Integer.parseInt(str[2])/100-1;
		}

		out.println(kruskal(s,t,c,n));
		return true;
	}

	public static int kruskal(int[] s, int[] t, int[] cost, int n) {
		DisjointSet ds = new DisjointSet(n);
		int e = s.length;
		long[] link = new long[e];
		for (int i=0; i<e; i++)
			link[i] = (long)cost[i]<<32 | i;

		int res = 0;

		Arrays.sort(link);
		for (int i=0; i<e; i++) {
			int cur = (int)link[i];
			if (!ds.same(s[cur],t[cur])) {
				ds.unite(s[cur],t[cur]);
				res += cost[cur];
			}
		}

		return res;
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

class DisjointSet {
	int[] data;

	public DisjointSet(int n){
		data = new int[n];
		for (int i=0; i<n; i++) data[i] = i;
	}

	public int find(int x){
		if(data[x] == x) return x;
		return data[x] = find(data[x]);
	}

	public boolean same(int x,int y){
		return find(x) == find(y);
	}

	public void unite(int x,int y){
		if (find(x) == find(y)) return;
		data[find(x)] = find(y);
	}

	public String toString() {
		return Arrays.toString(data);
	}
}