package lab5;

import java.io.IOException;
import java.util.ArrayList;

public interface LineByLineFileHandler {
	public ArrayList<String> readLines (String fileName) throws IOException;
	
	public void writeLines (String fileName, ArrayList<String> lines) throws IOException;
}
