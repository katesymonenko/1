package lab5;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;

// Cоздадим отдельный класс для совмещения таких сущностей
// как Lines и Files. Задача класса - только читать и писать файлы построчно
public class LinesIO implements LineByLineFileHandler {

	public LinesIO() {}

	public ArrayList<String> readLines (String inputFileName) throws IOException {
		ArrayList<String> lines = new ArrayList<String>();
		// Задекларируем BufferedReader со значение null для корректной
		// обработки исключений в перехватчике
		BufferedReader reader = null;
		try {
			// Создадим буфер с содержимым файла по имени
			// Мы можем не найти файл по имени, не иметь прав на чтение, etc
			// Поэтому обернем этот блок кода в try catch
			reader = new BufferedReader(
					new FileReader(inputFileName)
			);
			// Прочитаем первую строку файла
			String nextLine = reader.readLine();
			// Будем двигаться по строкам, пока они будут представлены в файле
			// Сделаем проверку на null, чтобы избежать неожиданного поведения
			// в случае столкновения с "пустой" строкой посередине файла
			while (nextLine != null) {
				lines.add(nextLine);
				nextLine = reader.readLine();
			}
			// Мы обязаны чистить память, когда буфер больше не нужен
			reader.close();
		} catch (IOException err) {
			if (reader != null) {
				reader.close();
			}
			throw err;
		}
		return lines;
	}

	public void writeLines (String outputFileName, ArrayList<String> lines) throws IOException {
		PrintWriter outputStream = null;
		try	{
			outputStream = new PrintWriter(
					new FileWriter(outputFileName)
			);
			for (String line: lines) {
				outputStream.println(line);
			}
			outputStream.close();
		} catch (IOException err) {
			throw err;
		}
	}
}
