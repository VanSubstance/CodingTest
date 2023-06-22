import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;
import java.util.Stack;

/**
 * 구현
 * 스택
 * https://www.acmicpc.net/problem/23300
 * @author YangGaNorm
 *
 */
public class BJ23300 {
	static BufferedReader br;
	static StringTokenizer st;
	static StringBuilder sb;
	static int n, qq, curPage;
	static Stack<Integer> b, f;

	public static void main(String[] args) throws IOException {
		br = new BufferedReader(new InputStreamReader(System.in));
		sb = new StringBuilder();
		line();
		n = nextInt();
		qq = nextInt();
		b = new Stack<>();
		f = new Stack<>();
		curPage = -1;
		for (int i = 0; i < qq; i++) {
			line();
			switch (nextStr()) {
			case "B":
				backward();
				break;
			case "F":
				forward();
				break;
			case "C":
				compress();
				break;
			case "A":
				access(nextInt());
				break;
			}
		}

		System.out.println(curPage);
		makeStr(b);
		System.out.println(sb);
		makeStr(f);
		System.out.println(sb);
	}
	
	static void makeStr(Stack<Integer> stk) {
		sb = new StringBuilder();
		if (stk.isEmpty()) {
			sb.append(-1);
		} else {
			while (!stk.isEmpty()) {
				sb.append(stk.pop());
				if (stk.size() > 0) {
					sb.append(" ");
				}
			}
		}
	}

	static void access(int idx) {
		if (curPage == -1) {
			// 최초 접속
			curPage = idx;
			return;
		}
		// 현재 페이지 존재
		b.add(0 + curPage);
		curPage = idx;
		f.clear();
	}

	static void backward() {
		if (b.isEmpty()) return;
		f.add(0 + curPage);
		curPage = b.pop();
	}

	static void forward() {
		if (f.isEmpty()) return;
		b.add(0 + curPage);
		curPage = f.pop();
	}

	static void compress() {
		if (b.isEmpty()) return;
		Stack<Integer> temp = new Stack<>();
		int prev = -1, cur;
		while (!b.isEmpty()) {
			cur = b.pop();
			if (prev != cur) {
				temp.add(cur);
			}
			prev = cur;
		}
		b.addAll(temp);
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
