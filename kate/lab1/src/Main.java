import java.util.Arrays;
import java.lang.StringBuilder;

import Comparator.Comparator;

public class Main {
	public static void main(String[] args) throws Exception {
		// Предположим, что первый аргумент от CLI будет коммандой
		// Например: $ java Main --gta
		String commandName = args[0];
		// а все последующие аргументы - значения строк в будущем массиве
		// Например: $ java Main --lta abcd, abc, ab, a
		// Для этого используем метод класса Arrays copyOfRange для создания слайса
		String[] rows = Arrays.copyOfRange(args, 1, args.length);
		if (commandName.equals(CLI_COMMANDS.GREATER_THAN_AVERAGE.getCommandName())) {
			String[] result = Comparator.getRowsGreaterThanAverage(rows);
			System.out.println(Arrays.toString(result));
			return;
		}
		if (commandName.equals(CLI_COMMANDS.LESSER_THAN_AVERAGE.getCommandName())) {
			String[] result = Comparator.getRowsLesserThanAverage(rows);
			System.out.println(Arrays.toString(result));
			return;
		}
		Main.throwIncorrectArgs();
  }

	private static void throwIncorrectArgs () throws Exception {
		String errorMsg = new StringBuilder()
				.append("Please, use ")
				.append(CLI_COMMANDS.GREATER_THAN_AVERAGE.getCommandName())
				.append(" or ")
				.append(CLI_COMMANDS.LESSER_THAN_AVERAGE.getCommandName())
				.append(" as a first argument")
				.toString();
		throw new Exception(errorMsg);
	}
}
