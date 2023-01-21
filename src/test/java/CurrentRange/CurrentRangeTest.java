package CurrentRange;

import org.junit.Test;

public class CurrentRangeTest {

	@Test
	public void testGetRangeWiseReadings() {
		
		int[] testIntegers = {4, 5};
		
		StringBuilder output = new StringBuilder("Range, Readings\n4-5, 2");
		
		assert(CurrentRange.getRangeWiseReadings(testIntegers).toString().equals(output.toString()));
		
		int[] testIntegers1 = {3, 3, 5, 4, 10, 11, 12};
		
		StringBuilder output1 = new StringBuilder("Range, Readings\n3-5, 4\n10-12, 3");
		
		assert(CurrentRange.getRangeWiseReadings(testIntegers1).toString().equals(output1.toString()));
	}

}
