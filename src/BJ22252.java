import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Collections;
import java.util.HashMap;
import java.util.PriorityQueue;
import java.util.StringTokenizer;

/**
 * 우선순위 큐 + 사전 만들기
 * 28:49
 * 문제를 잘읽자 제발
 * @author sungh
 *
 */
public class BJ22252 {
	static BufferedReader br;
	static StringTokenizer st;
	static int q;
	static long res;
	static HashMap<String, PriorityQueue<Integer>> market;
	static PriorityQueue<Integer> target;

	public static void main(String[] args) throws IOException {
		br = new BufferedReader(new InputStreamReader(System.in));
		line();
		q = Integer.parseInt(next());
		market = new HashMap<>();
		res = 0;
		String ss;
		int cnt = 0, temp;
		for (int i = 0; i < q; i++) {
			line();
			if (nextInt() == 1) {
				// 넣기
				ss = next();
				if (market.get(ss) == null) {
					market.put(ss, new PriorityQueue<>(Collections.reverseOrder()));
				}
				temp = nextInt();
				for (int j = 0; j < temp; j++) {
					market.get(ss).add(nextInt());
				}
				continue;
			}
			// 구매
			ss = next();
			target = market.get(ss);
			if (target == null)
				continue;
			cnt = nextInt();
			while (cnt > 0 && target.size() > 0) {
				res += target.poll();
				cnt--;
			}
			continue;
		}

		System.out.println(res);
	}

	static void line() throws IOException {
		st = new StringTokenizer(br.readLine());
	}

	static String next() {
		return st.nextToken();
	}

	static int nextInt() {
		return Integer.parseInt(next());
	}
}
