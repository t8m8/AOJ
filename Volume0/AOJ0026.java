import java.util.*;
import java.io.*;
import java.awt.geom.*;
import java.math.*;

public class AOJ0026 {

	static final BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	static final PrintWriter out = new PrintWriter(System.out,false);

	static void solve() throws IOException{
		int[][] table = new int[30][30];
		String s;
		while ((s = br.readLine()) != null) {
			String[] ss = s.split(",");
			int x = Integer.parseInt(ss[0]) + 10;
			int y = Integer.parseInt(ss[1]) + 10;
			int size = Integer.parseInt(ss[2]);

			switch(size) {
				case 3:
					table[x-2][y]++;
					table[x][y-2]++;
					table[x+2][y]++;
					table[x][y+2]++;
				case 2:
					table[x-1][y-1]++;
					table[x+1][y-1]++;
					table[x-1][y+1]++;
					table[x+1][y+1]++;
				case 1:
					table[x][y]++;
					table[x-1][y]++;
					table[x][y-1]++;
					table[x+1][y]++;
					table[x][y+1]++;
			}
		}

		int cnt = 0, max = 0;

		for (int i=10; i<20; i++) {
			for (int j=10; j<20; j++) {
				if (table[i][j] == 0) cnt++;
				else max = Math.max(max, table[i][j]);
			}
		}

		out.println(cnt);
		out.println(max);
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