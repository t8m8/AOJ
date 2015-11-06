import java.util.*;
import java.io.*;
import java.awt.geom.*;
import java.math.*;

public class AOJ0072_2 {

	static final Scanner in = new Scanner(System.in);
	static final PrintWriter out = new PrintWriter(System.out,false);

	static boolean solve() {
		int n = in.nextInt();
		if (n == 0) return false;
		int m = in.nextInt();
		UndirectedGraph g = new UndirectedGraph(n);

		for (int i=0; i<m; i++) {
			String[] str = in.next().split(",");
			g.addLink(Integer.parseInt(str[0]), Integer.parseInt(str[1]), Integer.parseInt(str[2])/100-1);
		}

		out.println(prim(g,0));

		return true;
	}

	public static int prim(UndirectedGraph g, int from) {
		int n = g.n;
		final int[] d = new int[n];
		Arrays.fill(d,Integer.MAX_VALUE/2);

		BitSet bs = new BitSet();
		TreeSet<Integer> que = new TreeSet<Integer>(new Comparator<Integer>(){
			public int compare(Integer a, Integer b){
				if (d[a] - d[b] != 0) return d[a] - d[b];
				return a - b;
			}
		});

		que.add(from);
		d[from] = 0;

		while (!que.isEmpty()) {
			int cur = que.pollFirst();
			bs.set(cur);
			for(int[] to : g.get(cur)) {
				int next = to[0];
				int cost = to[1];

				if(!bs.get(next)){
					if(cost < d[next]){
						que.remove(next);
						d[next] = cost;
						que.add(next);
					}
				}
			}
		}

		int res = 0;

		for (int i=0; i<n; i++) {
			res += d[i];
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

class UndirectedGraph {

	public static final int INF = Integer.MAX_VALUE/2;

	public final int n;
	private ArrayList<ArrayList<int[]>> adjlist;

	public UndirectedGraph(int n) {
		this.n = n;
		this.adjlist = new ArrayList<ArrayList<int[]>>();
		for (int i=0; i<n; i++) adjlist.add(new ArrayList<int[]>());
	}

	public void addLink(int v1, int v2) {
		addLink(v1,v2,0);
	}

	public void addLink(int v1, int v2, int c) {
		adjlist.get(v1).add(new int[]{v2,c});
		adjlist.get(v2).add(new int[]{v1,c});
	}

	public ArrayList<int[]> get(int cur) {
		return adjlist.get(cur);
	}

	public String toString() {
		StringBuilder res = new StringBuilder();
		for (int i=0; i<n; i++) {
			res.append(i).append(" ").append(Arrays.deepToString(adjlist.get(i).toArray())).append("\n");
		}
		return res.substring(0,res.length()-1);
	}
}