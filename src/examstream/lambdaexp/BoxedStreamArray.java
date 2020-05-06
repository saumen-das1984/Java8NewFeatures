package examstream.lambdaexp;

import java.util.Arrays;
import java.util.Iterator;
import java.util.List;
import java.util.stream.Collectors;

public class BoxedStreamArray {
	public static void main(String[] args) {
		Object[] objArrayOfIntArrays1 = new Object[] { new int[] { 1, 2 }, // add 2
				new int[] { 1, 2 }, // add 2
				new int[] { 3, 2 }, // query freq 2
				new int[] { 2, 2 }, // delete 2
				new int[] { 3, 2 }, // query freq 2
		};

		List<List<Integer>> primitiveList = Arrays.stream(objArrayOfIntArrays1).map(q -> {
			return Arrays.stream((int[]) q).boxed().collect(Collectors.toList());
		}).collect(Collectors.toList());
		
		for (Iterator<List<Integer>> iterator = primitiveList.iterator(); iterator.hasNext();) {
			List<Integer> list = (List<Integer>) iterator.next();
			System.out.println();
			for (Iterator<Integer> iterator2 = list.iterator(); iterator2.hasNext();) {
				Integer integer = (Integer) iterator2.next();
				System.out.print("\t"+integer);
			}
		}
	}
}
