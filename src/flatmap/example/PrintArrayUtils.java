package flatmap.example;

public class PrintArrayUtils {
	public static void main(String[] args) {

		// array
		String[] arrayStr = new String[] { "Java", "Node", "Python", "Ruby" };
		PrintUtils.print(arrayStr);

		int[] arrayInt = { 1, 3, 5, 7, 9 };
		PrintUtils.print(arrayInt);

		// 2d array
		String[][] deepArrayStr = new String[][] { { "mkyong1", "mkyong2" }, { "mkyong3", "mkyong4" } };
		PrintUtils.print(deepArrayStr);

		int[][] deepArrayInt = new int[][] { { 1, 3, 5, 7, 9 }, { 2, 4, 6, 8, 10 } };
		PrintUtils.print(deepArrayInt);

	}
}
