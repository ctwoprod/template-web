package org.rf.template.util;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;

public final class DateUtil {
	public static final DateFormat dateFormatIndonesia = new SimpleDateFormat(
			"dd-MM-yyyy");
	public static final DateFormat dateFormatNotIndonesia = new SimpleDateFormat(
			"yyyy-MM-dd");
	public static final DateFormat timeFormatIndonesia = new SimpleDateFormat(
			"dd-MM-yyyy hh:mm:ss");

	public static Integer getJumlahHari(Integer month, Integer year) {
		Calendar calendar = Calendar.getInstance();
		calendar.set(Calendar.YEAR, year);
		calendar.set(Calendar.MONTH, month);
		int numDays = calendar.getActualMaximum(Calendar.DATE);
		return numDays;
	}

	public static final String getMonthName(String numberMonth) {
		if (numberMonth.equalsIgnoreCase("01")) {
			return "Jan";
		} else if (numberMonth.equalsIgnoreCase("02")) {
			return "Feb";
		} else if (numberMonth.equalsIgnoreCase("03")) {
			return "Mar";
		} else if (numberMonth.equalsIgnoreCase("04")) {
			return "Apr";
		} else if (numberMonth.equalsIgnoreCase("05")) {
			return "May";
		} else if (numberMonth.equalsIgnoreCase("06")) {
			return "Jun";
		} else if (numberMonth.equalsIgnoreCase("07")) {
			return "Jul";
		} else if (numberMonth.equalsIgnoreCase("08")) {
			return "Aug";
		} else if (numberMonth.equalsIgnoreCase("09")) {
			return "Sep";
		} else if (numberMonth.equalsIgnoreCase("10")) {
			return "Oct";
		} else if (numberMonth.equalsIgnoreCase("11")) {
			return "Nov";
		} else if (numberMonth.equalsIgnoreCase("12")) {
			return "Dec";
		} else {
			return "";
		}
	}

	public static final String getIndexMonth(String name) {
		if (name.equalsIgnoreCase("January")) {
			return "01";
		} else if (name.equalsIgnoreCase("February")) {
			return "02";
		} else if (name.equalsIgnoreCase("March")) {
			return "03";
		} else if (name.equalsIgnoreCase("April")) {
			return "04";
		} else if (name.equalsIgnoreCase("May")) {
			return "05";
		} else if (name.equalsIgnoreCase("June")) {
			return "06";
		} else if (name.equalsIgnoreCase("July")) {
			return "07";
		} else if (name.equalsIgnoreCase("August")) {
			return "08";
		} else if (name.equalsIgnoreCase("September")) {
			return "09";
		} else if (name.equalsIgnoreCase("October")) {
			return "10";
		} else if (name.equalsIgnoreCase("November")) {
			return "11";
		} else if (name.equalsIgnoreCase("December")) {
			return "12";
		} else {
			return "";
		}
	}
	public static final String getMonthFullName(String numberMonth) {
		if (numberMonth.equalsIgnoreCase("01")) {
			return "January";
		} else if (numberMonth.equalsIgnoreCase("02")) {
			return "February";
		} else if (numberMonth.equalsIgnoreCase("03")) {
			return "March";
		} else if (numberMonth.equalsIgnoreCase("04")) {
			return "April";
		} else if (numberMonth.equalsIgnoreCase("05")) {
			return "May";
		} else if (numberMonth.equalsIgnoreCase("06")) {
			return "June";
		} else if (numberMonth.equalsIgnoreCase("07")) {
			return "July";
		} else if (numberMonth.equalsIgnoreCase("08")) {
			return "August";
		} else if (numberMonth.equalsIgnoreCase("09")) {
			return "September";
		} else if (numberMonth.equalsIgnoreCase("10")) {
			return "October";
		} else if (numberMonth.equalsIgnoreCase("11")) {
			return "November";
		} else if (numberMonth.equalsIgnoreCase("12")) {
			return "December";
		} else {
			return "";
		}
	}

	public static final String getMonthFullName(int index) {
		if (index == 0) {
			return "January";
		} else if (index == 1) {
			return "February";
		} else if (index == 2) {
			return "March";
		} else if (index == 3) {
			return "April";
		} else if (index == 4) {
			return "May";
		} else if (index == 5) {
			return "June";
		} else if (index == 6) {
			return "July";
		} else if (index == 7) {
			return "August";
		} else if (index == 8) {
			return "September";
		} else if (index == 9) {
			return "October";
		} else if (index == 10) {
			return "November";
		} else if (index == 11) {
			return "December";
		} else {
			return "";
		}
	}

	public static final String getMonth(int index) {
		if (index == 0) {
			return "01";
		} else if (index == 1) {
			return "02";
		} else if (index == 2) {
			return "03";
		} else if (index == 3) {
			return "04";
		} else if (index == 4) {
			return "05";
		} else if (index == 5) {
			return "06";
		} else if (index == 6) {
			return "07";
		} else if (index == 7) {
			return "08";
		} else if (index == 8) {
			return "09";
		} else if (index == 9) {
			return "10";
		} else if (index == 10) {
			return "11";
		} else if (index == 11) {
			return "12";
		} else {
			return "";
		}
	}

	public static final String[] getNextMonthYear(String numberMonth,
			String year) {
		if (numberMonth.equalsIgnoreCase("01")) {
			return new String[] { "02", year };
		} else if (numberMonth.equalsIgnoreCase("02")) {
			return new String[] { "03", year };
		} else if (numberMonth.equalsIgnoreCase("03")) {
			return new String[] { "04", year };
		} else if (numberMonth.equalsIgnoreCase("04")) {
			return new String[] { "05", year };
		} else if (numberMonth.equalsIgnoreCase("05")) {
			return new String[] { "06", year };
		} else if (numberMonth.equalsIgnoreCase("06")) {
			return new String[] { "07", year };
		} else if (numberMonth.equalsIgnoreCase("07")) {
			return new String[] { "08", year };
		} else if (numberMonth.equalsIgnoreCase("08")) {
			return new String[] { "09", year };
		} else if (numberMonth.equalsIgnoreCase("09")) {
			return new String[] { "10", year };
		} else if (numberMonth.equalsIgnoreCase("10")) {
			return new String[] { "11", year };
		} else if (numberMonth.equalsIgnoreCase("11")) {
			return new String[] { "12", year };
		} else if (numberMonth.equalsIgnoreCase("12")) {
			return new String[] { "01", "" + (Integer.valueOf(year) + 1) };
		} else {
			return new String[] { "", "" };
		}
	}

	public static final Date getRandomDate() {
		Calendar c = Calendar.getInstance();
		c.set(Calendar.YEAR, 1989);
		c.set(Calendar.MONTH, 4);
		c.set(Calendar.DAY_OF_MONTH, 11);
		return c.getTime();
	}

}
