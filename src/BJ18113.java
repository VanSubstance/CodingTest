import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

/**
 * 이분 탐색 24:01 값 입력 순서 제대로 볼 것
 * 
 * @author sungh
 *
 */
public class BJ18113 {
	static BufferedReader br;
	static StringTokenizer st;
	static int n, k, m, map[], p, s, e;

	public static void main(String[] args) throws IOException {
		br = new BufferedReader(new InputStreamReader(System.in));
		line();
		n = next();
		map = new int[n];
		k = next();
		m = next();
		p = -1;
		e = 0;
		int t;
		for (int i = 0; i < n; i++) {
			line();
			t = next();
			if (t >= 2 * k) {
				map[i] = t - (2 * k);
				e = Math.max(e, map[i]);
				continue;
			}
			if (t > k) {
				map[i] = t - k;
				e = Math.max(e, map[i]);
				continue;
			}
			map[i] = 0;
		}
		int tempS = 0, mid;
		s = 1;
		while (s <= e) {
			tempS = 0;
			mid = (e - s) / 2 + s;
			for (int len : map) {
				tempS += len / mid;
			}
			if (tempS >= m) {
				p = Math.max(p, mid);
				s = mid + 1;
				continue;
			}
			e = mid - 1;
		}

		System.out.println(p);
	}

	static void line() throws IOException {
		st = new StringTokenizer(br.readLine());
	}

	static int next() {
		return Integer.parseInt(st.nextToken());
	}
}
