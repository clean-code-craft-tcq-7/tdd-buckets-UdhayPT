package CurrentRange;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class CurrentRange {
	
	public static StringBuilder getRangeWiseReadings (int[] readings) {
		
		Arrays.sort(readings);
		
		List<String> ranges = new ArrayList<>();
		
		
		StringBuilder output = new StringBuilder("Range, Readings");
		
		getRangesWithReadings(readings, ranges);

		for (String range : ranges) {
			output.append("\n" + range + ", " + Integer.toString(getCountWithRange(readings, range)));
		}
		System.out.println("output" + output);
		return output;
	}
	
	public static StringBuilder getRangeWiseReadingsAnalogInput(int[] analogReadings) {
		
		int[] digitalReadings = new int[analogReadings.length];
		for (int i = 0; i<analogReadings.length; i++) {
			digitalReadings[i] = getDigitalConversion((double)analogReadings[i]);
		}
		return getRangeWiseReadings(digitalReadings);
	}
	
	public static void getRangesWithReadings(int[] readings, List<String> ranges) {
		
		int start = readings[0];
		int end = readings[0];
		
		for (int i = 1; i < readings.length; i++) {
		    if (readings[i] == readings[i-1] + 1) {
		        end = readings[i];
		    } else {
		    	if(start == end) {
		    		continue;
		    	}
		        ranges.add(start + "-" + end);
		    	start = readings[i];
		        end = readings[i];
		    }
		}
		
		ranges.add(start + "-" + end);
		
	}

	public static int getCountWithRange(int[] readings, String range) {
		
		String[] ranges = range.split("-");
		
		int lower = Integer.parseInt(ranges[0]); 
		int upper = Integer.parseInt(ranges[1]);

        int count = 0;

        for (int number : readings) {
            if (number >= lower && number <= upper) {
                count++;
            }
        }

        return count;
    }
	
	public static int getDigitalConversion(double analogData) {
		int digitalRate = 0;
		
		if (analogData > 4094) {
			return -1;
		}	
		digitalRate = (int) Math.round(analogData * 10 / 4094);
		return digitalRate;
	}

}
