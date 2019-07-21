import java.util.Arrays;
import java.util.HashMap;
import java.util.Stack;

public class ParantheseValidator {

	// -> [{()}] -> STORE OPENING BRACIS in LinkedList ->
	/*
	 * opening brackets should push to stack -> [{( on the other side if we have
	 * closing bracket we can peek and check if it match with closing bracket then
	 * we cal poll this value if peek value is ( and upcoming is )
	 * 
	 */

	static boolean isValidComParath(String para) {
		// this map is used to store the opening braces as key and close as value.
		HashMap<Character, Character> map = new HashMap<>();
		map.put('(', ')');
		map.put('{', '}');
		map.put('[', ']');
		Stack<Character> stack = new Stack<>();
		for (char c : para.toCharArray()) {
			if (map.containsKey(c)) {
				stack.push(c);
			} else if (!stack.isEmpty() && (c == map.get(stack.peek()))) {
				stack.pop();
			} else {
				return false;
			}
		}

		return stack.isEmpty();

	}

	// Bracket check

//	static boolean isValidParanCheck(String paran) {
//		HashMap<Character, Character> map = new HashMap<>();
//		map.put('(', ')');
//		map.put('{', '}');
//		map.put('[', ']');
//		Stack<Character> stack = new Stack<>();
//		for (char p : paran.toCharArray()) {
//			if (map.containsKey(p)) {
//				stack.push(p);
//			} else if (!stack.isEmpty() && map.get(stack.peek()) == p) {
//				stack.pop();
//			}
//			else {
//				return false;
//			}
//		}
//		return stack.isEmpty();
//	}

	// (()))
	static boolean isValidParathensis(String paran) {
		if (paran == null || paran.isEmpty())
			throw new IllegalArgumentException("String not available..");
		int checkParam = 0;
		for (char c : paran.toCharArray()) {
			if (c == '(') {
				checkParam++;
			} else if (c == ')') {
				checkParam--;
			}
			if (checkParam < 0) {
				return false;
			}
		}
		if (checkParam == 0)
			return true;
		return false;
	}

	// Complete the rotLeft function below.
	static int[] rotLeft(int[] a, int d) {
		int[] rotate = new int[a.length];
		if (d < 0)
			return null;
		while (d > 0) {
			for (int x = a.length - 1; x >= 0; x--) {
				int next = x + 1;
				if (x == a.length - 1) {
					next = 0;
				}
				rotate[x] = (a[x] + a[next]) - a[x];
			}
			--d;
		}
		return rotate;
	}

	public static void main(String[] args) {
//		System.out.println(isValidParathensis("))"));
//		System.out.println(isValidParathensis("()()"));
//		System.out.println(isValidParathensis("(())"));
//		System.out.println(isValidParathensis("()))"));
//		System.out.println(isValidParathensis("(()())"));

		System.out.println(Arrays.toString(rotLeft(new int[] { 1, 2, 3, 4, 5 }, 3)));

	}
}
