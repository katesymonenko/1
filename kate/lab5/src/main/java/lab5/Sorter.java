package lab5;

import java.io.IOException;
import java.util.ArrayList;
import java.util.Collections;

// Этот класс занимается сортировкой коллекций и выдачей результатов
// Маленькое допущение в рамках лабораторной работы, чтобы не усложнять код
// еще одним общим клиентским классом
public class Sorter {
	private LineByLineFileHandler linesIO;

	public Sorter(LineByLineFileHandler linesIO) {
		this.linesIO = linesIO;
	}

	public ArrayList<String> handleByLength (String inputFileName, String outputFileName) {
		try {
			ArrayList<String> inputLines = this.linesIO.readLines(inputFileName);
			ArrayList<String> outputLines = this.sortLinesByLength(inputLines);
			this.linesIO.writeLines(outputFileName, outputLines);
			return outputLines;
		} catch (IOException err) {
			return new ArrayList<String>();
		}
	}

	public ArrayList<String> handleByLexicographicOrder (String inputFileName, String outputFileName) {
		try {
			ArrayList<String> inputLines = this.linesIO.readLines(inputFileName);
			ArrayList<String> outputLines = this.sortLinesLexicographically(inputLines);
			this.linesIO.writeLines(outputFileName, outputLines);
			return outputLines;
		} catch (IOException err) {
			return new ArrayList<String>();
		}
	}

	private ArrayList<String> sortLinesByLength (ArrayList<String> lines) {
		ArrayList<String> linesToSort = new ArrayList<String>(lines);
		Collections.sort(linesToSort, (String a, String b) -> {
			return a.length() - b.length();
		});
		return linesToSort;
	}

	private ArrayList<String> sortLinesLexicographically (ArrayList<String> lines) {
		ArrayList<String> linesToSort = new ArrayList<String>(lines);
		Collections.sort(linesToSort);
		return linesToSort;
	}

}
