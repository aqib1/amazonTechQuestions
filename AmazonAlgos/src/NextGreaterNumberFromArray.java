import java.util.Stack;

public class NextGreaterNumberFromArray {

	// Time complexity in worst case is O(n)
	static void optimizeSolutionUsingStack(int[] arr) {
		Stack<Integer> stack = new Stack<>();
		stack.push(arr[0]);
		for (int x = 1; x < arr.length; x++) {
			int pushedVal = stack.pop();
			while (arr[x] > pushedVal) {
				System.out.println("Next Greater val of " + pushedVal + " is " + arr[x]);
				if (stack.isEmpty())
					break;
				pushedVal = stack.pop();
			}
			if (pushedVal > arr[x]) {
				stack.push(pushedVal);
			}
			stack.push(arr[x]);
		}
		while (!stack.isEmpty()) {
			System.out.println("Next Greater val of " + stack.pop() + " is -1");
		}

	}

	// Time complexity in worst case O(m)^2
	static void printNextGreaterUsingLinearSearch(int[] arr) {
		for (int x = 0; x < arr.length; x++) {
			int nextGreater = -1;
			for (int y = x + 1; y < arr.length; y++) {
				if (arr[x] < arr[y]) {
					nextGreater = arr[y];
					break;
				}
			}
			System.out.println("Next Greater of " + arr[x] + " is " + nextGreater);
		}
	}

	public static void main(String[] args) {
		int[] arr = { 3, 1, 10, 4, 6 };
		optimizeSolutionUsingStack(arr);

	}

}
