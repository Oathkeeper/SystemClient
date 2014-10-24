package ca.owenpeterson.utils;

public class FormatUtils {

	public static String reduceWhitespace(String stringToReduce) {
		return stringToReduce.replaceAll(" {2,}", " ");
	}
}
