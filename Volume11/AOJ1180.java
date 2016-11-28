import java.util.*;
import java.io.*;
import java.awt.geom.*;
import java.math.*;

public class AOJ1180 {

	static final Scanner in = new Scanner(System.in);
	static final PrintWriter out = new PrintWriter(System.out,false);
	static boolean debug = false;

	static boolean solve() {
		int a = in.nextInt();
		int l = in.nextInt();
		if (a + l == 0) return false;

		HashMap<Integer,Integer> map = new HashMap<>();
		int p = 0;
		while (true) {
			if (map.containsKey(a)) {
				break;
			}
			map.put(a, p);

			ArrayList<Integer> max = new ArrayList<>();
			ArrayList<Integer> min = new ArrayList<>();

			while (a != 0) {
				max.add(a%10);
				min.add(a%10);
				a /= 10;
			}

			while (max.size() < l) {
				max.add(0);
				min.add(0);
			}

			Collections.sort(max);
			Collections.sort(min, new Comparator<Integer>(){
				public int compare(Integer a, Integer b) {
					return b - a;
				}
			});

			int maxI = 0, minI = 0, d = 1;
			for (int i=0; i<l; i++) {
				maxI += max.get(i)*d;
				minI += min.get(i)*d;
				d *= 10;
			}

			a = maxI - minI;
			p++;
		}

		out.println(map.get(a)+" "+a+" "+(p-map.get(a)));

		return true;
	}

	public static void main(String[] args) {
		debug = args.length > 0;
		long start = System.nanoTime();

		while(solve());
		out.flush();

		long end = System.nanoTime();
		dump((end - start) / 1000000 + " ms");
		in.close();
		out.close();
	}

	static void dump(Object... o) { if (debug) System.err.println(Arrays.deepToString(o)); }
}