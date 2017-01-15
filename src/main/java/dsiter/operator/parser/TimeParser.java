package dsiter.operator.parser;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class TimeParser {

	public static Pattern dateTimePattern = Pattern.compile(
		"^(?<year>\\d{4})-(?<month>\\d{2})-(?<day>\\d{2})(?:T(?<hour>\\d{2}):(?<minute>\\d{2}):(?<second>\\d{2}(?:\\.\\d+)?))?Z?"
	);

	public static int dateLengthAt(String input, int startIndex) {
		Matcher matcher = dateTimePattern.matcher(
			input.subSequence(startIndex, input.length())
		);

		if (matcher.matches()) {
			int length = matcher.end();
			return length;
		}
		else {
			return -1;
		}
	}
}
