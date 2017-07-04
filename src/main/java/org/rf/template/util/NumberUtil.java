package org.rf.template.util;

import java.text.DecimalFormat;

public final class NumberUtil {
	@SuppressWarnings("unused")
	public static boolean isNumeric(String str) {
		try {
			double d = Double.parseDouble(str);
		} catch (NumberFormatException nfe) {
			return false;
		}
		return true;
	}

	public static boolean isNumericUsingRegex(String str) {
		return str.matches("-?\\d+(\\.\\d+)?"); // match a number with optional
												// '-' and decimal.
	}
	public static final DecimalFormat formatter = new DecimalFormat("#,##0.00");
}
