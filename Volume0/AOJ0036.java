import java.util.*;
import java.io.*;
import java.awt.geom.*;
import java.math.*;

public class AOJ0036 {

	static final BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	static final PrintWriter out = new PrintWriter(System.out,false);

	static void solve() throws IOException{
		String[] str = new String[8];
		str[0] = br.readLine();
		while (true) {
			for (int i=1; i<8; i++) {
				str[i] = br.readLine();
			}

			int cnt = 0;
			ArrayList<Integer> list = new ArrayList<Integer>();
			for (int i=0; i<8; i++) {
				if (!str[i].equals("00000000")) {
					cnt++;
					for (int j=0; j<8; j++) {
						if (str[i].charAt(j) == '1') {
							list.add(j);
							break;
						}
					}
				}
			}

			if (cnt == 1) {
				out.println("C");
			} else if (cnt == 4) {
				out.println("B");
			} else if (cnt == 2) {
				if (list.get(0) == list.get(1)) out.println("A");
				else if (list.get(0) > list.get(1)) out.println("G");
				else out.println("E");
			} else {
				if (list.get(0) > list.get(2)) out.println("D");
				else out.println("F");
			}

			String check = br.readLine();
			if (check == null) break;
			else str[0] = br.readLine();
		}
	}

	public static void main(String[] args) throws Exception {
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