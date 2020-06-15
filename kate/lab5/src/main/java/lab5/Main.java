package lab5;

import java.util.ArrayList;

public class Main {
	public static void main(String[] args) {
		LinesIO linesIO = new LinesIO();
		Sorter sorter = new Sorter(linesIO);
		ArrayList<String> res = sorter.handleByLength("input1.txt", "output1.txt");
		System.out.println(res.toString());
	}
}
