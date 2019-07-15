import java.util.Arrays;
import java.util.stream.IntStream;

public class SwapElementSumArrayProblem {

	/*
	 * 
	 * Given two arrays(A & B), can you tell if its possible to swap an element from
	 * A with an element from B and make the sum of both arrays equal ?
	 */

	static int getSum(int[] array) {
		return IntStream.of(array).sum();
	}

	static int getTarget(int[] a1, int[] a2) {
		int sum1 = getSum(a1);
		int sum2 = getSum(a2);
		int difference = sum1 - sum2;

		if (difference % 2 == 0) {
			return difference / 2;
		} else {
			return 0;
		}
	}

	static int[] getNumbersCanSwap(int a1[], int a2[]) {
		Arrays.sort(a1);
		Arrays.sort(a2);
		int target = getTarget(a1, a2);
		if(target == 0) return null;
		int[] numbers = new int[2];
		int x = 0, y = 0;
		while(x < a1.length && y < a2.length) {
			int instantDiff = a1[x] - a2[y];
			if(instantDiff < target) x++;
			if(instantDiff > target) y++;
			if(instantDiff == target) {
				numbers[0] = a1[x];
				numbers[1] = a2[y];
				break;
			}
		}
		return numbers;
	}

	public static void main(String[] args) {
		//if arrays are sorted -> time complexity is O(n+m) where n!=m
		//if are not sorted -> time complexity is O(nlog(n) + mlog(m)) where n!=m
		int A[] = { 4, 1, 2, 1, 1, 2 };
		int B[] = { 3, 6, 3, 3 };
		
		System.out.println(Arrays.toString(getNumbersCanSwap(A, B)));
	}

}
