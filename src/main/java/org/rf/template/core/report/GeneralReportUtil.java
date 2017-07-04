package org.rf.template.core.report;

public class GeneralReportUtil {

	public static final String PATH_TO_PLN_LOGO = "/reports/pln.png";

	public static final String RPT_TEST_CETAK_XLS = "rptTestCetakXls";

	/** The default directory. */
	private static String defaultDirectory = "/reports/";
	/** The rpt Test. */
	private static String rptTest = defaultDirectory + "rptTest.jasper";

	public static String getRptTest() {
		return rptTest;
	}
}
