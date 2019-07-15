import java.util.Arrays;
import java.util.Random;

public class ShufflePlayList {

	static int[] sufflePlayList(int[] playList) {
		if (playList.length == 0)
			throw new IllegalArgumentException("Playlist is empty");
		Random random = new Random();

		for (int x = playList.length - 1; x > 0; x--) {
			int j = random.nextInt(x + 1);
			if (x != j) {
				playList[x] = playList[x] + playList[j];
				playList[j] = playList[x] - playList[j];
				playList[x] = playList[x] - playList[j];
			}
		}

		return playList;
	}

	public static void main(String[] args) {
		int[] playList = { 1, 3, 5, 7, 15, 1 };

		System.out.println(Arrays.toString(sufflePlayList(playList)));

	}

}
