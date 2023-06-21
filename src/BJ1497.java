import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;
import java.util.Set;
import java.util.HashSet;

/**
 * bfs
 * 문제의 의도: 비트마스킹
 * https://www.acmicpc.net/problem/1497
 * 31:37
 * @author YangGaNorm
 *
 */
public class BJ1497 {
	static BufferedReader br;
	static StringTokenizer st;
	static Set<Integer> map[];
	static String tk[];
	static int n, m, res, maxSong;

	public static void main(String[] args) throws IOException {
		br = new BufferedReader(new InputStreamReader(System.in));
		line();
		n = nextInt();
		m = nextInt();
		map = new Set[n];
		String k, v[];
		int cnt;
		for (int i = 0; i < n; i++) {
			map[i] = new HashSet<>();
			line();
			k = nextStr();
			v = nextStr().split("");
			cnt = 1;
			for (String vv : v) {
				if (vv.equals("Y")) {
					map[i].add(cnt);
				}
				cnt++;
			}
		}
		res = Integer.MAX_VALUE;
		maxSong = 0;
		bfs(0, new HashSet<>(), 0);
		System.out.println(res == 0 ? -1 : res);
	}

	static void bfs(int nextIdx, Set<Integer> curPlaylist, int curCnt) {
		if (maxSong == curPlaylist.size()) {
			maxSong = Math.max(maxSong, curPlaylist.size());
			res = Math.min(res, curCnt);
		} else if (maxSong < curPlaylist.size()) {
			maxSong = curPlaylist.size();
			res = curCnt;
		}
		if (curPlaylist.size() == m) {
			maxSong = m;
			res = Math.min(res, curCnt);
			return;
		}
		if (nextIdx >= n) {
			return;
		}
		Set<Integer> nextSet = new HashSet<>(curPlaylist);
		bfs(nextIdx + 1, nextSet, curCnt + 0);
		nextSet = new HashSet<>(curPlaylist);
		nextSet.addAll(map[nextIdx]);
		bfs(nextIdx + 1, nextSet, curCnt + 1);
	}

	static void line() throws IOException {
		st = new StringTokenizer(br.readLine());
	}

	static String nextStr() {
		return st.nextToken();
	}

	static int nextInt() {
		return Integer.parseInt(nextStr());
	}
}
