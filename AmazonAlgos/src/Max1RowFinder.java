import java.util.HashMap;

public class Max1RowFinder {

	static int getRowWithMax1(int[][] data) {
		HashMap<Integer, Integer> map = new HashMap<>();
		for (int x = 0; x < data.length; x++) {
			for (int y = 0; y < data[x].length; y++) {
				
				if (data[x][y] == 1) {
					if (map.containsKey(x)) {
						map.put(x, map.get(x) + 1);
					} else {
						map.put(x, 0);
					}
				}
			}
		}

		return map.entrySet().stream().max((x, y) -> x.getValue() - y.getValue()).get().getKey();
	}

	public static void main(String[] args) {
		int[][] data = { { 0, 1, 1, 1 }, { 1, 0, 1, 1 }, { 1,1, 1, 1, 1 }, { 1, 1, 1, 1 } };
		System.out.println(getRowWithMax1(data));
	}
}
