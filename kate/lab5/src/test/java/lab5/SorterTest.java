package lab5;

import java.util.ArrayList;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Assertions;

public class SorterTest {
	private Sorter sorter;

	@BeforeEach
	public void beforeEach () {
		ArrayList<String> inputMock = new ArrayList<String>();
		inputMock.add("c:1");
		inputMock.add("a:123");
		inputMock.add("b:12");
		LineByLineFileHandler linesIOMock = new LinesIOMock(inputMock);
		this.sorter = new Sorter(linesIOMock);
	}

	@Test
	public void shouldSortByLineLength() {
		ArrayList<String> expected = new ArrayList<String>();
		expected.add("c:1");
		expected.add("b:12");
		expected.add("a:123");

		ArrayList<String> actual = this.sorter.handleByLength("none", "none");

		Assertions.assertEquals(expected, actual);
	}

	@Test
	public void shouldSortByLexicographicalOrder() {
		ArrayList<String> expected = new ArrayList<String>();
		expected.add("a:123");
		expected.add("b:12");
		expected.add("c:1");

		ArrayList<String> actual = this.sorter.handleByLexicographicOrder("none", "none");

		Assertions.assertEquals(expected, actual);
	}
}
