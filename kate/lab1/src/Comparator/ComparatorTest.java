package Comparator;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.Assertions;

class ComparatorTest {
	@Test
	public void shouldGetLesserRows () {
		String[] data = {"1", "12", "123", "1234"};
		String[] expected = {"1", "12"};

		String[] actual = Comparator.getRowsLesserThanAverage(data);

		Assertions.assertArrayEquals(expected, actual);
	}

	@Test
	public void shouldGetGreaterRows () {
		String[] data = {"1", "12", "123", "1234"};
		String[] expected = {"123", "1234"};

		String[] actual = Comparator.getRowsGreaterThanAverage(data);

		Assertions.assertArrayEquals(expected, actual);
	}

	@Test
	public void shouldGetAnEmptyArrayIfReceiveEmpty () {
		String[] data = {};
		String[] expected = {};
		String[] actual = Comparator.getRowsGreaterThanAverage(data);
		Assertions.assertArrayEquals(expected, actual);
	}
}
