package CurrentRange;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class CurrentRange {
	
	public static StringBuilder getRangeWiseReadings (int[] readings) {
		
		Arrays.sort(readings);
		
		List<String> ranges = new ArrayList<>();
		int start = readings[0];
		int end = readings[0];
		
		StringBuilder output = new StringBuilder("Range, Readings");
		
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

		for (String range : ranges) {
			output.append("\n" + range + ", " + Integer.toString(getCountWithRange(readings, range)));
		}
		return output;
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

}
