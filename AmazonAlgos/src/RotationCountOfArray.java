import java.util.Objects;
import java.util.OptionalInt;
import java.util.stream.IntStream;

//A sorted array rotated N time clock wise
//we need to find N
//take an example 2,3,4,5,6
//rotate 1 time -> 6,2,3,4,5
// as you can see when we rotate the indexes of numbers change and index of smallest number
//define how many time an array rotate -> for example if we rotate one time 2 move one index
//if we rotate two times 2 moves to time, i mean on 2nd index
//-> 2 -> index 0 on 0 rotation
//-> 2 -> index 1 on 1st rotation.. and so on
public class RotationCountOfArray {
	private static int findRotation(int [] arr) {
		if(Objects.isNull(arr) || arr.length == 0) throw new IllegalArgumentException("Array Should be present");
		OptionalInt val = IntStream.of(arr).min();
		int min = val.orElse(0);
		return IntStream.range(0, arr.length).filter(i -> min == arr[i]).findFirst().orElse(0);
	}
	
	public static void main(String[] args) {
		System.out.println(findRotation(new int [] {7, 9, 11, 12, 5, 5}));
	}
}
