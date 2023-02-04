package CurrentRange;

import java.util.ArrayList;
import java.util.List;

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
	
	@Test
	public void testGetRangeWiseReadingsAnalogInput() {
		
		int[] testIntegers = {1024, 1500, 2048};
		
		StringBuilder output = new StringBuilder("Range, Readings\n3-5, 3");
		
		assert(CurrentRange.getRangeWiseReadingsAnalogInput(testIntegers).toString().equals(output.toString()));
		
		int[] testIntegers1 = {1024, 1500, 2048, 4094, 3700, 3300};
		
		StringBuilder output1 = new StringBuilder("Range, Readings\n3-5, 3\n8-10, 3");
		
		System.out.println(CurrentRange.getRangeWiseReadingsAnalogInput(testIntegers1));
		
		assert(CurrentRange.getRangeWiseReadingsAnalogInput(testIntegers1).toString().equals(output1.toString()));

	}
	
	@Test
	public void testAnalogToDigitalConversion() {
		
		assert(CurrentRange.getDigitalConversion(1024) == 3);
		assert(CurrentRange.getDigitalConversion(2048) == 5);
		assert(CurrentRange.getDigitalConversion(100) == 0);
		assert(CurrentRange.getDigitalConversion(1146) == 3);
		assert(CurrentRange.getDigitalConversion(4094) == 10);
		assert(CurrentRange.getDigitalConversion(4095) == -1);
		
	}
	
	@Test
	public void testGetCountWithRange() {
		assert(CurrentRange.getCountWithRange(new int[] {3,4,5,4,3}, "3-5") == 5);
		assert(CurrentRange.getCountWithRange(new int[] {3,4,5,4,3,10}, "3-5") == 5);
		assert(CurrentRange.getCountWithRange(new int[] {3,4,5,4,3,1,2}, "3-5") == 5);
		assert(CurrentRange.getCountWithRange(new int[] {3,4,5,4,3,1,5,8}, "4-6") == 4);
	}
	
	@Test
	public void testGetRangesWithReadings() {
		List<String> ranges = new ArrayList<>();
		CurrentRange.getRangesWithReadings(new int[] {3,4,5,4,3}, ranges);
		assert(ranges.get(0).equals("3-5"));
		List<String> ranges1 = new ArrayList<>();
		CurrentRange.getRangesWithReadings(new int[] {3,4,5,10,11,12}, ranges1);
		assert(ranges1.get(0).equals("3-5"));
		assert(ranges1.get(1).equals("10-12"));
	}
	

}
