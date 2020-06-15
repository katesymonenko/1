package Comparator;
import java.util.stream.Stream;

public class Comparator {
	private static float getRowsAverageLength (String[] rows) {
		int sum = 0;
		for(String row: rows) {
			sum += row.length();
		}
		return (float)sum / (float)rows.length;
	}

	public static String[] getRowsLesserThanAverage (String[] rows) {
		float average = Comparator.getRowsAverageLength(rows);
		Stream<String> rowsStream = Stream.of(rows);
		return rowsStream
			.filter(row -> {
				return row.length() < average;
			})
			.toArray(size -> new String[size]);
	}

	public static String[] getRowsGreaterThanAverage (String[] rows) {
		float average = Comparator.getRowsAverageLength(rows);
		Stream<String> rowsStream = Stream.of(rows);
		return rowsStream
			.filter(row -> {
				return row.length() > average;
			})
			.toArray(size -> new String[size]);
	}
}
