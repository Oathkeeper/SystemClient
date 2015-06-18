package ca.owenpeterson.utils;

/**
 * Added this comment to test pushing to github through eclipse.
 * @author owen
 *
 */
public class FormatUtils {

	public static String reduceWhitespace(String stringToReduce) {
		return stringToReduce.replaceAll(" {2,}", " ");
	}
}
