import java.util.ArrayList;
import java.util.List;
import java.util.function.IntPredicate;
import java.util.stream.IntStream;

public class TwoPlayerCoinGame {

	static int getSumOfElements(IntPredicate pred, int[] coins) {
		return IntStream.range(0, coins.length)
				.filter(pred)
				.map(x -> coins[x])
				.sum();
		}

	// Get coins using Greedy approach for even list
	static List<Integer> getPlayerOneCoins(int[] coins) {
		// if coins is empty ->
		if (coins.length == 0)
			throw new IllegalArgumentException("Coins are not available");
		List<Integer> li = new ArrayList<>();

		int evenSum = getSumOfElements((t) -> t % 2 == 0, coins);
		int oddSum = getSumOfElements((t) -> t % 2 != 0, coins);

		int startIndex = evenSum > oddSum ? 0 : 1;
		for (; startIndex < coins.length; startIndex += 2) {
			li.add(coins[startIndex]);
		}
		return li;
	}

	public static void main(String[] args) {
		int[] coinNumbers = {8, 155, 3, 7, 199};

		System.out.println(getPlayerOneCoins(coinNumbers));

	}
}
