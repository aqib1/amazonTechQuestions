import java.util.Arrays;
import java.util.HashSet;

public class TripletSumIsEqualsToZero {

	// O(n)^2 approach
	static void findTrippletUsingHashing(int[] data) {
		for (int x = 0; x < data.length - 1; x++) {
			HashSet<Integer> set = new HashSet<>();
			for(int y = x+1; y < data.length; y++) {
				int thirdNumb = -(data[x] + data[y]);
				if(set.contains(thirdNumb)) {
					System.out.println("Tripplets are "+data[x] +", "+ data[y]+", "+ thirdNumb);
				}
				set.add(data[y]);
			}
		}
	}

	// O(n)^3 approach
	static void findTripletSumZeroN3(int[] data) {
		for (int x = 0; x < data.length - 2; x++) {
			for (int y = x + 1; y < data.length - 1; y++) {
				for (int z = y + 1; z < data.length; z++) {
					if (data[x] + data[y] + data[z] == 0) {
						System.out.println("Tripplets are " + data[x] + ", " + data[y] + ", " + data[z]);
					}
				}
			}
		}
	}

	// O(n)^2 using sort and sandwich approach
	static void findTripletSumZero(int[] data) {
		boolean found = false;
		Arrays.sort(data);
		for (int x = 0; x < data.length - 1; x++) {
			int maxIndex = data.length - 1;
			int minIndex = x + 1;
			while (minIndex < maxIndex) {
				int sum = data[x] + data[maxIndex] + data[minIndex];
				if (sum == 0) {
					System.out.println("Tripplets are " + data[x] + ", " + data[maxIndex] + ", " + data[minIndex]);
					--maxIndex;
					++minIndex;
					found = true;
				}
				if (sum > 0) {
					--maxIndex;
				}
				if (sum < 0) {
					++minIndex;
				}
			}
		}
		if (!found)
			System.out.println("No tripplets found");
	}

	public static void main(String[] args) {
		int arr[] = { 0, -1, 2, -3, 1 };
		// findTripletSumZeroN3(arr);
		// findTripletSumZero(arr);
		findTrippletUsingHashing(arr);
	}
}
