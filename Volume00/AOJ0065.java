import java.util.*;
import java.io.*;
import java.awt.geom.*;
import java.math.*;

public class AOJ0065 {

	static final Scanner in = new Scanner(System.in);
	static final PrintWriter out = new PrintWriter(System.out,false);

	static void solve() {
		HashMap<Integer, Integer> map1 = new HashMap<Integer, Integer>();
		HashMap<Integer, Integer> map2 = new HashMap<Integer, Integer>();

		String str;
		while (true) {
			str = br.readLine();
			if (str.equals("")) break;
			String[] s = str.split(",");
			int x = Integer.parseInt(s[0]);

			if (map1.containsKey(x)) {
				map1.put(x,map1.get(x)+1);
			} else {
				map1.put(x,1);
			}
		}

		while ((str = br.readLine()) != null) {
			String[] s = str.split(",");
			int x = Integer.parseInt(s[0]);

			if (map1.containsKey(x)) {
				if (map2.containsKey(x)) {
					map2.put(x,map2.get(x)+1);
				} else {
					map2.put(x,1);
				}
			}
		}

		ArrayList<int[]> list = new ArrayList<int[]>();
		for (int x : map2.keySet()) {
			list.add(new int[]{x, map1.get(x) + map2.get(x)});
		}

		Collections.sort(list, new Comparator<int[]>(){
			public int compare(int[] a, int[] b) {
				return a[0] - b[0];
			}
		});

		for (int[] i : list) {
			out.println(i[0] + " " + i[1]);
		}

	}

	public static void main(String[] args) {
		long start = System.currentTimeMillis();

		solve();
		out.flush();

		long end = System.currentTimeMillis();
		//trace(end-start + "ms");
		br.close();
		out.close();
	}

	static void trace(Object... o) { System.out.println(Arrays.deepToString(o));}
}