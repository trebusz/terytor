package pl.warg.terytor.util;

public class ReadUtil {

	public static String readTextContent(StringBuilder content) {

		if (null == content) {
			return "";
		}

		String result = content.toString();

		result = result.replace('\u00A0',' ');
		result = result.replaceAll(" +", " ");
		result = result.trim();

		return result;
	}
}
