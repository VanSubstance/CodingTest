import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.IOException;
import java.util.StringTokenizer;

/**
 * bfs
 * 15:32
 * https://www.acmicpc.net/problem/14562
 * @author YangGaNorm
 *
 */
public class BJ14562 {
	static BufferedReader br;
	static StringTokenizer st;
	static StringBuilder sb;
	static int c, minCnt;

	public static void main(String[] args) throws IOException {
		br = new BufferedReader(new InputStreamReader(System.in));
		sb = new StringBuilder();
		line();
		c = next();
		for (int i = 0; i < c; i++) {
			line();
			minCnt = Integer.MAX_VALUE;
			bfs(next(), next(), 0);
			sb.append(minCnt + "\n");
		}
		
		System.out.print(sb);
	}

	static void bfs(int s, int e, int accuCnt) {
		if (accuCnt >= minCnt)
			return;
		if (s > e)
			return;
		if (s == e) {
			minCnt = Math.min(minCnt, accuCnt);
			return;
		}
		bfs(s * 2, e + 3, accuCnt + 1);
		bfs(s + 1, e, accuCnt + 1);
	}

	static void line() throws IOException {
		st = new StringTokenizer(br.readLine());
	}

	static int next() {
		return Integer.parseInt(st.nextToken());
	}
}