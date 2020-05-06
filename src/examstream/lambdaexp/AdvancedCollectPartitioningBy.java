package examstream.lambdaexp;

import java.util.Arrays;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

public class AdvancedCollectPartitioningBy {

	public static void main(String[] args) {

		 List<Integer> intList = Arrays.asList(2, 4, 5, 6, 8);
		 Map<Boolean, List<Integer>> isEven = intList.stream().collect(
				Collectors.partitioningBy(i -> i % 2 == 0));
		 
		 System.out.println(isEven.toString());

	}

}
