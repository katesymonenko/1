package lab5;

import java.io.IOException;
import java.util.ArrayList;

// Напишем отдельный Мок класс, чтобы мочь сосредоточиться на тестировании
// сортировки коллекций
public class LinesIOMock implements LineByLineFileHandler {

	private ArrayList<String> readResponse;

	public LinesIOMock(ArrayList<String> readResponse) {
		this.readResponse = readResponse;
	}

	public ArrayList<String> readLines (String inputFileName) throws IOException {
		return this.readResponse;
	}

	public void writeLines (String outputFileName, ArrayList<String> lines) throws IOException {
		return;
	}
}
