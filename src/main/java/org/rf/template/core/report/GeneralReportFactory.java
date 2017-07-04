package org.rf.template.core.report;

import java.util.HashMap;
import java.util.Map;

import org.apache.commons.logging.LogFactory;
import org.rf.template.command.ReportCommand;

public class GeneralReportFactory {
	private static final org.apache.commons.logging.Log LOG = LogFactory
			.getLog(GeneralReportFactory.class);

	private static final Map<String, Class<? extends ReportCommand>> REPORT_COMMANDS = new HashMap<String, Class<? extends ReportCommand>>(
			100, 1);

	static {

	}

	/**
	 * This private constructor is created to prevent instantiation of this
	 * class.
	 * 
	 */
	private GeneralReportFactory() {
		// to prevent instantiation
	}

	/**
	 * This method is a factory method to get the <b> ReportCommand </b> object
	 * according to the <code> reportType </code> parameter given.
	 * 
	 * @param reportType
	 *            String
	 * @return ReportCommand
	 */
	public static ReportCommand getReportCommand(String reportType) {
		ReportCommand reportCommand = null;
		Class<? extends ReportCommand> reportCommandClass = REPORT_COMMANDS
				.get(reportType);
		if (reportCommandClass != null) {
			try {
				reportCommand = reportCommandClass.newInstance();
			} catch (Exception e) {
				LOG.debug("Can't create a ReportCommand object.", e);
			}
		}
		return reportCommand;
	}
}
